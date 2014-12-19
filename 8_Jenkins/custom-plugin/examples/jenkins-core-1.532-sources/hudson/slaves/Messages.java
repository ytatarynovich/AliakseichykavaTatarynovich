// CHECKSTYLE:OFF

package hudson.slaves;

import org.jvnet.localizer.Localizable;
import org.jvnet.localizer.ResourceBundleHolder;

@SuppressWarnings({
    "",
    "PMD"
})
public class Messages {

    private final static ResourceBundleHolder holder = ResourceBundleHolder.get(Messages.class);

    /**
     * Dumb Slave
     * 
     */
    public static String DumbSlave_displayName() {
        return holder.format("DumbSlave.displayName");
    }

    /**
     * Dumb Slave
     * 
     */
    public static Localizable _DumbSlave_displayName() {
        return new Localizable(holder, "DumbSlave.displayName");
    }

    /**
     * Environment variables
     * 
     */
    public static String EnvironmentVariablesNodeProperty_displayName() {
        return holder.format("EnvironmentVariablesNodeProperty.displayName");
    }

    /**
     * Environment variables
     * 
     */
    public static Localizable _EnvironmentVariablesNodeProperty_displayName() {
        return new Localizable(holder, "EnvironmentVariablesNodeProperty.displayName");
    }

    /**
     * Offline because computer was idle; it will be relaunched when needed.
     * 
     */
    public static String RetentionStrategy_Demand_OfflineIdle() {
        return holder.format("RetentionStrategy.Demand.OfflineIdle");
    }

    /**
     * Offline because computer was idle; it will be relaunched when needed.
     * 
     */
    public static Localizable _RetentionStrategy_Demand_OfflineIdle() {
        return new Localizable(holder, "RetentionStrategy.Demand.OfflineIdle");
    }

    /**
     * Launch slave agents via Java Web Start
     * 
     */
    public static String JNLPLauncher_displayName() {
        return holder.format("JNLPLauncher.displayName");
    }

    /**
     * Launch slave agents via Java Web Start
     * 
     */
    public static Localizable _JNLPLauncher_displayName() {
        return new Localizable(holder, "JNLPLauncher.displayName");
    }

    /**
     * Couldn’t figure out the Java version of {0}
     * 
     */
    public static String ComputerLauncher_UknownJavaVersion(Object arg1) {
        return holder.format("ComputerLauncher.UknownJavaVersion", arg1);
    }

    /**
     * Couldn’t figure out the Java version of {0}
     * 
     */
    public static Localizable _ComputerLauncher_UknownJavaVersion(Object arg1) {
        return new Localizable(holder, "ComputerLauncher.UknownJavaVersion", arg1);
    }

    /**
     * Disconnected from CLI
     * 
     */
    public static String OfflineCause_DisconnectedFromCLI() {
        return holder.format("OfflineCause.DisconnectedFromCLI");
    }

    /**
     * Disconnected from CLI
     * 
     */
    public static Localizable _OfflineCause_DisconnectedFromCLI() {
        return new Localizable(holder, "OfflineCause.DisconnectedFromCLI");
    }

    /**
     * Launching slave process aborted.
     * 
     */
    public static String ComputerLauncher_abortedLaunch() {
        return holder.format("ComputerLauncher.abortedLaunch");
    }

    /**
     * Launching slave process aborted.
     * 
     */
    public static Localizable _ComputerLauncher_abortedLaunch() {
        return new Localizable(holder, "ComputerLauncher.abortedLaunch");
    }

    /**
     * Computer has finished its scheduled uptime
     * 
     */
    public static String SimpleScheduledRetentionStrategy_FinishedUpTime() {
        return holder.format("SimpleScheduledRetentionStrategy.FinishedUpTime");
    }

    /**
     * Computer has finished its scheduled uptime
     * 
     */
    public static Localizable _SimpleScheduledRetentionStrategy_FinishedUpTime() {
        return new Localizable(holder, "SimpleScheduledRetentionStrategy.FinishedUpTime");
    }

    /**
     * Name is mandatory
     * 
     */
    public static String NodeDescripter_CheckName_Mandatory() {
        return holder.format("NodeDescripter.CheckName.Mandatory");
    }

    /**
     * Name is mandatory
     * 
     */
    public static Localizable _NodeDescripter_CheckName_Mandatory() {
        return new Localizable(holder, "NodeDescripter.CheckName.Mandatory");
    }

    /**
     * 
     * 
     */
    public static String NodeProvisioner_EmptyString() {
        return holder.format("NodeProvisioner.EmptyString");
    }

    /**
     * 
     * 
     */
    public static Localizable _NodeProvisioner_EmptyString() {
        return new Localizable(holder, "NodeProvisioner.EmptyString");
    }

    /**
     * Unexpected error in launching a slave. This is probably a bug in Jenkins
     * 
     */
    public static String ComputerLauncher_unexpectedError() {
        return holder.format("ComputerLauncher.unexpectedError");
    }

    /**
     * Unexpected error in launching a slave. This is probably a bug in Jenkins
     * 
     */
    public static Localizable _ComputerLauncher_unexpectedError() {
        return new Localizable(holder, "ComputerLauncher.unexpectedError");
    }

    /**
     * Take this slave on-line according to a schedule
     * 
     */
    public static String SimpleScheduledRetentionStrategy_displayName() {
        return holder.format("SimpleScheduledRetentionStrategy.displayName");
    }

    /**
     * Take this slave on-line according to a schedule
     * 
     */
    public static Localizable _SimpleScheduledRetentionStrategy_displayName() {
        return new Localizable(holder, "SimpleScheduledRetentionStrategy.displayName");
    }

    /**
     * Repeated ping attempts failed
     * 
     */
    public static String ConnectionActivityMonitor_OfflineCause() {
        return holder.format("ConnectionActivityMonitor.OfflineCause");
    }

    /**
     * Repeated ping attempts failed
     * 
     */
    public static Localizable _ConnectionActivityMonitor_OfflineCause() {
        return new Localizable(holder, "ConnectionActivityMonitor.OfflineCause");
    }

    /**
     * Launch slave via execution of command on the Master
     * 
     */
    public static String CommandLauncher_displayName() {
        return holder.format("CommandLauncher.displayName");
    }

    /**
     * Launch slave via execution of command on the Master
     * 
     */
    public static Localizable _CommandLauncher_displayName() {
        return new Localizable(holder, "CommandLauncher.displayName");
    }

    /**
     * {0} -version returned {1}.
     * 
     */
    public static String ComputerLauncher_JavaVersionResult(Object arg1, Object arg2) {
        return holder.format("ComputerLauncher.JavaVersionResult", arg1, arg2);
    }

    /**
     * {0} -version returned {1}.
     * 
     */
    public static Localizable _ComputerLauncher_JavaVersionResult(Object arg1, Object arg2) {
        return new Localizable(holder, "ComputerLauncher.JavaVersionResult", arg1, arg2);
    }

    /**
     * Disconnected by {0}{1}
     * 
     */
    public static String SlaveComputer_DisconnectedBy(Object arg1, Object arg2) {
        return holder.format("SlaveComputer.DisconnectedBy", arg1, arg2);
    }

    /**
     * Disconnected by {0}{1}
     * 
     */
    public static Localizable _SlaveComputer_DisconnectedBy(Object arg1, Object arg2) {
        return new Localizable(holder, "SlaveComputer.DisconnectedBy", arg1, arg2);
    }

    /**
     * Java version {0} was found but 1.5 or later is needed.
     * 
     */
    public static String ComputerLauncher_NoJavaFound(Object arg1) {
        return holder.format("ComputerLauncher.NoJavaFound", arg1);
    }

    /**
     * Java version {0} was found but 1.5 or later is needed.
     * 
     */
    public static Localizable _ComputerLauncher_NoJavaFound(Object arg1) {
        return new Localizable(holder, "ComputerLauncher.NoJavaFound", arg1);
    }

    /**
     * No launch command specified
     * 
     */
    public static String CommandLauncher_NoLaunchCommand() {
        return holder.format("CommandLauncher.NoLaunchCommand");
    }

    /**
     * No launch command specified
     * 
     */
    public static Localizable _CommandLauncher_NoLaunchCommand() {
        return new Localizable(holder, "CommandLauncher.NoLaunchCommand");
    }

    /**
     * Keep this slave on-line as much as possible
     * 
     */
    public static String RetentionStrategy_Always_displayName() {
        return holder.format("RetentionStrategy.Always.displayName");
    }

    /**
     * Keep this slave on-line as much as possible
     * 
     */
    public static Localizable _RetentionStrategy_Always_displayName() {
        return new Localizable(holder, "RetentionStrategy.Always.displayName");
    }

    /**
     * Take this slave on-line when in demand and off-line when idle
     * 
     */
    public static String RetentionStrategy_Demand_displayName() {
        return holder.format("RetentionStrategy.Demand.displayName");
    }

    /**
     * Take this slave on-line when in demand and off-line when idle
     * 
     */
    public static Localizable _RetentionStrategy_Demand_displayName() {
        return new Localizable(holder, "RetentionStrategy.Demand.displayName");
    }

    /**
     * This node is offline because Jenkins failed to launch the slave agent on it.
     * 
     */
    public static String OfflineCause_LaunchFailed() {
        return holder.format("OfflineCause.LaunchFailed");
    }

    /**
     * This node is offline because Jenkins failed to launch the slave agent on it.
     * 
     */
    public static Localizable _OfflineCause_LaunchFailed() {
        return new Localizable(holder, "OfflineCause.LaunchFailed");
    }

}
