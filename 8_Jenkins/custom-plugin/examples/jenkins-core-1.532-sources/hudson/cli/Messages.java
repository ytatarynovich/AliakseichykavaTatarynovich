// CHECKSTYLE:OFF

package hudson.cli;

import org.jvnet.localizer.Localizable;
import org.jvnet.localizer.ResourceBundleHolder;

@SuppressWarnings({
    "",
    "PMD"
})
public class Messages {

    private final static ResourceBundleHolder holder = ResourceBundleHolder.get(Messages.class);

    /**
     * Builds a job, and optionally waits until its completion.
     * 
     */
    public static String BuildCommand_ShortDescription() {
        return holder.format("BuildCommand.ShortDescription");
    }

    /**
     * Builds a job, and optionally waits until its completion.
     * 
     */
    public static Localizable _BuildCommand_ShortDescription() {
        return new Localizable(holder, "BuildCommand.ShortDescription");
    }

    /**
     * Saves the current credential to allow future commands to run without explicit credential information.
     * 
     */
    public static String LoginCommand_ShortDescription() {
        return holder.format("LoginCommand.ShortDescription");
    }

    /**
     * Saves the current credential to allow future commands to run without explicit credential information.
     * 
     */
    public static Localizable _LoginCommand_ShortDescription() {
        return new Localizable(holder, "LoginCommand.ShortDescription");
    }

    /**
     * Dumps the node definition XML to stdout
     * 
     */
    public static String GetNodeCommand_ShortDescription() {
        return holder.format("GetNodeCommand.ShortDescription");
    }

    /**
     * Dumps the node definition XML to stdout
     * 
     */
    public static Localizable _GetNodeCommand_ShortDescription() {
        return new Localizable(holder, "GetNodeCommand.ShortDescription");
    }

    /**
     * Deletes build record(s).
     * 
     */
    public static String DeleteBuildsCommand_ShortDescription() {
        return holder.format("DeleteBuildsCommand.ShortDescription");
    }

    /**
     * Deletes build record(s).
     * 
     */
    public static Localizable _DeleteBuildsCommand_ShortDescription() {
        return new Localizable(holder, "DeleteBuildsCommand.ShortDescription");
    }

    /**
     * Copies a job.
     * 
     */
    public static String CopyJobCommand_ShortDescription() {
        return holder.format("CopyJobCommand.ShortDescription");
    }

    /**
     * Copies a job.
     * 
     */
    public static Localizable _CopyJobCommand_ShortDescription() {
        return new Localizable(holder, "CopyJobCommand.ShortDescription");
    }

    /**
     * Reads stdin and sends that out as an e-mail.
     * 
     */
    public static String MailCommand_ShortDescription() {
        return holder.format("MailCommand.ShortDescription");
    }

    /**
     * Reads stdin and sends that out as an e-mail.
     * 
     */
    public static Localizable _MailCommand_ShortDescription() {
        return new Localizable(holder, "MailCommand.ShortDescription");
    }

    /**
     * Installs a plugin either from a file, an URL, or from update center. 
     * 
     */
    public static String InstallPluginCommand_ShortDescription() {
        return holder.format("InstallPluginCommand.ShortDescription");
    }

    /**
     * Installs a plugin either from a file, an URL, or from update center. 
     * 
     */
    public static Localizable _InstallPluginCommand_ShortDescription() {
        return new Localizable(holder, "InstallPluginCommand.ShortDescription");
    }

    /**
     * {0} looks like a short plugin name. Did you mean ‘{1}’?
     * 
     */
    public static String InstallPluginCommand_DidYouMean(Object arg1, Object arg2) {
        return holder.format("InstallPluginCommand.DidYouMean", arg1, arg2);
    }

    /**
     * {0} looks like a short plugin name. Did you mean ‘{1}’?
     * 
     */
    public static Localizable _InstallPluginCommand_DidYouMean(Object arg1, Object arg2) {
        return new Localizable(holder, "InstallPluginCommand.DidYouMean", arg1, arg2);
    }

    /**
     * Started by command line by {0}
     * 
     */
    public static String BuildCommand_CLICause_ShortDescription(Object arg1) {
        return holder.format("BuildCommand.CLICause.ShortDescription", arg1);
    }

    /**
     * Started by command line by {0}
     * 
     */
    public static Localizable _BuildCommand_CLICause_ShortDescription(Object arg1) {
        return new Localizable(holder, "BuildCommand.CLICause.ShortDescription", arg1);
    }

    /**
     * Dumps the job definition XML to stdout
     * 
     */
    public static String GetJobCommand_ShortDescription() {
        return holder.format("GetJobCommand.ShortDescription");
    }

    /**
     * Dumps the job definition XML to stdout
     * 
     */
    public static Localizable _GetJobCommand_ShortDescription() {
        return new Localizable(holder, "GetJobCommand.ShortDescription");
    }

    /**
     * Note that no update center is defined in this Jenkins.
     * 
     */
    public static String InstallPluginCommand_NoUpdateCenterDefined() {
        return holder.format("InstallPluginCommand.NoUpdateCenterDefined");
    }

    /**
     * Note that no update center is defined in this Jenkins.
     * 
     */
    public static Localizable _InstallPluginCommand_NoUpdateCenterDefined() {
        return new Localizable(holder, "InstallPluginCommand.NoUpdateCenterDefined");
    }

    /**
     * Performs automatic tool installation, and print its location to stdout. Can be only called from inside a build.
     * 
     */
    public static String InstallToolCommand_ShortDescription() {
        return holder.format("InstallToolCommand.ShortDescription");
    }

    /**
     * Performs automatic tool installation, and print its location to stdout. Can be only called from inside a build.
     * 
     */
    public static Localizable _InstallToolCommand_ShortDescription() {
        return new Localizable(holder, "InstallToolCommand.ShortDescription");
    }

    /**
     * Cannot build {0} because its configuration has not been saved.
     * 
     */
    public static String BuildCommand_CLICause_CannotBuildConfigNotSaved(Object arg1) {
        return holder.format("BuildCommand.CLICause.CannotBuildConfigNotSaved", arg1);
    }

    /**
     * Cannot build {0} because its configuration has not been saved.
     * 
     */
    public static Localizable _BuildCommand_CLICause_CannotBuildConfigNotSaved(Object arg1) {
        return new Localizable(holder, "BuildCommand.CLICause.CannotBuildConfigNotSaved", arg1);
    }

    /**
     * Creates a new node by reading stdin as a XML configuration.
     * 
     */
    public static String CreateNodeCommand_ShortDescription() {
        return holder.format("CreateNodeCommand.ShortDescription");
    }

    /**
     * Creates a new node by reading stdin as a XML configuration.
     * 
     */
    public static Localizable _CreateNodeCommand_ShortDescription() {
        return new Localizable(holder, "CreateNodeCommand.ShortDescription");
    }

    /**
     * Creates a new job by reading stdin as a configuration XML file.
     * 
     */
    public static String CreateJobCommand_ShortDescription() {
        return holder.format("CreateJobCommand.ShortDescription");
    }

    /**
     * Creates a new job by reading stdin as a configuration XML file.
     * 
     */
    public static Localizable _CreateJobCommand_ShortDescription() {
        return new Localizable(holder, "CreateJobCommand.ShortDescription");
    }

    /**
     * Lists all the available commands.
     * 
     */
    public static String HelpCommand_ShortDescription() {
        return holder.format("HelpCommand.ShortDescription");
    }

    /**
     * Lists all the available commands.
     * 
     */
    public static Localizable _HelpCommand_ShortDescription() {
        return new Localizable(holder, "HelpCommand.ShortDescription");
    }

    /**
     * Cannot build {0} because it is disabled.
     * 
     */
    public static String BuildCommand_CLICause_CannotBuildDisabled(Object arg1) {
        return holder.format("BuildCommand.CLICause.CannotBuildDisabled", arg1);
    }

    /**
     * Cannot build {0} because it is disabled.
     * 
     */
    public static Localizable _BuildCommand_CLICause_CannotBuildDisabled(Object arg1) {
        return new Localizable(holder, "BuildCommand.CLICause.CannotBuildDisabled", arg1);
    }

    /**
     * Reports your credential and permissions
     * 
     */
    public static String WhoAmICommand_ShortDescription() {
        return holder.format("WhoAmICommand.ShortDescription");
    }

    /**
     * Reports your credential and permissions
     * 
     */
    public static Localizable _WhoAmICommand_ShortDescription() {
        return new Localizable(holder, "WhoAmICommand.ShortDescription");
    }

    /**
     * Outputs the current version.
     * 
     */
    public static String VersionCommand_ShortDescription() {
        return holder.format("VersionCommand.ShortDescription");
    }

    /**
     * Outputs the current version.
     * 
     */
    public static Localizable _VersionCommand_ShortDescription() {
        return new Localizable(holder, "VersionCommand.ShortDescription");
    }

    /**
     * Cannot build {0} for unknown reasons.
     * 
     */
    public static String BuildCommand_CLICause_CannotBuildUnknownReasons(Object arg1) {
        return holder.format("BuildCommand.CLICause.CannotBuildUnknownReasons", arg1);
    }

    /**
     * Cannot build {0} for unknown reasons.
     * 
     */
    public static Localizable _BuildCommand_CLICause_CannotBuildUnknownReasons(Object arg1) {
        return new Localizable(holder, "BuildCommand.CLICause.CannotBuildUnknownReasons", arg1);
    }

    /**
     * {0} is neither a valid file, URL, nor a plugin artifact name in the update center
     * 
     */
    public static String InstallPluginCommand_NotAValidSourceName(Object arg1) {
        return holder.format("InstallPluginCommand.NotAValidSourceName", arg1);
    }

    /**
     * {0} is neither a valid file, URL, nor a plugin artifact name in the update center
     * 
     */
    public static Localizable _InstallPluginCommand_NotAValidSourceName(Object arg1) {
        return new Localizable(holder, "InstallPluginCommand.NotAValidSourceName", arg1);
    }

    /**
     * Deletes the credential stored with the login command. 
     * 
     */
    public static String LogoutCommand_ShortDescription() {
        return holder.format("LogoutCommand.ShortDescription");
    }

    /**
     * Deletes the credential stored with the login command. 
     * 
     */
    public static Localizable _LogoutCommand_ShortDescription() {
        return new Localizable(holder, "LogoutCommand.ShortDescription");
    }

    /**
     * Updates the job definition XML from stdin. The opposite of the get-job command
     * 
     */
    public static String UpdateJobCommand_ShortDescription() {
        return holder.format("UpdateJobCommand.ShortDescription");
    }

    /**
     * Updates the job definition XML from stdin. The opposite of the get-job command
     * 
     */
    public static Localizable _UpdateJobCommand_ShortDescription() {
        return new Localizable(holder, "UpdateJobCommand.ShortDescription");
    }

    /**
     * Runs an interactive groovy shell.
     * 
     */
    public static String GroovyshCommand_ShortDescription() {
        return holder.format("GroovyshCommand.ShortDescription");
    }

    /**
     * Runs an interactive groovy shell.
     * 
     */
    public static Localizable _GroovyshCommand_ShortDescription() {
        return new Localizable(holder, "GroovyshCommand.ShortDescription");
    }

    /**
     * No update center data is retrieved yet from: {0}
     * 
     */
    public static String InstallPluginCommand_NoUpdateDataRetrieved(Object arg1) {
        return holder.format("InstallPluginCommand.NoUpdateDataRetrieved", arg1);
    }

    /**
     * No update center data is retrieved yet from: {0}
     * 
     */
    public static Localizable _InstallPluginCommand_NoUpdateDataRetrieved(Object arg1) {
        return new Localizable(holder, "InstallPluginCommand.NoUpdateDataRetrieved", arg1);
    }

    /**
     * Sets the displayName of a build
     * 
     */
    public static String SetBuildDisplayNameCommand_ShortDescription() {
        return holder.format("SetBuildDisplayNameCommand.ShortDescription");
    }

    /**
     * Sets the displayName of a build
     * 
     */
    public static Localizable _SetBuildDisplayNameCommand_ShortDescription() {
        return new Localizable(holder, "SetBuildDisplayNameCommand.ShortDescription");
    }

    /**
     * Outputs a list of installed plugins.
     * 
     */
    public static String ListPluginsCommand_ShortDescription() {
        return holder.format("ListPluginsCommand.ShortDescription");
    }

    /**
     * Outputs a list of installed plugins.
     * 
     */
    public static Localizable _ListPluginsCommand_ShortDescription() {
        return new Localizable(holder, "ListPluginsCommand.ShortDescription");
    }

    /**
     * Installing a plugin from {0}
     * 
     */
    public static String InstallPluginCommand_InstallingPluginFromUrl(Object arg1) {
        return holder.format("InstallPluginCommand.InstallingPluginFromUrl", arg1);
    }

    /**
     * Installing a plugin from {0}
     * 
     */
    public static Localizable _InstallPluginCommand_InstallingPluginFromUrl(Object arg1) {
        return new Localizable(holder, "InstallPluginCommand.InstallingPluginFromUrl", arg1);
    }

    /**
     * Update/set the build parameter of the current build in progress
     * 
     */
    public static String SetBuildParameterCommand_ShortDescription() {
        return holder.format("SetBuildParameterCommand.ShortDescription");
    }

    /**
     * Update/set the build parameter of the current build in progress
     * 
     */
    public static Localizable _SetBuildParameterCommand_ShortDescription() {
        return new Localizable(holder, "SetBuildParameterCommand.ShortDescription");
    }

    /**
     * Sets the description of a build.
     * 
     */
    public static String SetBuildDescriptionCommand_ShortDescription() {
        return holder.format("SetBuildDescriptionCommand.ShortDescription");
    }

    /**
     * Sets the description of a build.
     * 
     */
    public static Localizable _SetBuildDescriptionCommand_ShortDescription() {
        return new Localizable(holder, "SetBuildDescriptionCommand.ShortDescription");
    }

    /**
     * Installing a plugin from local file: {0}
     * 
     */
    public static String InstallPluginCommand_InstallingPluginFromLocalFile(Object arg1) {
        return holder.format("InstallPluginCommand.InstallingPluginFromLocalFile", arg1);
    }

    /**
     * Installing a plugin from local file: {0}
     * 
     */
    public static Localizable _InstallPluginCommand_InstallingPluginFromLocalFile(Object arg1) {
        return new Localizable(holder, "InstallPluginCommand.InstallingPluginFromLocalFile", arg1);
    }

    /**
     * Executes the specified Groovy script. 
     * 
     */
    public static String GroovyCommand_ShortDescription() {
        return holder.format("GroovyCommand.ShortDescription");
    }

    /**
     * Executes the specified Groovy script. 
     * 
     */
    public static Localizable _GroovyCommand_ShortDescription() {
        return new Localizable(holder, "GroovyCommand.ShortDescription");
    }

    /**
     * Installing {0} from update center
     * 
     */
    public static String InstallPluginCommand_InstallingFromUpdateCenter(Object arg1) {
        return holder.format("InstallPluginCommand.InstallingFromUpdateCenter", arg1);
    }

    /**
     * Installing {0} from update center
     * 
     */
    public static Localizable _InstallPluginCommand_InstallingFromUpdateCenter(Object arg1) {
        return new Localizable(holder, "InstallPluginCommand.InstallingFromUpdateCenter", arg1);
    }

    /**
     * Lists all jobs in a specific view or item group.
     * 
     */
    public static String ListJobsCommand_ShortDescription() {
        return holder.format("ListJobsCommand.ShortDescription");
    }

    /**
     * Lists all jobs in a specific view or item group.
     * 
     */
    public static Localizable _ListJobsCommand_ShortDescription() {
        return new Localizable(holder, "ListJobsCommand.ShortDescription");
    }

    /**
     * Sets the result of the current build. Works only if invoked from within a build.
     * 
     */
    public static String SetBuildResultCommand_ShortDescription() {
        return holder.format("SetBuildResultCommand.ShortDescription");
    }

    /**
     * Sets the result of the current build. Works only if invoked from within a build.
     * 
     */
    public static Localizable _SetBuildResultCommand_ShortDescription() {
        return new Localizable(holder, "SetBuildResultCommand.ShortDescription");
    }

    /**
     * Updates the node definition XML from stdin. The opposite of the get-node command
     * 
     */
    public static String UpdateNodeCommand_ShortDescription() {
        return holder.format("UpdateNodeCommand.ShortDescription");
    }

    /**
     * Updates the node definition XML from stdin. The opposite of the get-node command
     * 
     */
    public static Localizable _UpdateNodeCommand_ShortDescription() {
        return new Localizable(holder, "UpdateNodeCommand.ShortDescription");
    }

    /**
     * Dumps the changelog for the specified build(s).
     * 
     */
    public static String ListChangesCommand_ShortDescription() {
        return holder.format("ListChangesCommand.ShortDescription");
    }

    /**
     * Dumps the changelog for the specified build(s).
     * 
     */
    public static Localizable _ListChangesCommand_ShortDescription() {
        return new Localizable(holder, "ListChangesCommand.ShortDescription");
    }

}
