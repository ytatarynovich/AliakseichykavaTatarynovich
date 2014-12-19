// CHECKSTYLE:OFF

package jenkins.mvn;

import org.jvnet.localizer.Localizable;
import org.jvnet.localizer.ResourceBundleHolder;

@SuppressWarnings({
    "",
    "PMD"
})
public class Messages {

    private final static ResourceBundleHolder holder = ResourceBundleHolder.get(Messages.class);

    /**
     * Use default maven global settings
     * 
     */
    public static String DefaultGlobalSettingsProvider_DisplayName() {
        return holder.format("DefaultGlobalSettingsProvider.DisplayName");
    }

    /**
     * Use default maven global settings
     * 
     */
    public static Localizable _DefaultGlobalSettingsProvider_DisplayName() {
        return new Localizable(holder, "DefaultGlobalSettingsProvider.DisplayName");
    }

    /**
     * Global settings file on filesystem
     * 
     */
    public static String FilePathGlobalSettingsProvider_DisplayName() {
        return holder.format("FilePathGlobalSettingsProvider.DisplayName");
    }

    /**
     * Global settings file on filesystem
     * 
     */
    public static Localizable _FilePathGlobalSettingsProvider_DisplayName() {
        return new Localizable(holder, "FilePathGlobalSettingsProvider.DisplayName");
    }

    /**
     * Settings file in filesystem
     * 
     */
    public static String FilePathSettingsProvider_DisplayName() {
        return holder.format("FilePathSettingsProvider.DisplayName");
    }

    /**
     * Settings file in filesystem
     * 
     */
    public static Localizable _FilePathSettingsProvider_DisplayName() {
        return new Localizable(holder, "FilePathSettingsProvider.DisplayName");
    }

    /**
     * Use default maven settings
     * 
     */
    public static String DefaultSettingsProvider_DisplayName() {
        return holder.format("DefaultSettingsProvider.DisplayName");
    }

    /**
     * Use default maven settings
     * 
     */
    public static Localizable _DefaultSettingsProvider_DisplayName() {
        return new Localizable(holder, "DefaultSettingsProvider.DisplayName");
    }

}
