package com.iluwatar.foundation.dropdown;

import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.MarkupStream;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import com.iluwatar.foundation.util.Attribute;

public class FoundationContentDropdown extends FoundationDropdownBase {

	private static final long serialVersionUID = 1L;

	public FoundationContentDropdown(String id, String title, DropdownOptions options, String content) {
		this(id, Model.of(title), Model.of(options), Model.of(content));
	}
	
	public FoundationContentDropdown(String id, IModel<String> titleModel, IModel<DropdownOptions> optionsModel, IModel<String> contentModel) {
		super(id, titleModel, optionsModel);
		FoundationDropdownContent content = new FoundationDropdownContent("content", contentModel);
		add(content);
		DropdownOptions options = optionsModel.getObject().setType(DropdownType.DROPDOWNCONTENT);
		optionsModel.setObject(options);
	}

	@Override
	protected String getContainerMarkupId() {
		return this.get("content").getMarkupId();
	}
	
	private class FoundationDropdownContent extends WebMarkupContainer {

		private static final long serialVersionUID = 1L;
		
		private IModel<String> contentModel;
		
		public FoundationDropdownContent(String id, IModel<String> contentModel) {
			super(id);
			this.contentModel = contentModel;
			this.setOutputMarkupId(true);
		}
		
		@Override
		protected void onComponentTag(ComponentTag tag) {
			Attribute.addAttribute(tag, "data-dropdown-content");
			Attribute.addClass(tag, "f-dropdown");
			Attribute.addClass(tag, "content");
			Attribute.addAttribute(tag, "aria-hidden", true);
			Attribute.addAttribute(tag, "tabindex", -1);
			super.onComponentTag(tag);
		}
		
		@Override
		public void onComponentTagBody(MarkupStream markupStream,
				ComponentTag openTag) {
			this.replaceComponentTagBody(markupStream, openTag, contentModel.getObject());
			super.onComponentTagBody(markupStream, openTag);
		}
		
		@Override
		protected void onDetach() {
			contentModel.detach();
			super.onDetach();
		}
	}	
}
