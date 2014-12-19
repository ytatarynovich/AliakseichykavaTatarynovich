/*
 * The MIT License
 * 
 * Copyright (c) 2004-2009, Sun Microsystems, Inc., Kohsuke Kawaguchi
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
package hudson.node_monitors;

import hudson.Util;
import hudson.model.Computer;
import hudson.model.Descriptor;
import jenkins.model.Jenkins;
import hudson.model.ComputerSet;
import hudson.model.AdministrativeMonitor;
import hudson.triggers.Trigger;
import hudson.triggers.SafeTimerTask;
import hudson.slaves.OfflineCause;

import java.io.IOException;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Convenient base class for common {@link NodeMonitor} implementation
 * where the "monitoring" consists of executing something periodically on every node
 * and taking some action based on its result.
 *
 * @param <T>
 *     represents the the result of the monitoring.
 * @author Kohsuke Kawaguchi
 */
public abstract class AbstractNodeMonitorDescriptor<T> extends Descriptor<NodeMonitor> {
    /**
     * @deprecated as of 1.522
     *      Extend from {@link AbstractAsyncNodeMonitorDescriptor}
     */
    protected AbstractNodeMonitorDescriptor() {
        this(HOUR);
    }

    /**
     * @deprecated as of 1.522
     *      Extend from {@link AbstractAsyncNodeMonitorDescriptor}
     */
    protected AbstractNodeMonitorDescriptor(long interval) {
        schedule(interval);
    }

    /**
     * @deprecated as of 1.522
     *      Extend from {@link AbstractAsyncNodeMonitorDescriptor}
     */
    protected AbstractNodeMonitorDescriptor(Class<? extends NodeMonitor> clazz) {
        this(clazz,HOUR);
    }

    /**
     * @deprecated as of 1.522
     *      Extend from {@link AbstractAsyncNodeMonitorDescriptor}
     */
    protected AbstractNodeMonitorDescriptor(Class<? extends NodeMonitor> clazz, long interval) {
        super(clazz);

        schedule(interval);
    }

    private void schedule(long interval) {
        Timer timer = Trigger.timer;
        if (timer != null) {
            timer.scheduleAtFixedRate(new SafeTimerTask() {
                public void doRun() {
                    triggerUpdate();
                }
            }, interval, interval);
        }
    }

    /**
     * Represents the last record of the update.
     *
     * Once set to non-null, never be null.
     */
    private transient volatile Record record = null;

    /**
     * Represents the update activity in progress.
     */
    private transient volatile Record inProgress = null;

    /**
     * Performs monitoring of the given computer object.
     * This method is invoked periodically to perform the monitoring of the computer.
     *
     * @return
     *      Application-specific value that represents the observed monitoring value
     *      on the given node. This value will be returned from the {@link #get(Computer)} method.
     *      If null is returned, it will be interpreted as "no observed value." This is
     *      convenient way of abandoning the observation on a particular computer,
     *      whereas {@link IOException} is useful for indicating a hard error that needs to be
     *      corrected.
     */
    protected abstract T monitor(Computer c) throws IOException,InterruptedException;

    /**
     * Performs monitoring across the board.
     *
     * @return
     *      For all the computers, report the monitored values.
     */
    protected Map<Computer,T> monitor() throws InterruptedException {
        Map<Computer,T> data = new HashMap<Computer,T>();
        for( Computer c : Jenkins.getInstance().getComputers() ) {
            try {
                Thread.currentThread().setName("Monitoring "+c.getDisplayName()+" for "+getDisplayName());

                if(c.getChannel()==null)
                    data.put(c,null);
                else
                    data.put(c,monitor(c));
            } catch (RuntimeException e) {
                LOGGER.log(Level.WARNING, "Failed to monitor "+c.getDisplayName()+" for "+getDisplayName(), e);
            } catch (IOException e) {
                LOGGER.log(Level.WARNING, "Failed to monitor "+c.getDisplayName()+" for "+getDisplayName(), e);
            } catch (InterruptedException e) {
                throw (InterruptedException)new InterruptedException("Node monitoring "+c.getDisplayName()+" for "+getDisplayName()+" aborted.").initCause(e);
            }
        }
        return data;
    }

    /**
     * Obtains the monitoring result currently available, or null if no data is available.
     *
     * <p>
     * If no data is available, a background task to collect data will be started.
     */
    public T get(Computer c) {
        if(record==null || !record.data.containsKey(c)) {
            // if we don't have the data, schedule the check now
            if(!isInProgress()) {
                synchronized(this) {
                    if(!isInProgress())
                        new Record().start();
                }
            }
            return null;
        }
        return record.data.get(c);
    }

    /**
     * Is the monitoring activity currently in progress?
     */
    private boolean isInProgress() {
        Record r = inProgress;  // capture for atomicity
        return r!=null && r.isAlive();
    }

    /**
     * The timestamp that indicates when the last round of the monitoring has completed.
     */
    public long getTimestamp() {
        return record==null ? 0L : record.timestamp;
    }

    public String getTimestampString() {
        if (record==null)
            return Messages.AbstractNodeMonitorDescriptor_NoDataYet();
//        return Messages.AbstractNodeMonitorDescriptor_DataObtainedSometimeAgo(
//                Util.getTimeSpanString(System.currentTimeMillis()-record.timestamp));
        return Util.getTimeSpanString(System.currentTimeMillis()-record.timestamp);
    }

    /**
     * Is this monitor currently ignored?
     */
    public boolean isIgnored() {
        NodeMonitor m = ComputerSet.getMonitors().get(this);
        return m==null || m.isIgnored();
    }

    /**
     * Utility method to mark the computer online for derived classes.
     * 
     * @return true 
     *      if the node was actually taken online by this act (as opposed to us deciding not to do it,
     *      or the computer was already online.)
     */
    protected boolean markOnline(Computer c) {
        if(isIgnored() || c.isOnline()) return false; // noop
        c.setTemporarilyOffline(false,null);
        return true;
    }
    
    /**
     * Utility method to mark the computer offline for derived classes.
     *
     * @return true
     *      if the node was actually taken offline by this act (as opposed to us deciding not to do it,
     *      or the computer already marked offline.)
     */
    protected boolean markOffline(Computer c, OfflineCause oc) {
        if(isIgnored() || c.isTemporarilyOffline()) return false; // noop

        c.setTemporarilyOffline(true, oc);

        // notify the admin
        MonitorMarkedNodeOffline no = AdministrativeMonitor.all().get(MonitorMarkedNodeOffline.class);
        if(no!=null)
            no.active = true;
        return true;
    }

    /**
     * @deprecated as of 1.320
     *      Use {@link #markOffline(Computer, OfflineCause)} to specify the cause.
     */
    protected boolean markOffline(Computer c) {
        return markOffline(c,null);
    }

    /**
     * @see NodeMonitor#triggerUpdate()
     */
    /*package*/ Thread triggerUpdate() {
        Record t = new Record();
        t.start();
        return t;
    }

    /**
     * Thread that monitors nodes, as well as the data structure to record
     * the result.
     */
    private final class Record extends Thread {
        /**
         * Last computed monitoring result.
         */
        private /*final*/ Map<Computer,T> data = Collections.emptyMap();

        private long timestamp;

        public Record() {
            super("Monitoring thread for "+getDisplayName()+" started on "+new Date());
            synchronized(AbstractNodeMonitorDescriptor.this) {
                if(inProgress!=null) {
                    // maybe it got stuck?
                    LOGGER.warning("Previous "+getDisplayName()+" monitoring activity still in progress. Interrupting");
                    inProgress.interrupt();
                }
                inProgress = this;
            }
        }

        @Override
        public void run() {
            try {
                long startTime = System.currentTimeMillis();
                String oldName = getName();
                data=monitor();
                setName(oldName);

                timestamp = System.currentTimeMillis();
                record = this;

                LOGGER.fine("Node monitoring "+getDisplayName()+" completed in "+(System.currentTimeMillis()-startTime)+"ms");
            } catch (Throwable t) {
                LOGGER.log(Level.WARNING, "Unexpected node monitoring termination: "+getDisplayName(),t);
            } finally {
                synchronized(AbstractNodeMonitorDescriptor.this) {
                    if (inProgress==this)
                        inProgress = null;
                }
            }
        }
    }

    private static final Logger LOGGER = Logger.getLogger(AbstractNodeMonitorDescriptor.class.getName());

    private static final long HOUR = 1000*60*60L;
}