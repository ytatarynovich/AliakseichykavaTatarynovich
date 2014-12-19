// CHECKSTYLE:OFF

package hudson.tools;

import org.jvnet.localizer.Localizable;
import org.jvnet.localizer.ResourceBundleHolder;

@SuppressWarnings({
    "",
    "PMD"
})
public class Messages {

    private final static ResourceBundleHolder holder = ResourceBundleHolder.get(Messages.class);

    /**
     * Run Command
     * 
     */
    public static String CommandInstaller_DescriptorImpl_displayName() {
        return holder.format("CommandInstaller.DescriptorImpl.displayName");
    }

    /**
     * Run Command
     * 
     */
    public static Localizable _CommandInstaller_DescriptorImpl_displayName() {
        return new Localizable(holder, "CommandInstaller.DescriptorImpl.displayName");
    }

    /**
     * Could not connect to URL.
     * 
     */
    public static String ZipExtractionInstaller_could_not_connect() {
        return holder.format("ZipExtractionInstaller.could_not_connect");
    }

    /**
     * Could not connect to URL.
     * 
     */
    public static Localizable _ZipExtractionInstaller_could_not_connect() {
        return new Localizable(holder, "ZipExtractionInstaller.could_not_connect");
    }

    /**
     * Must provide a command to run.
     * 
     */
    public static String CommandInstaller_no_command() {
        return holder.format("CommandInstaller.no_command");
    }

    /**
     * Must provide a command to run.
     * 
     */
    public static Localizable _CommandInstaller_no_command() {
        return new Localizable(holder, "CommandInstaller.no_command");
    }

    /**
     * Must provide a tool home directory.
     * 
     */
    public static String CommandInstaller_no_toolHome() {
        return holder.format("CommandInstaller.no_toolHome");
    }

    /**
     * Must provide a tool home directory.
     * 
     */
    public static Localizable _CommandInstaller_no_toolHome() {
        return new Localizable(holder, "CommandInstaller.no_toolHome");
    }

    /**
     * Installing JDK requires Oracle account. &lt;a href="{0}" target="_new">Please enter your username/password&lt;/a>
     * 
     */
    public static String JDKInstaller_RequireOracleAccount(Object arg1) {
        return holder.format("JDKInstaller.RequireOracleAccount", arg1);
    }

    /**
     * Installing JDK requires Oracle account. &lt;a href="{0}" target="_new">Please enter your username/password&lt;/a>
     * 
     */
    public static Localizable _JDKInstaller_RequireOracleAccount(Object arg1) {
        return new Localizable(holder, "JDKInstaller.RequireOracleAccount", arg1);
    }

    /**
     * Install automatically
     * 
     */
    public static String InstallSourceProperty_DescriptorImpl_displayName() {
        return holder.format("InstallSourceProperty.DescriptorImpl.displayName");
    }

    /**
     * Install automatically
     * 
     */
    public static Localizable _InstallSourceProperty_DescriptorImpl_displayName() {
        return new Localizable(holder, "InstallSourceProperty.DescriptorImpl.displayName");
    }

    /**
     * Unable to auto-install JDK until the license is accepted.
     * 
     */
    public static String JDKInstaller_UnableToInstallUntilLicenseAccepted() {
        return holder.format("JDKInstaller.UnableToInstallUntilLicenseAccepted");
    }

    /**
     * Unable to auto-install JDK until the license is accepted.
     * 
     */
    public static Localizable _JDKInstaller_UnableToInstallUntilLicenseAccepted() {
        return new Localizable(holder, "JDKInstaller.UnableToInstallUntilLicenseAccepted");
    }

    /**
     * Tool Locations
     * 
     */
    public static String ToolLocationNodeProperty_displayName() {
        return holder.format("ToolLocationNodeProperty.displayName");
    }

    /**
     * Tool Locations
     * 
     */
    public static Localizable _ToolLocationNodeProperty_displayName() {
        return new Localizable(holder, "ToolLocationNodeProperty.displayName");
    }

    /**
     * Malformed URL.
     * 
     */
    public static String ZipExtractionInstaller_malformed_url() {
        return holder.format("ZipExtractionInstaller.malformed_url");
    }

    /**
     * Malformed URL.
     * 
     */
    public static Localizable _ZipExtractionInstaller_malformed_url() {
        return new Localizable(holder, "ZipExtractionInstaller.malformed_url");
    }

    /**
     * Define JDK ID
     * 
     */
    public static String JDKInstaller_DescriptorImpl_doCheckId() {
        return holder.format("JDKInstaller.DescriptorImpl.doCheckId");
    }

    /**
     * Define JDK ID
     * 
     */
    public static Localizable _JDKInstaller_DescriptorImpl_doCheckId() {
        return new Localizable(holder, "JDKInstaller.DescriptorImpl.doCheckId");
    }

    /**
     * Failed to install JDK. Exit code={0}
     * 
     */
    public static String JDKInstaller_FailedToInstallJDK(Object arg1) {
        return holder.format("JDKInstaller.FailedToInstallJDK", arg1);
    }

    /**
     * Failed to install JDK. Exit code={0}
     * 
     */
    public static Localizable _JDKInstaller_FailedToInstallJDK(Object arg1) {
        return new Localizable(holder, "JDKInstaller.FailedToInstallJDK", arg1);
    }

    /**
     * Extract *.zip/*.tar.gz
     * 
     */
    public static String ZipExtractionInstaller_DescriptorImpl_displayName() {
        return holder.format("ZipExtractionInstaller.DescriptorImpl.displayName");
    }

    /**
     * Extract *.zip/*.tar.gz
     * 
     */
    public static Localizable _ZipExtractionInstaller_DescriptorImpl_displayName() {
        return new Localizable(holder, "ZipExtractionInstaller.DescriptorImpl.displayName");
    }

    /**
     * Server rejected connection.
     * 
     */
    public static String ZipExtractionInstaller_bad_connection() {
        return holder.format("ZipExtractionInstaller.bad_connection");
    }

    /**
     * Server rejected connection.
     * 
     */
    public static Localizable _ZipExtractionInstaller_bad_connection() {
        return new Localizable(holder, "ZipExtractionInstaller.bad_connection");
    }

    /**
     * You must agree to the license to download the JDK.
     * 
     */
    public static String JDKInstaller_DescriptorImpl_doCheckAcceptLicense() {
        return holder.format("JDKInstaller.DescriptorImpl.doCheckAcceptLicense");
    }

    /**
     * You must agree to the license to download the JDK.
     * 
     */
    public static Localizable _JDKInstaller_DescriptorImpl_doCheckAcceptLicense() {
        return new Localizable(holder, "JDKInstaller.DescriptorImpl.doCheckAcceptLicense");
    }

    /**
     * Install from java.sun.com
     * 
     */
    public static String JDKInstaller_DescriptorImpl_displayName() {
        return holder.format("JDKInstaller.DescriptorImpl.displayName");
    }

    /**
     * Install from java.sun.com
     * 
     */
    public static Localizable _JDKInstaller_DescriptorImpl_displayName() {
        return new Localizable(holder, "JDKInstaller.DescriptorImpl.displayName");
    }

}
