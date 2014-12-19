// CHECKSTYLE:OFF

package hudson.init.impl;

import org.jvnet.localizer.Localizable;
import org.jvnet.localizer.ResourceBundleHolder;

@SuppressWarnings({
    "",
    "PMD"
})
public class Messages {

    private final static ResourceBundleHolder holder = ResourceBundleHolder.get(Messages.class);

    /**
     * Executing user-defined init script
     * 
     */
    public static String GroovyInitScript_init() {
        return holder.format("GroovyInitScript.init");
    }

    /**
     * Executing user-defined init script
     * 
     */
    public static Localizable _GroovyInitScript_init() {
        return new Localizable(holder, "GroovyInitScript.init");
    }

    /**
     * Preparing initial user content
     * 
     */
    public static String InitialUserContent_init() {
        return holder.format("InitialUserContent.init");
    }

    /**
     * Preparing initial user content
     * 
     */
    public static Localizable _InitialUserContent_init() {
        return new Localizable(holder, "InitialUserContent.init");
    }

}
