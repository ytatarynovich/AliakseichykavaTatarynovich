// CHECKSTYLE:OFF

package hudson.widgets;

import org.jvnet.localizer.Localizable;
import org.jvnet.localizer.ResourceBundleHolder;

@SuppressWarnings({
    "",
    "PMD"
})
public class Messages {

    private final static ResourceBundleHolder holder = ResourceBundleHolder.get(Messages.class);

    /**
     * Build History
     * 
     */
    public static String BuildHistoryWidget_DisplayName() {
        return holder.format("BuildHistoryWidget.DisplayName");
    }

    /**
     * Build History
     * 
     */
    public static Localizable _BuildHistoryWidget_DisplayName() {
        return new Localizable(holder, "BuildHistoryWidget.DisplayName");
    }

}
