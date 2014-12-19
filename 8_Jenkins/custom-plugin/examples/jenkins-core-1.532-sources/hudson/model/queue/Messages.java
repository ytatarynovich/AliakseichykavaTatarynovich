// CHECKSTYLE:OFF

package hudson.model.queue;

import org.jvnet.localizer.Localizable;
import org.jvnet.localizer.ResourceBundleHolder;

@SuppressWarnings({
    "",
    "PMD"
})
public class Messages {

    private final static ResourceBundleHolder holder = ResourceBundleHolder.get(Messages.class);

    /**
     * Installing default queue sorter
     * 
     */
    public static String QueueSorter_installDefaultQueueSorter() {
        return holder.format("QueueSorter.installDefaultQueueSorter");
    }

    /**
     * Installing default queue sorter
     * 
     */
    public static Localizable _QueueSorter_installDefaultQueueSorter() {
        return new Localizable(holder, "QueueSorter.installDefaultQueueSorter");
    }

}
