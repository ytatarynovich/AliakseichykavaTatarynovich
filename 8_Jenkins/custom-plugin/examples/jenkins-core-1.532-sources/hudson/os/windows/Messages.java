// CHECKSTYLE:OFF

package hudson.os.windows;

import org.jvnet.localizer.Localizable;
import org.jvnet.localizer.ResourceBundleHolder;

@SuppressWarnings({
    "",
    "PMD"
})
public class Messages {

    private final static ResourceBundleHolder holder = ResourceBundleHolder.get(Messages.class);

    /**
     * Copying jenkins-slave.exe
     * 
     */
    public static String ManagedWindowsServiceLauncher_CopyingSlaveExe() {
        return holder.format("ManagedWindowsServiceLauncher.CopyingSlaveExe");
    }

    /**
     * Copying jenkins-slave.exe
     * 
     */
    public static Localizable _ManagedWindowsServiceLauncher_CopyingSlaveExe() {
        return new Localizable(holder, "ManagedWindowsServiceLauncher.CopyingSlaveExe");
    }

    /**
     * Stopping the service
     * 
     */
    public static String ManagedWindowsServiceLauncher_StoppingService() {
        return holder.format("ManagedWindowsServiceLauncher.StoppingService");
    }

    /**
     * Stopping the service
     * 
     */
    public static Localizable _ManagedWindowsServiceLauncher_StoppingService() {
        return new Localizable(holder, "ManagedWindowsServiceLauncher.StoppingService");
    }

    /**
     * The service did not respond. Perhaps it failed to launch?
     * 
     */
    public static String ManagedWindowsServiceLauncher_ServiceDidntRespond() {
        return holder.format("ManagedWindowsServiceLauncher.ServiceDidntRespond");
    }

    /**
     * The service did not respond. Perhaps it failed to launch?
     * 
     */
    public static Localizable _ManagedWindowsServiceLauncher_ServiceDidntRespond() {
        return new Localizable(holder, "ManagedWindowsServiceLauncher.ServiceDidntRespond");
    }

    /**
     * Unregistering the service
     * 
     */
    public static String ManagedWindowsServiceLauncher_UnregisteringService() {
        return holder.format("ManagedWindowsServiceLauncher.UnregisteringService");
    }

    /**
     * Unregistering the service
     * 
     */
    public static Localizable _ManagedWindowsServiceLauncher_UnregisteringService() {
        return new Localizable(holder, "ManagedWindowsServiceLauncher.UnregisteringService");
    }

    /**
     * Registering the service
     * 
     */
    public static String ManagedWindowsServiceLauncher_RegisteringService() {
        return holder.format("ManagedWindowsServiceLauncher.RegisteringService");
    }

    /**
     * Registering the service
     * 
     */
    public static Localizable _ManagedWindowsServiceLauncher_RegisteringService() {
        return new Localizable(holder, "ManagedWindowsServiceLauncher.RegisteringService");
    }

    /**
     * .NET Framework 2.0 or later is required on this computer to run a Jenkins slave as a Windows service
     * 
     */
    public static String ManagedWindowsServiceLauncher_DotNetRequired() {
        return holder.format("ManagedWindowsServiceLauncher.DotNetRequired");
    }

    /**
     * .NET Framework 2.0 or later is required on this computer to run a Jenkins slave as a Windows service
     * 
     */
    public static Localizable _ManagedWindowsServiceLauncher_DotNetRequired() {
        return new Localizable(holder, "ManagedWindowsServiceLauncher.DotNetRequired");
    }

    /**
     * Installing the Jenkins slave service
     * 
     */
    public static String ManagedWindowsServiceLauncher_InstallingSlaveService() {
        return holder.format("ManagedWindowsServiceLauncher.InstallingSlaveService");
    }

    /**
     * Installing the Jenkins slave service
     * 
     */
    public static Localizable _ManagedWindowsServiceLauncher_InstallingSlaveService() {
        return new Localizable(holder, "ManagedWindowsServiceLauncher.InstallingSlaveService");
    }

    /**
     * Waiting for the service to become ready
     * 
     */
    public static String ManagedWindowsServiceLauncher_WaitingForService() {
        return holder.format("ManagedWindowsServiceLauncher.WaitingForService");
    }

    /**
     * Waiting for the service to become ready
     * 
     */
    public static Localizable _ManagedWindowsServiceLauncher_WaitingForService() {
        return new Localizable(holder, "ManagedWindowsServiceLauncher.WaitingForService");
    }

    /**
     * Access is denied. See http://wiki.jenkins-ci.org/display/JENKINS/Windows+slaves+fail+to+start+via+DCOM for more information about how to resolve this.
     * 
     */
    public static String ManagedWindowsServiceLauncher_AccessDenied() {
        return holder.format("ManagedWindowsServiceLauncher.AccessDenied");
    }

    /**
     * Access is denied. See http://wiki.jenkins-ci.org/display/JENKINS/Windows+slaves+fail+to+start+via+DCOM for more information about how to resolve this.
     * 
     */
    public static Localizable _ManagedWindowsServiceLauncher_AccessDenied() {
        return new Localizable(holder, "ManagedWindowsServiceLauncher.AccessDenied");
    }

    /**
     * Copying slave.jar
     * 
     */
    public static String ManagedWindowsServiceLauncher_CopyingSlaveJar() {
        return holder.format("ManagedWindowsServiceLauncher.CopyingSlaveJar");
    }

    /**
     * Copying slave.jar
     * 
     */
    public static Localizable _ManagedWindowsServiceLauncher_CopyingSlaveJar() {
        return new Localizable(holder, "ManagedWindowsServiceLauncher.CopyingSlaveJar");
    }

    /**
     * Copying jenkins-slave.xml
     * 
     */
    public static String ManagedWindowsServiceLauncher_CopyingSlaveXml() {
        return holder.format("ManagedWindowsServiceLauncher.CopyingSlaveXml");
    }

    /**
     * Copying jenkins-slave.xml
     * 
     */
    public static Localizable _ManagedWindowsServiceLauncher_CopyingSlaveXml() {
        return new Localizable(holder, "ManagedWindowsServiceLauncher.CopyingSlaveXml");
    }

    /**
     * Let Jenkins control this Windows slave as a Windows service
     * 
     */
    public static String ManagedWindowsServiceLauncher_DisplayName() {
        return holder.format("ManagedWindowsServiceLauncher.DisplayName");
    }

    /**
     * Let Jenkins control this Windows slave as a Windows service
     * 
     */
    public static Localizable _ManagedWindowsServiceLauncher_DisplayName() {
        return new Localizable(holder, "ManagedWindowsServiceLauncher.DisplayName");
    }

    /**
     * Starting the service
     * 
     */
    public static String ManagedWindowsServiceLauncher_StartingService() {
        return holder.format("ManagedWindowsServiceLauncher.StartingService");
    }

    /**
     * Starting the service
     * 
     */
    public static Localizable _ManagedWindowsServiceLauncher_StartingService() {
        return new Localizable(holder, "ManagedWindowsServiceLauncher.StartingService");
    }

    /**
     * Connecting to port {0}
     * 
     */
    public static String ManagedWindowsServiceLauncher_ConnectingToPort(Object arg1) {
        return holder.format("ManagedWindowsServiceLauncher.ConnectingToPort", arg1);
    }

    /**
     * Connecting to port {0}
     * 
     */
    public static Localizable _ManagedWindowsServiceLauncher_ConnectingToPort(Object arg1) {
        return new Localizable(holder, "ManagedWindowsServiceLauncher.ConnectingToPort", arg1);
    }

    /**
     * Connecting to {0}
     * 
     */
    public static String ManagedWindowsServiceLauncher_ConnectingTo(Object arg1) {
        return holder.format("ManagedWindowsServiceLauncher.ConnectingTo", arg1);
    }

    /**
     * Connecting to {0}
     * 
     */
    public static Localizable _ManagedWindowsServiceLauncher_ConnectingTo(Object arg1) {
        return new Localizable(holder, "ManagedWindowsServiceLauncher.ConnectingTo", arg1);
    }

}
