// CHECKSTYLE:OFF

package hudson.lifecycle;

import org.jvnet.localizer.Localizable;
import org.jvnet.localizer.ResourceBundleHolder;

@SuppressWarnings({
    "",
    "PMD"
})
public class Messages {

    private final static ResourceBundleHolder holder = ResourceBundleHolder.get(Messages.class);

    /**
     * Install as Windows Service
     * 
     */
    public static String WindowsInstallerLink_DisplayName() {
        return holder.format("WindowsInstallerLink.DisplayName");
    }

    /**
     * Install as Windows Service
     * 
     */
    public static Localizable _WindowsInstallerLink_DisplayName() {
        return new Localizable(holder, "WindowsInstallerLink.DisplayName");
    }

    /**
     * Installation was successful. Would you like to start the service now?
     * 
     */
    public static String WindowsSlaveInstaller_InstallationSuccessful() {
        return holder.format("WindowsSlaveInstaller.InstallationSuccessful");
    }

    /**
     * Installation was successful. Would you like to start the service now?
     * 
     */
    public static Localizable _WindowsSlaveInstaller_InstallationSuccessful() {
        return new Localizable(holder, "WindowsSlaveInstaller.InstallationSuccessful");
    }

    /**
     * .NET Framework 2.0 or later is required for this feature
     * 
     */
    public static String WindowsSlaveInstaller_DotNetRequired() {
        return holder.format("WindowsSlaveInstaller.DotNetRequired");
    }

    /**
     * .NET Framework 2.0 or later is required for this feature
     * 
     */
    public static Localizable _WindowsSlaveInstaller_DotNetRequired() {
        return new Localizable(holder, "WindowsSlaveInstaller.DotNetRequired");
    }

    /**
     * Installs Jenkins as a Windows service to this system, so that Jenkins starts automatically when the machine boots.
     * 
     */
    public static String WindowsInstallerLink_Description() {
        return holder.format("WindowsInstallerLink.Description");
    }

    /**
     * Installs Jenkins as a Windows service to this system, so that Jenkins starts automatically when the machine boots.
     * 
     */
    public static Localizable _WindowsInstallerLink_Description() {
        return new Localizable(holder, "WindowsInstallerLink.Description");
    }

    /**
     * Slave root directory ‘{0}’ doesn’t exist
     * 
     */
    public static String WindowsSlaveInstaller_RootFsDoesntExist(Object arg1) {
        return holder.format("WindowsSlaveInstaller.RootFsDoesntExist", arg1);
    }

    /**
     * Slave root directory ‘{0}’ doesn’t exist
     * 
     */
    public static Localizable _WindowsSlaveInstaller_RootFsDoesntExist(Object arg1) {
        return new Localizable(holder, "WindowsSlaveInstaller.RootFsDoesntExist", arg1);
    }

    /**
     * This will install a slave agent as a Windows service, so that a Jenkins slave starts automatically when the machine boots.
     * 
     */
    public static String WindowsSlaveInstaller_ConfirmInstallation() {
        return holder.format("WindowsSlaveInstaller.ConfirmInstallation");
    }

    /**
     * This will install a slave agent as a Windows service, so that a Jenkins slave starts automatically when the machine boots.
     * 
     */
    public static Localizable _WindowsSlaveInstaller_ConfirmInstallation() {
        return new Localizable(holder, "WindowsSlaveInstaller.ConfirmInstallation");
    }

}
