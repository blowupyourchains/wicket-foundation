package com.iluwatar.foundation.dropdown;

import java.util.List;

import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.MarkupStream;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.util.ListModel;
import org.apache.wicket.util.lang.Args;

import com.iluwatar.foundation.component.FoundationJsPanel;
import com.iluwatar.foundation.util.Attribute;
import com.iluwatar.foundation.util.StringUtil;

public abstract class FoundationDropdown extends FoundationJsPanel {

	private static final long serialVersionUID = 1L;
	
	public FoundationDropdown(String id, String title, DropdownOptions options, List<String> linkTitles) {
		this(id, Model.of(title), Model.of(options), new ListModel<>(linkTitles));
	}
	
	public FoundationDropdown(String id, IModel<String> titleModel, IModel<DropdownOptions> optionsModel, IModel<List<String>> linkTitleModels) {
		super(id);
		
		FoundationDropdownContainer container = new FoundationDropdownContainer("container", linkTitleModels);
		add(container);
		
		FoundationDropdownButton btn = new FoundationDropdownButton("btn", container.getMarkupId(), titleModel, optionsModel);
		add(btn);
	}
	
	protected abstract WebMarkupContainer createDropdownLink(int idx, String id);
	
	private static class FoundationDropdownButton extends WebMarkupContainer {

		private static final long serialVersionUID = 1L;
		
		private String containerId;
		private IModel<String> titleModel;
		private IModel<DropdownOptions> optionsModel;

		public FoundationDropdownButton(String id, String containerId, IModel<String> titleModel, IModel<DropdownOptions> optionsModel) {
			super(id);
			Args.notNull(containerId, "containerId");
			Args.notNull(optionsModel, "titleModel");
			Args.notNull(optionsModel, "optionsModel");
			this.containerId = containerId;
			this.titleModel = titleModel;
			this.optionsModel = optionsModel;
		}
		
		@Override
		protected void onComponentTag(ComponentTag tag) {
			Attribute.addAttribute(tag, "data-dropdown", containerId);
			Attribute.addAttribute(tag, "aria-controls", containerId);
			Attribute.addAttribute(tag, "aria-expanded", false);
			Attribute.addClass(tag, "button");
			Attribute.addClass(tag, "dropdown");
			if (optionsModel.getObject().getColor() != null) {
				Attribute.addClass(tag, StringUtil.EnumNameToCssClassName(optionsModel.getObject().getColor().name()));
			}
			if (optionsModel.getObject().getRadius() != null) {
				Attribute.addClass(tag, StringUtil.EnumNameToCssClassName(optionsModel.getObject().getRadius().name()));
			}
			if (optionsModel.getObject().getSize() != null) {
				Attribute.addClass(tag, StringUtil.EnumNameToCssClassName(optionsModel.getObject().getSize().name()));
			}
			super.onComponentTag(tag);
		}
		
		@Override
		public void onComponentTagBody(MarkupStream markupStream,
				ComponentTag openTag) {
			this.replaceComponentTagBody(markupStream, openTag, titleModel.getObject());
			super.onComponentTagBody(markupStream, openTag);
		}
		
		@Override
		protected void onDetach() {
			titleModel.detach();
			optionsModel.detach();
			super.onDetach();
		}
	}
	
	private class FoundationDropdownContainer extends WebMarkupContainer {

		private static final long serialVersionUID = 1L;

		public FoundationDropdownContainer(String id, IModel<List<String>> linkTitleModels) {
			super(id);
			this.setOutputMarkupId(true);
			
			ListView<String> lv = new ListView<String>("item", linkTitleModels) {

				private static final long serialVersionUID = 1L;

				@Override
				protected void populateItem(ListItem<String> item) {
					WebMarkupContainer link = FoundationDropdown.this.createDropdownLink(item.getIndex(), "link");
					item.add(link);
					link.add(new Label("body", item.getModel()));
				}
			};
			add(lv);
		}
		
		@Override
		protected void onComponentTag(ComponentTag tag) {
			Attribute.addAttribute(tag, "data-dropdown-content");
			Attribute.addClass(tag, "f-dropdown");
			Attribute.addAttribute(tag, "aria-hidden", true);
			Attribute.addAttribute(tag, "tabindex", -1);
			super.onComponentTag(tag);
		}
	}
}
