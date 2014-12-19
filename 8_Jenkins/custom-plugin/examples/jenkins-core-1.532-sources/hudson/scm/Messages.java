// CHECKSTYLE:OFF

package hudson.scm;

import org.jvnet.localizer.Localizable;
import org.jvnet.localizer.ResourceBundleHolder;

@SuppressWarnings({
    "",
    "PMD"
})
public class Messages {

    private final static ResourceBundleHolder holder = ResourceBundleHolder.get(Messages.class);

    /**
     * None
     * 
     */
    public static String NullSCM_DisplayName() {
        return holder.format("NullSCM.DisplayName");
    }

    /**
     * None
     * 
     */
    public static Localizable _NullSCM_DisplayName() {
        return new Localizable(holder, "NullSCM.DisplayName");
    }

    /**
     * SCM
     * 
     */
    public static String SCM_Permissions_Title() {
        return holder.format("SCM.Permissions.Title");
    }

    /**
     * SCM
     * 
     */
    public static Localizable _SCM_Permissions_Title() {
        return new Localizable(holder, "SCM.Permissions.Title");
    }

    /**
     * This permission allows users to create a new tag in the source code repository for a given build.
     * 
     */
    public static String SCM_TagPermission_Description() {
        return holder.format("SCM.TagPermission.Description");
    }

    /**
     * This permission allows users to create a new tag in the source code repository for a given build.
     * 
     */
    public static Localizable _SCM_TagPermission_Description() {
        return new Localizable(holder, "SCM.TagPermission.Description");
    }

}
