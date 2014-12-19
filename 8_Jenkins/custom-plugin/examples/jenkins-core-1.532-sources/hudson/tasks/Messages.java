// CHECKSTYLE:OFF

package hudson.tasks;

import org.jvnet.localizer.Localizable;
import org.jvnet.localizer.ResourceBundleHolder;

@SuppressWarnings({
    "",
    "PMD"
})
public class Messages {

    private final static ResourceBundleHolder holder = ResourceBundleHolder.get(Messages.class);

    /**
     * {0} is already in the queue
     * 
     */
    public static String BuildTrigger_InQueue(Object arg1) {
        return holder.format("BuildTrigger.InQueue", arg1);
    }

    /**
     * {0} is already in the queue
     * 
     */
    public static Localizable _BuildTrigger_InQueue(Object arg1) {
        return new Localizable(holder, "BuildTrigger.InQueue", arg1);
    }

    /**
     * Archive the artifacts
     * 
     */
    public static String ArtifactArchiver_DisplayName() {
        return holder.format("ArtifactArchiver.DisplayName");
    }

    /**
     * Archive the artifacts
     * 
     */
    public static Localizable _ArtifactArchiver_DisplayName() {
        return new Localizable(holder, "ArtifactArchiver.DisplayName");
    }

    /**
     * Execute shell
     * 
     */
    public static String Shell_DisplayName() {
        return holder.format("Shell.DisplayName");
    }

    /**
     * Execute shell
     * 
     */
    public static Localizable _Shell_DisplayName() {
        return new Localizable(holder, "Shell.DisplayName");
    }

    /**
     * Recording fingerprints
     * 
     */
    public static String Fingerprinter_Recording() {
        return holder.format("Fingerprinter.Recording");
    }

    /**
     * Recording fingerprints
     * 
     */
    public static Localizable _Fingerprinter_Recording() {
        return new Localizable(holder, "Fingerprinter.Recording");
    }

    /**
     * Build other projects
     * 
     */
    public static String BuildTrigger_DisplayName() {
        return holder.format("BuildTrigger.DisplayName");
    }

    /**
     * Build other projects
     * 
     */
    public static Localizable _BuildTrigger_DisplayName() {
        return new Localizable(holder, "BuildTrigger.DisplayName");
    }

    /**
     * No artifacts found that match the file pattern "{0}". Configuration error?
     * 
     */
    public static String ArtifactArchiver_NoMatchFound(Object arg1) {
        return holder.format("ArtifactArchiver.NoMatchFound", arg1);
    }

    /**
     * No artifacts found that match the file pattern "{0}". Configuration error?
     * 
     */
    public static Localizable _ArtifactArchiver_NoMatchFound(Object arg1) {
        return new Localizable(holder, "ArtifactArchiver.NoMatchFound", arg1);
    }

    /**
     * No project specified
     * 
     */
    public static String BuildTrigger_NoProjectSpecified() {
        return holder.format("BuildTrigger.NoProjectSpecified");
    }

    /**
     * No project specified
     * 
     */
    public static Localizable _BuildTrigger_NoProjectSpecified() {
        return new Localizable(holder, "BuildTrigger.NoProjectSpecified");
    }

    /**
     * Unable to copy Javadoc from {0} to {1}
     * 
     */
    public static String JavadocArchiver_UnableToCopy(Object arg1, Object arg2) {
        return holder.format("JavadocArchiver.UnableToCopy", arg1, arg2);
    }

    /**
     * Unable to copy Javadoc from {0} to {1}
     * 
     */
    public static Localizable _JavadocArchiver_UnableToCopy(Object arg1, Object arg2) {
        return new Localizable(holder, "JavadocArchiver.UnableToCopy", arg1, arg2);
    }

    /**
     * You have no permission to build {0}
     * 
     */
    public static String BuildTrigger_you_have_no_permission_to_build_(Object arg1) {
        return holder.format("BuildTrigger.you_have_no_permission_to_build_", arg1);
    }

    /**
     * You have no permission to build {0}
     * 
     */
    public static Localizable _BuildTrigger_you_have_no_permission_to_build_(Object arg1) {
        return new Localizable(holder, "BuildTrigger.you_have_no_permission_to_build_", arg1);
    }

    /**
     * Cannot find executable from the chosen Ant installation "{0}"
     * 
     */
    public static String Ant_ExecutableNotFound(Object arg1) {
        return holder.format("Ant.ExecutableNotFound", arg1);
    }

    /**
     * Cannot find executable from the chosen Ant installation "{0}"
     * 
     */
    public static Localizable _Ant_ExecutableNotFound(Object arg1) {
        return new Localizable(holder, "Ant.ExecutableNotFound", arg1);
    }

    /**
     * Deleting old artifacts from {0}
     * 
     */
    public static String ArtifactArchiver_DeletingOld(Object arg1) {
        return holder.format("ArtifactArchiver.DeletingOld", arg1);
    }

    /**
     * Deleting old artifacts from {0}
     * 
     */
    public static Localizable _ArtifactArchiver_DeletingOld(Object arg1) {
        return new Localizable(holder, "ArtifactArchiver.DeletingOld", arg1);
    }

    /**
     * Archiving artifacts
     * 
     */
    public static String ArtifactArchiver_ARCHIVING_ARTIFACTS() {
        return holder.format("ArtifactArchiver.ARCHIVING_ARTIFACTS");
    }

    /**
     * Archiving artifacts
     * 
     */
    public static Localizable _ArtifactArchiver_ARCHIVING_ARTIFACTS() {
        return new Localizable(holder, "ArtifactArchiver.ARCHIVING_ARTIFACTS");
    }

    /**
     * Triggering a new build of {0}
     * 
     */
    public static String BuildTrigger_Triggering(Object arg1) {
        return holder.format("BuildTrigger.Triggering", arg1);
    }

    /**
     * Triggering a new build of {0}
     * 
     */
    public static Localizable _BuildTrigger_Triggering(Object arg1) {
        return new Localizable(holder, "BuildTrigger.Triggering", arg1);
    }

    /**
     * {0} is disabled. Triggering skipped
     * 
     */
    public static String BuildTrigger_Disabled(Object arg1) {
        return holder.format("BuildTrigger.Disabled", arg1);
    }

    /**
     * {0} is disabled. Triggering skipped
     * 
     */
    public static Localizable _BuildTrigger_Disabled(Object arg1) {
        return new Localizable(holder, "BuildTrigger.Disabled", arg1);
    }

    /**
     * {0} is not a directory
     * 
     */
    public static String Maven_NotADirectory(Object arg1) {
        return holder.format("Maven.NotADirectory", arg1);
    }

    /**
     * {0} is not a directory
     * 
     */
    public static Localizable _Maven_NotADirectory(Object arg1) {
        return new Localizable(holder, "Maven.NotADirectory", arg1);
    }

    /**
     * No artifacts are configured for archiving.
     * You probably forgot to set the file pattern, so please go back to the configuration and specify it.
     * If you really did mean to archive all the files in the workspace, please specify "**"
     * 
     */
    public static String ArtifactArchiver_NoIncludes() {
        return holder.format("ArtifactArchiver.NoIncludes");
    }

    /**
     * No artifacts are configured for archiving.
     * You probably forgot to set the file pattern, so please go back to the configuration and specify it.
     * If you really did mean to archive all the files in the workspace, please specify "**"
     * 
     */
    public static Localizable _ArtifactArchiver_NoIncludes() {
        return new Localizable(holder, "ArtifactArchiver.NoIncludes");
    }

    /**
     * Invoke top-level Maven targets
     * 
     */
    public static String Maven_DisplayName() {
        return holder.format("Maven.DisplayName");
    }

    /**
     * Invoke top-level Maven targets
     * 
     */
    public static Localizable _Maven_DisplayName() {
        return new Localizable(holder, "Maven.DisplayName");
    }

    /**
     * {0} doesn’t look like an Ant directory
     * 
     */
    public static String Ant_NotAntDirectory(Object arg1) {
        return holder.format("Ant.NotAntDirectory", arg1);
    }

    /**
     * {0} doesn’t look like an Ant directory
     * 
     */
    public static Localizable _Ant_NotAntDirectory(Object arg1) {
        return new Localizable(holder, "Ant.NotAntDirectory", arg1);
    }

    /**
     * command execution failed
     * 
     */
    public static String Maven_ExecFailed() {
        return holder.format("Maven.ExecFailed");
    }

    /**
     * command execution failed
     * 
     */
    public static Localizable _Maven_ExecFailed() {
        return new Localizable(holder, "Maven.ExecFailed");
    }

    /**
     * Execute Windows batch command
     * 
     */
    public static String BatchFile_DisplayName() {
        return holder.format("BatchFile.DisplayName");
    }

    /**
     * Execute Windows batch command
     * 
     */
    public static Localizable _BatchFile_DisplayName() {
        return new Localizable(holder, "BatchFile.DisplayName");
    }

    /**
     * failed to record fingerprint for {0}
     * 
     */
    public static String Fingerprinter_FailedFor(Object arg1) {
        return holder.format("Fingerprinter.FailedFor", arg1);
    }

    /**
     * failed to record fingerprint for {0}
     * 
     */
    public static Localizable _Fingerprinter_FailedFor(Object arg1) {
        return new Localizable(holder, "Fingerprinter.FailedFor", arg1);
    }

    /**
     * Publish Javadoc
     * 
     */
    public static String JavadocArchiver_DisplayName() {
        return holder.format("JavadocArchiver.DisplayName");
    }

    /**
     * Publish Javadoc
     * 
     */
    public static Localizable _JavadocArchiver_DisplayName() {
        return new Localizable(holder, "JavadocArchiver.DisplayName");
    }

    /**
     * Unable to delete script file {0}
     * 
     */
    public static String CommandInterpreter_UnableToDelete(Object arg1) {
        return holder.format("CommandInterpreter.UnableToDelete", arg1);
    }

    /**
     * Unable to delete script file {0}
     * 
     */
    public static Localizable _CommandInterpreter_UnableToDelete(Object arg1) {
        return new Localizable(holder, "CommandInterpreter.UnableToDelete", arg1);
    }

    /**
     * Failed to archive artifacts: {0}
     * 
     */
    public static String ArtifactArchiver_FailedToArchive(Object arg1) {
        return holder.format("ArtifactArchiver.FailedToArchive", arg1);
    }

    /**
     * Failed to archive artifacts: {0}
     * 
     */
    public static Localizable _ArtifactArchiver_FailedToArchive(Object arg1) {
        return new Localizable(holder, "ArtifactArchiver.FailedToArchive", arg1);
    }

    /**
     * Failed to record fingerprints
     * 
     */
    public static String Fingerprinter_Failed() {
        return holder.format("Fingerprinter.Failed");
    }

    /**
     * Failed to record fingerprints
     * 
     */
    public static Localizable _Fingerprinter_Failed() {
        return new Localizable(holder, "Fingerprinter.Failed");
    }

    /**
     * Publishing Javadoc
     * 
     */
    public static String JavadocArchiver_Publishing() {
        return holder.format("JavadocArchiver.Publishing");
    }

    /**
     * Publishing Javadoc
     * 
     */
    public static Localizable _JavadocArchiver_Publishing() {
        return new Localizable(holder, "JavadocArchiver.Publishing");
    }

    /**
     * Maybe you need to configure where your Ant installations are?
     * 
     */
    public static String Ant_GlobalConfigNeeded() {
        return holder.format("Ant.GlobalConfigNeeded");
    }

    /**
     * Maybe you need to configure where your Ant installations are?
     * 
     */
    public static Localizable _Ant_GlobalConfigNeeded() {
        return new Localizable(holder, "Ant.GlobalConfigNeeded");
    }

    /**
     * No such project ‘{0}’. Did you mean ‘{1}’?
     * 
     */
    public static String BuildTrigger_NoSuchProject(Object arg1, Object arg2) {
        return holder.format("BuildTrigger.NoSuchProject", arg1, arg2);
    }

    /**
     * No such project ‘{0}’. Did you mean ‘{1}’?
     * 
     */
    public static Localizable _BuildTrigger_NoSuchProject(Object arg1, Object arg2) {
        return new Localizable(holder, "BuildTrigger.NoSuchProject", arg1, arg2);
    }

    /**
     * command execution failed
     * 
     */
    public static String CommandInterpreter_CommandFailed() {
        return holder.format("CommandInterpreter.CommandFailed");
    }

    /**
     * command execution failed
     * 
     */
    public static Localizable _CommandInterpreter_CommandFailed() {
        return new Localizable(holder, "CommandInterpreter.CommandFailed");
    }

    /**
     * Build artifacts are supposed to be fingerprinted, but build artifact archiving is not configured
     * 
     */
    public static String Fingerprinter_NoArchiving() {
        return holder.format("Fingerprinter.NoArchiving");
    }

    /**
     * Build artifacts are supposed to be fingerprinted, but build artifact archiving is not configured
     * 
     */
    public static Localizable _Fingerprinter_NoArchiving() {
        return new Localizable(holder, "Fingerprinter.NoArchiving");
    }

    /**
     * No javadoc found in {0}: {1}
     * 
     */
    public static String JavadocArchiver_NoMatchFound(Object arg1, Object arg2) {
        return holder.format("JavadocArchiver.NoMatchFound", arg1, arg2);
    }

    /**
     * No javadoc found in {0}: {1}
     * 
     */
    public static Localizable _JavadocArchiver_NoMatchFound(Object arg1, Object arg2) {
        return new Localizable(holder, "JavadocArchiver.NoMatchFound", arg1, arg2);
    }

    /**
     * Javadoc
     * 
     */
    public static String JavadocArchiver_DisplayName_Javadoc() {
        return holder.format("JavadocArchiver.DisplayName.Javadoc");
    }

    /**
     * Javadoc
     * 
     */
    public static Localizable _JavadocArchiver_DisplayName_Javadoc() {
        return new Localizable(holder, "JavadocArchiver.DisplayName.Javadoc");
    }

    /**
     * Failed to compute digest for {0}
     * 
     */
    public static String Fingerprinter_DigestFailed(Object arg1) {
        return holder.format("Fingerprinter.DigestFailed", arg1);
    }

    /**
     * Failed to compute digest for {0}
     * 
     */
    public static Localizable _Fingerprinter_DigestFailed(Object arg1) {
        return new Localizable(holder, "Fingerprinter.DigestFailed", arg1);
    }

    /**
     * Unable to record fingerprints because there’s no workspace
     * 
     */
    public static String Fingerprinter_NoWorkspace() {
        return holder.format("Fingerprinter.NoWorkspace");
    }

    /**
     * Unable to record fingerprints because there’s no workspace
     * 
     */
    public static Localizable _Fingerprinter_NoWorkspace() {
        return new Localizable(holder, "Fingerprinter.NoWorkspace");
    }

    /**
     * Aborted
     * 
     */
    public static String Fingerprinter_Aborted() {
        return holder.format("Fingerprinter.Aborted");
    }

    /**
     * Aborted
     * 
     */
    public static Localizable _Fingerprinter_Aborted() {
        return new Localizable(holder, "Fingerprinter.Aborted");
    }

    /**
     * See Fingerprints
     * 
     */
    public static String Fingerprinter_Action_DisplayName() {
        return holder.format("Fingerprinter.Action.DisplayName");
    }

    /**
     * See Fingerprints
     * 
     */
    public static Localizable _Fingerprinter_Action_DisplayName() {
        return new Localizable(holder, "Fingerprinter.Action.DisplayName");
    }

    /**
     * Unable to produce a script file
     * 
     */
    public static String CommandInterpreter_UnableToProduceScript() {
        return holder.format("CommandInterpreter.UnableToProduceScript");
    }

    /**
     * Unable to produce a script file
     * 
     */
    public static Localizable _CommandInterpreter_UnableToProduceScript() {
        return new Localizable(holder, "CommandInterpreter.UnableToProduceScript");
    }

    /**
     * Invoke Ant
     * 
     */
    public static String Ant_DisplayName() {
        return holder.format("Ant.DisplayName");
    }

    /**
     * Invoke Ant
     * 
     */
    public static Localizable _Ant_DisplayName() {
        return new Localizable(holder, "Ant.DisplayName");
    }

    /**
     * Couldn’t find any executable in {0}
     * 
     */
    public static String Maven_NoExecutable(Object arg1) {
        return holder.format("Maven.NoExecutable", arg1);
    }

    /**
     * Couldn’t find any executable in {0}
     * 
     */
    public static Localizable _Maven_NoExecutable(Object arg1) {
        return new Localizable(holder, "Maven.NoExecutable", arg1);
    }

    /**
     * Test Javadoc
     * 
     */
    public static String TestJavadocArchiver_DisplayName_Javadoc() {
        return holder.format("TestJavadocArchiver.DisplayName.Javadoc");
    }

    /**
     * Test Javadoc
     * 
     */
    public static Localizable _TestJavadocArchiver_DisplayName_Javadoc() {
        return new Localizable(holder, "TestJavadocArchiver.DisplayName.Javadoc");
    }

    /**
     * {0} doesn’t look like a Maven directory
     * 
     */
    public static String Maven_NotMavenDirectory(Object arg1) {
        return holder.format("Maven.NotMavenDirectory", arg1);
    }

    /**
     * {0} doesn’t look like a Maven directory
     * 
     */
    public static Localizable _Maven_NotMavenDirectory(Object arg1) {
        return new Localizable(holder, "Maven.NotMavenDirectory", arg1);
    }

    /**
     * {0} is not buildable
     * 
     */
    public static String BuildTrigger_NotBuildable(Object arg1) {
        return holder.format("BuildTrigger.NotBuildable", arg1);
    }

    /**
     * {0} is not buildable
     * 
     */
    public static Localizable _BuildTrigger_NotBuildable(Object arg1) {
        return new Localizable(holder, "BuildTrigger.NotBuildable", arg1);
    }

    /**
     * Install from Apache
     * 
     */
    public static String InstallFromApache() {
        return holder.format("InstallFromApache");
    }

    /**
     * Install from Apache
     * 
     */
    public static Localizable _InstallFromApache() {
        return new Localizable(holder, "InstallFromApache");
    }

    /**
     * Document
     * 
     */
    public static String JavadocArchiver_DisplayName_Generic() {
        return holder.format("JavadocArchiver.DisplayName.Generic");
    }

    /**
     * Document
     * 
     */
    public static Localizable _JavadocArchiver_DisplayName_Generic() {
        return new Localizable(holder, "JavadocArchiver.DisplayName.Generic");
    }

    /**
     * command execution failed.
     * 
     */
    public static String Ant_ExecFailed() {
        return holder.format("Ant.ExecFailed");
    }

    /**
     * command execution failed.
     * 
     */
    public static Localizable _Ant_ExecFailed() {
        return new Localizable(holder, "Ant.ExecFailed");
    }

    /**
     * {0} is not a directory
     * 
     */
    public static String Ant_NotADirectory(Object arg1) {
        return holder.format("Ant.NotADirectory", arg1);
    }

    /**
     * {0} is not a directory
     * 
     */
    public static Localizable _Ant_NotADirectory(Object arg1) {
        return new Localizable(holder, "Ant.NotADirectory", arg1);
    }

    /**
     * Record fingerprints of files to track usage
     * 
     */
    public static String Fingerprinter_DisplayName() {
        return holder.format("Fingerprinter.DisplayName");
    }

    /**
     * Record fingerprints of files to track usage
     * 
     */
    public static Localizable _Fingerprinter_DisplayName() {
        return new Localizable(holder, "Fingerprinter.DisplayName");
    }

    /**
     * Maybe you need to configure the job to choose one of your Ant installations?
     * 
     */
    public static String Ant_ProjectConfigNeeded() {
        return holder.format("Ant.ProjectConfigNeeded");
    }

    /**
     * Maybe you need to configure the job to choose one of your Ant installations?
     * 
     */
    public static Localizable _Ant_ProjectConfigNeeded() {
        return new Localizable(holder, "Ant.ProjectConfigNeeded");
    }

}
