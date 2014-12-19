// CHECKSTYLE:OFF

package hudson.scheduler;

import org.jvnet.localizer.Localizable;
import org.jvnet.localizer.ResourceBundleHolder;

@SuppressWarnings({
    "",
    "PMD"
})
public class Messages {

    private final static ResourceBundleHolder holder = ResourceBundleHolder.get(Messages.class);

    /**
     * Invalid input: "{0}": {1}
     * 
     */
    public static String CronTabList_InvalidInput(Object arg1, Object arg2) {
        return holder.format("CronTabList.InvalidInput", arg1, arg2);
    }

    /**
     * Invalid input: "{0}": {1}
     * 
     */
    public static Localizable _CronTabList_InvalidInput(Object arg1, Object arg2) {
        return new Localizable(holder, "CronTabList.InvalidInput", arg1, arg2);
    }

    /**
     * Spread load evenly by using ‘{0}’ rather than ‘{1}’
     * 
     */
    public static String CronTab_spread_load_evenly_by_using_rather_than_(Object arg1, Object arg2) {
        return holder.format("CronTab.spread_load_evenly_by_using_rather_than_", arg1, arg2);
    }

    /**
     * Spread load evenly by using ‘{0}’ rather than ‘{1}’
     * 
     */
    public static Localizable _CronTab_spread_load_evenly_by_using_rather_than_(Object arg1, Object arg2) {
        return new Localizable(holder, "CronTab.spread_load_evenly_by_using_rather_than_", arg1, arg2);
    }

    /**
     * {0} is an invalid value. Must be within {1} and {2}
     * 
     */
    public static String BaseParser_OutOfRange(Object arg1, Object arg2, Object arg3) {
        return holder.format("BaseParser.OutOfRange", arg1, arg2, arg3);
    }

    /**
     * {0} is an invalid value. Must be within {1} and {2}
     * 
     */
    public static Localizable _BaseParser_OutOfRange(Object arg1, Object arg2, Object arg3) {
        return new Localizable(holder, "BaseParser.OutOfRange", arg1, arg2, arg3);
    }

    /**
     * step must be positive, but found {0}
     * 
     */
    public static String BaseParser_MustBePositive(Object arg1) {
        return holder.format("BaseParser.MustBePositive", arg1);
    }

    /**
     * step must be positive, but found {0}
     * 
     */
    public static Localizable _BaseParser_MustBePositive(Object arg1) {
        return new Localizable(holder, "BaseParser.MustBePositive", arg1);
    }

    /**
     * You mean {0}-{1}?
     * 
     */
    public static String BaseParser_StartEndReversed(Object arg1, Object arg2) {
        return holder.format("BaseParser.StartEndReversed", arg1, arg2);
    }

    /**
     * You mean {0}-{1}?
     * 
     */
    public static Localizable _BaseParser_StartEndReversed(Object arg1, Object arg2) {
        return new Localizable(holder, "BaseParser.StartEndReversed", arg1, arg2);
    }

    /**
     * Do you really mean "every minute" when you say "{0}"? Perhaps you meant "{1}"
     * 
     */
    public static String CronTab_do_you_really_mean_every_minute_when_you(Object arg1, Object arg2) {
        return holder.format("CronTab.do_you_really_mean_every_minute_when_you", arg1, arg2);
    }

    /**
     * Do you really mean "every minute" when you say "{0}"? Perhaps you meant "{1}"
     * 
     */
    public static Localizable _CronTab_do_you_really_mean_every_minute_when_you(Object arg1, Object arg2) {
        return new Localizable(holder, "CronTab.do_you_really_mean_every_minute_when_you", arg1, arg2);
    }

}
