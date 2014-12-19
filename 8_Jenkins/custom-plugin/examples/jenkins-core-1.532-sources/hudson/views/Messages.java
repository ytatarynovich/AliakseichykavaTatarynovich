// CHECKSTYLE:OFF

package hudson.views;

import org.jvnet.localizer.Localizable;
import org.jvnet.localizer.ResourceBundleHolder;

@SuppressWarnings({
    "",
    "PMD"
})
public class Messages {

    private final static ResourceBundleHolder holder = ResourceBundleHolder.get(Messages.class);

    /**
     * Default Views TabBar
     * 
     */
    public static String DefaultViewsTabsBar_DisplayName() {
        return holder.format("DefaultViewsTabsBar.DisplayName");
    }

    /**
     * Default Views TabBar
     * 
     */
    public static Localizable _DefaultViewsTabsBar_DisplayName() {
        return new Localizable(holder, "DefaultViewsTabsBar.DisplayName");
    }

    /**
     * Weather
     * 
     */
    public static String WeatherColumn_DisplayName() {
        return holder.format("WeatherColumn.DisplayName");
    }

    /**
     * Weather
     * 
     */
    public static Localizable _WeatherColumn_DisplayName() {
        return new Localizable(holder, "WeatherColumn.DisplayName");
    }

    /**
     * Status
     * 
     */
    public static String StatusColumn_DisplayName() {
        return holder.format("StatusColumn.DisplayName");
    }

    /**
     * Status
     * 
     */
    public static Localizable _StatusColumn_DisplayName() {
        return new Localizable(holder, "StatusColumn.DisplayName");
    }

    /**
     * Last Failure
     * 
     */
    public static String LastFailureColumn_DisplayName() {
        return holder.format("LastFailureColumn.DisplayName");
    }

    /**
     * Last Failure
     * 
     */
    public static Localizable _LastFailureColumn_DisplayName() {
        return new Localizable(holder, "LastFailureColumn.DisplayName");
    }

    /**
     * Default My Views TabBar
     * 
     */
    public static String DefaultMyViewsTabsBar_DisplayName() {
        return holder.format("DefaultMyViewsTabsBar.DisplayName");
    }

    /**
     * Default My Views TabBar
     * 
     */
    public static Localizable _DefaultMyViewsTabsBar_DisplayName() {
        return new Localizable(holder, "DefaultMyViewsTabsBar.DisplayName");
    }

    /**
     * Last Duration
     * 
     */
    public static String LastDurationColumn_DisplayName() {
        return holder.format("LastDurationColumn.DisplayName");
    }

    /**
     * Last Duration
     * 
     */
    public static Localizable _LastDurationColumn_DisplayName() {
        return new Localizable(holder, "LastDurationColumn.DisplayName");
    }

    /**
     * Name
     * 
     */
    public static String JobColumn_DisplayName() {
        return holder.format("JobColumn.DisplayName");
    }

    /**
     * Name
     * 
     */
    public static Localizable _JobColumn_DisplayName() {
        return new Localizable(holder, "JobColumn.DisplayName");
    }

    /**
     * Build Button
     * 
     */
    public static String BuildButtonColumn_DisplayName() {
        return holder.format("BuildButtonColumn.DisplayName");
    }

    /**
     * Build Button
     * 
     */
    public static Localizable _BuildButtonColumn_DisplayName() {
        return new Localizable(holder, "BuildButtonColumn.DisplayName");
    }

    /**
     * Last Success
     * 
     */
    public static String LastSuccessColumn_DisplayName() {
        return holder.format("LastSuccessColumn.DisplayName");
    }

    /**
     * Last Success
     * 
     */
    public static Localizable _LastSuccessColumn_DisplayName() {
        return new Localizable(holder, "LastSuccessColumn.DisplayName");
    }

    /**
     * Last Stable
     * 
     */
    public static String LastStableColumn_DisplayName() {
        return holder.format("LastStableColumn.DisplayName");
    }

    /**
     * Last Stable
     * 
     */
    public static Localizable _LastStableColumn_DisplayName() {
        return new Localizable(holder, "LastStableColumn.DisplayName");
    }

}
