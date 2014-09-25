package com.iluwatar.foundation.topbar;

import java.util.Iterator;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.repeater.RepeatingView;

public abstract class TopBarRecursiveLinkPanel extends Panel {

	private static final long serialVersionUID = 1L;

	public TopBarRecursiveLinkPanel(String id, TopBarItem topBarItem) {
		super(id);
		if (!topBarItem.hasChildren()) {
			WebMarkupContainer link = createLink("link", topBarItem.getItemId());
			add(link);
			link.add(new Label("text", topBarItem.getText()));
			WebMarkupContainer dropdown = new WebMarkupContainer("dropdown");
			dropdown.setVisible(false);
			add(dropdown);
			dropdown.add(new WebMarkupContainer("item"));
		} else {
			add(new AttributeModifier("class", "has-dropdown"));
			WebMarkupContainer link = new WebMarkupContainer("link");
			add(link);
			link.add(new Label("text", topBarItem.getText()));
			WebMarkupContainer dropdown = new WebMarkupContainer("dropdown");
			add(dropdown);
			RepeatingView rv = new RepeatingView("item");
			dropdown.add(rv);
			Iterator<TopBarItem> childIterator = topBarItem.getChildren().iterator();
			while (childIterator.hasNext()) {
				final TopBarItem child = childIterator.next();
				rv.add(new TopBarRecursiveLinkPanel(rv.newChildId(), child) {

					private static final long serialVersionUID = 1L;

					@Override
					public WebMarkupContainer createLink(String id, String itemId) {
						return TopBarRecursiveLinkPanel.this.createLink(id, itemId);
					}
				});
			}
		}
	}
	
	public abstract WebMarkupContainer createLink(String id, String itemId);
}
