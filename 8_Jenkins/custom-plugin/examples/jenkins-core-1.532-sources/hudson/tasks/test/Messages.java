// CHECKSTYLE:OFF

package hudson.tasks.test;

import org.jvnet.localizer.Localizable;
import org.jvnet.localizer.ResourceBundleHolder;

@SuppressWarnings({
    "",
    "PMD"
})
public class Messages {

    private final static ResourceBundleHolder holder = ResourceBundleHolder.get(Messages.class);

    /**
     * {0}: {1} {1,choice,0#failures|1#failure|1&lt;failures}
     * 
     */
    public static String AbstractTestResultAction_fail(Object arg1, Object arg2) {
        return holder.format("AbstractTestResultAction.fail", arg1, arg2);
    }

    /**
     * {0}: {1} {1,choice,0#failures|1#failure|1&lt;failures}
     * 
     */
    public static Localizable _AbstractTestResultAction_fail(Object arg1, Object arg2) {
        return new Localizable(holder, "AbstractTestResultAction.fail", arg1, arg2);
    }

    /**
     * Aggregate downstream test results
     * 
     */
    public static String AggregatedTestResultPublisher_DisplayName() {
        return holder.format("AggregatedTestResultPublisher.DisplayName");
    }

    /**
     * Aggregate downstream test results
     * 
     */
    public static Localizable _AggregatedTestResultPublisher_DisplayName() {
        return new Localizable(holder, "AggregatedTestResultPublisher.DisplayName");
    }

    /**
     * {0}: {1} {1,choice,0#tests|1#test|1&lt;tests} failing out of a total of {2} {2,choice,1#test|1&lt;tests}.
     * 
     */
    public static String AbstractTestResultAction_TestsDescription(Object arg1, Object arg2, Object arg3) {
        return holder.format("AbstractTestResultAction.TestsDescription", arg1, arg2, arg3);
    }

    /**
     * {0}: {1} {1,choice,0#tests|1#test|1&lt;tests} failing out of a total of {2} {2,choice,1#test|1&lt;tests}.
     * 
     */
    public static Localizable _AbstractTestResultAction_TestsDescription(Object arg1, Object arg2, Object arg3) {
        return new Localizable(holder, "AbstractTestResultAction.TestsDescription", arg1, arg2, arg3);
    }

    /**
     * Test Result
     * 
     */
    public static String AbstractTestResultAction_getDisplayName() {
        return holder.format("AbstractTestResultAction.getDisplayName");
    }

    /**
     * Test Result
     * 
     */
    public static Localizable _AbstractTestResultAction_getDisplayName() {
        return new Localizable(holder, "AbstractTestResultAction.getDisplayName");
    }

    /**
     * {0}: {1} {1,choice,0#skips|1#skip|1&lt;skips}
     * 
     */
    public static String AbstractTestResultAction_skip(Object arg1, Object arg2) {
        return holder.format("AbstractTestResultAction.skip", arg1, arg2);
    }

    /**
     * {0}: {1} {1,choice,0#skips|1#skip|1&lt;skips}
     * 
     */
    public static Localizable _AbstractTestResultAction_skip(Object arg1, Object arg2) {
        return new Localizable(holder, "AbstractTestResultAction.skip", arg1, arg2);
    }

    /**
     * Aggregated Test Result
     * 
     */
    public static String AggregatedTestResultPublisher_Title() {
        return holder.format("AggregatedTestResultPublisher.Title");
    }

    /**
     * Aggregated Test Result
     * 
     */
    public static Localizable _AggregatedTestResultPublisher_Title() {
        return new Localizable(holder, "AggregatedTestResultPublisher.Title");
    }

    /**
     * {0}: 0 tests in total.
     * 
     */
    public static String AbstractTestResultAction_zeroTestDescription(Object arg1) {
        return holder.format("AbstractTestResultAction.zeroTestDescription", arg1);
    }

    /**
     * {0}: 0 tests in total.
     * 
     */
    public static Localizable _AbstractTestResultAction_zeroTestDescription(Object arg1) {
        return new Localizable(holder, "AbstractTestResultAction.zeroTestDescription", arg1);
    }

    /**
     * {0}: {1} {1,choice,0#tests|1#test|1&lt;tests}
     * 
     */
    public static String AbstractTestResultAction_test(Object arg1, Object arg2) {
        return holder.format("AbstractTestResultAction.test", arg1, arg2);
    }

    /**
     * {0}: {1} {1,choice,0#tests|1#test|1&lt;tests}
     * 
     */
    public static Localizable _AbstractTestResultAction_test(Object arg1, Object arg2) {
        return new Localizable(holder, "AbstractTestResultAction.test", arg1, arg2);
    }

}
