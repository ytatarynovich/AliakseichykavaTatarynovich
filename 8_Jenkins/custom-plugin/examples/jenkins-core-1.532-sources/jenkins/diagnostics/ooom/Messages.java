// CHECKSTYLE:OFF

package jenkins.diagnostics.ooom;

import org.jvnet.localizer.Localizable;
import org.jvnet.localizer.ResourceBundleHolder;

@SuppressWarnings({
    "",
    "PMD"
})
public class Messages {

    private final static ResourceBundleHolder holder = ResourceBundleHolder.get(Messages.class);

    /**
     * {0} builds have inconsistent timestamps in &lt;a href="{2}">{1}&lt;/a>
     * 
     */
    public static String Problem_DisplayName(Object arg1, Object arg2, Object arg3) {
        return holder.format("Problem.DisplayName", arg1, arg2, arg3);
    }

    /**
     * {0} builds have inconsistent timestamps in &lt;a href="{2}">{1}&lt;/a>
     * 
     */
    public static Localizable _Problem_DisplayName(Object arg1, Object arg2, Object arg3) {
        return new Localizable(holder, "Problem.DisplayName", arg1, arg2, arg3);
    }

}
