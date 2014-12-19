// CHECKSTYLE:OFF

package hudson;

import org.jvnet.localizer.Localizable;
import org.jvnet.localizer.ResourceBundleHolder;

@SuppressWarnings({
    "",
    "PMD"
})
public class Messages {

    private final static ResourceBundleHolder holder = ResourceBundleHolder.get(Messages.class);

    /**
     * {0} {0,choice,0#days|1#day|1&lt;days}
     * 
     */
    public static String Util_day(Object arg1) {
        return holder.format("Util.day", arg1);
    }

    /**
     * {0} {0,choice,0#days|1#day|1&lt;days}
     * 
     */
    public static Localizable _Util_day(Object arg1) {
        return new Localizable(holder, "Util.day", arg1);
    }

    /**
     * Plugin Manager
     * 
     */
    public static String PluginManager_DisplayName() {
        return holder.format("PluginManager.DisplayName");
    }

    /**
     * Plugin Manager
     * 
     */
    public static Localizable _PluginManager_DisplayName() {
        return new Localizable(holder, "PluginManager.DisplayName");
    }

    /**
     * {0} ms
     * 
     */
    public static String Util_millisecond(Object arg1) {
        return holder.format("Util.millisecond", arg1);
    }

    /**
     * {0} ms
     * 
     */
    public static Localizable _Util_millisecond(Object arg1) {
        return new Localizable(holder, "Util.millisecond", arg1);
    }

    /**
     * The "upload plugin" permission allows a user to upload arbitrary plugins.
     * 
     */
    public static String PluginManager_UploadPluginsPermission_Description() {
        return holder.format("PluginManager.UploadPluginsPermission.Description");
    }

    /**
     * The "upload plugin" permission allows a user to upload arbitrary plugins.
     * 
     */
    public static Localizable _PluginManager_UploadPluginsPermission_Description() {
        return new Localizable(holder, "PluginManager.UploadPluginsPermission.Description");
    }

    /**
     * {0} plugin is already installed. Jenkins needs to be restarted for the update to take effect
     * 
     */
    public static String PluginManager_PluginIsAlreadyInstalled_RestartRequired(Object arg1) {
        return holder.format("PluginManager.PluginIsAlreadyInstalled.RestartRequired", arg1);
    }

    /**
     * {0} plugin is already installed. Jenkins needs to be restarted for the update to take effect
     * 
     */
    public static Localizable _PluginManager_PluginIsAlreadyInstalled_RestartRequired(Object arg1) {
        return new Localizable(holder, "PluginManager.PluginIsAlreadyInstalled.RestartRequired", arg1);
    }

    /**
     * ‘{0}’ is not a file
     * 
     */
    public static String FilePath_validateRelativePath_notFile(Object arg1) {
        return holder.format("FilePath.validateRelativePath.notFile", arg1);
    }

    /**
     * ‘{0}’ is not a file
     * 
     */
    public static Localizable _FilePath_validateRelativePath_notFile(Object arg1) {
        return new Localizable(holder, "FilePath.validateRelativePath.notFile", arg1);
    }

    /**
     * No such file: ‘{0}’
     * 
     */
    public static String FilePath_validateRelativePath_noSuchFile(Object arg1) {
        return holder.format("FilePath.validateRelativePath.noSuchFile", arg1);
    }

    /**
     * No such file: ‘{0}’
     * 
     */
    public static Localizable _FilePath_validateRelativePath_noSuchFile(Object arg1) {
        return new Localizable(holder, "FilePath.validateRelativePath.noSuchFile", arg1);
    }

    /**
     * ‘{0}’ doesn’t match anything: even ‘{1}’ doesn’t exist
     * 
     */
    public static String FilePath_validateAntFileMask_doesntMatchAnythingAndSuggest(Object arg1, Object arg2) {
        return holder.format("FilePath.validateAntFileMask.doesntMatchAnythingAndSuggest", arg1, arg2);
    }

    /**
     * ‘{0}’ doesn’t match anything: even ‘{1}’ doesn’t exist
     * 
     */
    public static Localizable _FilePath_validateAntFileMask_doesntMatchAnythingAndSuggest(Object arg1, Object arg2) {
        return new Localizable(holder, "FilePath.validateAntFileMask.doesntMatchAnythingAndSuggest", arg1, arg2);
    }

    /**
     * ‘{0}’ is not a directory
     * 
     */
    public static String FilePath_validateRelativePath_notDirectory(Object arg1) {
        return holder.format("FilePath.validateRelativePath.notDirectory", arg1);
    }

    /**
     * ‘{0}’ is not a directory
     * 
     */
    public static Localizable _FilePath_validateRelativePath_notDirectory(Object arg1) {
        return new Localizable(holder, "FilePath.validateRelativePath.notDirectory", arg1);
    }

    /**
     * {0}
     * 
     */
    public static String Util_pastTime(Object arg1) {
        return holder.format("Util.pastTime", arg1);
    }

    /**
     * {0}
     * 
     */
    public static Localizable _Util_pastTime(Object arg1) {
        return new Localizable(holder, "Util.pastTime", arg1);
    }

    /**
     * {0} plugin doesn’t support dynamic loading. Jenkins needs to be restarted for the update to take effect
     * 
     */
    public static String PluginManager_PluginDoesntSupportDynamicLoad_RestartRequired(Object arg1) {
        return holder.format("PluginManager.PluginDoesntSupportDynamicLoad.RestartRequired", arg1);
    }

    /**
     * {0} plugin doesn’t support dynamic loading. Jenkins needs to be restarted for the update to take effect
     * 
     */
    public static Localizable _PluginManager_PluginDoesntSupportDynamicLoad_RestartRequired(Object arg1) {
        return new Localizable(holder, "PluginManager.PluginDoesntSupportDynamicLoad.RestartRequired", arg1);
    }

    /**
     * Wildcard is not allowed here
     * 
     */
    public static String FilePath_validateRelativePath_wildcardNotAllowed() {
        return holder.format("FilePath.validateRelativePath.wildcardNotAllowed");
    }

    /**
     * Wildcard is not allowed here
     * 
     */
    public static Localizable _FilePath_validateRelativePath_wildcardNotAllowed() {
        return new Localizable(holder, "FilePath.validateRelativePath.wildcardNotAllowed");
    }

    /**
     * ‘{0}’ doesn’t match anything, but ‘{1}’ does. Perhaps that’s what you mean?
     * 
     */
    public static String FilePath_validateAntFileMask_doesntMatchAndSuggest(Object arg1, Object arg2) {
        return holder.format("FilePath.validateAntFileMask.doesntMatchAndSuggest", arg1, arg2);
    }

    /**
     * ‘{0}’ doesn’t match anything, but ‘{1}’ does. Perhaps that’s what you mean?
     * 
     */
    public static Localizable _FilePath_validateAntFileMask_doesntMatchAndSuggest(Object arg1, Object arg2) {
        return new Localizable(holder, "FilePath.validateAntFileMask.doesntMatchAndSuggest", arg1, arg2);
    }

    /**
     * ‘{0}’ doesn’t match anything
     * 
     */
    public static String FilePath_validateAntFileMask_doesntMatchAnything(Object arg1) {
        return holder.format("FilePath.validateAntFileMask.doesntMatchAnything", arg1);
    }

    /**
     * ‘{0}’ doesn’t match anything
     * 
     */
    public static Localizable _FilePath_validateAntFileMask_doesntMatchAnything(Object arg1) {
        return new Localizable(holder, "FilePath.validateAntFileMask.doesntMatchAnything", arg1);
    }

    /**
     * {0} hr
     * 
     */
    public static String Util_hour(Object arg1) {
        return holder.format("Util.hour", arg1);
    }

    /**
     * {0} hr
     * 
     */
    public static Localizable _Util_hour(Object arg1) {
        return new Localizable(holder, "Util.hour", arg1);
    }

    /**
     * No such directory: ‘{0}’
     * 
     */
    public static String FilePath_validateRelativePath_noSuchDirectory(Object arg1) {
        return holder.format("FilePath.validateRelativePath.noSuchDirectory", arg1);
    }

    /**
     * No such directory: ‘{0}’
     * 
     */
    public static Localizable _FilePath_validateRelativePath_noSuchDirectory(Object arg1) {
        return new Localizable(holder, "FilePath.validateRelativePath.noSuchDirectory", arg1);
    }

    /**
     * Whitespace can no longer be used as the separator. Please Use ‘,’ as the separator instead.
     * 
     */
    public static String FilePath_validateAntFileMask_whitespaceSeprator() {
        return holder.format("FilePath.validateAntFileMask.whitespaceSeprator");
    }

    /**
     * Whitespace can no longer be used as the separator. Please Use ‘,’ as the separator instead.
     * 
     */
    public static Localizable _FilePath_validateAntFileMask_whitespaceSeprator() {
        return new Localizable(holder, "FilePath.validateAntFileMask.whitespaceSeprator");
    }

    /**
     * {0} min
     * 
     */
    public static String Util_minute(Object arg1) {
        return holder.format("Util.minute", arg1);
    }

    /**
     * {0} min
     * 
     */
    public static Localizable _Util_minute(Object arg1) {
        return new Localizable(holder, "Util.minute", arg1);
    }

    /**
     * Port is not a number
     * 
     */
    public static String PluginManager_PortNotANumber() {
        return holder.format("PluginManager.PortNotANumber");
    }

    /**
     * Port is not a number
     * 
     */
    public static Localizable _PluginManager_PortNotANumber() {
        return new Localizable(holder, "PluginManager.PortNotANumber");
    }

    /**
     * {0} yr
     * 
     */
    public static String Util_year(Object arg1) {
        return holder.format("Util.year", arg1);
    }

    /**
     * {0} yr
     * 
     */
    public static Localizable _Util_year(Object arg1) {
        return new Localizable(holder, "Util.year", arg1);
    }

    /**
     * The "configure update center" permission allows a user to configure update sites and proxy settings.
     * 
     */
    public static String PluginManager_ConfigureUpdateCenterPermission_Description() {
        return holder.format("PluginManager.ConfigureUpdateCenterPermission.Description");
    }

    /**
     * The "configure update center" permission allows a user to configure update sites and proxy settings.
     * 
     */
    public static Localizable _PluginManager_ConfigureUpdateCenterPermission_Description() {
        return new Localizable(holder, "PluginManager.ConfigureUpdateCenterPermission.Description");
    }

    /**
     * ‘{0}’ doesn’t match anything, although ‘{1}’ exists
     * 
     */
    public static String FilePath_validateAntFileMask_portionMatchAndSuggest(Object arg1, Object arg2) {
        return holder.format("FilePath.validateAntFileMask.portionMatchAndSuggest", arg1, arg2);
    }

    /**
     * ‘{0}’ doesn’t match anything, although ‘{1}’ exists
     * 
     */
    public static Localizable _FilePath_validateAntFileMask_portionMatchAndSuggest(Object arg1, Object arg2) {
        return new Localizable(holder, "FilePath.validateAntFileMask.portionMatchAndSuggest", arg1, arg2);
    }

    /**
     * {0} mo
     * 
     */
    public static String Util_month(Object arg1) {
        return holder.format("Util.month", arg1);
    }

    /**
     * {0} mo
     * 
     */
    public static Localizable _Util_month(Object arg1) {
        return new Localizable(holder, "Util.month", arg1);
    }

    /**
     * ‘{0}’ doesn’t match anything: ‘{1}’ exists but not ‘{2}’
     * 
     */
    public static String FilePath_validateAntFileMask_portionMatchButPreviousNotMatchAndSuggest(Object arg1, Object arg2, Object arg3) {
        return holder.format("FilePath.validateAntFileMask.portionMatchButPreviousNotMatchAndSuggest", arg1, arg2, arg3);
    }

    /**
     * ‘{0}’ doesn’t match anything: ‘{1}’ exists but not ‘{2}’
     * 
     */
    public static Localizable _FilePath_validateAntFileMask_portionMatchButPreviousNotMatchAndSuggest(Object arg1, Object arg2, Object arg3) {
        return new Localizable(holder, "FilePath.validateAntFileMask.portionMatchButPreviousNotMatchAndSuggest", arg1, arg2, arg3);
    }

    /**
     * {0} sec
     * 
     */
    public static String Util_second(Object arg1) {
        return holder.format("Util.second", arg1);
    }

    /**
     * {0} sec
     * 
     */
    public static Localizable _Util_second(Object arg1) {
        return new Localizable(holder, "Util.second", arg1);
    }

    /**
     * Did not manage to validate {0} (may be too slow)
     * 
     */
    public static String FilePath_did_not_manage_to_validate_may_be_too_sl(Object arg1) {
        return holder.format("FilePath.did_not_manage_to_validate_may_be_too_sl", arg1);
    }

    /**
     * Did not manage to validate {0} (may be too slow)
     * 
     */
    public static Localizable _FilePath_did_not_manage_to_validate_may_be_too_sl(Object arg1) {
        return new Localizable(holder, "FilePath.did_not_manage_to_validate_may_be_too_sl", arg1);
    }

    /**
     * Port doesn’t range from {0} to {1}
     * 
     */
    public static String PluginManager_PortNotInRange(Object arg1, Object arg2) {
        return holder.format("PluginManager.PortNotInRange", arg1, arg2);
    }

    /**
     * Port doesn’t range from {0} to {1}
     * 
     */
    public static Localizable _PluginManager_PortNotInRange(Object arg1, Object arg2) {
        return new Localizable(holder, "PluginManager.PortNotInRange", arg1, arg2);
    }

    /**
     * ‘~’ is only supported in a Unix shell and nowhere else.
     * 
     */
    public static String FilePath_TildaDoesntWork() {
        return holder.format("FilePath.TildaDoesntWork");
    }

    /**
     * ‘~’ is only supported in a Unix shell and nowhere else.
     * 
     */
    public static Localizable _FilePath_TildaDoesntWork() {
        return new Localizable(holder, "FilePath.TildaDoesntWork");
    }

    /**
     * About Jenkins
     * 
     */
    public static String AboutJenkins_DisplayName() {
        return holder.format("AboutJenkins.DisplayName");
    }

    /**
     * About Jenkins
     * 
     */
    public static Localizable _AboutJenkins_DisplayName() {
        return new Localizable(holder, "AboutJenkins.DisplayName");
    }

    /**
     * See the version and license information.
     * 
     */
    public static String AboutJenkins_Description() {
        return holder.format("AboutJenkins.Description");
    }

    /**
     * See the version and license information.
     * 
     */
    public static Localizable _AboutJenkins_Description() {
        return new Localizable(holder, "AboutJenkins.Description");
    }

}
