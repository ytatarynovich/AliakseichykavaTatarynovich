// CHECKSTYLE:OFF

package hudson.security.csrf;

import org.jvnet.localizer.Localizable;
import org.jvnet.localizer.ResourceBundleHolder;

@SuppressWarnings({
    "",
    "PMD"
})
public class Messages {

    private final static ResourceBundleHolder holder = ResourceBundleHolder.get(Messages.class);

    /**
     * Default Crumb Issuer
     * 
     */
    public static String DefaultCrumbIssuer_DisplayName() {
        return holder.format("DefaultCrumbIssuer.DisplayName");
    }

    /**
     * Default Crumb Issuer
     * 
     */
    public static Localizable _DefaultCrumbIssuer_DisplayName() {
        return new Localizable(holder, "DefaultCrumbIssuer.DisplayName");
    }

}
