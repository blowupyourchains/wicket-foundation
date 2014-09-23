package com.iluwatar.foundation.topbar;

import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.panel.Panel;

public abstract class FoundationTopBarLinkPanel extends Panel {

	private static final long serialVersionUID = 1L;

	public FoundationTopBarLinkPanel(String id) {
		super(id);
		add(createLink("link"));
	}
	
	public abstract WebMarkupContainer createLink(String id);
}
