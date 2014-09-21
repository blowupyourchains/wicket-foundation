package com.iluwatar.foundation.topbar;

import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.WebMarkupContainer;

import com.iluwatar.foundation.component.FoundationJsPanel;
import com.iluwatar.foundation.util.Attribute;

public class FoundationTopBarPanel extends FoundationJsPanel {

	private static final long serialVersionUID = 1L;

	public FoundationTopBarPanel(String id) {
		super(id);
		FoundationTopBarContainer topBarContainer = new FoundationTopBarContainer("topBarContainer");
		add(topBarContainer);
		FoundationTopBar topBar = new FoundationTopBar("topBar");
		topBarContainer.add(topBar);
	}
	
	private static class FoundationTopBarContainer extends WebMarkupContainer {

		private static final long serialVersionUID = 1L;

		public FoundationTopBarContainer(String id) {
			super(id);
		}
	}
	
	private static class FoundationTopBar extends WebMarkupContainer {

		private static final long serialVersionUID = 1L;

		public FoundationTopBar(String id) {
			super(id);
		}
		
		@Override
		protected void onComponentTag(ComponentTag tag) {
			Attribute.addClass(tag, "top-bar");
			Attribute.addAttribute(tag, "data-topbar");
			Attribute.addAttribute(tag, "role", "navigation");
			super.onComponentTag(tag);
		}
	}
}
