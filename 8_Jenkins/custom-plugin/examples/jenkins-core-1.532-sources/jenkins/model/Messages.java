// CHECKSTYLE:OFF

package jenkins.model;

import org.jvnet.localizer.Localizable;
import org.jvnet.localizer.ResourceBundleHolder;

@SuppressWarnings({
    "",
    "PMD"
})
public class Messages {

    private final static ResourceBundleHolder holder = ResourceBundleHolder.get(Messages.class);

    /**
     * Bad port number {0}
     * 
     */
    public static String Hudson_BadPortNumber(Object arg1) {
        return holder.format("Hudson.BadPortNumber", arg1);
    }

    /**
     * Bad port number {0}
     * 
     */
    public static Localizable _Hudson_BadPortNumber(Object arg1) {
        return new Localizable(holder, "Hudson.BadPortNumber", arg1);
    }

    /**
     * Master
     * 
     */
    public static String Hudson_Computer_Caption() {
        return holder.format("Hudson.Computer.Caption");
    }

    /**
     * Master
     * 
     */
    public static Localizable _Hudson_Computer_Caption() {
        return new Localizable(holder, "Hudson.Computer.Caption");
    }

    /**
     * Aborted by {0}
     * 
     */
    public static String CauseOfInterruption_ShortDescription(Object arg1) {
        return holder.format("CauseOfInterruption.ShortDescription", arg1);
    }

    /**
     * Aborted by {0}
     * 
     */
    public static Localizable _CauseOfInterruption_ShortDescription(Object arg1) {
        return new Localizable(holder, "CauseOfInterruption.ShortDescription", arg1);
    }

    /**
     * master
     * 
     */
    public static String Hudson_Computer_DisplayName() {
        return holder.format("Hudson.Computer.DisplayName");
    }

    /**
     * master
     * 
     */
    public static Localizable _Hudson_Computer_DisplayName() {
        return new Localizable(holder, "Hudson.Computer.DisplayName");
    }

    /**
     * Please set a valid host name, instead of localhost
     * 
     */
    public static String Mailer_Localhost_Error() {
        return holder.format("Mailer.Localhost.Error");
    }

    /**
     * Please set a valid host name, instead of localhost
     * 
     */
    public static Localizable _Mailer_Localhost_Error() {
        return new Localizable(holder, "Mailer.Localhost.Error");
    }

    /**
     * Pattern
     * 
     */
    public static String PatternProjectNamingStrategy_DisplayName() {
        return holder.format("PatternProjectNamingStrategy.DisplayName");
    }

    /**
     * Pattern
     * 
     */
    public static Localizable _PatternProjectNamingStrategy_DisplayName() {
        return new Localizable(holder, "PatternProjectNamingStrategy.DisplayName");
    }

    /**
     * Jenkins
     * 
     */
    public static String Hudson_DisplayName() {
        return holder.format("Hudson.DisplayName");
    }

    /**
     * Jenkins
     * 
     */
    public static Localizable _Hudson_DisplayName() {
        return new Localizable(holder, "Hudson.DisplayName");
    }

    /**
     * A job already exists with the name ‘{0}’
     * 
     */
    public static String Hudson_JobAlreadyExists(Object arg1) {
        return holder.format("Hudson.JobAlreadyExists", arg1);
    }

    /**
     * A job already exists with the name ‘{0}’
     * 
     */
    public static Localizable _Hudson_JobAlreadyExists(Object arg1) {
        return new Localizable(holder, "Hudson.JobAlreadyExists", arg1);
    }

    /**
     * ‘{0}’ is an unsafe character
     * 
     */
    public static String Hudson_UnsafeChar(Object arg1) {
        return holder.format("Hudson.UnsafeChar", arg1);
    }

    /**
     * ‘{0}’ is an unsafe character
     * 
     */
    public static Localizable _Hudson_UnsafeChar(Object arg1) {
        return new Localizable(holder, "Hudson.UnsafeChar", arg1);
    }

    /**
     * No name is specified
     * 
     */
    public static String Hudson_NoName() {
        return holder.format("Hudson.NoName");
    }

    /**
     * No name is specified
     * 
     */
    public static Localizable _Hudson_NoName() {
        return new Localizable(holder, "Hudson.NoName");
    }

    /**
     * No control code is allowed: {0}
     * 
     */
    public static String Hudson_ControlCodeNotAllowed(Object arg1) {
        return holder.format("Hudson.ControlCodeNotAllowed", arg1);
    }

    /**
     * No control code is allowed: {0}
     * 
     */
    public static Localizable _Hudson_ControlCodeNotAllowed(Object arg1) {
        return new Localizable(holder, "Hudson.ControlCodeNotAllowed", arg1);
    }

    /**
     * the master Jenkins node
     * 
     */
    public static String Hudson_NodeDescription() {
        return holder.format("Hudson.NodeDescription");
    }

    /**
     * the master Jenkins node
     * 
     */
    public static Localizable _Hudson_NodeDescription() {
        return new Localizable(holder, "Hudson.NodeDescription");
    }

    /**
     * Restart Jenkins
     * 
     */
    public static String CLI_restart_shortDescription() {
        return holder.format("CLI.restart.shortDescription");
    }

    /**
     * Restart Jenkins
     * 
     */
    public static Localizable _CLI_restart_shortDescription() {
        return new Localizable(holder, "CLI.restart.shortDescription");
    }

    /**
     * Your container doesn’t use UTF-8 to decode URLs. If you use non-ASCII characters as a job name etc, this will cause problems. See &lt;a href="http://wiki.jenkins-ci.org/display/JENKINS/Containers">Containers&lt;/a> and &lt;a href="http://wiki.jenkins-ci.org/display/JENKINS/Tomcat#Tomcat-i18n">Tomcat i18n&lt;/a> for more details.
     * 
     */
    public static String Hudson_NotUsesUTF8ToDecodeURL() {
        return holder.format("Hudson.NotUsesUTF8ToDecodeURL");
    }

    /**
     * Your container doesn’t use UTF-8 to decode URLs. If you use non-ASCII characters as a job name etc, this will cause problems. See &lt;a href="http://wiki.jenkins-ci.org/display/JENKINS/Containers">Containers&lt;/a> and &lt;a href="http://wiki.jenkins-ci.org/display/JENKINS/Tomcat#Tomcat-i18n">Tomcat i18n&lt;/a> for more details.
     * 
     */
    public static Localizable _Hudson_NotUsesUTF8ToDecodeURL() {
        return new Localizable(holder, "Hudson.NotUsesUTF8ToDecodeURL");
    }

    /**
     * Cancel the effect of the "quiet-down" command.
     * 
     */
    public static String CLI_cancel_quiet_down_shortDescription() {
        return holder.format("CLI.cancel-quiet-down.shortDescription");
    }

    /**
     * Cancel the effect of the "quiet-down" command.
     * 
     */
    public static Localizable _CLI_cancel_quiet_down_shortDescription() {
        return new Localizable(holder, "CLI.cancel-quiet-down.shortDescription");
    }

    /**
     * Immediately shuts down Jenkins server
     * 
     */
    public static String CLI_shutdown_shortDescription() {
        return holder.format("CLI.shutdown.shortDescription");
    }

    /**
     * Immediately shuts down Jenkins server
     * 
     */
    public static Localizable _CLI_shutdown_shortDescription() {
        return new Localizable(holder, "CLI.shutdown.shortDescription");
    }

    /**
     * Discard all the loaded data in memory and reload everything from file system. Useful when you modified config files directly on disk.
     * 
     */
    public static String CLI_reload_configuration_shortDescription() {
        return holder.format("CLI.reload-configuration.shortDescription");
    }

    /**
     * Discard all the loaded data in memory and reload everything from file system. Useful when you modified config files directly on disk.
     * 
     */
    public static Localizable _CLI_reload_configuration_shortDescription() {
        return new Localizable(holder, "CLI.reload-configuration.shortDescription");
    }

    /**
     * ‘{0}’ does not match the job name convention pattern {1}
     * 
     */
    public static String Hudson_JobNameConventionNotApplyed(Object arg1, Object arg2) {
        return holder.format("Hudson.JobNameConventionNotApplyed", arg1, arg2);
    }

    /**
     * ‘{0}’ does not match the job name convention pattern {1}
     * 
     */
    public static Localizable _Hudson_JobNameConventionNotApplyed(Object arg1, Object arg2) {
        return new Localizable(holder, "Hudson.JobNameConventionNotApplyed", arg1, arg2);
    }

    /**
     * The read permission is necessary for viewing almost all pages of Jenkins. This permission is useful when you don’t want unauthenticated users to see Jenkins pages &amp;mdash; revoke this permission from the anonymous user, then add "authenticated" pseudo-user and grant the read access. 
     * 
     */
    public static String Hudson_ReadPermission_Description() {
        return holder.format("Hudson.ReadPermission.Description");
    }

    /**
     * The read permission is necessary for viewing almost all pages of Jenkins. This permission is useful when you don’t want unauthenticated users to see Jenkins pages &amp;mdash; revoke this permission from the anonymous user, then add "authenticated" pseudo-user and grant the read access. 
     * 
     */
    public static Localizable _Hudson_ReadPermission_Description() {
        return new Localizable(holder, "Hudson.ReadPermission.Description");
    }

    /**
     * java is not in your PATH. Maybe you need to &lt;a href="{0}/configure">configure JDKs&lt;/a>?
     * 
     */
    public static String Hudson_NoJavaInPath(Object arg1) {
        return holder.format("Hudson.NoJavaInPath", arg1);
    }

    /**
     * java is not in your PATH. Maybe you need to &lt;a href="{0}/configure">configure JDKs&lt;/a>?
     * 
     */
    public static Localizable _Hudson_NoJavaInPath(Object arg1) {
        return new Localizable(holder, "Hudson.NoJavaInPath", arg1);
    }

    /**
     * Puts Jenkins into the quiet mode, wait for existing builds to be completed, and then shut down Jenkins.
     * 
     */
    public static String CLI_safe_shutdown_shortDescription() {
        return holder.format("CLI.safe-shutdown.shortDescription");
    }

    /**
     * Puts Jenkins into the quiet mode, wait for existing builds to be completed, and then shut down Jenkins.
     * 
     */
    public static Localizable _CLI_safe_shutdown_shortDescription() {
        return new Localizable(holder, "CLI.safe-shutdown.shortDescription");
    }

    /**
     * Quiet down Jenkins, in preparation for a restart. Don’t start any builds.
     * 
     */
    public static String CLI_quiet_down_shortDescription() {
        return holder.format("CLI.quiet-down.shortDescription");
    }

    /**
     * Quiet down Jenkins, in preparation for a restart. Don’t start any builds.
     * 
     */
    public static Localizable _CLI_quiet_down_shortDescription() {
        return new Localizable(holder, "CLI.quiet-down.shortDescription");
    }

    /**
     * Default
     * 
     */
    public static String DefaultProjectNamingStrategy_DisplayName() {
        return holder.format("DefaultProjectNamingStrategy.DisplayName");
    }

    /**
     * Default
     * 
     */
    public static Localizable _DefaultProjectNamingStrategy_DisplayName() {
        return new Localizable(holder, "DefaultProjectNamingStrategy.DisplayName");
    }

    /**
     * Node is being removed
     * 
     */
    public static String Hudson_NodeBeingRemoved() {
        return holder.format("Hudson.NodeBeingRemoved");
    }

    /**
     * Node is being removed
     * 
     */
    public static Localizable _Hudson_NodeBeingRemoved() {
        return new Localizable(holder, "Hudson.NodeBeingRemoved");
    }

    /**
     * Safely restart Jenkins
     * 
     */
    public static String CLI_safe_restart_shortDescription() {
        return holder.format("CLI.safe-restart.shortDescription");
    }

    /**
     * Safely restart Jenkins
     * 
     */
    public static Localizable _CLI_safe_restart_shortDescription() {
        return new Localizable(holder, "CLI.safe-restart.shortDescription");
    }

    /**
     * A view already exists with the name "{0}"
     * 
     */
    public static String Hudson_ViewAlreadyExists(Object arg1) {
        return holder.format("Hudson.ViewAlreadyExists", arg1);
    }

    /**
     * A view already exists with the name "{0}"
     * 
     */
    public static Localizable _Hudson_ViewAlreadyExists(Object arg1) {
        return new Localizable(holder, "Hudson.ViewAlreadyExists", arg1);
    }

    /**
     * regular expression's syntax is invalid.
     * 
     */
    public static String PatternProjectNamingStrategy_NamePatternInvalidSyntax() {
        return holder.format("PatternProjectNamingStrategy.NamePatternInvalidSyntax");
    }

    /**
     * regular expression's syntax is invalid.
     * 
     */
    public static Localizable _PatternProjectNamingStrategy_NamePatternInvalidSyntax() {
        return new Localizable(holder, "PatternProjectNamingStrategy.NamePatternInvalidSyntax");
    }

    /**
     * Name Pattern is required
     * 
     */
    public static String PatternProjectNamingStrategy_NamePatternRequired() {
        return holder.format("PatternProjectNamingStrategy.NamePatternRequired");
    }

    /**
     * Name Pattern is required
     * 
     */
    public static Localizable _PatternProjectNamingStrategy_NamePatternRequired() {
        return new Localizable(holder, "PatternProjectNamingStrategy.NamePatternRequired");
    }

    /**
     * Mark the build to keep the build forever.
     * 
     */
    public static String CLI_keep_build_shortDescription() {
        return holder.format("CLI.keep-build.shortDescription");
    }

    /**
     * Mark the build to keep the build forever.
     * 
     */
    public static Localizable _CLI_keep_build_shortDescription() {
        return new Localizable(holder, "CLI.keep-build.shortDescription");
    }

    /**
     * All
     * 
     */
    public static String Hudson_ViewName() {
        return holder.format("Hudson.ViewName");
    }

    /**
     * All
     * 
     */
    public static Localizable _Hudson_ViewName() {
        return new Localizable(holder, "Hudson.ViewName");
    }

    /**
     * address not configured yet &lt;nobody@nowhere>
     * 
     */
    public static String Mailer_Address_Not_Configured() {
        return holder.format("Mailer.Address.Not.Configured");
    }

    /**
     * address not configured yet &lt;nobody@nowhere>
     * 
     */
    public static Localizable _Mailer_Address_Not_Configured() {
        return new Localizable(holder, "Mailer.Address.Not.Configured");
    }

}
