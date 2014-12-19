// CHECKSTYLE:OFF

package hudson.search;

import org.jvnet.localizer.Localizable;
import org.jvnet.localizer.ResourceBundleHolder;

@SuppressWarnings({
    "",
    "PMD"
})
public class Messages {

    private final static ResourceBundleHolder holder = ResourceBundleHolder.get(Messages.class);

    /**
     * Setting for search
     * 
     */
    public static String UserSearchProperty_DisplayName() {
        return holder.format("UserSearchProperty.DisplayName");
    }

    /**
     * Setting for search
     * 
     */
    public static Localizable _UserSearchProperty_DisplayName() {
        return new Localizable(holder, "UserSearchProperty.DisplayName");
    }

}
