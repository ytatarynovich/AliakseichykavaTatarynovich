// CHECKSTYLE:OFF

package hudson.node_monitors;

import org.jvnet.localizer.Localizable;
import org.jvnet.localizer.ResourceBundleHolder;

@SuppressWarnings({
    "",
    "PMD"
})
public class Messages {

    private final static ResourceBundleHolder holder = ResourceBundleHolder.get(Messages.class);

    /**
     * Putting {0} back online as there is enough disk space again
     * 
     */
    public static String DiskSpaceMonitor_MarkedOnline(Object arg1) {
        return holder.format("DiskSpaceMonitor.MarkedOnline", arg1);
    }

    /**
     * Putting {0} back online as there is enough disk space again
     * 
     */
    public static Localizable _DiskSpaceMonitor_MarkedOnline(Object arg1) {
        return new Localizable(holder, "DiskSpaceMonitor.MarkedOnline", arg1);
    }

    /**
     * Time out for last {0} try
     * 
     */
    public static String ResponseTimeMonitor_TimeOut(Object arg1) {
        return holder.format("ResponseTimeMonitor.TimeOut", arg1);
    }

    /**
     * Time out for last {0} try
     * 
     */
    public static Localizable _ResponseTimeMonitor_TimeOut(Object arg1) {
        return new Localizable(holder, "ResponseTimeMonitor.TimeOut", arg1);
    }

    /**
     * Free Disk Space
     * 
     */
    public static String DiskSpaceMonitor_DisplayName() {
        return holder.format("DiskSpaceMonitor.DisplayName");
    }

    /**
     * Free Disk Space
     * 
     */
    public static Localizable _DiskSpaceMonitor_DisplayName() {
        return new Localizable(holder, "DiskSpaceMonitor.DisplayName");
    }

    /**
     * Free Swap Space
     * 
     */
    public static String SwapSpaceMonitor_DisplayName() {
        return holder.format("SwapSpaceMonitor.DisplayName");
    }

    /**
     * Free Swap Space
     * 
     */
    public static Localizable _SwapSpaceMonitor_DisplayName() {
        return new Localizable(holder, "SwapSpaceMonitor.DisplayName");
    }

    /**
     * Free Temp Space
     * 
     */
    public static String TemporarySpaceMonitor_DisplayName() {
        return holder.format("TemporarySpaceMonitor.DisplayName");
    }

    /**
     * Free Temp Space
     * 
     */
    public static Localizable _TemporarySpaceMonitor_DisplayName() {
        return new Localizable(holder, "TemporarySpaceMonitor.DisplayName");
    }

    /**
     * Architecture
     * 
     */
    public static String ArchitectureMonitor_DisplayName() {
        return holder.format("ArchitectureMonitor.DisplayName");
    }

    /**
     * Architecture
     * 
     */
    public static Localizable _ArchitectureMonitor_DisplayName() {
        return new Localizable(holder, "ArchitectureMonitor.DisplayName");
    }

    /**
     * Response Time
     * 
     */
    public static String ResponseTimeMonitor_DisplayName() {
        return holder.format("ResponseTimeMonitor.DisplayName");
    }

    /**
     * Response Time
     * 
     */
    public static Localizable _ResponseTimeMonitor_DisplayName() {
        return new Localizable(holder, "ResponseTimeMonitor.DisplayName");
    }

    /**
     * Making {0} offline because it’s not responding
     * 
     */
    public static String ResponseTimeMonitor_MarkedOffline(Object arg1) {
        return holder.format("ResponseTimeMonitor.MarkedOffline", arg1);
    }

    /**
     * Making {0} offline because it’s not responding
     * 
     */
    public static Localizable _ResponseTimeMonitor_MarkedOffline(Object arg1) {
        return new Localizable(holder, "ResponseTimeMonitor.MarkedOffline", arg1);
    }

    /**
     * Making {0} offline temporarily due to the lack of disk space
     * 
     */
    public static String DiskSpaceMonitor_MarkedOffline(Object arg1) {
        return holder.format("DiskSpaceMonitor.MarkedOffline", arg1);
    }

    /**
     * Making {0} offline temporarily due to the lack of disk space
     * 
     */
    public static Localizable _DiskSpaceMonitor_MarkedOffline(Object arg1) {
        return new Localizable(holder, "DiskSpaceMonitor.MarkedOffline", arg1);
    }

    /**
     * Not yet
     * 
     */
    public static String AbstractNodeMonitorDescriptor_NoDataYet() {
        return holder.format("AbstractNodeMonitorDescriptor.NoDataYet");
    }

    /**
     * Not yet
     * 
     */
    public static Localizable _AbstractNodeMonitorDescriptor_NoDataYet() {
        return new Localizable(holder, "AbstractNodeMonitorDescriptor.NoDataYet");
    }

    /**
     * Clock Difference
     * 
     */
    public static String ClockMonitor_DisplayName() {
        return holder.format("ClockMonitor.DisplayName");
    }

    /**
     * Clock Difference
     * 
     */
    public static Localizable _ClockMonitor_DisplayName() {
        return new Localizable(holder, "ClockMonitor.DisplayName");
    }

}
