package com.iluwatar.foundation.revealmodal;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.MarkupStream;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;

import com.iluwatar.foundation.component.FoundationJsPanel;
import com.iluwatar.foundation.util.Attribute;

public class FoundationRevealModal extends FoundationJsPanel {

	private static final long serialVersionUID = 1L;

	public FoundationRevealModal(String id, IModel<String> linkTextModel, IModel<String> contentModel) {
		super(id);
		final RevealModalContent revealModalContent = new RevealModalContent("modalContent", contentModel);
		add(revealModalContent);
		AjaxLink<Void> openLink = new AjaxLink<Void>("openLink") {

			private static final long serialVersionUID = 1L;

			@Override
			protected void onComponentTag(ComponentTag tag) {
				Attribute.addAttribute(tag, "data-reveal-id", revealModalContent.getMarkupId());
				super.onComponentTag(tag);
			}
			
			@Override
			public void onClick(AjaxRequestTarget arg0) {
			}
		};
		add(openLink);
		openLink.add(new Label("openLinkText", linkTextModel));
	}
	
	private static class RevealModalContent extends WebMarkupContainer {

		private static final long serialVersionUID = 1L;

		public RevealModalContent(String id, IModel<String> contentModel) {
			super(id, contentModel);
			this.setEscapeModelStrings(false);
		}
		
		@Override
		protected void onComponentTag(ComponentTag tag) {
			Attribute.addClass(tag, "reveal-modal");
			Attribute.addAttribute(tag, "data-reveal");
			super.onComponentTag(tag);
		}
		
		@Override
		public void onComponentTagBody(MarkupStream markupStream,
				ComponentTag openTag) {
			this.replaceComponentTagBody(markupStream, openTag, getDefaultModelObjectAsString());
			super.onComponentTagBody(markupStream, openTag);
		}
	}
}
