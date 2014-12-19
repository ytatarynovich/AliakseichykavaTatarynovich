// CHECKSTYLE:OFF

package hudson.diagnosis;

import org.jvnet.localizer.Localizable;
import org.jvnet.localizer.ResourceBundleHolder;

@SuppressWarnings({
    "",
    "PMD"
})
public class Messages {

    private final static ResourceBundleHolder holder = ResourceBundleHolder.get(Messages.class);

    /**
     * Total
     * 
     */
    public static String MemoryUsageMonitor_TOTAL() {
        return holder.format("MemoryUsageMonitor.TOTAL");
    }

    /**
     * Total
     * 
     */
    public static Localizable _MemoryUsageMonitor_TOTAL() {
        return new Localizable(holder, "MemoryUsageMonitor.TOTAL");
    }

    /**
     * Manage Old Data
     * 
     */
    public static String OldDataMonitor_DisplayName() {
        return holder.format("OldDataMonitor.DisplayName");
    }

    /**
     * Manage Old Data
     * 
     */
    public static Localizable _OldDataMonitor_DisplayName() {
        return new Localizable(holder, "OldDataMonitor.DisplayName");
    }

    /**
     * Scrub configuration files to remove remnants from old plugins and earlier versions.
     * 
     */
    public static String OldDataMonitor_Description() {
        return holder.format("OldDataMonitor.Description");
    }

    /**
     * Scrub configuration files to remove remnants from old plugins and earlier versions.
     * 
     */
    public static Localizable _OldDataMonitor_Description() {
        return new Localizable(holder, "OldDataMonitor.Description");
    }

    /**
     * Used
     * 
     */
    public static String MemoryUsageMonitor_USED() {
        return holder.format("MemoryUsageMonitor.USED");
    }

    /**
     * Used
     * 
     */
    public static Localizable _MemoryUsageMonitor_USED() {
        return new Localizable(holder, "MemoryUsageMonitor.USED");
    }

}
