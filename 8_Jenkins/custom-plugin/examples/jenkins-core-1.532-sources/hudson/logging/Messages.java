// CHECKSTYLE:OFF

package hudson.logging;

import org.jvnet.localizer.Localizable;
import org.jvnet.localizer.ResourceBundleHolder;

@SuppressWarnings({
    "",
    "PMD"
})
public class Messages {

    private final static ResourceBundleHolder holder = ResourceBundleHolder.get(Messages.class);

    /**
     * Initialing log recorders
     * 
     */
    public static String LogRecorderManager_init() {
        return holder.format("LogRecorderManager.init");
    }

    /**
     * Initialing log recorders
     * 
     */
    public static Localizable _LogRecorderManager_init() {
        return new Localizable(holder, "LogRecorderManager.init");
    }

    /**
     * log
     * 
     */
    public static String LogRecorderManager_DisplayName() {
        return holder.format("LogRecorderManager.DisplayName");
    }

    /**
     * log
     * 
     */
    public static Localizable _LogRecorderManager_DisplayName() {
        return new Localizable(holder, "LogRecorderManager.DisplayName");
    }

}
