package com.iluwatar.foundation.buttongroup;

import java.util.List;

import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.util.ListModel;

import com.iluwatar.foundation.button.ButtonOptions;
import com.iluwatar.foundation.component.FoundationBasePanel;
import com.iluwatar.foundation.util.Attribute;
import com.iluwatar.foundation.util.StringUtil;

/**
 * Button groups are containers for related action items.
 * http://foundation.zurb.com/docs/components/button_groups.html
 * @author ilkka
 *
 */
public abstract class ButtonGroupPanel extends FoundationBasePanel {

	private static final long serialVersionUID = 1L;

	public ButtonGroupPanel(String id, ButtonGroupOptions groupOptions, List<ButtonOptions> btnOptions) {
		this(id, Model.of(groupOptions), new ListModel<ButtonOptions>(btnOptions));
	}
	
	public ButtonGroupPanel(String id, IModel<ButtonGroupOptions> groupOptionsModel, IModel<List<ButtonOptions>> btnOptionsModel) {
		super(id);
		WebMarkupContainer container = createContainer("group", groupOptionsModel);
		add(container);
		ListView<ButtonOptions> lv = createRepeater("item", btnOptionsModel);
		container.add(lv);
	}
	
	protected WebMarkupContainer createContainer(String id, IModel<ButtonGroupOptions> groupOptions) {
		return new ButtonGroupContainer(id, groupOptions);
	}
	
	protected ListView<ButtonOptions> createRepeater(String id, IModel<List<ButtonOptions>> btnOptionsModel) {
		return new ListView<ButtonOptions>(id, btnOptionsModel) {

			private static final long serialVersionUID = 1L;

			@Override
			protected void populateItem(ListItem<ButtonOptions> item) {
				WebMarkupContainer btn = ButtonGroupPanel.this.createButton(item.getIndex(), "btn", item.getModel());
				item.add(btn);
			}
		};
	}
	
	protected abstract WebMarkupContainer createButton(int idx, String id, IModel<ButtonOptions> optionsModel);

	private static class ButtonGroupContainer extends WebMarkupContainer {

		private static final long serialVersionUID = 1L;

		public ButtonGroupContainer(String id, IModel<ButtonGroupOptions> model) {
			super(id, model);
		}
	
		@Override
		protected void onComponentTag(ComponentTag tag) {
			Attribute.setClass(tag, ButtonGroupClassNames.BUTTON_GROUP);
			ButtonGroupOptions options = (ButtonGroupOptions) getDefaultModelObject();
			if (options.getRadius() != null) {
				Attribute.addClass(tag, StringUtil.EnumNameToCssClassName(options.getRadius().name()));
			}
			if (options.getColor() != null) {
				Attribute.addClass(tag, StringUtil.EnumNameToCssClassName(options.getColor().name()));
			}
			if (options.getStacking() != null) {
				Attribute.addClass(tag, StringUtil.EnumNameToCssClassName(options.getStacking().name()));
			}
			super.onComponentTag(tag);
		}
	}
}
