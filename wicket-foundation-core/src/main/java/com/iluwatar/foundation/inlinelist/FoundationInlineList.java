package com.iluwatar.foundation.inlinelist;

import java.util.List;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.AbstractLink;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;

import com.iluwatar.foundation.component.FoundationBasePanel;

/**
 * This simple construct creates a horizontal list of links, like in a footer.
 * http://foundation.zurb.com/docs/components/inline_lists.html
 * @author ilkka
 *
 */
public abstract class FoundationInlineList extends FoundationBasePanel {

	private static final long serialVersionUID = 1L;

	public FoundationInlineList(String id, List<String> titles) {
		super(id);
		add(new ListView<String>("item", titles) {

			private static final long serialVersionUID = 1L;

			@Override
			protected void populateItem(ListItem<String> item) {
				AbstractLink link = createLink("link", item.getIndex());
				item.add(link);
				link.add(new Label("text", item.getModelObject()));
			}
			
		});
	}
	
	public abstract AbstractLink createLink(String id, int idx);
}
