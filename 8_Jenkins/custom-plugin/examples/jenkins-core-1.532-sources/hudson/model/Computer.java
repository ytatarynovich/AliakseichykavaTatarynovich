/*
 * The MIT License
 *
 * Copyright (c) 2004-2010, Sun Microsystems, Inc., Kohsuke Kawaguchi,
 * Red Hat, Inc., Seiji Sogabe, Stephen Connolly, Thomas J. Black, Tom Huybrechts, CloudBees, Inc.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package hudson.model;

import hudson.EnvVars;
import hudson.Launcher.ProcStarter;
import hudson.Util;
import hudson.cli.declarative.CLIMethod;
import hudson.cli.declarative.CLIResolver;
import hudson.console.AnnotatedLargeText;
import hudson.init.Initializer;
import hudson.model.Descriptor.FormException;
import hudson.model.Queue.FlyweightTask;
import hudson.model.labels.LabelAtom;
import hudson.model.queue.WorkUnit;
import hudson.node_monitors.NodeMonitor;
import hudson.remoting.Channel;
import hudson.remoting.VirtualChannel;
import hudson.remoting.Callable;
import hudson.security.ACL;
import hudson.security.AccessControlled;
import hudson.security.Permission;
import hudson.security.PermissionGroup;
import hudson.security.PermissionScope;
import hudson.slaves.ComputerLauncher;
import hudson.slaves.ComputerListener;
import hudson.slaves.NodeProperty;
import hudson.slaves.RetentionStrategy;
import hudson.slaves.WorkspaceList;
import hudson.slaves.OfflineCause;
import hudson.slaves.OfflineCause.ByCLI;
import hudson.util.EditDistance;
import hudson.util.ExceptionCatchingThreadFactory;
import hudson.util.RemotingDiagnostics;
import hudson.util.RemotingDiagnostics.HeapDump;
import hudson.util.RunList;
import hudson.util.Futures;
import jenkins.model.Jenkins;
import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.stapler.StaplerRequest;
import org.kohsuke.stapler.StaplerResponse;
import org.kohsuke.stapler.QueryParameter;
import org.kohsuke.stapler.HttpResponses;
import org.kohsuke.stapler.HttpResponse;
import org.kohsuke.stapler.HttpRedirect;
import org.kohsuke.stapler.WebMethod;
import org.kohsuke.stapler.export.Exported;
import org.kohsuke.stapler.export.ExportedBean;
import org.kohsuke.args4j.Option;
import org.kohsuke.stapler.interceptor.RequirePOST;

import javax.servlet.ServletException;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.LogRecord;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.nio.charset.Charset;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.Inet4Address;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.CheckForNull;
import javax.annotation.Nullable;

import static javax.servlet.http.HttpServletResponse.*;

/**
 * Represents the running state of a remote computer that holds {@link Executor}s.
 *
 * <p>
 * {@link Executor}s on one {@link Computer} are transparently interchangeable
 * (that is the definition of {@link Computer}.)
 *
 * <p>
 * This object is related to {@link Node} but they have some significant difference.
 * {@link Computer} primarily works as a holder of {@link Executor}s, so
 * if a {@link Node} is configured (probably temporarily) with 0 executors,
 * you won't have a {@link Computer} object for it (except for the master node,
 * which always get its {@link Computer} in case we have no static executors and
 * we need to run a {@link FlyweightTask} - see JENKINS-7291 for more discussion.)
 *
 * Also, even if you remove a {@link Node}, it takes time for the corresponding
 * {@link Computer} to be removed, if some builds are already in progress on that
 * node. Or when the node configuration is changed, unaffected {@link Computer} object
 * remains intact, while all the {@link Node} objects will go away.
 *
 * <p>
 * This object also serves UI (since {@link Node} is an interface and can't have
 * related side pages.)
 *
 * @author Kohsuke Kawaguchi
 */
@ExportedBean
public /*transient*/ abstract class Computer extends Actionable implements AccessControlled, ExecutorListener {

    private final CopyOnWriteArrayList<Executor> executors = new CopyOnWriteArrayList<Executor>();
    // TODO: 
    private final CopyOnWriteArrayList<OneOffExecutor> oneOffExecutors = new CopyOnWriteArrayList<OneOffExecutor>();

    private int numExecutors;

    /**
     * Contains info about reason behind computer being offline.
     */
    protected volatile OfflineCause offlineCause;
    
    private long connectTime = 0;

    /**
     * True if Jenkins shouldn't start new builds on this node.
     */
    private boolean temporarilyOffline;

    /**
     * {@link Node} object may be created and deleted independently
     * from this object.
     */
    protected String nodeName;

    /**
     * @see #getHostName()
     */
    private volatile String cachedHostName;
    private volatile boolean hostNameCached;

    private final WorkspaceList workspaceList = new WorkspaceList();

    protected transient List<Action> transientActions;

    protected final Object statusChangeLock = new Object();

    public Computer(Node node) {
        setNode(node);
    }

     /**
     * Returns list of all boxes {@link ComputerPanelBox}s.
     */
    public List<ComputerPanelBox> getComputerPanelBoxs(){
        return ComputerPanelBox.all(this);
    }
    
    /**
     * Returns the transient {@link Action}s associated with the computer.
     */
    public List<Action> getActions() {
    	List<Action> result = new ArrayList<Action>();
    	result.addAll(super.getActions());
    	synchronized (this) {
    		if (transientActions == null) {
    			transientActions = TransientComputerActionFactory.createAllFor(this);
    		}
    		result.addAll(transientActions);
    	}
    	return result;
    }

    @Override
    public void addAction(Action a) {
        if(a==null) throw new IllegalArgumentException();
        super.getActions().add(a);
    }

    /**
     * This is where the log from the remote agent goes.
     *
     * @see #relocateOldLogs()
     */
    protected File getLogFile() {
        File dir = new File(Jenkins.getInstance().getRootDir(),"logs/slaves/"+nodeName);
        dir.mkdirs();
        return new File(dir,"slave.log");
    }

    /**
     * Gets the object that coordinates the workspace allocation on this computer.
     */
    public WorkspaceList getWorkspaceList() {
        return workspaceList;
    }

    /**
     * Gets the string representation of the slave log.
     */
    public String getLog() throws IOException {
        return Util.loadFile(getLogFile());
    }

    /**
     * Used to URL-bind {@link AnnotatedLargeText}.
     */
    public AnnotatedLargeText<Computer> getLogText() {
        return new AnnotatedLargeText<Computer>(getLogFile(), Charset.defaultCharset(), false, this);
    }

    public ACL getACL() {
        return Jenkins.getInstance().getAuthorizationStrategy().getACL(this);
    }

    public void checkPermission(Permission permission) {
        getACL().checkPermission(permission);
    }

    public boolean hasPermission(Permission permission) {
        return getACL().hasPermission(permission);
    }

    /**
     * If the computer was offline (either temporarily or not),
     * this method will return the cause.
     *
     * @return
     *      null if the system was put offline without given a cause.
     */
    @Exported
    public OfflineCause getOfflineCause() {
        return offlineCause;
    }

    /**
     * If the computer was offline (either temporarily or not),
     * this method will return the cause as a string (without user info).
     *
     * @return
     *      empty string if the system was put offline without given a cause.
     */
    @Exported
    public String getOfflineCauseReason() {
        if (offlineCause == null) {
            return "";
        }
        // fetch the localized string for "Disconnected By"
        String gsub_base = hudson.slaves.Messages.SlaveComputer_DisconnectedBy("","");
        // regex to remove commented reason base string
        String gsub1 = "^" + gsub_base + "[\\w\\W]* \\: ";
        // regex to remove non-commented reason base string
        String gsub2 = "^" + gsub_base + "[\\w\\W]*";

        String newString = offlineCause.toString().replaceAll(gsub1, "");
        return newString.replaceAll(gsub2, "");
    }

    /**
     * Gets the channel that can be used to run a program on this computer.
     *
     * @return
     *      never null when {@link #isOffline()}==false.
     */
    public abstract @Nullable VirtualChannel getChannel();

    /**
     * Gets the default charset of this computer.
     *
     * @return
     *      never null when {@link #isOffline()}==false.
     */
    public abstract Charset getDefaultCharset();

    /**
     * Gets the logs recorded by this slave.
     */
    public abstract List<LogRecord> getLogRecords() throws IOException, InterruptedException;

    /**
     * If {@link #getChannel()}==null, attempts to relaunch the slave agent.
     */
    public abstract void doLaunchSlaveAgent( StaplerRequest req, StaplerResponse rsp ) throws IOException, ServletException;

    /**
     * @deprecated since 2009-01-06.  Use {@link #connect(boolean)}
     */
    public final void launch() {
        connect(true);
    }

    /**
     * Do the same as {@link #doLaunchSlaveAgent(StaplerRequest, StaplerResponse)}
     * but outside the context of serving a request.
     *
     * <p>
     * If already connected or if this computer doesn't support proactive launching, no-op.
     * This method may return immediately
     * while the launch operation happens asynchronously.
     *
     * @see #disconnect()
     *
     * @param forceReconnect
     *      If true and a connect activity is already in progress, it will be cancelled and
     *      the new one will be started. If false, and a connect activity is already in progress, this method
     *      will do nothing and just return the pending connection operation.
     * @return
     *      A {@link Future} representing pending completion of the task. The 'completion' includes
     *      both a successful completion and a non-successful completion (such distinction typically doesn't
     *      make much sense because as soon as {@link Computer} is connected it can be disconnected by some other threads.)
     */
    public final Future<?> connect(boolean forceReconnect) {
    	connectTime = System.currentTimeMillis();
    	return _connect(forceReconnect);
    }
    
    /**
     * Allows implementing-classes to provide an implementation for the connect method.
     *
     * <p>
     * If already connected or if this computer doesn't support proactive launching, no-op.
     * This method may return immediately
     * while the launch operation happens asynchronously.
     *
     * @see #disconnect()
     *
     * @param forceReconnect
     *      If true and a connect activity is already in progress, it will be cancelled and
     *      the new one will be started. If false, and a connect activity is already in progress, this method
     *      will do nothing and just return the pending connection operation.
     * @return
     *      A {@link Future} representing pending completion of the task. The 'completion' includes
     *      both a successful completion and a non-successful completion (such distinction typically doesn't
     *      make much sense because as soon as {@link Computer} is connected it can be disconnected by some other threads.)
     */
    protected abstract Future<?> _connect(boolean forceReconnect);

    /**
     * CLI command to reconnect this node.
     */
    @CLIMethod(name="connect-node")
    public void cliConnect(@Option(name="-f",usage="Cancel any currently pending connect operation and retry from scratch") boolean force) throws ExecutionException, InterruptedException {
        checkPermission(CONNECT);
        connect(force).get();
    }

    /**
     * Gets the time (since epoch) when this computer connected.
     *  
     * @return The time in ms since epoch when this computer last connected.
     */
    public final long getConnectTime() {
    	return connectTime;
    }
    
    /**
     * Disconnect this computer.
     *
     * If this is the master, no-op. This method may return immediately
     * while the launch operation happens asynchronously.
     *
     * @param cause
     *      Object that identifies the reason the node was disconnected.
     *
     * @return
     *      {@link Future} to track the asynchronous disconnect operation.
     * @see #connect(boolean)
     * @since 1.320
     */
    public Future<?> disconnect(OfflineCause cause) {
        offlineCause = cause;
        if (Util.isOverridden(Computer.class,getClass(),"disconnect"))
            return disconnect();    // legacy subtypes that extend disconnect().

        connectTime=0;
        return Futures.precomputed(null);
    }

    /**
     * Equivalent to {@code disconnect(null)}
     *
     * @deprecated as of 1.320.
     *      Use {@link #disconnect(OfflineCause)} and specify the cause.
     */
    public Future<?> disconnect() {
        if (Util.isOverridden(Computer.class,getClass(),"disconnect",OfflineCause.class))
            // if the subtype already derives disconnect(OfflineCause), delegate to it
            return disconnect(null);

        connectTime=0;
        return Futures.precomputed(null);
    }

    /**
     * CLI command to disconnects this node.
     */
    @CLIMethod(name="disconnect-node")
    public void cliDisconnect(@Option(name="-m",usage="Record the note about why you are disconnecting this node") String cause) throws ExecutionException, InterruptedException {
        checkPermission(DISCONNECT);
        disconnect(new ByCLI(cause)).get();
    }

    /**
     * CLI command to mark the node offline.
     */
    @CLIMethod(name="offline-node")
    public void cliOffline(@Option(name="-m",usage="Record the note about why you are disconnecting this node") String cause) throws ExecutionException, InterruptedException {
        checkPermission(DISCONNECT);
        setTemporarilyOffline(true,new ByCLI(cause));
    }

    @CLIMethod(name="online-node")
    public void cliOnline() throws ExecutionException, InterruptedException {
        checkPermission(CONNECT);
        setTemporarilyOffline(false,null);
    }

    /**
     * Number of {@link Executor}s that are configured for this computer.
     *
     * <p>
     * When this value is decreased, it is temporarily possible
     * for {@link #executors} to have a larger number than this.
     */
    // ugly name to let EL access this
    @Exported
    public int getNumExecutors() {
        return numExecutors;
    }

    /**
     * Returns {@link Node#getNodeName() the name of the node}.
     */
    public String getName() {
        return nodeName;
    }

    /**
     * Returns the {@link Node} that this computer represents.
     *
     * @return
     *      null if the configuration has changed and the node is removed, yet the corresponding {@link Computer}
     *      is not yet gone.
     */
    public @CheckForNull Node getNode() {
        if(nodeName==null)
            return Jenkins.getInstance();
        return Jenkins.getInstance().getNode(nodeName);
    }

    @Exported
    public LoadStatistics getLoadStatistics() {
        return LabelAtom.get(nodeName != null ? nodeName : "").loadStatistics;
    }

    public BuildTimelineWidget getTimeline() {
        return new BuildTimelineWidget(getBuilds());
    }

    /**
     * {@inheritDoc}
     */
    public void taskAccepted(Executor executor, Queue.Task task) {
        // dummy implementation
    }

    /**
     * {@inheritDoc}
     */
    public void taskCompleted(Executor executor, Queue.Task task, long durationMS) {
        // dummy implementation
    }

    /**
     * {@inheritDoc}
     */
    public void taskCompletedWithProblems(Executor executor, Queue.Task task, long durationMS, Throwable problems) {
        // dummy implementation
    }

    @Exported
    public boolean isOffline() {
        return temporarilyOffline || getChannel()==null;
    }

    public final boolean isOnline() {
        return !isOffline();
    }

    /**
     * This method is called to determine whether manual launching of the slave is allowed at this point in time.
     * @return {@code true} if manual launching of the slave is allowed at this point in time.
     */
    @Exported
    public boolean isManualLaunchAllowed() {
        return getRetentionStrategy().isManualLaunchAllowed(this);
    }


    /**
     * Is a {@link #connect(boolean)} operation in progress?
     */
    public abstract boolean isConnecting();

    /**
     * Returns true if this computer is supposed to be launched via JNLP.
     * @deprecated since 2008-05-18.
     *     See {@linkplain #isLaunchSupported()} and {@linkplain ComputerLauncher}
     */
    @Exported
    @Deprecated
    public boolean isJnlpAgent() {
        return false;
    }

    /**
     * Returns true if this computer can be launched by Hudson proactively and automatically.
     *
     * <p>
     * For example, JNLP slaves return {@code false} from this, because the launch process
     * needs to be initiated from the slave side.
     */
    @Exported
    public boolean isLaunchSupported() {
        return true;
    }

    /**
     * Returns true if this node is marked temporarily offline by the user.
     *
     * <p>
     * In contrast, {@link #isOffline()} represents the actual online/offline
     * state. For example, this method may return false while {@link #isOffline()}
     * returns true if the slave agent failed to launch.
     *
     * @deprecated
     *      You should almost always want {@link #isOffline()}.
     *      This method is marked as deprecated to warn people when they
     *      accidentally call this method.
     */
    @Exported
    public boolean isTemporarilyOffline() {
        return temporarilyOffline;
    }

    /**
     * @deprecated as of 1.320.
     *      Use {@link #setTemporarilyOffline(boolean, OfflineCause)}
     */
    public void setTemporarilyOffline(boolean temporarilyOffline) {
        setTemporarilyOffline(temporarilyOffline,null);
    }

    /**
     * Marks the computer as temporarily offline. This retains the underlying
     * {@link Channel} connection, but prevent builds from executing.
     *
     * @param cause
     *      If the first argument is true, specify the reason why the node is being put
     *      offline. 
     */
    public void setTemporarilyOffline(boolean temporarilyOffline, OfflineCause cause) {
        offlineCause = temporarilyOffline ? cause : null;
        this.temporarilyOffline = temporarilyOffline;
        Node node = getNode();
        if (node != null) {
            node.setTemporaryOfflineCause(offlineCause);
        }
        Jenkins.getInstance().getQueue().scheduleMaintenance();
        synchronized (statusChangeLock) {
            statusChangeLock.notifyAll();
        }
        for (ComputerListener cl : ComputerListener.all()) {
            if (temporarilyOffline)     cl.onTemporarilyOffline(this,cause);
            else                        cl.onTemporarilyOnline(this);
        }
    }

    @Exported
    public String getIcon() {
        if(isOffline())
            return "computer-x.png";
        else
            return "computer.png";
    }

    public String getIconAltText() {
        if(isOffline())
            return "[offline]";
        else
            return "[online]";
    }

    @Exported
    public String getDisplayName() {
        return nodeName;
    }

    public String getCaption() {
        return Messages.Computer_Caption(nodeName);
    }

    public String getUrl() {
        return "computer/" + Util.rawEncode(getDisplayName()) + "/";
    }

    /**
     * Returns projects that are tied on this node.
     */
    public List<AbstractProject> getTiedJobs() {
        Node node = getNode();
        return (node != null) ? node.getSelfLabel().getTiedJobs() : Collections.EMPTY_LIST;
    }

    public RunList getBuilds() {
    	return new RunList(Jenkins.getInstance().getAllItems(Job.class)).node(getNode());
    }

    /**
     * Called to notify {@link Computer} that its corresponding {@link Node}
     * configuration is updated.
     */
    protected void setNode(Node node) {
        assert node!=null;
        if(node instanceof Slave)
            this.nodeName = node.getNodeName();
        else
            this.nodeName = null;

        setNumExecutors(node.getNumExecutors());
        if (this.temporarilyOffline) {
            // When we get a new node, push our current temp offline
            // status to it (as the status is not carried across
            // configuration changes that recreate the node).
            // Since this is also called the very first time this
            // Computer is created, avoid pushing an empty status
            // as that could overwrite any status that the Node
            // brought along from its persisted config data.
            node.setTemporaryOfflineCause(this.offlineCause);
        }
    }

    /**
     * Called by {@link Jenkins#updateComputerList()} to notify {@link Computer} that it will be discarded.
     *
     * <p>
     * Note that at this point {@link #getNode()} returns null.
     *
     * @see #onRemoved()
     */
    protected void kill() {
        setNumExecutors(0);
    }

    /**
     * Called by {@link Jenkins} when this computer is removed.
     *
     * <p>
     * This happens when list of nodes are updated (for example by {@link Jenkins#setNodes(List)} and
     * the computer becomes redundant. Such {@link Computer}s get {@linkplain #kill() killed}, then
     * after all its executors are finished, this method is called.
     *
     * <p>
     * Note that at this point {@link #getNode()} returns null.
     *
     * @see #kill()
     * @since 1.510
     */
    protected void onRemoved(){
    }

    private synchronized void setNumExecutors(int n) {
        this.numExecutors = n;
        int diff = executors.size()-n;

        if (diff>0) {
            // we have too many executors
            // send signal to all idle executors to potentially kill them off
            for( Executor e : executors )
                if(e.isIdle())
                    e.interrupt();
        }

        if (diff<0) {
            // if the number is increased, add new ones
            addNewExecutorIfNecessary();
        }
    }

    private void addNewExecutorIfNecessary() {
        Set<Integer> availableNumbers  = new HashSet<Integer>();
        for (int i = 0; i < numExecutors; i++)
            availableNumbers.add(i);

        for (Executor executor : executors)
            availableNumbers.remove(executor.getNumber());

        for (Integer number : availableNumbers) {
            Executor e = new Executor(this, number);
            e.start();
            executors.add(e);
        }
    }

    /**
     * Returns the number of idle {@link Executor}s that can start working immediately.
     */
    public int countIdle() {
        int n = 0;
        for (Executor e : executors) {
            if(e.isIdle())
                n++;
        }
        return n;
    }

    /**
     * Returns the number of {@link Executor}s that are doing some work right now.
     */
    public final int countBusy() {
        return countExecutors()-countIdle();
    }

    /**
     * Returns the current size of the executor pool for this computer.
     * This number may temporarily differ from {@link #getNumExecutors()} if there
     * are busy tasks when the configured size is decreased.  OneOffExecutors are
     * not included in this count.
     */
    public final int countExecutors() {
        return executors.size();
    }

    /**
     * Gets the read-only snapshot view of all {@link Executor}s.
     */
    @Exported
    public List<Executor> getExecutors() {
        return new ArrayList<Executor>(executors);
    }

    /**
     * Gets the read-only snapshot view of all {@link OneOffExecutor}s.
     */
    @Exported
    public List<OneOffExecutor> getOneOffExecutors() {
        return new ArrayList<OneOffExecutor>(oneOffExecutors);
    }

    /**
     * Returns true if all the executors of this computer are idle.
     */
    @Exported
    public final boolean isIdle() {
        if (!oneOffExecutors.isEmpty())
            return false;
        for (Executor e : executors)
            if(!e.isIdle())
                return false;
        return true;
    }

    /**
     * Returns true if this computer has some idle executors that can take more workload.
     */
    public final boolean isPartiallyIdle() {
        for (Executor e : executors)
            if(e.isIdle())
                return true;
        return false;
    }

    /**
     * Returns the time when this computer last became idle.
     *
     * <p>
     * If this computer is already idle, the return value will point to the
     * time in the past since when this computer has been idle.
     *
     * <p>
     * If this computer is busy, the return value will point to the
     * time in the future where this computer will be expected to become free.
     */
    public final long getIdleStartMilliseconds() {
        long firstIdle = Long.MIN_VALUE;
        for (Executor e : oneOffExecutors) {
            firstIdle = Math.max(firstIdle, e.getIdleStartMilliseconds());
        }
        for (Executor e : executors) {
            firstIdle = Math.max(firstIdle, e.getIdleStartMilliseconds());
        }
        return firstIdle;
    }

    /**
     * Returns the time when this computer first became in demand.
     */
    public final long getDemandStartMilliseconds() {
        long firstDemand = Long.MAX_VALUE;
        for (Queue.BuildableItem item : Jenkins.getInstance().getQueue().getBuildableItems(this)) {
            firstDemand = Math.min(item.buildableStartMilliseconds, firstDemand);
        }
        return firstDemand;
    }

    /**
     * Called by {@link Executor} to kill excessive executors from this computer.
     */
    /*package*/ synchronized void removeExecutor(Executor e) {
        executors.remove(e);
        addNewExecutorIfNecessary();
        if(!isAlive())
        {
            AbstractCIBase ciBase = Jenkins.getInstance();
            ciBase.removeComputer(this);
        }
    }

    /**
     * Returns true if any of the executors are functioning.
     *
     * Note that if an executor dies, we'll leave it in {@link #executors} until
     * the administrator yanks it out, so that we can see why it died.
     *
     * @since 1.509
     */
    protected boolean isAlive() {
        for (Executor e : executors)
            if (e.isAlive())
                return true;
        return false;
    }

    /**
     * Interrupt all {@link Executor}s.
     */
    public void interrupt() {
        for (Executor e : executors) {
            e.interrupt();
        }
    }

    public String getSearchUrl() {
        return "computer/"+nodeName;
    }

    /**
     * {@link RetentionStrategy} associated with this computer.
     *
     * @return
     *      never null. This method return {@code RetentionStrategy<? super T>} where
     *      {@code T=this.getClass()}.
     */
    public abstract RetentionStrategy getRetentionStrategy();

    /**
     * Expose monitoring data for the remote API.
     */
    @Exported(inline=true)
    public Map<String/*monitor name*/,Object> getMonitorData() {
        Map<String,Object> r = new HashMap<String, Object>();
        for (NodeMonitor monitor : NodeMonitor.getAll())
            r.put(monitor.getClass().getName(),monitor.data(this));
        return r;
    }

    /**
     * Gets the system properties of the JVM on this computer.
     * If this is the master, it returns the system property of the master computer.
     */
    public Map<Object,Object> getSystemProperties() throws IOException, InterruptedException {
        return RemotingDiagnostics.getSystemProperties(getChannel());
    }

    /**
     * @deprecated as of 1.292
     *      Use {@link #getEnvironment()} instead.
     */
    public Map<String,String> getEnvVars() throws IOException, InterruptedException {
        return getEnvironment();
    }

    /**
     * Gets the environment variables of the JVM on this computer.
     * If this is the master, it returns the system property of the master computer.
     */
    public EnvVars getEnvironment() throws IOException, InterruptedException {
        return EnvVars.getRemote(getChannel());
    }

    /**
     * Creates an environment variable override to be used for launching processes on this node.
     *
     * @see ProcStarter#envs(Map)
     * @since 1.489
     */
    public EnvVars buildEnvironment(TaskListener listener) throws IOException, InterruptedException {
        EnvVars env = new EnvVars();

        Node node = getNode();
        if (node==null)     return env; // bail out

        for (NodeProperty nodeProperty: Jenkins.getInstance().getGlobalNodeProperties()) {
            nodeProperty.buildEnvVars(env,listener);
        }

        for (NodeProperty nodeProperty: node.getNodeProperties()) {
            nodeProperty.buildEnvVars(env,listener);
        }

        // TODO: hmm, they don't really belong
        String rootUrl = Hudson.getInstance().getRootUrl();
        if(rootUrl!=null) {
            env.put("HUDSON_URL", rootUrl); // Legacy.
            env.put("JENKINS_URL", rootUrl);
        }

        return env;
    }

    /**
     * Gets the thread dump of the slave JVM.
     * @return
     *      key is the thread name, and the value is the pre-formatted dump.
     */
    public Map<String,String> getThreadDump() throws IOException, InterruptedException {
        return RemotingDiagnostics.getThreadDump(getChannel());
    }

    /**
     * Obtains the heap dump.
     */
    public HeapDump getHeapDump() throws IOException {
        return new HeapDump(this,getChannel());
    }

    /**
     * This method tries to compute the name of the host that's reachable by all the other nodes.
     *
     * <p>
     * Since it's possible that the slave is not reachable from the master (it may be behind a firewall,
     * connecting to master via JNLP), this method may return null.
     *
     * It's surprisingly tricky for a machine to know a name that other systems can get to,
     * especially between things like DNS search suffix, the hosts file, and YP.
     *
     * <p>
     * So the technique here is to compute possible interfaces and names on the slave,
     * then try to ping them from the master, and pick the one that worked.
     *
     * <p>
     * The computation may take some time, so it employs caching to make the successive lookups faster.
     *
     * @since 1.300
     * @return
     *      null if the host name cannot be computed (for example because this computer is offline,
     *      because the slave is behind the firewall, etc.) 
     */
    public String getHostName() throws IOException, InterruptedException {
        if(hostNameCached)
            // in the worst case we end up having multiple threads computing the host name simultaneously, but that's not harmful, just wasteful.
            return cachedHostName;

        VirtualChannel channel = getChannel();
        if(channel==null)   return null; // can't compute right now

        for( String address : channel.call(new ListPossibleNames())) {
            try {
                InetAddress ia = InetAddress.getByName(address);
                if(!(ia instanceof Inet4Address)) {
                    LOGGER.fine(address+" is not an IPv4 address");
                    continue;
                }
                if(!ComputerPinger.checkIsReachable(ia, 3)) {
                    LOGGER.fine(address+" didn't respond to ping");
                    continue;
                }
                cachedHostName = ia.getCanonicalHostName();
                hostNameCached = true;
                return cachedHostName;
            } catch (IOException e) {
                // if a given name fails to parse on this host, we get this error
                LOGGER.log(Level.FINE, "Failed to parse "+address,e);
            }
        }

        // allow the administrator to manually specify the host name as a fallback. HUDSON-5373
        cachedHostName = channel.call(new GetFallbackName());
        hostNameCached = true;
        return cachedHostName;
    }

    /**
     * Starts executing a fly-weight task.
     */
    /*package*/ final void startFlyWeightTask(WorkUnit p) {
        OneOffExecutor e = new OneOffExecutor(this, p);
        e.start();
        oneOffExecutors.add(e);
    }

    /*package*/ final void remove(OneOffExecutor e) {
        oneOffExecutors.remove(e);
    }

    private static class ListPossibleNames implements Callable<List<String>,IOException> {
        public List<String> call() throws IOException {
            List<String> names = new ArrayList<String>();

            Enumeration<NetworkInterface> nis = NetworkInterface.getNetworkInterfaces();
            while (nis.hasMoreElements()) {
                NetworkInterface ni =  nis.nextElement();
                LOGGER.fine("Listing up IP addresses for "+ni.getDisplayName());
                Enumeration<InetAddress> e = ni.getInetAddresses();
                while (e.hasMoreElements()) {
                    InetAddress ia =  e.nextElement();
                    if(ia.isLoopbackAddress()) {
                        LOGGER.fine(ia+" is a loopback address");
                        continue;
                    }

                    if(!(ia instanceof Inet4Address)) {
                        LOGGER.fine(ia+" is not an IPv4 address");
                        continue;
                    }

                    LOGGER.fine(ia+" is a viable candidate");
                    names.add(ia.getHostAddress());
                }
            }
            return names;
        }
        private static final long serialVersionUID = 1L;
    }

    private static class GetFallbackName implements Callable<String,IOException> {
        public String call() throws IOException {
            return System.getProperty("host.name");
        }
        private static final long serialVersionUID = 1L;
    }

    public static final ExecutorService threadPoolForRemoting = Executors.newCachedThreadPool(new ExceptionCatchingThreadFactory(
            new ThreadFactory() {
                
                private final AtomicInteger threadNumber = new AtomicInteger(1);
                
                @Override
                public Thread newThread(Runnable r) {
                    Thread t = new Thread(r);
                    t.setName("Jenkins-Remoting-Thread-"+threadNumber.getAndIncrement());
                    t.setDaemon(true);
                    return t;
                }
            }));

//
//
// UI
//
//
    public void doRssAll( StaplerRequest req, StaplerResponse rsp ) throws IOException, ServletException {
        rss(req, rsp, " all builds", getBuilds());
    }
    public void doRssFailed( StaplerRequest req, StaplerResponse rsp ) throws IOException, ServletException {
        rss(req, rsp, " failed builds", getBuilds().failureOnly());
    }
    private void rss(StaplerRequest req, StaplerResponse rsp, String suffix, RunList runs) throws IOException, ServletException {
        RSS.forwardToRss(getDisplayName()+ suffix, getUrl(),
            runs.newBuilds(), Run.FEED_ADAPTER, req, rsp );
    }

    public HttpResponse doToggleOffline(@QueryParameter String offlineMessage) throws IOException, ServletException {
        if(!temporarilyOffline) {
            checkPermission(DISCONNECT);
            offlineMessage = Util.fixEmptyAndTrim(offlineMessage);
            setTemporarilyOffline(!temporarilyOffline,
                    OfflineCause.create(hudson.slaves.Messages._SlaveComputer_DisconnectedBy(
                        Jenkins.getAuthentication().getName(),
                        offlineMessage!=null ? " : " + offlineMessage : "")));
        } else {
            checkPermission(CONNECT);
            setTemporarilyOffline(!temporarilyOffline,null);
        }
        return HttpResponses.redirectToDot();
    }

    public HttpResponse doChangeOfflineCause(@QueryParameter String offlineMessage) throws IOException, ServletException {
        checkPermission(DISCONNECT);
        offlineMessage = Util.fixEmptyAndTrim(offlineMessage);
        setTemporarilyOffline(true,
                OfflineCause.create(hudson.slaves.Messages._SlaveComputer_DisconnectedBy(
                        Jenkins.getAuthentication().getName(),
                        offlineMessage != null ? " : " + offlineMessage : "")));
        return HttpResponses.redirectToDot();
    }

    public Api getApi() {
        return new Api(this);
    }

    /**
     * Dumps the contents of the export table.
     */
    public void doDumpExportTable( StaplerRequest req, StaplerResponse rsp ) throws IOException, ServletException, InterruptedException {
        // this is a debug probe and may expose sensitive information
        checkPermission(Jenkins.ADMINISTER);

        rsp.setContentType("text/plain");
        PrintWriter w = new PrintWriter(rsp.getCompressedWriter(req));
        VirtualChannel vc = getChannel();
        if (vc instanceof Channel) {
            w.println("Master to slave");
            ((Channel)vc).dumpExportTable(w);
            w.flush(); // flush here once so that even if the dump from the slave fails, the client gets some useful info

            w.println("\n\n\nSlave to master");
            w.print(vc.call(new DumpExportTableTask()));
        } else {
            w.println(Messages.Computer_BadChannel());
        }
        w.close();
    }

    private static final class DumpExportTableTask implements Callable<String,IOException> {
        public String call() throws IOException {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            Channel.current().dumpExportTable(pw);
            pw.close();
            return sw.toString();
        }
    }

    /**
     * For system diagnostics.
     * Run arbitrary Groovy script.
     */
    public void doScript(StaplerRequest req, StaplerResponse rsp) throws IOException, ServletException {
        _doScript(req, rsp, "_script.jelly");
    }

    /**
     * Run arbitrary Groovy script and return result as plain text.
     */
    public void doScriptText(StaplerRequest req, StaplerResponse rsp) throws IOException, ServletException {
        _doScript(req, rsp, "_scriptText.jelly");
    }

    protected void _doScript( StaplerRequest req, StaplerResponse rsp, String view) throws IOException, ServletException {
        Jenkins._doScript(req, rsp, req.getView(this, view), getChannel(), getACL());
    }

    /**
     * Accepts the update to the node configuration.
     */
    @RequirePOST
    public void doConfigSubmit( StaplerRequest req, StaplerResponse rsp ) throws IOException, ServletException, FormException {
        checkPermission(CONFIGURE);

        String name = Util.fixEmptyAndTrim(req.getSubmittedForm().getString("name"));
        Jenkins.checkGoodName(name);
        
        Node node = getNode();
        if (node == null) {
            throw new ServletException("No such node " + nodeName);
        }
        Node result = node.reconfigure(req, req.getSubmittedForm());
        replaceBy(result);

        // take the user back to the slave top page.
        rsp.sendRedirect2("../" + result.getNodeName() + '/');
    }

    /**
     * Accepts <tt>config.xml</tt> submission, as well as serve it.
     */
    @WebMethod(name = "config.xml")
    public void doConfigDotXml(StaplerRequest req, StaplerResponse rsp)
            throws IOException, ServletException {

        if (req.getMethod().equals("GET")) {
            // read
            checkPermission(EXTENDED_READ);
            rsp.setContentType("application/xml");
            Jenkins.XSTREAM2.toXMLUTF8(getNode(), rsp.getOutputStream());
            return;
        }
        if (req.getMethod().equals("POST")) {
            // submission
            updateByXml(req.getInputStream());
            return;
        }

        // huh?
        rsp.sendError(SC_BAD_REQUEST);
    }

    /**
     * Replaces the current {@link Node} by another one.
     */
    private void replaceBy(Node newNode) throws ServletException, IOException {
        final Jenkins app = Jenkins.getInstance();

        // replace the old Node object by the new one
        synchronized (app) {
            List<Node> nodes = new ArrayList<Node>(app.getNodes());
            int i = nodes.indexOf(getNode());
            if(i<0) {
                throw new IOException("This slave appears to be removed while you were editing the configuration");
            }

            nodes.set(i, newNode);
            app.setNodes(nodes);
        }
    }

    /**
     * Updates Job by its XML definition.
     *
     * @since 1.526
     */
    public void updateByXml(final InputStream source) throws IOException, ServletException {
        checkPermission(CONFIGURE);
        Node result = (Node)Jenkins.XSTREAM2.fromXML(source);
        replaceBy(result);
    }

    /**
     * Really deletes the slave.
     */
    @CLIMethod(name="delete-node")
    public HttpResponse doDoDelete() throws IOException {
        checkPermission(DELETE);
        Node node = getNode();
        if (node != null) {
            Jenkins.getInstance().removeNode(node);
        } else {
            AbstractCIBase app = Jenkins.getInstance();
            app.removeComputer(this);
        }
        return new HttpRedirect("..");
    }

    /**
     * Blocks until the node becomes online/offline.
     */
    @CLIMethod(name="wait-node-online")
    public void waitUntilOnline() throws InterruptedException {
        synchronized (statusChangeLock) {
            while (!isOnline())
                statusChangeLock.wait(1000);
        }
    }

    @CLIMethod(name="wait-node-offline")
    public void waitUntilOffline() throws InterruptedException {
        synchronized (statusChangeLock) {
            while (!isOffline())
                statusChangeLock.wait(1000);
        }
    }

    /**
     * Handles incremental log.
     */
    public void doProgressiveLog( StaplerRequest req, StaplerResponse rsp) throws IOException {
        getLogText().doProgressText(req,rsp);
    }

    /**
     * Gets the current {@link Computer} that the build is running.
     * This method only works when called during a build, such as by
     * {@link hudson.tasks.Publisher}, {@link hudson.tasks.BuildWrapper}, etc.
     */
    public static Computer currentComputer() {
        Executor e = Executor.currentExecutor();
        // If no executor then must be on master node
        return e != null ? e.getOwner() : Jenkins.getInstance().toComputer();
    }

    /**
     * Returns {@code true} if the computer is accepting tasks. Needed to allow slaves programmatic suspension of task
     * scheduling that does not overlap with being offline.
     *
     * @return {@code true} if the computer is accepting tasks
     */
    public boolean isAcceptingTasks() {
        return true;
    }

    /**
     * Used for CLI binding.
     */
    @CLIResolver
    public static Computer resolveForCLI(
            @Argument(required=true,metaVar="NAME",usage="Slave name, or empty string for master") String name) throws CmdLineException {
        Jenkins h = Jenkins.getInstance();
        Computer item = h.getComputer(name);
        if (item==null) {
            List<String> names = new ArrayList<String>();
            for (Computer c : h.getComputers())
                if (c.getName().length()>0)
                    names.add(c.getName());
            throw new CmdLineException(null,Messages.Computer_NoSuchSlaveExists(name,EditDistance.findNearest(name,names)));
        }
        return item;
    }

    /**
     * Relocate log files in the old location to the new location.
     *
     * Files were used to be $JENKINS_ROOT/slave-NAME.log (and .1, .2, ...)
     * but now they are at $JENKINS_ROOT/logs/slaves/NAME/slave.log (and .1, .2, ...)
     *
     * @see #getLogFile()
     */
    @Initializer
    public static void relocateOldLogs() {
        relocateOldLogs(Jenkins.getInstance().getRootDir());
    }

    /*package*/ static void relocateOldLogs(File dir) {
        final Pattern logfile = Pattern.compile("slave-(.*)\\.log(\\.[0-9]+)?");
        File[] logfiles = dir.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return logfile.matcher(name).matches();
            }
        });
        if (logfiles==null)     return;

        for (File f : logfiles) {
            Matcher m = logfile.matcher(f.getName());
            if (m.matches()) {
                File newLocation = new File(dir, "logs/slaves/" + m.group(1) + "/slave.log" + Util.fixNull(m.group(2)));
                newLocation.getParentFile().mkdirs();
                f.renameTo(newLocation);
            } else {
                assert false;
            }
        }
    }

    public static final PermissionGroup PERMISSIONS = new PermissionGroup(Computer.class,Messages._Computer_Permissions_Title());
    public static final Permission CONFIGURE = new Permission(PERMISSIONS,"Configure", Messages._Computer_ConfigurePermission_Description(), Permission.CONFIGURE, PermissionScope.COMPUTER);
    /**
     * @since 1.532
     */
    public static final Permission EXTENDED_READ = new Permission(PERMISSIONS,"ExtendedRead", Messages._Computer_ExtendedReadPermission_Description(), CONFIGURE, Boolean.getBoolean("hudson.security.ExtendedReadPermission"), new PermissionScope[]{PermissionScope.COMPUTER});
    public static final Permission DELETE = new Permission(PERMISSIONS,"Delete", Messages._Computer_DeletePermission_Description(), Permission.DELETE, PermissionScope.COMPUTER);
    public static final Permission CREATE = new Permission(PERMISSIONS,"Create", Messages._Computer_CreatePermission_Description(), Permission.CREATE, PermissionScope.COMPUTER);
    public static final Permission DISCONNECT = new Permission(PERMISSIONS,"Disconnect", Messages._Computer_DisconnectPermission_Description(), Jenkins.ADMINISTER, PermissionScope.COMPUTER);
    public static final Permission CONNECT = new Permission(PERMISSIONS,"Connect", Messages._Computer_ConnectPermission_Description(), DISCONNECT, PermissionScope.COMPUTER);
    public static final Permission BUILD = new Permission(PERMISSIONS, "Build", Messages._Computer_BuildPermission_Description(),  Permission.WRITE, PermissionScope.COMPUTER);

    private static final Logger LOGGER = Logger.getLogger(Computer.class.getName());
}
