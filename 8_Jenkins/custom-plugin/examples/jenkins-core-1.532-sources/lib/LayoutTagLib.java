
package lib;

import java.util.Map;
import groovy.lang.Closure;
import org.kohsuke.stapler.jelly.groovy.TagFile;
import org.kohsuke.stapler.jelly.groovy.TagLibraryUri;
import org.kohsuke.stapler.jelly.groovy.TypedTagLibrary;

@TagLibraryUri("/lib/layout")
public interface LayoutTagLib
    extends TypedTagLibrary
{


    /**
     * 
     *     Send escaped value to output decorated to be safely broken into lines when necessary
     *     @since 1.517
     *     
     *   
     * 
     */
    void breakable(Map args, Closure body);

    /**
     * 
     *     Send escaped value to output decorated to be safely broken into lines when necessary
     *     @since 1.517
     *     
     *   
     * 
     */
    void breakable(Closure body);

    /**
     * 
     *     Send escaped value to output decorated to be safely broken into lines when necessary
     *     @since 1.517
     *     
     *   
     * 
     */
    void breakable(Map args);

    /**
     * 
     *     Send escaped value to output decorated to be safely broken into lines when necessary
     *     @since 1.517
     *     
     *   
     * 
     */
    void breakable();

    /**
     * 
     *     
     *     
     *     
     *   
     * 
     */
    void renderOnDemand(Map args, Closure body);

    /**
     * 
     *     
     *     
     *     
     *   
     * 
     */
    void renderOnDemand(Closure body);

    /**
     * 
     *     
     *     
     *     
     *   
     * 
     */
    void renderOnDemand(Map args);

    /**
     * 
     *     
     *     
     *     
     *   
     * 
     */
    void renderOnDemand();

    /**
     * 
     *     Header portion of the HTML page, that gets rendered into the &lt;head> tag.
     *     Multiple &lt;l:header> elements can be specified, and can even come after
     *     &lt;l:main-panel>.
     * 
     *     This tag can be placed inside &lt;l:layout>.
     *   
     * 
     */
    void header(Map args, Closure body);

    /**
     * 
     *     Header portion of the HTML page, that gets rendered into the &lt;head> tag.
     *     Multiple &lt;l:header> elements can be specified, and can even come after
     *     &lt;l:main-panel>.
     * 
     *     This tag can be placed inside &lt;l:layout>.
     *   
     * 
     */
    void header(Closure body);

    /**
     * 
     *     Header portion of the HTML page, that gets rendered into the &lt;head> tag.
     *     Multiple &lt;l:header> elements can be specified, and can even come after
     *     &lt;l:main-panel>.
     * 
     *     This tag can be placed inside &lt;l:layout>.
     *   
     * 
     */
    void header(Map args);

    /**
     * 
     *     Header portion of the HTML page, that gets rendered into the &lt;head> tag.
     *     Multiple &lt;l:header> elements can be specified, and can even come after
     *     &lt;l:main-panel>.
     * 
     *     This tag can be placed inside &lt;l:layout>.
     *   
     * 
     */
    void header();

    /**
     * 
     *         
     *         
     *         
     *     
     * 
     */
    void progressiveRendering(Map args, Closure body);

    /**
     * 
     *         
     *         
     *         
     *     
     * 
     */
    void progressiveRendering(Closure body);

    /**
     * 
     *         
     *         
     *         
     *     
     * 
     */
    void progressiveRendering(Map args);

    /**
     * 
     *         
     *         
     *         
     *     
     * 
     */
    void progressiveRendering();

    /**
     * 
     *         Produces a hyperlink which when clicked first asks for confirmation, then goes to that URL if confirmed.
     *         The body is displayed as the link text.
     *         @since 1.512
     *         
     *         
     *         
     *     
     * 
     */
    void confirmationLink(Map args, Closure body);

    /**
     * 
     *         Produces a hyperlink which when clicked first asks for confirmation, then goes to that URL if confirmed.
     *         The body is displayed as the link text.
     *         @since 1.512
     *         
     *         
     *         
     *     
     * 
     */
    void confirmationLink(Closure body);

    /**
     * 
     *         Produces a hyperlink which when clicked first asks for confirmation, then goes to that URL if confirmed.
     *         The body is displayed as the link text.
     *         @since 1.512
     *         
     *         
     *         
     *     
     * 
     */
    void confirmationLink(Map args);

    /**
     * 
     *         Produces a hyperlink which when clicked first asks for confirmation, then goes to that URL if confirmed.
     *         The body is displayed as the link text.
     *         @since 1.512
     *         
     *         
     *         
     *     
     * 
     */
    void confirmationLink();

    /**
     * 
     *     Generates the body as the main content part of a Jenkins page.
     *   
     * 
     */
    @TagFile("main-panel")
    void main_panel(Map args, Closure body);

    /**
     * 
     *     Generates the body as the main content part of a Jenkins page.
     *   
     * 
     */
    @TagFile("main-panel")
    void main_panel(Closure body);

    /**
     * 
     *     Generates the body as the main content part of a Jenkins page.
     *   
     * 
     */
    @TagFile("main-panel")
    void main_panel(Map args);

    /**
     * 
     *     Generates the body as the main content part of a Jenkins page.
     *   
     * 
     */
    @TagFile("main-panel")
    void main_panel();

    /**
     * 
     *         Creates a clickable “Stop” button.
     *         
     *         
     *     
     * 
     */
    void stopButton(Map args, Closure body);

    /**
     * 
     *         Creates a clickable “Stop” button.
     *         
     *         
     *     
     * 
     */
    void stopButton(Closure body);

    /**
     * 
     *         Creates a clickable “Stop” button.
     *         
     *         
     *     
     * 
     */
    void stopButton(Map args);

    /**
     * 
     *         Creates a clickable “Stop” button.
     *         
     *         
     *     
     * 
     */
    void stopButton();

    /**
     * 
     */
    @TagFile("side-panel")
    void side_panel(Map args, Closure body);

    /**
     * 
     */
    @TagFile("side-panel")
    void side_panel(Closure body);

    /**
     * 
     */
    @TagFile("side-panel")
    void side_panel(Map args);

    /**
     * 
     */
    @TagFile("side-panel")
    void side_panel();

    /**
     * 
     *     Generates the bar that shows breadcrumbs, along with its associated dynamic behaviours.
     *     This tag is used by l:layout and not expected to be used by anyone else,
     *     but it's written as separate tag for better readability of code.
     * 
     *     To render additional breadcrumb items (for example to provide in-page navigations),
     *     use the &lt;l:breadcrumb> tag.
     *   
     * 
     */
    void breadcrumbBar(Map args, Closure body);

    /**
     * 
     *     Generates the bar that shows breadcrumbs, along with its associated dynamic behaviours.
     *     This tag is used by l:layout and not expected to be used by anyone else,
     *     but it's written as separate tag for better readability of code.
     * 
     *     To render additional breadcrumb items (for example to provide in-page navigations),
     *     use the &lt;l:breadcrumb> tag.
     *   
     * 
     */
    void breadcrumbBar(Closure body);

    /**
     * 
     *     Generates the bar that shows breadcrumbs, along with its associated dynamic behaviours.
     *     This tag is used by l:layout and not expected to be used by anyone else,
     *     but it's written as separate tag for better readability of code.
     * 
     *     To render additional breadcrumb items (for example to provide in-page navigations),
     *     use the &lt;l:breadcrumb> tag.
     *   
     * 
     */
    void breadcrumbBar(Map args);

    /**
     * 
     *     Generates the bar that shows breadcrumbs, along with its associated dynamic behaviours.
     *     This tag is used by l:layout and not expected to be used by anyone else,
     *     but it's written as separate tag for better readability of code.
     * 
     *     To render additional breadcrumb items (for example to provide in-page navigations),
     *     use the &lt;l:breadcrumb> tag.
     *   
     * 
     */
    void breadcrumbBar();

    /**
     * 
     */
    void expandButton(Map args, Closure body);

    /**
     * 
     */
    void expandButton(Closure body);

    /**
     * 
     */
    void expandButton(Map args);

    /**
     * 
     */
    void expandButton();

    /**
     * Deprecated, do not use.
     * 
     */
    void isAdminOrTest(Map args, Closure body);

    /**
     * Deprecated, do not use.
     * 
     */
    void isAdminOrTest(Closure body);

    /**
     * Deprecated, do not use.
     * 
     */
    void isAdminOrTest(Map args);

    /**
     * Deprecated, do not use.
     * 
     */
    void isAdminOrTest();

    /**
     * 
     *     Creates a small button that lets the user copies a text into clipboard
     * 
     *     
     *     
     *     
     *     
     *   
     * 
     */
    void copyButton(Map args, Closure body);

    /**
     * 
     *     Creates a small button that lets the user copies a text into clipboard
     * 
     *     
     *     
     *     
     *     
     *   
     * 
     */
    void copyButton(Closure body);

    /**
     * 
     *     Creates a small button that lets the user copies a text into clipboard
     * 
     *     
     *     
     *     
     *     
     *   
     * 
     */
    void copyButton(Map args);

    /**
     * 
     *     Creates a small button that lets the user copies a text into clipboard
     * 
     *     
     *     
     *     
     *     
     *   
     * 
     */
    void copyButton();

    /**
     * 
     */
    void ajax(Map args, Closure body);

    /**
     * 
     */
    void ajax(Closure body);

    /**
     * 
     */
    void ajax(Map args);

    /**
     * 
     */
    void ajax();

    /**
     * 
     *     Used in the &lt;l:side-panel> to draw a box with a title.
     * 
     *     The box is drawn as a table, and the body of this tag
     *     is expected to draw a series of &lt;TR>s to fill in the contents
     *     of the box.
     *     
     *     
     *     
     *     
     *   
     * 
     */
    void pane(Map args, Closure body);

    /**
     * 
     *     Used in the &lt;l:side-panel> to draw a box with a title.
     * 
     *     The box is drawn as a table, and the body of this tag
     *     is expected to draw a series of &lt;TR>s to fill in the contents
     *     of the box.
     *     
     *     
     *     
     *     
     *   
     * 
     */
    void pane(Closure body);

    /**
     * 
     *     Used in the &lt;l:side-panel> to draw a box with a title.
     * 
     *     The box is drawn as a table, and the body of this tag
     *     is expected to draw a series of &lt;TR>s to fill in the contents
     *     of the box.
     *     
     *     
     *     
     *     
     *   
     * 
     */
    void pane(Map args);

    /**
     * 
     *     Used in the &lt;l:side-panel> to draw a box with a title.
     * 
     *     The box is drawn as a table, and the body of this tag
     *     is expected to draw a series of &lt;TR>s to fill in the contents
     *     of the box.
     *     
     *     
     *     
     *     
     *   
     * 
     */
    void pane();

    /**
     * 
     */
    void tasks(Map args, Closure body);

    /**
     * 
     */
    void tasks(Closure body);

    /**
     * 
     */
    void tasks(Map args);

    /**
     * 
     */
    void tasks();

    /**
     * 
     *     Outer-most tag for a normal (non-AJAX) HTML rendering.
     *     This is used with nested &lt;header>, &lt;side-panel>, and &lt;main-panel>
     *     to form Jenkins's basic HTML layout.
     * 
     *     
     *     
     *     
     *     
     *   
     * 
     */
    void layout(Map args, Closure body);

    /**
     * 
     *     Outer-most tag for a normal (non-AJAX) HTML rendering.
     *     This is used with nested &lt;header>, &lt;side-panel>, and &lt;main-panel>
     *     to form Jenkins's basic HTML layout.
     * 
     *     
     *     
     *     
     *     
     *   
     * 
     */
    void layout(Closure body);

    /**
     * 
     *     Outer-most tag for a normal (non-AJAX) HTML rendering.
     *     This is used with nested &lt;header>, &lt;side-panel>, and &lt;main-panel>
     *     to form Jenkins's basic HTML layout.
     * 
     *     
     *     
     *     
     *     
     *   
     * 
     */
    void layout(Map args);

    /**
     * 
     *     Outer-most tag for a normal (non-AJAX) HTML rendering.
     *     This is used with nested &lt;header>, &lt;side-panel>, and &lt;main-panel>
     *     to form Jenkins's basic HTML layout.
     * 
     *     
     *     
     *     
     *     
     *   
     * 
     */
    void layout();

    /**
     * 
     */
    void tabBar(Map args, Closure body);

    /**
     * 
     */
    void tabBar(Closure body);

    /**
     * 
     */
    void tabBar(Map args);

    /**
     * 
     */
    void tabBar();

    /**
     * 
     *     Renders the body only if the current user has the specified permission
     *     
     *   
     * 
     */
    void hasPermission(Map args, Closure body);

    /**
     * 
     *     Renders the body only if the current user has the specified permission
     *     
     *   
     * 
     */
    void hasPermission(Closure body);

    /**
     * 
     *     Renders the body only if the current user has the specified permission
     *     
     *   
     * 
     */
    void hasPermission(Map args);

    /**
     * 
     *     Renders the body only if the current user has the specified permission
     *     
     *   
     * 
     */
    void hasPermission();

    /**
     * 
     */
    void tab(Map args, Closure body);

    /**
     * 
     */
    void tab(Closure body);

    /**
     * 
     */
    void tab(Map args);

    /**
     * 
     */
    void tab();

    /**
     * 
     *     Used inside &lt;l:layout> to render additional breadcrumb items.
     * 
     *     
     *     
     *     
     *   
     * 
     */
    void breadcrumb(Map args, Closure body);

    /**
     * 
     *     Used inside &lt;l:layout> to render additional breadcrumb items.
     * 
     *     
     *     
     *     
     *   
     * 
     */
    void breadcrumb(Closure body);

    /**
     * 
     *     Used inside &lt;l:layout> to render additional breadcrumb items.
     * 
     *     
     *     
     *     
     *   
     * 
     */
    void breadcrumb(Map args);

    /**
     * 
     *     Used inside &lt;l:layout> to render additional breadcrumb items.
     * 
     *     
     *     
     *     
     *   
     * 
     */
    void breadcrumb();

    /**
     * 
     *     Load Yahoo UI module.
     *     
     *   
     * 
     */
    void yui(Map args, Closure body);

    /**
     * 
     *     Load Yahoo UI module.
     *     
     *   
     * 
     */
    void yui(Closure body);

    /**
     * 
     *     Load Yahoo UI module.
     *     
     *   
     * 
     */
    void yui(Map args);

    /**
     * 
     *     Load Yahoo UI module.
     *     
     *   
     * 
     */
    void yui();

    /**
     * 
     */
    void isAdmin(Map args, Closure body);

    /**
     * 
     */
    void isAdmin(Closure body);

    /**
     * 
     */
    void isAdmin(Map args);

    /**
     * 
     */
    void isAdmin();

    /**
     * 
     *     Creates a space for the right-hand side of the page.
     *     This sticks to the right of the page even when the content overflows.
     *   
     * 
     */
    void rightspace(Map args, Closure body);

    /**
     * 
     *     Creates a space for the right-hand side of the page.
     *     This sticks to the right of the page even when the content overflows.
     *   
     * 
     */
    void rightspace(Closure body);

    /**
     * 
     *     Creates a space for the right-hand side of the page.
     *     This sticks to the right of the page even when the content overflows.
     *   
     * 
     */
    void rightspace(Map args);

    /**
     * 
     *     Creates a space for the right-hand side of the page.
     *     This sticks to the right of the page even when the content overflows.
     *   
     * 
     */
    void rightspace();

    /**
     * 
     *     This tag inside &lt;l:tasks> tag renders the left navigation bar of Hudson.
     *     Each &lt;task> tag gets an icon and link.
     * 
     *     
     *     
     *     
     *     
     *     
     *     
     *     
     *     
     *     
     *   
     * 
     */
    void task(Map args, Closure body);

    /**
     * 
     *     This tag inside &lt;l:tasks> tag renders the left navigation bar of Hudson.
     *     Each &lt;task> tag gets an icon and link.
     * 
     *     
     *     
     *     
     *     
     *     
     *     
     *     
     *     
     *     
     *   
     * 
     */
    void task(Closure body);

    /**
     * 
     *     This tag inside &lt;l:tasks> tag renders the left navigation bar of Hudson.
     *     Each &lt;task> tag gets an icon and link.
     * 
     *     
     *     
     *     
     *     
     *     
     *     
     *     
     *     
     *     
     *   
     * 
     */
    void task(Map args);

    /**
     * 
     *     This tag inside &lt;l:tasks> tag renders the left navigation bar of Hudson.
     *     Each &lt;task> tag gets an icon and link.
     * 
     *     
     *     
     *     
     *     
     *     
     *     
     *     
     *     
     *     
     *   
     * 
     */
    void task();

}
