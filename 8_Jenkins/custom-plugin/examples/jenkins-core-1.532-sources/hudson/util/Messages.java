// CHECKSTYLE:OFF

package hudson.util;

import org.jvnet.localizer.Localizable;
import org.jvnet.localizer.ResourceBundleHolder;

@SuppressWarnings({
    "",
    "PMD"
})
public class Messages {

    private final static ResourceBundleHolder holder = ResourceBundleHolder.get(Messages.class);

    /**
     * Saved
     * 
     */
    public static String HttpResponses_Saved() {
        return holder.format("HttpResponses.Saved");
    }

    /**
     * Saved
     * 
     */
    public static Localizable _HttpResponses_Saved() {
        return new Localizable(holder, "HttpResponses.Saved");
    }

    /**
     * Required
     * 
     */
    public static String FormValidation_ValidateRequired() {
        return holder.format("FormValidation.ValidateRequired");
    }

    /**
     * Required
     * 
     */
    public static Localizable _FormValidation_ValidateRequired() {
        return new Localizable(holder, "FormValidation.ValidateRequired");
    }

    /**
     * In sync
     * 
     */
    public static String ClockDifference_InSync() {
        return holder.format("ClockDifference.InSync");
    }

    /**
     * In sync
     * 
     */
    public static Localizable _ClockDifference_InSync() {
        return new Localizable(holder, "ClockDifference.InSync");
    }

    /**
     * (show details)
     * 
     */
    public static String FormValidation_Error_Details() {
        return holder.format("FormValidation.Error.Details");
    }

    /**
     * (show details)
     * 
     */
    public static Localizable _FormValidation_Error_Details() {
        return new Localizable(holder, "FormValidation.Error.Details");
    }

    /**
     * Failed to check
     * 
     */
    public static String ClockDifference_Failed() {
        return holder.format("ClockDifference.Failed");
    }

    /**
     * Failed to check
     * 
     */
    public static Localizable _ClockDifference_Failed() {
        return new Localizable(holder, "ClockDifference.Failed");
    }

    /**
     * Did not manage to validate {0} (may be too slow)
     * 
     */
    public static String FormFieldValidator_did_not_manage_to_validate_may_be_too_sl(Object arg1) {
        return holder.format("FormFieldValidator.did_not_manage_to_validate_may_be_too_sl", arg1);
    }

    /**
     * Did not manage to validate {0} (may be too slow)
     * 
     */
    public static Localizable _FormFieldValidator_did_not_manage_to_validate_may_be_too_sl(Object arg1) {
        return new Localizable(holder, "FormFieldValidator.did_not_manage_to_validate_may_be_too_sl", arg1);
    }

    /**
     * {0} ahead
     * 
     */
    public static String ClockDifference_Ahead(Object arg1) {
        return holder.format("ClockDifference.Ahead", arg1);
    }

    /**
     * {0} ahead
     * 
     */
    public static Localizable _ClockDifference_Ahead(Object arg1) {
        return new Localizable(holder, "ClockDifference.Ahead", arg1);
    }

    /**
     * {0} behind
     * 
     */
    public static String ClockDifference_Behind(Object arg1) {
        return holder.format("ClockDifference.Behind", arg1);
    }

    /**
     * {0} behind
     * 
     */
    public static Localizable _ClockDifference_Behind(Object arg1) {
        return new Localizable(holder, "ClockDifference.Behind", arg1);
    }

}
