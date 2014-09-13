package com.iluwatar.foundation.dropdown;

import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.MarkupStream;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.util.lang.Args;

import com.iluwatar.foundation.component.FoundationJsPanel;
import com.iluwatar.foundation.util.Attribute;
import com.iluwatar.foundation.util.StringUtil;

public abstract class FoundationDropdownBase extends FoundationJsPanel {

	private static final long serialVersionUID = 1L;
	
	private IModel<String> titleModel;
	private IModel<DropdownOptions> optionsModel;

	public FoundationDropdownBase(String id, String title, DropdownOptions options) {
		this(id, Model.of(title), Model.of(options));
	}
	
	public FoundationDropdownBase(String id, IModel<String> titleModel, IModel<DropdownOptions> optionsModel) {
		super(id);
		this.titleModel = titleModel;
		this.optionsModel = optionsModel;
	}
	
	@Override
	protected void onInitialize() {
		String markupId = getContainerMarkupId();
		FoundationDropdownLink btn = new FoundationDropdownLink("btn", markupId, titleModel, optionsModel);
		add(btn);
		super.onInitialize();
	}
	
	protected abstract String getContainerMarkupId();
	
	@Override
	protected void onDetach() {
		titleModel.detach();
		optionsModel.detach();
		super.onDetach();
	}
	
	private static class FoundationDropdownLink extends WebMarkupContainer {

		private static final long serialVersionUID = 1L;
		
		private String containerId;
		private IModel<String> titleModel;
		private IModel<DropdownOptions> optionsModel;

		public FoundationDropdownLink(String id, String containerId, IModel<String> titleModel, IModel<DropdownOptions> optionsModel) {
			super(id);
			Args.notNull(containerId, "containerId");
			Args.notNull(titleModel, "titleModel");
			Args.notNull(optionsModel, "optionsModel");
			this.containerId = containerId;
			this.titleModel = titleModel;
			this.optionsModel = optionsModel;
		}
		
		@Override
		protected void onComponentTag(ComponentTag tag) {
			DropdownOptions options = optionsModel.getObject();
			DropdownType type = options.getType();
			if (type == null || type.equals(DropdownType.DROPDOWN) || type.equals(DropdownType.DROPDOWNLINK) || type.equals(DropdownType.DROPDOWNCONTENT)) {
				tag.setName("a");
			}
			Attribute.addAttribute(tag, "data-dropdown", containerId);
			Attribute.addAttribute(tag, "aria-controls", containerId);
			Attribute.addAttribute(tag, "aria-expanded", false);
			if (type != null && (type.equals(DropdownType.DROPDOWNLINK) || type.equals(DropdownType.DROPDOWNBUTTON))) {
				Attribute.addClass(tag, "button");
			}
			if (type != null && type.equals(DropdownType.DROPDOWNBUTTON)) {
				Attribute.addClass(tag, "dropdown");
			}
			if (options.getColor() != null) {
				Attribute.addClass(tag, StringUtil.EnumNameToCssClassName(options.getColor().name()));
			}
			if (options.getRadius() != null) {
				Attribute.addClass(tag, StringUtil.EnumNameToCssClassName(options.getRadius().name()));
			}
			if (options.getSize() != null) {
				Attribute.addClass(tag, StringUtil.EnumNameToCssClassName(options.getSize().name()));
			}
			if (options.getExpansion() != null) {
				Attribute.addClass(tag, StringUtil.EnumNameToCssClassName(options.getExpansion().name()));
			}
			if (options.getListAlignment() != null) {
				String partial = StringUtil.EnumNameToCssClassName(options.getListAlignment().name());
				Attribute.addAttribute(tag, "data-options", "align: " + partial);
			}
			if (options.getHover() != null) {
				Attribute.addAttribute(tag, "data-options", "is_hover: true");
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
	
//	private class FoundationDropdownContainer extends WebMarkupContainer {
//
//		private static final long serialVersionUID = 1L;
//		
//		private IModel<DropdownOptions> optionsModel;
//
//		public FoundationDropdownContainer(String id, IModel<List<String>> linkTitleModels, IModel<DropdownOptions> optionsModel) {
//			super(id);
//			Args.notNull(optionsModel, "optionsModel");
//			this.optionsModel = optionsModel;
//			this.setOutputMarkupId(true);
//			
//			ListView<String> lv = new ListView<String>("item", linkTitleModels) {
//
//				private static final long serialVersionUID = 1L;
//
//				@Override
//				protected void populateItem(ListItem<String> item) {
//					WebMarkupContainer link = FoundationDropdownBase.this.createDropdownLink(item.getIndex(), "link");
//					item.add(link);
//					link.add(new Label("body", item.getModel()));
//				}
//			};
//			add(lv);
//		}
//		
//		@Override
//		protected void onComponentTag(ComponentTag tag) {
//			Attribute.addAttribute(tag, "data-dropdown-content");
//			Attribute.addClass(tag, "f-dropdown");
//			Attribute.addAttribute(tag, "aria-hidden", true);
//			Attribute.addAttribute(tag, "tabindex", -1);
//			DropdownOptions options = optionsModel.getObject();
//			if (options.getListStyle() != null) {
//				Attribute.addClass(tag, StringUtil.EnumNameToCssClassName(options.getListStyle().name()));
//			}
//			super.onComponentTag(tag);
//		}
//		
//		@Override
//		protected void onDetach() {
//			optionsModel.detach();
//			super.onDetach();
//		}
//	}
//	
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