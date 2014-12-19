// CHECKSTYLE:OFF

package hudson.tasks.junit;

import org.jvnet.localizer.Localizable;
import org.jvnet.localizer.ResourceBundleHolder;

@SuppressWarnings({
    "",
    "PMD"
})
public class Messages {

    private final static ResourceBundleHolder holder = ResourceBundleHolder.get(Messages.class);

    /**
     * Recording test results
     * 
     */
    public static String JUnitResultArchiver_Recording() {
        return holder.format("JUnitResultArchiver.Recording");
    }

    /**
     * Recording test results
     * 
     */
    public static Localizable _JUnitResultArchiver_Recording() {
        return new Localizable(holder, "JUnitResultArchiver.Recording");
    }

    /**
     * JUnit Parser
     * 
     */
    public static String JUnitParser_DisplayName() {
        return holder.format("JUnitParser.DisplayName");
    }

    /**
     * JUnit Parser
     * 
     */
    public static Localizable _JUnitParser_DisplayName() {
        return new Localizable(holder, "JUnitParser.DisplayName");
    }

    /**
     * None of the test reports contained any result
     * 
     */
    public static String JUnitResultArchiver_ResultIsEmpty() {
        return holder.format("JUnitResultArchiver.ResultIsEmpty");
    }

    /**
     * None of the test reports contained any result
     * 
     */
    public static Localizable _JUnitResultArchiver_ResultIsEmpty() {
        return new Localizable(holder, "JUnitResultArchiver.ResultIsEmpty");
    }

    /**
     * Test Results
     * 
     */
    public static String TestResult_getDisplayName() {
        return holder.format("TestResult.getDisplayName");
    }

    /**
     * Test Results
     * 
     */
    public static Localizable _TestResult_getDisplayName() {
        return new Localizable(holder, "TestResult.getDisplayName");
    }

    /**
     * No workspace found for {0}
     * 
     */
    public static String JUnitParser_no_workspace_found(Object arg1) {
        return holder.format("JUnitParser.no_workspace_found", arg1);
    }

    /**
     * No workspace found for {0}
     * 
     */
    public static Localizable _JUnitParser_no_workspace_found(Object arg1) {
        return new Localizable(holder, "JUnitParser.no_workspace_found", arg1);
    }

    /**
     * Fixed
     * 
     */
    public static String CaseResult_Status_Fixed() {
        return holder.format("CaseResult.Status.Fixed");
    }

    /**
     * Fixed
     * 
     */
    public static Localizable _CaseResult_Status_Fixed() {
        return new Localizable(holder, "CaseResult.Status.Fixed");
    }

    /**
     * Test Result
     * 
     */
    public static String TestResult_getTitle() {
        return holder.format("TestResult.getTitle");
    }

    /**
     * Test Result
     * 
     */
    public static Localizable _TestResult_getTitle() {
        return new Localizable(holder, "TestResult.getTitle");
    }

    /**
     * Package
     * 
     */
    public static String TestResult_getChildTitle() {
        return holder.format("TestResult.getChildTitle");
    }

    /**
     * Package
     * 
     */
    public static Localizable _TestResult_getChildTitle() {
        return new Localizable(holder, "TestResult.getChildTitle");
    }

    /**
     * Passed
     * 
     */
    public static String CaseResult_Status_Passed() {
        return holder.format("CaseResult.Status.Passed");
    }

    /**
     * Passed
     * 
     */
    public static Localizable _CaseResult_Status_Passed() {
        return new Localizable(holder, "CaseResult.Status.Passed");
    }

    /**
     * Skipped
     * 
     */
    public static String CaseResult_Status_Skipped() {
        return holder.format("CaseResult.Status.Skipped");
    }

    /**
     * Skipped
     * 
     */
    public static Localizable _CaseResult_Status_Skipped() {
        return new Localizable(holder, "CaseResult.Status.Skipped");
    }

    /**
     * Incorrect XML attributes for test results found in {0}
     * 
     */
    public static String JUnitResultArchiver_BadXML(Object arg1) {
        return holder.format("JUnitResultArchiver.BadXML", arg1);
    }

    /**
     * Incorrect XML attributes for test results found in {0}
     * 
     */
    public static Localizable _JUnitResultArchiver_BadXML(Object arg1) {
        return new Localizable(holder, "JUnitResultArchiver.BadXML", arg1);
    }

    /**
     * Test Result : {0}
     * 
     */
    public static String PackageResult_getTitle(Object arg1) {
        return holder.format("PackageResult.getTitle", arg1);
    }

    /**
     * Test Result : {0}
     * 
     */
    public static Localizable _PackageResult_getTitle(Object arg1) {
        return new Localizable(holder, "PackageResult.getTitle", arg1);
    }

    /**
     * Test Result : {0}
     * 
     */
    public static String ClassResult_getTitle(Object arg1) {
        return holder.format("ClassResult.getTitle", arg1);
    }

    /**
     * Test Result : {0}
     * 
     */
    public static Localizable _ClassResult_getTitle(Object arg1) {
        return new Localizable(holder, "ClassResult.getTitle", arg1);
    }

    /**
     * Failed
     * 
     */
    public static String CaseResult_Status_Failed() {
        return holder.format("CaseResult.Status.Failed");
    }

    /**
     * Failed
     * 
     */
    public static Localizable _CaseResult_Status_Failed() {
        return new Localizable(holder, "CaseResult.Status.Failed");
    }

    /**
     * Regression
     * 
     */
    public static String CaseResult_Status_Regression() {
        return holder.format("CaseResult.Status.Regression");
    }

    /**
     * Regression
     * 
     */
    public static Localizable _CaseResult_Status_Regression() {
        return new Localizable(holder, "CaseResult.Status.Regression");
    }

    /**
     * Class
     * 
     */
    public static String PackageResult_getChildTitle() {
        return holder.format("PackageResult.getChildTitle");
    }

    /**
     * Class
     * 
     */
    public static Localizable _PackageResult_getChildTitle() {
        return new Localizable(holder, "PackageResult.getChildTitle");
    }

    /**
     * No test report files were found. Configuration error?
     * 
     */
    public static String JUnitResultArchiver_NoTestReportFound() {
        return holder.format("JUnitResultArchiver.NoTestReportFound");
    }

    /**
     * No test report files were found. Configuration error?
     * 
     */
    public static Localizable _JUnitResultArchiver_NoTestReportFound() {
        return new Localizable(holder, "JUnitResultArchiver.NoTestReportFound");
    }

    /**
     * Publish JUnit test result report
     * 
     */
    public static String JUnitResultArchiver_DisplayName() {
        return holder.format("JUnitResultArchiver.DisplayName");
    }

    /**
     * Publish JUnit test result report
     * 
     */
    public static Localizable _JUnitResultArchiver_DisplayName() {
        return new Localizable(holder, "JUnitResultArchiver.DisplayName");
    }

    /**
     * JUnit xml files:
     * 
     */
    public static String JUnitParser_TestResultLocationMessage() {
        return holder.format("JUnitParser.TestResultLocationMessage");
    }

    /**
     * JUnit xml files:
     * 
     */
    public static Localizable _JUnitParser_TestResultLocationMessage() {
        return new Localizable(holder, "JUnitParser.TestResultLocationMessage");
    }

}
