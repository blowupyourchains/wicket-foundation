package com.iluwatar.foundation.dropdown;

import java.util.List;

import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.util.ListModel;
import org.apache.wicket.util.lang.Args;

import com.iluwatar.foundation.util.Attribute;
import com.iluwatar.foundation.util.StringUtil;

public abstract class FoundationDropdown extends FoundationDropdownBase {

	private static final long serialVersionUID = 1L;

	public FoundationDropdown(String id, String title, DropdownOptions options, List<String> linkTitles) {
		this(id, Model.of(title), Model.of(options), new ListModel<>(linkTitles));
	}
	
	public FoundationDropdown(String id, IModel<String> titleModel, IModel<DropdownOptions> optionsModel, IModel<List<String>> linkTitleModels) {
		super(id, titleModel, optionsModel);
		FoundationDropdownContainer container = new FoundationDropdownContainer("container", linkTitleModels, optionsModel);
		add(container);
	}

	@Override
	protected String getContainerMarkupId() {
		return this.get("container").getMarkupId();
	}
	
	protected abstract WebMarkupContainer createDropdownLink(int idx, String id);
	
	private class FoundationDropdownContainer extends WebMarkupContainer {

		private static final long serialVersionUID = 1L;
		
		private IModel<DropdownOptions> optionsModel;

		public FoundationDropdownContainer(String id, IModel<List<String>> linkTitleModels, IModel<DropdownOptions> optionsModel) {
			super(id);
			Args.notNull(optionsModel, "optionsModel");
			this.optionsModel = optionsModel;
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
			DropdownOptions options = optionsModel.getObject();
			if (options.getListStyle() != null) {
				Attribute.addClass(tag, StringUtil.EnumNameToCssClassName(options.getListStyle().name()));
			}
			super.onComponentTag(tag);
		}
		
		@Override
		protected void onDetach() {
			optionsModel.detach();
			super.onDetach();
		}
	}
	
//	private class FoundationDropdownContent extends WebMarkupContainer {
//
//		private static final long serialVersionUID = 1L;
//		
//		private IModel<String> contentModel;
//		
//		public FoundationDropdownContent(String id, IModel<String> contentModel) {
//			super(id);
//			this.contentModel = contentModel;
//			this.setOutputMarkupId(true);
//		}
//		
//		@Override
//		protected void onComponentTag(ComponentTag tag) {
//			Attribute.addAttribute(tag, "data-dropdown-content");
//			Attribute.addClass(tag, "f-dropdown");
//			Attribute.addClass(tag, "content");
//			Attribute.addAttribute(tag, "aria-hidden", true);
//			Attribute.addAttribute(tag, "tabindex", -1);
//			super.onComponentTag(tag);
//		}
//		
//		@Override
//		public void onComponentTagBody(MarkupStream markupStream,
//				ComponentTag openTag) {
//			this.replaceComponentTagBody(markupStream, openTag, contentModel.getObject());
//			super.onComponentTagBody(markupStream, openTag);
//		}
//		
//		@Override
//		protected void onDetach() {
//			contentModel.detach();
//			super.onDetach();
//		}
//	}	
}
