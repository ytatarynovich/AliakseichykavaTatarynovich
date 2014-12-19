// CHECKSTYLE:OFF

package hudson.matrix;

import org.jvnet.localizer.Localizable;
import org.jvnet.localizer.ResourceBundleHolder;

@SuppressWarnings({
    "",
    "PMD"
})
public class Messages {

    private final static ResourceBundleHolder holder = ResourceBundleHolder.get(Messages.class);

    /**
     * Slaves
     * 
     */
    public static String LabelAxis_DisplayName() {
        return holder.format("LabelAxis.DisplayName");
    }

    /**
     * Slaves
     * 
     */
    public static Localizable _LabelAxis_DisplayName() {
        return new Localizable(holder, "LabelAxis.DisplayName");
    }

    /**
     * Interrupting {0}
     * 
     */
    public static String MatrixBuild_Interrupting(Object arg1) {
        return holder.format("MatrixBuild.Interrupting", arg1);
    }

    /**
     * Interrupting {0}
     * 
     */
    public static Localizable _MatrixBuild_Interrupting(Object arg1) {
        return new Localizable(holder, "MatrixBuild.Interrupting", arg1);
    }

    /**
     * Label expression
     * 
     */
    public static String LabelExpAxis_DisplayName() {
        return holder.format("LabelExpAxis.DisplayName");
    }

    /**
     * Label expression
     * 
     */
    public static Localizable _LabelExpAxis_DisplayName() {
        return new Localizable(holder, "LabelExpAxis.DisplayName");
    }

    /**
     * {0} depends on this.
     * 
     */
    public static String MatrixBuild_depends_on_this(Object arg1) {
        return holder.format("MatrixBuild.depends_on_this", arg1);
    }

    /**
     * {0} depends on this.
     * 
     */
    public static Localizable _MatrixBuild_depends_on_this(Object arg1) {
        return new Localizable(holder, "MatrixBuild.depends_on_this", arg1);
    }

    /**
     * User-defined Axis
     * 
     */
    public static String TextArea_DisplayName() {
        return holder.format("TextArea.DisplayName");
    }

    /**
     * User-defined Axis
     * 
     */
    public static Localizable _TextArea_DisplayName() {
        return new Localizable(holder, "TextArea.DisplayName");
    }

    /**
     * {0} appears to be cancelled
     * 
     */
    public static String MatrixBuild_AppearsCancelled(Object arg1) {
        return holder.format("MatrixBuild.AppearsCancelled", arg1);
    }

    /**
     * {0} appears to be cancelled
     * 
     */
    public static Localizable _MatrixBuild_AppearsCancelled(Object arg1) {
        return new Localizable(holder, "MatrixBuild.AppearsCancelled", arg1);
    }

    /**
     * {0} completed with result {1}
     * 
     */
    public static String MatrixBuild_Completed(Object arg1, Object arg2) {
        return holder.format("MatrixBuild.Completed", arg1, arg2);
    }

    /**
     * {0} completed with result {1}
     * 
     */
    public static Localizable _MatrixBuild_Completed(Object arg1, Object arg2) {
        return new Localizable(holder, "MatrixBuild.Completed", arg1, arg2);
    }

    /**
     * Configuration
     * 
     */
    public static String MatrixConfiguration_Pronoun() {
        return holder.format("MatrixConfiguration.Pronoun");
    }

    /**
     * Configuration
     * 
     */
    public static Localizable _MatrixConfiguration_Pronoun() {
        return new Localizable(holder, "MatrixConfiguration.Pronoun");
    }

    /**
     * Duplicate axis name
     * 
     */
    public static String MatrixProject_DuplicateAxisName() {
        return holder.format("MatrixProject.DuplicateAxisName");
    }

    /**
     * Duplicate axis name
     * 
     */
    public static Localizable _MatrixProject_DuplicateAxisName() {
        return new Localizable(holder, "MatrixProject.DuplicateAxisName");
    }

    /**
     * Cancelled {0}
     * 
     */
    public static String MatrixBuild_Cancelled(Object arg1) {
        return holder.format("MatrixBuild.Cancelled", arg1);
    }

    /**
     * Cancelled {0}
     * 
     */
    public static Localizable _MatrixBuild_Cancelled(Object arg1) {
        return new Localizable(holder, "MatrixBuild.Cancelled", arg1);
    }

    /**
     * Triggering {0}
     * 
     */
    public static String MatrixBuild_Triggering(Object arg1) {
        return holder.format("MatrixBuild.Triggering", arg1);
    }

    /**
     * Triggering {0}
     * 
     */
    public static Localizable _MatrixBuild_Triggering(Object arg1) {
        return new Localizable(holder, "MatrixBuild.Triggering", arg1);
    }

    /**
     * Build multi-configuration project
     * 
     */
    public static String MatrixProject_DisplayName() {
        return holder.format("MatrixProject.DisplayName");
    }

    /**
     * Build multi-configuration project
     * 
     */
    public static Localizable _MatrixProject_DisplayName() {
        return new Localizable(holder, "MatrixProject.DisplayName");
    }

    /**
     * JDK
     * 
     */
    public static String JDKAxis_DisplayName() {
        return holder.format("JDKAxis.DisplayName");
    }

    /**
     * JDK
     * 
     */
    public static Localizable _JDKAxis_DisplayName() {
        return new Localizable(holder, "JDKAxis.DisplayName");
    }

    /**
     * Multi-configuration project
     * 
     */
    public static String MatrixProject_Pronoun() {
        return holder.format("MatrixProject.Pronoun");
    }

    /**
     * Multi-configuration project
     * 
     */
    public static Localizable _MatrixProject_Pronoun() {
        return new Localizable(holder, "MatrixProject.Pronoun");
    }

    /**
     * Kept because {0} is kept
     * 
     */
    public static String MatrixRun_KeptBecauseOfParent(Object arg1) {
        return holder.format("MatrixRun.KeptBecauseOfParent", arg1);
    }

    /**
     * Kept because {0} is kept
     * 
     */
    public static Localizable _MatrixRun_KeptBecauseOfParent(Object arg1) {
        return new Localizable(holder, "MatrixRun.KeptBecauseOfParent", arg1);
    }

}
