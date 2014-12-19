// CHECKSTYLE:OFF

package jenkins.management;

import org.jvnet.localizer.Localizable;
import org.jvnet.localizer.ResourceBundleHolder;

@SuppressWarnings({
    "",
    "PMD"
})
public class Messages {

    private final static ResourceBundleHolder holder = ResourceBundleHolder.get(Messages.class);

    /**
     * Displays various environmental information to assist trouble-shooting.
     * 
     */
    public static String SystemInfoLink_Description() {
        return holder.format("SystemInfoLink.Description");
    }

    /**
     * Displays various environmental information to assist trouble-shooting.
     * 
     */
    public static Localizable _SystemInfoLink_Description() {
        return new Localizable(holder, "SystemInfoLink.Description");
    }

    /**
     * Prepare for Shutdown
     * 
     */
    public static String ShutdownLink_DisplayName_prepare() {
        return holder.format("ShutdownLink.DisplayName_prepare");
    }

    /**
     * Prepare for Shutdown
     * 
     */
    public static Localizable _ShutdownLink_DisplayName_prepare() {
        return new Localizable(holder, "ShutdownLink.DisplayName_prepare");
    }

    /**
     * Script Console
     * 
     */
    public static String ConsoleLink_DisplayName() {
        return holder.format("ConsoleLink.DisplayName");
    }

    /**
     * Script Console
     * 
     */
    public static Localizable _ConsoleLink_DisplayName() {
        return new Localizable(holder, "ConsoleLink.DisplayName");
    }

    /**
     * Manage Nodes
     * 
     */
    public static String NodesLink_DisplayName() {
        return holder.format("NodesLink.DisplayName");
    }

    /**
     * Manage Nodes
     * 
     */
    public static Localizable _NodesLink_DisplayName() {
        return new Localizable(holder, "NodesLink.DisplayName");
    }

    /**
     * Add, remove, control and monitor the various nodes that Jenkins runs jobs on.
     * 
     */
    public static String NodesLink_Description() {
        return holder.format("NodesLink.Description");
    }

    /**
     * Add, remove, control and monitor the various nodes that Jenkins runs jobs on.
     * 
     */
    public static Localizable _NodesLink_Description() {
        return new Localizable(holder, "NodesLink.Description");
    }

    /**
     * System log captures output from &lt;tt>java.util.logging&lt;/tt> output related to Jenkins.
     * 
     */
    public static String SystemLogLink_Description() {
        return holder.format("SystemLogLink.Description");
    }

    /**
     * System log captures output from &lt;tt>java.util.logging&lt;/tt> output related to Jenkins.
     * 
     */
    public static Localizable _SystemLogLink_Description() {
        return new Localizable(holder, "SystemLogLink.Description");
    }

    /**
     * Jenkins CLI
     * 
     */
    public static String CliLink_DisplayName() {
        return holder.format("CliLink.DisplayName");
    }

    /**
     * Jenkins CLI
     * 
     */
    public static Localizable _CliLink_DisplayName() {
        return new Localizable(holder, "CliLink.DisplayName");
    }

    /**
     * Access/manage Jenkins from your shell, or from your script.
     * 
     */
    public static String CliLink_Description() {
        return holder.format("CliLink.Description");
    }

    /**
     * Access/manage Jenkins from your shell, or from your script.
     * 
     */
    public static Localizable _CliLink_Description() {
        return new Localizable(holder, "CliLink.Description");
    }

    /**
     * Manage Plugins
     * 
     */
    public static String PluginsLink_DisplayName() {
        return holder.format("PluginsLink.DisplayName");
    }

    /**
     * Manage Plugins
     * 
     */
    public static Localizable _PluginsLink_DisplayName() {
        return new Localizable(holder, "PluginsLink.DisplayName");
    }

    /**
     * Add, remove, disable or enable plugins that can extend the functionality of Jenkins.
     * 
     */
    public static String PluginsLink_Description() {
        return holder.format("PluginsLink.Description");
    }

    /**
     * Add, remove, disable or enable plugins that can extend the functionality of Jenkins.
     * 
     */
    public static Localizable _PluginsLink_Description() {
        return new Localizable(holder, "PluginsLink.Description");
    }

    /**
     * Executes arbitrary script for administration/trouble-shooting/diagnostics.
     * 
     */
    public static String ConsoleLink_Description() {
        return holder.format("ConsoleLink.Description");
    }

    /**
     * Executes arbitrary script for administration/trouble-shooting/diagnostics.
     * 
     */
    public static Localizable _ConsoleLink_Description() {
        return new Localizable(holder, "ConsoleLink.Description");
    }

    /**
     * Reload Configuration from Disk
     * 
     */
    public static String ReloadLink_DisplayName() {
        return holder.format("ReloadLink.DisplayName");
    }

    /**
     * Reload Configuration from Disk
     * 
     */
    public static Localizable _ReloadLink_DisplayName() {
        return new Localizable(holder, "ReloadLink.DisplayName");
    }

    /**
     * Discard all the loaded data in memory and reload everything from file system.
     * Useful when you modified config files directly on disk.
     * 
     */
    public static String ReloadLink_Description() {
        return holder.format("ReloadLink.Description");
    }

    /**
     * Discard all the loaded data in memory and reload everything from file system.
     * Useful when you modified config files directly on disk.
     * 
     */
    public static Localizable _ReloadLink_Description() {
        return new Localizable(holder, "ReloadLink.Description");
    }

    /**
     * Load Statistics
     * 
     */
    public static String StatisticsLink_DisplayName() {
        return holder.format("StatisticsLink.DisplayName");
    }

    /**
     * Load Statistics
     * 
     */
    public static Localizable _StatisticsLink_DisplayName() {
        return new Localizable(holder, "StatisticsLink.DisplayName");
    }

    /**
     * Check your resource utilization and see if you need more computers for your builds.
     * 
     */
    public static String StatisticsLink_Description() {
        return holder.format("StatisticsLink.Description");
    }

    /**
     * Check your resource utilization and see if you need more computers for your builds.
     * 
     */
    public static Localizable _StatisticsLink_Description() {
        return new Localizable(holder, "StatisticsLink.Description");
    }

    /**
     * Cancel Shutdown
     * 
     */
    public static String ShutdownLink_DisplayName_cancel() {
        return holder.format("ShutdownLink.DisplayName_cancel");
    }

    /**
     * Cancel Shutdown
     * 
     */
    public static Localizable _ShutdownLink_DisplayName_cancel() {
        return new Localizable(holder, "ShutdownLink.DisplayName_cancel");
    }

    /**
     * Configure System
     * 
     */
    public static String ConfigureLink_DisplayName() {
        return holder.format("ConfigureLink.DisplayName");
    }

    /**
     * Configure System
     * 
     */
    public static Localizable _ConfigureLink_DisplayName() {
        return new Localizable(holder, "ConfigureLink.DisplayName");
    }

    /**
     * Stops executing new builds, so that the system can be eventually shut down safely.
     * 
     */
    public static String ShutdownLink_Description() {
        return holder.format("ShutdownLink.Description");
    }

    /**
     * Stops executing new builds, so that the system can be eventually shut down safely.
     * 
     */
    public static Localizable _ShutdownLink_Description() {
        return new Localizable(holder, "ShutdownLink.Description");
    }

    /**
     * Configure global settings and paths.
     * 
     */
    public static String ConfigureLink_Description() {
        return holder.format("ConfigureLink.Description");
    }

    /**
     * Configure global settings and paths.
     * 
     */
    public static Localizable _ConfigureLink_Description() {
        return new Localizable(holder, "ConfigureLink.Description");
    }

    /**
     * System Log
     * 
     */
    public static String SystemLogLink_DisplayName() {
        return holder.format("SystemLogLink.DisplayName");
    }

    /**
     * System Log
     * 
     */
    public static Localizable _SystemLogLink_DisplayName() {
        return new Localizable(holder, "SystemLogLink.DisplayName");
    }

    /**
     * System Information
     * 
     */
    public static String SystemInfoLink_DisplayName() {
        return holder.format("SystemInfoLink.DisplayName");
    }

    /**
     * System Information
     * 
     */
    public static Localizable _SystemInfoLink_DisplayName() {
        return new Localizable(holder, "SystemInfoLink.DisplayName");
    }

}
