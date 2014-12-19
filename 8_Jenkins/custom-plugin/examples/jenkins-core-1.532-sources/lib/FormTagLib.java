
package lib;

import java.util.Map;
import groovy.lang.Closure;
import org.kohsuke.stapler.jelly.groovy.TagFile;
import org.kohsuke.stapler.jelly.groovy.TagLibraryUri;
import org.kohsuke.stapler.jelly.groovy.TypedTagLibrary;

@TagLibraryUri("/lib/form")
public interface FormTagLib
    extends TypedTagLibrary
{


    /**
     * 
     *     Glorified &lt;select> control that supports the data binding and AJAX updates.
     *     Your descriptor should have the 'doFillXyzItems' method, which returns a ListBoxModel
     *     representation of the items in your drop-down list box, and your instance field should
     *     hold the current value.
     * 
     *     
     *     
     *     
     *   
     * 
     */
    void select(Map args, Closure body);

    /**
     * 
     *     Glorified &lt;select> control that supports the data binding and AJAX updates.
     *     Your descriptor should have the 'doFillXyzItems' method, which returns a ListBoxModel
     *     representation of the items in your drop-down list box, and your instance field should
     *     hold the current value.
     * 
     *     
     *     
     *     
     *   
     * 
     */
    void select(Closure body);

    /**
     * 
     *     Glorified &lt;select> control that supports the data binding and AJAX updates.
     *     Your descriptor should have the 'doFillXyzItems' method, which returns a ListBoxModel
     *     representation of the items in your drop-down list box, and your instance field should
     *     hold the current value.
     * 
     *     
     *     
     *     
     *   
     * 
     */
    void select(Map args);

    /**
     * 
     *     Glorified &lt;select> control that supports the data binding and AJAX updates.
     *     Your descriptor should have the 'doFillXyzItems' method, which returns a ListBoxModel
     *     representation of the items in your drop-down list box, and your instance field should
     *     hold the current value.
     * 
     *     
     *     
     *     
     *   
     * 
     */
    void select();

    /**
     * 
     *     Foldable block expanded when the corresponding item is selected in the drop-down list.
     * 
     *     
     *     
     *     
     *   
     * 
     */
    void dropdownList(Map args, Closure body);

    /**
     * 
     *     Foldable block expanded when the corresponding item is selected in the drop-down list.
     * 
     *     
     *     
     *     
     *   
     * 
     */
    void dropdownList(Closure body);

    /**
     * 
     *     Foldable block expanded when the corresponding item is selected in the drop-down list.
     * 
     *     
     *     
     *     
     *   
     * 
     */
    void dropdownList(Map args);

    /**
     * 
     *     Foldable block expanded when the corresponding item is selected in the drop-down list.
     * 
     *     
     *     
     *     
     *   
     * 
     */
    void dropdownList();

    /**
     * 
     *     Generate config pages from a list of Descriptors into a section.
     * 
     *     
     *     
     *     
     *     
     *     
     *   
     * 
     */
    void descriptorRadioList(Map args, Closure body);

    /**
     * 
     *     Generate config pages from a list of Descriptors into a section.
     * 
     *     
     *     
     *     
     *     
     *     
     *   
     * 
     */
    void descriptorRadioList(Closure body);

    /**
     * 
     *     Generate config pages from a list of Descriptors into a section.
     * 
     *     
     *     
     *     
     *     
     *     
     *   
     * 
     */
    void descriptorRadioList(Map args);

    /**
     * 
     *     Generate config pages from a list of Descriptors into a section.
     * 
     *     
     *     
     *     
     *     
     *     
     *   
     * 
     */
    void descriptorRadioList();

    /**
     * 
     *     Modifies the 'attrs.field' of the parent to inherit @field from the enclosing &lt;f:entry>
     *     if available. Also computes the @checkUrl attribute.
     *   
     * 
     */
    void prepareDatabinding(Map args, Closure body);

    /**
     * 
     *     Modifies the 'attrs.field' of the parent to inherit @field from the enclosing &lt;f:entry>
     *     if available. Also computes the @checkUrl attribute.
     *   
     * 
     */
    void prepareDatabinding(Closure body);

    /**
     * 
     *     Modifies the 'attrs.field' of the parent to inherit @field from the enclosing &lt;f:entry>
     *     if available. Also computes the @checkUrl attribute.
     *   
     * 
     */
    void prepareDatabinding(Map args);

    /**
     * 
     *     Modifies the 'attrs.field' of the parent to inherit @field from the enclosing &lt;f:entry>
     *     if available. Also computes the @checkUrl attribute.
     *   
     * 
     */
    void prepareDatabinding();

    /**
     * 
     *     Expandable section that shows "advanced..." button by default.
     *     Upon clicking it, a section unfolds, and the HTML rendered by the body of this tag
     *     appears.
     * 
     *     
     *     
     *     
     *   
     * 
     */
    void advanced(Map args, Closure body);

    /**
     * 
     *     Expandable section that shows "advanced..." button by default.
     *     Upon clicking it, a section unfolds, and the HTML rendered by the body of this tag
     *     appears.
     * 
     *     
     *     
     *     
     *   
     * 
     */
    void advanced(Closure body);

    /**
     * 
     *     Expandable section that shows "advanced..." button by default.
     *     Upon clicking it, a section unfolds, and the HTML rendered by the body of this tag
     *     appears.
     * 
     *     
     *     
     *     
     *   
     * 
     */
    void advanced(Map args);

    /**
     * 
     *     Expandable section that shows "advanced..." button by default.
     *     Upon clicking it, a section unfolds, and the HTML rendered by the body of this tag
     *     appears.
     * 
     *     
     *     
     *     
     *   
     * 
     */
    void advanced();

    /**
     * 
     *     listbox for choosing the slave's usage.
     * 
     *     
     *     
     *   
     * 
     */
    @TagFile("slave-mode")
    void slave_mode(Map args, Closure body);

    /**
     * 
     *     listbox for choosing the slave's usage.
     * 
     *     
     *     
     *   
     * 
     */
    @TagFile("slave-mode")
    void slave_mode(Closure body);

    /**
     * 
     *     listbox for choosing the slave's usage.
     * 
     *     
     *     
     *   
     * 
     */
    @TagFile("slave-mode")
    void slave_mode(Map args);

    /**
     * 
     *     listbox for choosing the slave's usage.
     * 
     *     
     *     
     *   
     * 
     */
    @TagFile("slave-mode")
    void slave_mode();

    /**
     * 
     *     Sibling of hetero-list, which only allows the user to pick one type from the list of descriptors and configure it.
     * 
     *     
     *     
     *   
     * 
     */
    @TagFile("hetero-radio")
    void hetero_radio(Map args, Closure body);

    /**
     * 
     *     Sibling of hetero-list, which only allows the user to pick one type from the list of descriptors and configure it.
     * 
     *     
     *     
     *   
     * 
     */
    @TagFile("hetero-radio")
    void hetero_radio(Closure body);

    /**
     * 
     *     Sibling of hetero-list, which only allows the user to pick one type from the list of descriptors and configure it.
     * 
     *     
     *     
     *   
     * 
     */
    @TagFile("hetero-radio")
    void hetero_radio(Map args);

    /**
     * 
     *     Sibling of hetero-list, which only allows the user to pick one type from the list of descriptors and configure it.
     * 
     *     
     *     
     *   
     * 
     */
    @TagFile("hetero-radio")
    void hetero_radio();

    /**
     * 
     *     Generates an input field  to be
     *     used inside &lt;f:entry/>
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
    void number(Map args, Closure body);

    /**
     * 
     *     Generates an input field  to be
     *     used inside &lt;f:entry/>
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
    void number(Closure body);

    /**
     * 
     *     Generates an input field  to be
     *     used inside &lt;f:entry/>
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
    void number(Map args);

    /**
     * 
     *     Generates an input field  to be
     *     used inside &lt;f:entry/>
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
    void number();

    /**
     * 
     *     Renders inline an optional single-value nested data-bound property of the current instance,
     *     by using a &lt;f:optionalBlock>
     * 
     *     This is useful when your object composes another data-bound object, and when that's optional,
     *     where the absence of the value is signified as null (in which case the optionalBlock will be drawn unchecked),
     *     and the presence of the value.
     *     
     *     
     *   
     * 
     */
    void optionalProperty(Map args, Closure body);

    /**
     * 
     *     Renders inline an optional single-value nested data-bound property of the current instance,
     *     by using a &lt;f:optionalBlock>
     * 
     *     This is useful when your object composes another data-bound object, and when that's optional,
     *     where the absence of the value is signified as null (in which case the optionalBlock will be drawn unchecked),
     *     and the presence of the value.
     *     
     *     
     *   
     * 
     */
    void optionalProperty(Closure body);

    /**
     * 
     *     Renders inline an optional single-value nested data-bound property of the current instance,
     *     by using a &lt;f:optionalBlock>
     * 
     *     This is useful when your object composes another data-bound object, and when that's optional,
     *     where the absence of the value is signified as null (in which case the optionalBlock will be drawn unchecked),
     *     and the presence of the value.
     *     
     *     
     *   
     * 
     */
    void optionalProperty(Map args);

    /**
     * 
     *     Renders inline an optional single-value nested data-bound property of the current instance,
     *     by using a &lt;f:optionalBlock>
     * 
     *     This is useful when your object composes another data-bound object, and when that's optional,
     *     where the absence of the value is signified as null (in which case the optionalBlock will be drawn unchecked),
     *     and the presence of the value.
     *     
     *     
     *   
     * 
     */
    void optionalProperty();

    /**
     * 
     *     Full-width space in the form table that can be filled with arbitrary HTML.
     *   
     * 
     */
    void block(Map args, Closure body);

    /**
     * 
     *     Full-width space in the form table that can be filled with arbitrary HTML.
     *   
     * 
     */
    void block(Closure body);

    /**
     * 
     *     Full-width space in the form table that can be filled with arbitrary HTML.
     *   
     * 
     */
    void block(Map args);

    /**
     * 
     *     Full-width space in the form table that can be filled with arbitrary HTML.
     *   
     * 
     */
    void block();

    /**
     * 
     *     Editable drop-down combo box that supports the data binding and AJAX updates.
     *     Your descriptor should have the 'doFillXyzItems' method, which returns a ComboBoxModel
     *     representation of the items in your combo box, and your instance field should
     *     hold the current value.
     * 
     *     
     *     
     *   
     * 
     */
    void combobox(Map args, Closure body);

    /**
     * 
     *     Editable drop-down combo box that supports the data binding and AJAX updates.
     *     Your descriptor should have the 'doFillXyzItems' method, which returns a ComboBoxModel
     *     representation of the items in your combo box, and your instance field should
     *     hold the current value.
     * 
     *     
     *     
     *   
     * 
     */
    void combobox(Closure body);

    /**
     * 
     *     Editable drop-down combo box that supports the data binding and AJAX updates.
     *     Your descriptor should have the 'doFillXyzItems' method, which returns a ComboBoxModel
     *     representation of the items in your combo box, and your instance field should
     *     hold the current value.
     * 
     *     
     *     
     *   
     * 
     */
    void combobox(Map args);

    /**
     * 
     *     Editable drop-down combo box that supports the data binding and AJAX updates.
     *     Your descriptor should have the 'doFillXyzItems' method, which returns a ComboBoxModel
     *     representation of the items in your combo box, and your instance field should
     *     hold the current value.
     * 
     *     
     *     
     *   
     * 
     */
    void combobox();

    /**
     * 
     *     Used inside &lt;f:editableComboBox/> to specify one value of a combobox.
     *     Normally one would use multiple values.
     *     
     *   
     * 
     */
    void editableComboBoxValue(Map args, Closure body);

    /**
     * 
     *     Used inside &lt;f:editableComboBox/> to specify one value of a combobox.
     *     Normally one would use multiple values.
     *     
     *   
     * 
     */
    void editableComboBoxValue(Closure body);

    /**
     * 
     *     Used inside &lt;f:editableComboBox/> to specify one value of a combobox.
     *     Normally one would use multiple values.
     *     
     *   
     * 
     */
    void editableComboBoxValue(Map args);

    /**
     * 
     *     Used inside &lt;f:editableComboBox/> to specify one value of a combobox.
     *     Normally one would use multiple values.
     *     
     *   
     * 
     */
    void editableComboBoxValue();

    /**
     * 
     *     &lt;textarea> tag on steroids.
     *     The textarea will be rendered to fit the content. It also gets the resize handle.
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
    void textarea(Map args, Closure body);

    /**
     * 
     *     &lt;textarea> tag on steroids.
     *     The textarea will be rendered to fit the content. It also gets the resize handle.
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
    void textarea(Closure body);

    /**
     * 
     *     &lt;textarea> tag on steroids.
     *     The textarea will be rendered to fit the content. It also gets the resize handle.
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
    void textarea(Map args);

    /**
     * 
     *     &lt;textarea> tag on steroids.
     *     The textarea will be rendered to fit the content. It also gets the resize handle.
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
    void textarea();

    /**
     * 
     *     Delete button for the &lt;repeatable> tag.
     * 
     *     
     *   
     * 
     */
    void repeatableDeleteButton(Map args, Closure body);

    /**
     * 
     *     Delete button for the &lt;repeatable> tag.
     * 
     *     
     *   
     * 
     */
    void repeatableDeleteButton(Closure body);

    /**
     * 
     *     Delete button for the &lt;repeatable> tag.
     * 
     *     
     *   
     * 
     */
    void repeatableDeleteButton(Map args);

    /**
     * 
     *     Delete button for the &lt;repeatable> tag.
     * 
     *     
     *   
     * 
     */
    void repeatableDeleteButton();

    /**
     * 
     *     Generates an input field  to be
     *     used inside &lt;f:entry/>
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
     * 
     */
    void textbox(Map args, Closure body);

    /**
     * 
     *     Generates an input field  to be
     *     used inside &lt;f:entry/>
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
     * 
     */
    void textbox(Closure body);

    /**
     * 
     *     Generates an input field  to be
     *     used inside &lt;f:entry/>
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
     * 
     */
    void textbox(Map args);

    /**
     * 
     *     Generates an input field  to be
     *     used inside &lt;f:entry/>
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
     * 
     */
    void textbox();

    /**
     * 
     *     Renders a single &lt;select> control for choosing a Describable.
     *     Depending on the currently selected value, its config.jelly will be
     *     rendered below &lt;select, allowing the user to configure Describable.
     * 
     *     
     *     
     *     
     *     
     *   
     * 
     */
    void dropdownDescriptorSelector(Map args, Closure body);

    /**
     * 
     *     Renders a single &lt;select> control for choosing a Describable.
     *     Depending on the currently selected value, its config.jelly will be
     *     rendered below &lt;select, allowing the user to configure Describable.
     * 
     *     
     *     
     *     
     *     
     *   
     * 
     */
    void dropdownDescriptorSelector(Closure body);

    /**
     * 
     *     Renders a single &lt;select> control for choosing a Describable.
     *     Depending on the currently selected value, its config.jelly will be
     *     rendered below &lt;select, allowing the user to configure Describable.
     * 
     *     
     *     
     *     
     *     
     *   
     * 
     */
    void dropdownDescriptorSelector(Map args);

    /**
     * 
     *     Renders a single &lt;select> control for choosing a Describable.
     *     Depending on the currently selected value, its config.jelly will be
     *     rendered below &lt;select, allowing the user to configure Describable.
     * 
     *     
     *     
     *     
     *     
     *   
     * 
     */
    void dropdownDescriptorSelector();

    /**
     * 
     *     Renders a row that shows description text below an input field.
     *   
     * 
     */
    void description(Map args, Closure body);

    /**
     * 
     *     Renders a row that shows description text below an input field.
     *   
     * 
     */
    void description(Closure body);

    /**
     * 
     *     Renders a row that shows description text below an input field.
     *   
     * 
     */
    void description(Map args);

    /**
     * 
     *     Renders a row that shows description text below an input field.
     *   
     * 
     */
    void description();

    /**
     * 
     *     Adds one more in-page breadcrumb that jumps to sections in the page.
     *     Put this tag right before &lt;l:main-panel>
     *   
     * 
     */
    @TagFile("breadcrumb-config-outline")
    void breadcrumb_config_outline(Map args, Closure body);

    /**
     * 
     *     Adds one more in-page breadcrumb that jumps to sections in the page.
     *     Put this tag right before &lt;l:main-panel>
     *   
     * 
     */
    @TagFile("breadcrumb-config-outline")
    void breadcrumb_config_outline(Closure body);

    /**
     * 
     *     Adds one more in-page breadcrumb that jumps to sections in the page.
     *     Put this tag right before &lt;l:main-panel>
     *   
     * 
     */
    @TagFile("breadcrumb-config-outline")
    void breadcrumb_config_outline(Map args);

    /**
     * 
     *     Adds one more in-page breadcrumb that jumps to sections in the page.
     *     Put this tag right before &lt;l:main-panel>
     *   
     * 
     */
    @TagFile("breadcrumb-config-outline")
    void breadcrumb_config_outline();

    /**
     * 
     *     Execute the body with a temporary currentDescriptorByNameUrl value
     * 
     *     
     *   
     * 
     */
    void withCustomDescriptorByName(Map args, Closure body);

    /**
     * 
     *     Execute the body with a temporary currentDescriptorByNameUrl value
     * 
     *     
     *   
     * 
     */
    void withCustomDescriptorByName(Closure body);

    /**
     * 
     *     Execute the body with a temporary currentDescriptorByNameUrl value
     * 
     *     
     *   
     * 
     */
    void withCustomDescriptorByName(Map args);

    /**
     * 
     *     Execute the body with a temporary currentDescriptorByNameUrl value
     * 
     *     
     *   
     * 
     */
    void withCustomDescriptorByName();

    /**
     * 
     *     Generate config pages from a list of Descriptors into a section.
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
    void descriptorList(Map args, Closure body);

    /**
     * 
     *     Generate config pages from a list of Descriptors into a section.
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
    void descriptorList(Closure body);

    /**
     * 
     *     Generate config pages from a list of Descriptors into a section.
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
    void descriptorList(Map args);

    /**
     * 
     *     Generate config pages from a list of Descriptors into a section.
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
    void descriptorList();

    /**
     * 
     *     Glorified &lt;input type="password">
     * 
     *     
     *     
     *     
     *     
     *     
     *   
     * 
     */
    void password(Map args, Closure body);

    /**
     * 
     *     Glorified &lt;input type="password">
     * 
     *     
     *     
     *     
     *     
     *     
     *   
     * 
     */
    void password(Closure body);

    /**
     * 
     *     Glorified &lt;input type="password">
     * 
     *     
     *     
     *     
     *     
     *     
     *   
     * 
     */
    void password(Map args);

    /**
     * 
     *     Glorified &lt;input type="password">
     * 
     *     
     *     
     *     
     *     
     *     
     *   
     * 
     */
    void password();

    /**
     * 
     *     Generates an input field  to be
     *     used inside &lt;f:entry/>
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
    void readOnlyTextbox(Map args, Closure body);

    /**
     * 
     *     Generates an input field  to be
     *     used inside &lt;f:entry/>
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
    void readOnlyTextbox(Closure body);

    /**
     * 
     *     Generates an input field  to be
     *     used inside &lt;f:entry/>
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
    void readOnlyTextbox(Map args);

    /**
     * 
     *     Generates an input field  to be
     *     used inside &lt;f:entry/>
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
    void readOnlyTextbox();

    /**
     * 
     *     &lt;input type="checkbox"> tag that takes true/false for @checked, which is more Jelly friendly.
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
     *     
     *   
     * 
     */
    void checkbox(Map args, Closure body);

    /**
     * 
     *     &lt;input type="checkbox"> tag that takes true/false for @checked, which is more Jelly friendly.
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
     *     
     *   
     * 
     */
    void checkbox(Closure body);

    /**
     * 
     *     &lt;input type="checkbox"> tag that takes true/false for @checked, which is more Jelly friendly.
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
     *     
     *   
     * 
     */
    void checkbox(Map args);

    /**
     * 
     *     &lt;input type="checkbox"> tag that takes true/false for @checked, which is more Jelly friendly.
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
     *     
     *   
     * 
     */
    void checkbox();

    /**
     * 
     *     An entry of the &lt;f:form>, which is one logical row (that consists of
     *     several &lt;TR> tags.
     * 
     *     One entry normally host one control.
     * 
     *     
     *     
     *     
     *     
     *   
     * 
     */
    void entry(Map args, Closure body);

    /**
     * 
     *     An entry of the &lt;f:form>, which is one logical row (that consists of
     *     several &lt;TR> tags.
     * 
     *     One entry normally host one control.
     * 
     *     
     *     
     *     
     *     
     *   
     * 
     */
    void entry(Closure body);

    /**
     * 
     *     An entry of the &lt;f:form>, which is one logical row (that consists of
     *     several &lt;TR> tags.
     * 
     *     One entry normally host one control.
     * 
     *     
     *     
     *     
     *     
     *   
     * 
     */
    void entry(Map args);

    /**
     * 
     *     An entry of the &lt;f:form>, which is one logical row (that consists of
     *     several &lt;TR> tags.
     * 
     *     One entry normally host one control.
     * 
     *     
     *     
     *     
     *     
     *   
     * 
     */
    void entry();

    /**
     * 
     *     Invisible &lt;f:entry> type. Useful for adding hidden field values.
     *   
     * 
     */
    void invisibleEntry(Map args, Closure body);

    /**
     * 
     *     Invisible &lt;f:entry> type. Useful for adding hidden field values.
     *   
     * 
     */
    void invisibleEntry(Closure body);

    /**
     * 
     *     Invisible &lt;f:entry> type. Useful for adding hidden field values.
     *   
     * 
     */
    void invisibleEntry(Map args);

    /**
     * 
     *     Invisible &lt;f:entry> type. Useful for adding hidden field values.
     *   
     * 
     */
    void invisibleEntry();

    /**
     * 
     *     Foldable block expanded when the corresponding item is selected in the drop-down list.
     * 
     *     
     *     
     *     
     *     
     *     
     *   
     * 
     */
    void dropdownListBlock(Map args, Closure body);

    /**
     * 
     *     Foldable block expanded when the corresponding item is selected in the drop-down list.
     * 
     *     
     *     
     *     
     *     
     *     
     *   
     * 
     */
    void dropdownListBlock(Closure body);

    /**
     * 
     *     Foldable block expanded when the corresponding item is selected in the drop-down list.
     * 
     *     
     *     
     *     
     *     
     *     
     *   
     * 
     */
    void dropdownListBlock(Map args);

    /**
     * 
     *     Foldable block expanded when the corresponding item is selected in the drop-down list.
     * 
     *     
     *     
     *     
     *     
     *     
     *   
     * 
     */
    void dropdownListBlock();

    /**
     *  
     *     Repeatable blocks used to present UI where the user can configure multiple entries
     *     of the same kind (see the Java installations configuration in the system config.)
     * 
     *     This tag works like &lt;j:forEach> and repeatedly evaluate the body so that
     *     initially all the items get their own copy. This tag also evaluate the body
     *     once more with var=null to create a 'master copy', which is the template entry
     *     used when a new copy is inserted.
     * 
     *     h1. HTML structure
     *       this tag mainly produces the nested DIVs with CSS classes as follows:
     * 
     *       {noformat}
     *       &lt;div class="repeated-container">   // container for the whole thing
     *         &lt;div class="repeated-chunk">
     *           ... copy 1 ...
     *         &lt;div class="repeated-chunk">
     *           ... copy 2 ...
     *         ...
     *       {noformat}
     * 
     *       The 'repeated-chunk' DIVs will also have additional CSS classes that represent
     *       their positions among siblings:
     * 
     *         first : first chunk among the siblings
     *         last  : last chunk among the siblings
     *         middle: neither first nor last
     *         only  : it is the only chunk (automatically get first and last at the same time)
     * 
     *     h1. Usage Note
     *       The caller of this tag should define a button to add a new copy and delete
     *       the current copy. Such buttons should have 'repeatable-add' CSS class and
     *       'repeatable-delete' CSS class respectively (it can have other CSS classes),
     *       so that their event handlers get properly wired up.
     * 
     *       The positional CSS classes on 'repeated-chunk' DIVs (as explained above)
     *       can be used to control the visibility of such buttons. For example, this allows
     *       you to hide 'delete' button if there's only one item, or only show 'add' button
     *       on the last row. There are a few CSS classes already defined in style.css
     *       for this purpose.
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
     *   
     * 
     */
    void repeatable(Map args, Closure body);

    /**
     *  
     *     Repeatable blocks used to present UI where the user can configure multiple entries
     *     of the same kind (see the Java installations configuration in the system config.)
     * 
     *     This tag works like &lt;j:forEach> and repeatedly evaluate the body so that
     *     initially all the items get their own copy. This tag also evaluate the body
     *     once more with var=null to create a 'master copy', which is the template entry
     *     used when a new copy is inserted.
     * 
     *     h1. HTML structure
     *       this tag mainly produces the nested DIVs with CSS classes as follows:
     * 
     *       {noformat}
     *       &lt;div class="repeated-container">   // container for the whole thing
     *         &lt;div class="repeated-chunk">
     *           ... copy 1 ...
     *         &lt;div class="repeated-chunk">
     *           ... copy 2 ...
     *         ...
     *       {noformat}
     * 
     *       The 'repeated-chunk' DIVs will also have additional CSS classes that represent
     *       their positions among siblings:
     * 
     *         first : first chunk among the siblings
     *         last  : last chunk among the siblings
     *         middle: neither first nor last
     *         only  : it is the only chunk (automatically get first and last at the same time)
     * 
     *     h1. Usage Note
     *       The caller of this tag should define a button to add a new copy and delete
     *       the current copy. Such buttons should have 'repeatable-add' CSS class and
     *       'repeatable-delete' CSS class respectively (it can have other CSS classes),
     *       so that their event handlers get properly wired up.
     * 
     *       The positional CSS classes on 'repeated-chunk' DIVs (as explained above)
     *       can be used to control the visibility of such buttons. For example, this allows
     *       you to hide 'delete' button if there's only one item, or only show 'add' button
     *       on the last row. There are a few CSS classes already defined in style.css
     *       for this purpose.
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
     *   
     * 
     */
    void repeatable(Closure body);

    /**
     *  
     *     Repeatable blocks used to present UI where the user can configure multiple entries
     *     of the same kind (see the Java installations configuration in the system config.)
     * 
     *     This tag works like &lt;j:forEach> and repeatedly evaluate the body so that
     *     initially all the items get their own copy. This tag also evaluate the body
     *     once more with var=null to create a 'master copy', which is the template entry
     *     used when a new copy is inserted.
     * 
     *     h1. HTML structure
     *       this tag mainly produces the nested DIVs with CSS classes as follows:
     * 
     *       {noformat}
     *       &lt;div class="repeated-container">   // container for the whole thing
     *         &lt;div class="repeated-chunk">
     *           ... copy 1 ...
     *         &lt;div class="repeated-chunk">
     *           ... copy 2 ...
     *         ...
     *       {noformat}
     * 
     *       The 'repeated-chunk' DIVs will also have additional CSS classes that represent
     *       their positions among siblings:
     * 
     *         first : first chunk among the siblings
     *         last  : last chunk among the siblings
     *         middle: neither first nor last
     *         only  : it is the only chunk (automatically get first and last at the same time)
     * 
     *     h1. Usage Note
     *       The caller of this tag should define a button to add a new copy and delete
     *       the current copy. Such buttons should have 'repeatable-add' CSS class and
     *       'repeatable-delete' CSS class respectively (it can have other CSS classes),
     *       so that their event handlers get properly wired up.
     * 
     *       The positional CSS classes on 'repeated-chunk' DIVs (as explained above)
     *       can be used to control the visibility of such buttons. For example, this allows
     *       you to hide 'delete' button if there's only one item, or only show 'add' button
     *       on the last row. There are a few CSS classes already defined in style.css
     *       for this purpose.
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
     *   
     * 
     */
    void repeatable(Map args);

    /**
     *  
     *     Repeatable blocks used to present UI where the user can configure multiple entries
     *     of the same kind (see the Java installations configuration in the system config.)
     * 
     *     This tag works like &lt;j:forEach> and repeatedly evaluate the body so that
     *     initially all the items get their own copy. This tag also evaluate the body
     *     once more with var=null to create a 'master copy', which is the template entry
     *     used when a new copy is inserted.
     * 
     *     h1. HTML structure
     *       this tag mainly produces the nested DIVs with CSS classes as follows:
     * 
     *       {noformat}
     *       &lt;div class="repeated-container">   // container for the whole thing
     *         &lt;div class="repeated-chunk">
     *           ... copy 1 ...
     *         &lt;div class="repeated-chunk">
     *           ... copy 2 ...
     *         ...
     *       {noformat}
     * 
     *       The 'repeated-chunk' DIVs will also have additional CSS classes that represent
     *       their positions among siblings:
     * 
     *         first : first chunk among the siblings
     *         last  : last chunk among the siblings
     *         middle: neither first nor last
     *         only  : it is the only chunk (automatically get first and last at the same time)
     * 
     *     h1. Usage Note
     *       The caller of this tag should define a button to add a new copy and delete
     *       the current copy. Such buttons should have 'repeatable-add' CSS class and
     *       'repeatable-delete' CSS class respectively (it can have other CSS classes),
     *       so that their event handlers get properly wired up.
     * 
     *       The positional CSS classes on 'repeated-chunk' DIVs (as explained above)
     *       can be used to control the visibility of such buttons. For example, this allows
     *       you to hide 'delete' button if there's only one item, or only show 'add' button
     *       on the last row. There are a few CSS classes already defined in style.css
     *       for this purpose.
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
     *   
     * 
     */
    void repeatable();

    /**
     * 
     *     Adds @nameRef to all table rows inside this tag, so that when the form is submitted,
     *     it gets grouped in one JSON object.
     * 
     *     
     *     
     *   
     * 
     */
    void rowSet(Map args, Closure body);

    /**
     * 
     *     Adds @nameRef to all table rows inside this tag, so that when the form is submitted,
     *     it gets grouped in one JSON object.
     * 
     *     
     *     
     *   
     * 
     */
    void rowSet(Closure body);

    /**
     * 
     *     Adds @nameRef to all table rows inside this tag, so that when the form is submitted,
     *     it gets grouped in one JSON object.
     * 
     *     
     *     
     *   
     * 
     */
    void rowSet(Map args);

    /**
     * 
     *     Adds @nameRef to all table rows inside this tag, so that when the form is submitted,
     *     it gets grouped in one JSON object.
     * 
     *     
     *     
     *   
     * 
     */
    void rowSet();

    /**
     * 
     *     Outer most tag for creating a heterogeneous list, where the user can choose arbitrary number of
     *     arbitrary items from the given list of descriptors, and configure them independently.
     * 
     *     The submission can be data-bound into List&lt;T> where T is the common base type for the describable instances.
     * 
     *     For databinding use, please use &lt;f:repeatableHeteroProperty />
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
     *   
     * 
     */
    @TagFile("hetero-list")
    void hetero_list(Map args, Closure body);

    /**
     * 
     *     Outer most tag for creating a heterogeneous list, where the user can choose arbitrary number of
     *     arbitrary items from the given list of descriptors, and configure them independently.
     * 
     *     The submission can be data-bound into List&lt;T> where T is the common base type for the describable instances.
     * 
     *     For databinding use, please use &lt;f:repeatableHeteroProperty />
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
     *   
     * 
     */
    @TagFile("hetero-list")
    void hetero_list(Closure body);

    /**
     * 
     *     Outer most tag for creating a heterogeneous list, where the user can choose arbitrary number of
     *     arbitrary items from the given list of descriptors, and configure them independently.
     * 
     *     The submission can be data-bound into List&lt;T> where T is the common base type for the describable instances.
     * 
     *     For databinding use, please use &lt;f:repeatableHeteroProperty />
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
     *   
     * 
     */
    @TagFile("hetero-list")
    void hetero_list(Map args);

    /**
     * 
     *     Outer most tag for creating a heterogeneous list, where the user can choose arbitrary number of
     *     arbitrary items from the given list of descriptors, and configure them independently.
     * 
     *     The submission can be data-bound into List&lt;T> where T is the common base type for the describable instances.
     * 
     *     For databinding use, please use &lt;f:repeatableHeteroProperty />
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
     *   
     * 
     */
    @TagFile("hetero-list")
    void hetero_list();

    /**
     * 
     *     &lt;input type="radio"> tag that takes true/false for @checked, which is more Jelly friendly.
     *     
     *     Note that safari doesn't support onchange.
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
    void radio(Map args, Closure body);

    /**
     * 
     *     &lt;input type="radio"> tag that takes true/false for @checked, which is more Jelly friendly.
     *     
     *     Note that safari doesn't support onchange.
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
    void radio(Closure body);

    /**
     * 
     *     &lt;input type="radio"> tag that takes true/false for @checked, which is more Jelly friendly.
     *     
     *     Note that safari doesn't support onchange.
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
    void radio(Map args);

    /**
     * 
     *     &lt;input type="radio"> tag that takes true/false for @checked, which is more Jelly friendly.
     *     
     *     Note that safari doesn't support onchange.
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
    void radio();

    /**
     * 
     *     See
     *     http://wiki.jenkins-ci.org/display/JENKINS/Jelly+form+controls
     *     for the reference.
     * 
     *     
     *     
     *     
     *     
     *   
     * 
     */
    void validateButton(Map args, Closure body);

    /**
     * 
     *     See
     *     http://wiki.jenkins-ci.org/display/JENKINS/Jelly+form+controls
     *     for the reference.
     * 
     *     
     *     
     *     
     *     
     *   
     * 
     */
    void validateButton(Closure body);

    /**
     * 
     *     See
     *     http://wiki.jenkins-ci.org/display/JENKINS/Jelly+form+controls
     *     for the reference.
     * 
     *     
     *     
     *     
     *     
     *   
     * 
     */
    void validateButton(Map args);

    /**
     * 
     *     See
     *     http://wiki.jenkins-ci.org/display/JENKINS/Jelly+form+controls
     *     for the reference.
     * 
     *     
     *     
     *     
     *     
     *   
     * 
     */
    void validateButton();

    /**
     * 
     *     Binds an enum field to a &lt;select> element.
     *     The body of this tag is evaluated for each enum value,
     *     which is passed as 'it'.
     * 
     *     
     *   
     * 
     */
    @TagFile("enum")
    void enum_(Map args, Closure body);

    /**
     * 
     *     Binds an enum field to a &lt;select> element.
     *     The body of this tag is evaluated for each enum value,
     *     which is passed as 'it'.
     * 
     *     
     *   
     * 
     */
    @TagFile("enum")
    void enum_(Closure body);

    /**
     * 
     *     Binds an enum field to a &lt;select> element.
     *     The body of this tag is evaluated for each enum value,
     *     which is passed as 'it'.
     * 
     *     
     *   
     * 
     */
    @TagFile("enum")
    void enum_(Map args);

    /**
     * 
     *     Binds an enum field to a &lt;select> element.
     *     The body of this tag is evaluated for each enum value,
     *     which is passed as 'it'.
     * 
     *     
     *   
     * 
     */
    @TagFile("enum")
    void enum_();

    /**
     * 
     *     Editable drop-down combo box. Deprecated as of 1.356. Use f:combobox and databinding instead.
     * 
     *     
     *     
     *     
     *   
     * 
     */
    void editableComboBox(Map args, Closure body);

    /**
     * 
     *     Editable drop-down combo box. Deprecated as of 1.356. Use f:combobox and databinding instead.
     * 
     *     
     *     
     *     
     *   
     * 
     */
    void editableComboBox(Closure body);

    /**
     * 
     *     Editable drop-down combo box. Deprecated as of 1.356. Use f:combobox and databinding instead.
     * 
     *     
     *     
     *     
     *   
     * 
     */
    void editableComboBox(Map args);

    /**
     * 
     *     Editable drop-down combo box. Deprecated as of 1.356. Use f:combobox and databinding instead.
     * 
     *     
     *     
     *     
     *   
     * 
     */
    void editableComboBox();

    /**
     * 
     *     Place holder to lazy-load help text via AJAX.
     *   
     * 
     */
    void helpArea(Map args, Closure body);

    /**
     * 
     *     Place holder to lazy-load help text via AJAX.
     *   
     * 
     */
    void helpArea(Closure body);

    /**
     * 
     *     Place holder to lazy-load help text via AJAX.
     *   
     * 
     */
    void helpArea(Map args);

    /**
     * 
     *     Place holder to lazy-load help text via AJAX.
     *   
     * 
     */
    void helpArea();

    /**
     * 
     *     Binds a boolean field to two radio buttons that say Yes/No OK/Cancel Top/Bottom.
     * 
     *     
     *     
     *     
     *   
     * 
     */
    void booleanRadio(Map args, Closure body);

    /**
     * 
     *     Binds a boolean field to two radio buttons that say Yes/No OK/Cancel Top/Bottom.
     * 
     *     
     *     
     *     
     *   
     * 
     */
    void booleanRadio(Closure body);

    /**
     * 
     *     Binds a boolean field to two radio buttons that say Yes/No OK/Cancel Top/Bottom.
     * 
     *     
     *     
     *     
     *   
     * 
     */
    void booleanRadio(Map args);

    /**
     * 
     *     Binds a boolean field to two radio buttons that say Yes/No OK/Cancel Top/Bottom.
     * 
     *     
     *     
     *     
     *   
     * 
     */
    void booleanRadio();

    /**
     * 
     *     Binds a set of Enum to a list of checkboxes, each with the label taken from enum Enum.toString()
     *     Should be used inside an &lt;f:entry field='...'> element.
     *     
     *   
     * 
     */
    void enumSet(Map args, Closure body);

    /**
     * 
     *     Binds a set of Enum to a list of checkboxes, each with the label taken from enum Enum.toString()
     *     Should be used inside an &lt;f:entry field='...'> element.
     *     
     *   
     * 
     */
    void enumSet(Closure body);

    /**
     * 
     *     Binds a set of Enum to a list of checkboxes, each with the label taken from enum Enum.toString()
     *     Should be used inside an &lt;f:entry field='...'> element.
     *     
     *   
     * 
     */
    void enumSet(Map args);

    /**
     * 
     *     Binds a set of Enum to a list of checkboxes, each with the label taken from enum Enum.toString()
     *     Should be used inside an &lt;f:entry field='...'> element.
     *     
     *   
     * 
     */
    void enumSet();

    /**
     * on
     *     Radio button with a label that hides additional controls.
     *     When checked, those additional controls are displayed. This is useful
     *     for presenting mutually exclusive options, where each option comes
     *     with a sub-form that provides additional configuration.
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
    void radioBlock(Map args, Closure body);

    /**
     * on
     *     Radio button with a label that hides additional controls.
     *     When checked, those additional controls are displayed. This is useful
     *     for presenting mutually exclusive options, where each option comes
     *     with a sub-form that provides additional configuration.
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
    void radioBlock(Closure body);

    /**
     * on
     *     Radio button with a label that hides additional controls.
     *     When checked, those additional controls are displayed. This is useful
     *     for presenting mutually exclusive options, where each option comes
     *     with a sub-form that provides additional configuration.
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
    void radioBlock(Map args);

    /**
     * on
     *     Radio button with a label that hides additional controls.
     *     When checked, those additional controls are displayed. This is useful
     *     for presenting mutually exclusive options, where each option comes
     *     with a sub-form that provides additional configuration.
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
    void radioBlock();

    /**
     *  
     *     Data-bound only version of &lt;f:hetero-list> that assumes the type pointed by the property is data-bound as well.
     *     The nested property type must be Describable and it needs to have config.jelly.
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
     * 
     */
    void repeatableHeteroProperty(Map args, Closure body);

    /**
     *  
     *     Data-bound only version of &lt;f:hetero-list> that assumes the type pointed by the property is data-bound as well.
     *     The nested property type must be Describable and it needs to have config.jelly.
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
     * 
     */
    void repeatableHeteroProperty(Closure body);

    /**
     *  
     *     Data-bound only version of &lt;f:hetero-list> that assumes the type pointed by the property is data-bound as well.
     *     The nested property type must be Describable and it needs to have config.jelly.
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
     * 
     */
    void repeatableHeteroProperty(Map args);

    /**
     *  
     *     Data-bound only version of &lt;f:hetero-list> that assumes the type pointed by the property is data-bound as well.
     *     The nested property type must be Describable and it needs to have config.jelly.
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
     * 
     */
    void repeatableHeteroProperty();

    /**
     *  
     *     Data-bound only version of &lt;f:repeatable> that assumes the type pointed by the property is data-bound as well.
     *     The nested property type must be Describable and it needs to have config.jelly.
     * 
     *     Unless that nested config.jelly already adds a delete button (deprecated), you should normally put the following inside this tag:
     * 
     *       	&lt;f:entry title="">
     *           &lt;div align="right">
     *             &lt;f:repeatableDeleteButton />
     *           &lt;/div>
     *         &lt;/f:entry>
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
    void repeatableProperty(Map args, Closure body);

    /**
     *  
     *     Data-bound only version of &lt;f:repeatable> that assumes the type pointed by the property is data-bound as well.
     *     The nested property type must be Describable and it needs to have config.jelly.
     * 
     *     Unless that nested config.jelly already adds a delete button (deprecated), you should normally put the following inside this tag:
     * 
     *       	&lt;f:entry title="">
     *           &lt;div align="right">
     *             &lt;f:repeatableDeleteButton />
     *           &lt;/div>
     *         &lt;/f:entry>
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
    void repeatableProperty(Closure body);

    /**
     *  
     *     Data-bound only version of &lt;f:repeatable> that assumes the type pointed by the property is data-bound as well.
     *     The nested property type must be Describable and it needs to have config.jelly.
     * 
     *     Unless that nested config.jelly already adds a delete button (deprecated), you should normally put the following inside this tag:
     * 
     *       	&lt;f:entry title="">
     *           &lt;div align="right">
     *             &lt;f:repeatableDeleteButton />
     *           &lt;/div>
     *         &lt;/f:entry>
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
    void repeatableProperty(Map args);

    /**
     *  
     *     Data-bound only version of &lt;f:repeatable> that assumes the type pointed by the property is data-bound as well.
     *     The nested property type must be Describable and it needs to have config.jelly.
     * 
     *     Unless that nested config.jelly already adds a delete button (deprecated), you should normally put the following inside this tag:
     * 
     *       	&lt;f:entry title="">
     *           &lt;div align="right">
     *             &lt;f:repeatableDeleteButton />
     *           &lt;/div>
     *         &lt;/f:entry>
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
    void repeatableProperty();

    /**
     * 
     *     Submit button themed by YUI. This should be always
     *     used instead of the plain &lt;input tag.
     * 
     *     
     *     
     *   
     * 
     */
    void submit(Map args, Closure body);

    /**
     * 
     *     Submit button themed by YUI. This should be always
     *     used instead of the plain &lt;input tag.
     * 
     *     
     *     
     *   
     * 
     */
    void submit(Closure body);

    /**
     * 
     *     Submit button themed by YUI. This should be always
     *     used instead of the plain &lt;input tag.
     * 
     *     
     *     
     *   
     * 
     */
    void submit(Map args);

    /**
     * 
     *     Submit button themed by YUI. This should be always
     *     used instead of the plain &lt;input tag.
     * 
     *     
     *     
     *   
     * 
     */
    void submit();

    /**
     * 
     *     Section header in the form table.
     * 
     *     
     *     
     *   
     * 
     */
    void section(Map args, Closure body);

    /**
     * 
     *     Section header in the form table.
     * 
     *     
     *     
     *   
     * 
     */
    void section(Closure body);

    /**
     * 
     *     Section header in the form table.
     * 
     *     
     *     
     *   
     * 
     */
    void section(Map args);

    /**
     * 
     *     Section header in the form table.
     * 
     *     
     *     
     *   
     * 
     */
    void section();

    /**
     * 
     *     Rich HTML editor from http://developer.yahoo.com/yui/editor/
     *     All the attributes are those of the &lt;textarea> tag.
     * 
     *     
     *     
     *     
     *     
     *   
     * 
     */
    void richtextarea(Map args, Closure body);

    /**
     * 
     *     Rich HTML editor from http://developer.yahoo.com/yui/editor/
     *     All the attributes are those of the &lt;textarea> tag.
     * 
     *     
     *     
     *     
     *     
     *   
     * 
     */
    void richtextarea(Closure body);

    /**
     * 
     *     Rich HTML editor from http://developer.yahoo.com/yui/editor/
     *     All the attributes are those of the &lt;textarea> tag.
     * 
     *     
     *     
     *     
     *     
     *   
     * 
     */
    void richtextarea(Map args);

    /**
     * 
     *     Rich HTML editor from http://developer.yahoo.com/yui/editor/
     *     All the attributes are those of the &lt;textarea> tag.
     * 
     *     
     *     
     *     
     *     
     *   
     * 
     */
    void richtextarea();

    /**
     * 
     *     "Apply" button that submits the form but without a page transition.
     *     See hudson.util.FormApply for the server-side code.
     * 
     *     When this button is pressed, the FORM element fires the "jenkins:apply" event
     *     that allows interested parties to write back whatever states back into the INPUT
     *     elements.
     *   
     * 
     */
    void apply(Map args, Closure body);

    /**
     * 
     *     "Apply" button that submits the form but without a page transition.
     *     See hudson.util.FormApply for the server-side code.
     * 
     *     When this button is pressed, the FORM element fires the "jenkins:apply" event
     *     that allows interested parties to write back whatever states back into the INPUT
     *     elements.
     *   
     * 
     */
    void apply(Closure body);

    /**
     * 
     *     "Apply" button that submits the form but without a page transition.
     *     See hudson.util.FormApply for the server-side code.
     * 
     *     When this button is pressed, the FORM element fires the "jenkins:apply" event
     *     that allows interested parties to write back whatever states back into the INPUT
     *     elements.
     *   
     * 
     */
    void apply(Map args);

    /**
     * 
     *     "Apply" button that submits the form but without a page transition.
     *     See hudson.util.FormApply for the server-side code.
     * 
     *     When this button is pressed, the FORM element fires the "jenkins:apply" event
     *     that allows interested parties to write back whatever states back into the INPUT
     *     elements.
     *   
     * 
     */
    void apply();

    /**
     * 
     */
    void nested(Map args, Closure body);

    /**
     * 
     */
    void nested(Closure body);

    /**
     * 
     */
    void nested(Map args);

    /**
     * 
     */
    void nested();

    /**
     * 
     *     Renders inline a single-value nested data-bound property of the current instance.
     *     This is useful when your object composes another data-bound object as a nested object,
     *     yet your UI would still like to render it
     * 
     *     
     *     
     *   
     * 
     */
    void property(Map args, Closure body);

    /**
     * 
     *     Renders inline a single-value nested data-bound property of the current instance.
     *     This is useful when your object composes another data-bound object as a nested object,
     *     yet your UI would still like to render it
     * 
     *     
     *     
     *   
     * 
     */
    void property(Closure body);

    /**
     * 
     *     Renders inline a single-value nested data-bound property of the current instance.
     *     This is useful when your object composes another data-bound object as a nested object,
     *     yet your UI would still like to render it
     * 
     *     
     *     
     *   
     * 
     */
    void property(Map args);

    /**
     * 
     *     Renders inline a single-value nested data-bound property of the current instance.
     *     This is useful when your object composes another data-bound object as a nested object,
     *     yet your UI would still like to render it
     * 
     *     
     *     
     *   
     * 
     */
    void property();

    /**
     * 
     *     Foldable block that can be expanded to show more controls by checking the checkbox.
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
    void optionalBlock(Map args, Closure body);

    /**
     * 
     *     Foldable block that can be expanded to show more controls by checking the checkbox.
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
    void optionalBlock(Closure body);

    /**
     * 
     *     Foldable block that can be expanded to show more controls by checking the checkbox.
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
    void optionalBlock(Map args);

    /**
     * 
     *     Foldable block that can be expanded to show more controls by checking the checkbox.
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
    void optionalBlock();

    /**
     * 
     *     Outer-most tag of the entire form taglib, that generates &lt;form> element.
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
    void form(Map args, Closure body);

    /**
     * 
     *     Outer-most tag of the entire form taglib, that generates &lt;form> element.
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
    void form(Closure body);

    /**
     * 
     *     Outer-most tag of the entire form taglib, that generates &lt;form> element.
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
    void form(Map args);

    /**
     * 
     *     Outer-most tag of the entire form taglib, that generates &lt;form> element.
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
    void form();

    /**
     * 
     *     single-line textbox that can be expanded into a multi-line textarea.
     * 
     *     This control is useful for a field that expects multiple whitespaec-separated tokens
     *     (such as URLs, glob patterns, etc.) When the user only enters a few tokens,
     *     they can keep it as a single line to save space, but to enter a large number of values,
     *     this can be turned into textarea for better visibility.
     * 
     *     If the initial value is already multi-line text, the control starts with
     *     textarea.
     * 
     *     On the server side, your program is responsible for treating ' ', \t, \r, and \n for
     *     separators. (StringTokenizer would do this.)
     * 
     *     
     *     
     *     
     *   
     * 
     */
    void expandableTextbox(Map args, Closure body);

    /**
     * 
     *     single-line textbox that can be expanded into a multi-line textarea.
     * 
     *     This control is useful for a field that expects multiple whitespaec-separated tokens
     *     (such as URLs, glob patterns, etc.) When the user only enters a few tokens,
     *     they can keep it as a single line to save space, but to enter a large number of values,
     *     this can be turned into textarea for better visibility.
     * 
     *     If the initial value is already multi-line text, the control starts with
     *     textarea.
     * 
     *     On the server side, your program is responsible for treating ' ', \t, \r, and \n for
     *     separators. (StringTokenizer would do this.)
     * 
     *     
     *     
     *     
     *   
     * 
     */
    void expandableTextbox(Closure body);

    /**
     * 
     *     single-line textbox that can be expanded into a multi-line textarea.
     * 
     *     This control is useful for a field that expects multiple whitespaec-separated tokens
     *     (such as URLs, glob patterns, etc.) When the user only enters a few tokens,
     *     they can keep it as a single line to save space, but to enter a large number of values,
     *     this can be turned into textarea for better visibility.
     * 
     *     If the initial value is already multi-line text, the control starts with
     *     textarea.
     * 
     *     On the server side, your program is responsible for treating ' ', \t, \r, and \n for
     *     separators. (StringTokenizer would do this.)
     * 
     *     
     *     
     *     
     *   
     * 
     */
    void expandableTextbox(Map args);

    /**
     * 
     *     single-line textbox that can be expanded into a multi-line textarea.
     * 
     *     This control is useful for a field that expects multiple whitespaec-separated tokens
     *     (such as URLs, glob patterns, etc.) When the user only enters a few tokens,
     *     they can keep it as a single line to save space, but to enter a large number of values,
     *     this can be turned into textarea for better visibility.
     * 
     *     If the initial value is already multi-line text, the control starts with
     *     textarea.
     * 
     *     On the server side, your program is responsible for treating ' ', \t, \r, and \n for
     *     separators. (StringTokenizer would do this.)
     * 
     *     
     *     
     *     
     *   
     * 
     */
    void expandableTextbox();

    /**
     * 
     *     Creates a button bar at the bottom of the page for things like "Submit".
     *     The actual buttons should be specified as the body of this tag.
     *     This area will always be visible in the bottom of the screen.
     *   
     * 
     */
    void bottomButtonBar(Map args, Closure body);

    /**
     * 
     *     Creates a button bar at the bottom of the page for things like "Submit".
     *     The actual buttons should be specified as the body of this tag.
     *     This area will always be visible in the bottom of the screen.
     *   
     * 
     */
    void bottomButtonBar(Closure body);

    /**
     * 
     *     Creates a button bar at the bottom of the page for things like "Submit".
     *     The actual buttons should be specified as the body of this tag.
     *     This area will always be visible in the bottom of the screen.
     *   
     * 
     */
    void bottomButtonBar(Map args);

    /**
     * 
     *     Creates a button bar at the bottom of the page for things like "Submit".
     *     The actual buttons should be specified as the body of this tag.
     *     This area will always be visible in the bottom of the screen.
     *   
     * 
     */
    void bottomButtonBar();

    /**
     * 
     *     &lt;option> tag for the &lt;select> element that takes true/false for selected.
     * 
     *     
     *     
     *   
     * 
     */
    void option(Map args, Closure body);

    /**
     * 
     *     &lt;option> tag for the &lt;select> element that takes true/false for selected.
     * 
     *     
     *     
     *   
     * 
     */
    void option(Closure body);

    /**
     * 
     *     &lt;option> tag for the &lt;select> element that takes true/false for selected.
     * 
     *     
     *     
     *   
     * 
     */
    void option(Map args);

    /**
     * 
     *     &lt;option> tag for the &lt;select> element that takes true/false for selected.
     * 
     *     
     *     
     *   
     * 
     */
    void option();

}
