package com.iluwatar.foundation.icon;

import org.apache.wicket.markup.html.basic.Label;

import com.iluwatar.foundation.component.FoundationBasePanel;

public class FoundationIconAndTextPanel extends FoundationBasePanel {

	private static final long serialVersionUID = 1L;

	public FoundationIconAndTextPanel(String id, FoundationIconType icon, String text) {
		super(id);
		add(new FoundationIcon("icon", icon));
		add(new Label("text", text));
	}
}
