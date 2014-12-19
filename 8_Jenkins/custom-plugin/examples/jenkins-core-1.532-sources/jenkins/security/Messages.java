// CHECKSTYLE:OFF

package jenkins.security;

import org.jvnet.localizer.Localizable;
import org.jvnet.localizer.ResourceBundleHolder;

@SuppressWarnings({
    "",
    "PMD"
})
public class Messages {

    private final static ResourceBundleHolder holder = ResourceBundleHolder.get(Messages.class);

    /**
     * API Token
     * 
     */
    public static String ApiTokenProperty_DisplayName() {
        return holder.format("ApiTokenProperty.DisplayName");
    }

    /**
     * API Token
     * 
     */
    public static Localizable _ApiTokenProperty_DisplayName() {
        return new Localizable(holder, "ApiTokenProperty.DisplayName");
    }

    /**
     * Re-keying
     * 
     */
    public static String RekeySecretAdminMonitor_DisplayName() {
        return holder.format("RekeySecretAdminMonitor.DisplayName");
    }

    /**
     * Re-keying
     * 
     */
    public static Localizable _RekeySecretAdminMonitor_DisplayName() {
        return new Localizable(holder, "RekeySecretAdminMonitor.DisplayName");
    }

    /**
     * &lt;div>Updated&lt;/div>
     * 
     */
    public static String ApiTokenProperty_ChangeToken_Success() {
        return holder.format("ApiTokenProperty.ChangeToken.Success");
    }

    /**
     * &lt;div>Updated&lt;/div>
     * 
     */
    public static Localizable _ApiTokenProperty_ChangeToken_Success() {
        return new Localizable(holder, "ApiTokenProperty.ChangeToken.Success");
    }

}
