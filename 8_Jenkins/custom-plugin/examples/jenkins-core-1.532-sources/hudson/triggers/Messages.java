// CHECKSTYLE:OFF

package hudson.triggers;

import org.jvnet.localizer.Localizable;
import org.jvnet.localizer.ResourceBundleHolder;

@SuppressWarnings({
    "",
    "PMD"
})
public class Messages {

    private final static ResourceBundleHolder holder = ResourceBundleHolder.get(Messages.class);

    /**
     * Polling Log
     * 
     */
    public static String SCMTrigger_BuildAction_DisplayName() {
        return holder.format("SCMTrigger.BuildAction.DisplayName");
    }

    /**
     * Polling Log
     * 
     */
    public static Localizable _SCMTrigger_BuildAction_DisplayName() {
        return new Localizable(holder, "SCMTrigger.BuildAction.DisplayName");
    }

    /**
     * Started by an SCM change
     * 
     */
    public static String SCMTrigger_SCMTriggerCause_ShortDescription() {
        return holder.format("SCMTrigger.SCMTriggerCause.ShortDescription");
    }

    /**
     * Started by an SCM change
     * 
     */
    public static Localizable _SCMTrigger_SCMTriggerCause_ShortDescription() {
        return new Localizable(holder, "SCMTrigger.SCMTriggerCause.ShortDescription");
    }

    /**
     * Poll SCM
     * 
     */
    public static String SCMTrigger_DisplayName() {
        return holder.format("SCMTrigger.DisplayName");
    }

    /**
     * Poll SCM
     * 
     */
    public static Localizable _SCMTrigger_DisplayName() {
        return new Localizable(holder, "SCMTrigger.DisplayName");
    }

    /**
     * Initializing timer for triggers
     * 
     */
    public static String Trigger_init() {
        return holder.format("Trigger.init");
    }

    /**
     * Initializing timer for triggers
     * 
     */
    public static Localizable _Trigger_init() {
        return new Localizable(holder, "Trigger.init");
    }

    /**
     * {0} Polling Log
     * 
     */
    public static String SCMTrigger_getDisplayName(Object arg1) {
        return holder.format("SCMTrigger.getDisplayName", arg1);
    }

    /**
     * {0} Polling Log
     * 
     */
    public static Localizable _SCMTrigger_getDisplayName(Object arg1) {
        return new Localizable(holder, "SCMTrigger.getDisplayName", arg1);
    }

    /**
     * Started by timer
     * 
     */
    public static String TimerTrigger_TimerTriggerCause_ShortDescription() {
        return holder.format("TimerTrigger.TimerTriggerCause.ShortDescription");
    }

    /**
     * Started by timer
     * 
     */
    public static Localizable _TimerTrigger_TimerTriggerCause_ShortDescription() {
        return new Localizable(holder, "TimerTrigger.TimerTriggerCause.ShortDescription");
    }

    /**
     * Build periodically
     * 
     */
    public static String TimerTrigger_DisplayName() {
        return holder.format("TimerTrigger.DisplayName");
    }

    /**
     * Build periodically
     * 
     */
    public static Localizable _TimerTrigger_DisplayName() {
        return new Localizable(holder, "TimerTrigger.DisplayName");
    }

    /**
     * You appear to be missing whitespace between * and *.
     * 
     */
    public static String TimerTrigger_MissingWhitespace() {
        return holder.format("TimerTrigger.MissingWhitespace");
    }

    /**
     * You appear to be missing whitespace between * and *.
     * 
     */
    public static Localizable _TimerTrigger_MissingWhitespace() {
        return new Localizable(holder, "TimerTrigger.MissingWhitespace");
    }

}
