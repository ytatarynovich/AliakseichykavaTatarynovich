// CHECKSTYLE:OFF

package hudson.fsp;

import org.jvnet.localizer.Localizable;
import org.jvnet.localizer.ResourceBundleHolder;

@SuppressWarnings({
    "",
    "PMD"
})
public class Messages {

    private final static ResourceBundleHolder holder = ResourceBundleHolder.get(Messages.class);

    /**
     * No such job ‘{0}’ exists. Perhaps you meant ‘{1}’?
     * 
     */
    public static String WorkspaceSnapshotSCM_NoSuchJob(Object arg1, Object arg2) {
        return holder.format("WorkspaceSnapshotSCM.NoSuchJob", arg1, arg2);
    }

    /**
     * No such job ‘{0}’ exists. Perhaps you meant ‘{1}’?
     * 
     */
    public static Localizable _WorkspaceSnapshotSCM_NoSuchJob(Object arg1, Object arg2) {
        return new Localizable(holder, "WorkspaceSnapshotSCM.NoSuchJob", arg1, arg2);
    }

    /**
     * No such permalink ‘{0}’ exists for {1}
     * 
     */
    public static String WorkspaceSnapshotSCM_NoSuchPermalink(Object arg1, Object arg2) {
        return holder.format("WorkspaceSnapshotSCM.NoSuchPermalink", arg1, arg2);
    }

    /**
     * No such permalink ‘{0}’ exists for {1}
     * 
     */
    public static Localizable _WorkspaceSnapshotSCM_NoSuchPermalink(Object arg1, Object arg2) {
        return new Localizable(holder, "WorkspaceSnapshotSCM.NoSuchPermalink", arg1, arg2);
    }

    /**
     * {0} {1} doesn’t have a workspace snapshot attached,
     * probably because when the build was done, no other jobs needed its workspace snapshot.
     * Please run another build in {0} to get the workspace snapshot taken.
     * 
     */
    public static String WorkspaceSnapshotSCM_NoWorkspace(Object arg1, Object arg2) {
        return holder.format("WorkspaceSnapshotSCM.NoWorkspace", arg1, arg2);
    }

    /**
     * {0} {1} doesn’t have a workspace snapshot attached,
     * probably because when the build was done, no other jobs needed its workspace snapshot.
     * Please run another build in {0} to get the workspace snapshot taken.
     * 
     */
    public static Localizable _WorkspaceSnapshotSCM_NoWorkspace(Object arg1, Object arg2) {
        return new Localizable(holder, "WorkspaceSnapshotSCM.NoWorkspace", arg1, arg2);
    }

    /**
     * {0} isn’t a job that has a workspace.
     * 
     */
    public static String WorkspaceSnapshotSCM_IncorrectJobType(Object arg1) {
        return holder.format("WorkspaceSnapshotSCM.IncorrectJobType", arg1);
    }

    /**
     * {0} isn’t a job that has a workspace.
     * 
     */
    public static Localizable _WorkspaceSnapshotSCM_IncorrectJobType(Object arg1) {
        return new Localizable(holder, "WorkspaceSnapshotSCM.IncorrectJobType", arg1);
    }

    /**
     * There’s no qualifying build for the {0} permalink in {1}
     * 
     */
    public static String WorkspaceSnapshotSCM_NoBuild(Object arg1, Object arg2) {
        return holder.format("WorkspaceSnapshotSCM.NoBuild", arg1, arg2);
    }

    /**
     * There’s no qualifying build for the {0} permalink in {1}
     * 
     */
    public static Localizable _WorkspaceSnapshotSCM_NoBuild(Object arg1, Object arg2) {
        return new Localizable(holder, "WorkspaceSnapshotSCM.NoBuild", arg1, arg2);
    }

}
