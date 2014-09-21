package com.iluwatar.foundation.topbar;

import org.apache.wicket.markup.html.WebMarkupContainer;

import com.iluwatar.foundation.component.FoundationJsPanel;

public class FoundationTopBarPanel extends FoundationJsPanel {

	private static final long serialVersionUID = 1L;

	public FoundationTopBarPanel(String id) {
		super(id);
		WebMarkupContainer topBarContainer = new WebMarkupContainer("topBarContainer");
		add(topBarContainer);
		WebMarkupContainer topBar = new WebMarkupContainer("topBar");
		topBarContainer.add(topBar);
	}
}
