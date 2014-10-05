package com.iluwatar.foundation.border;

import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.border.Border;
import org.apache.wicket.model.IModel;

import com.iluwatar.foundation.Foundation;

/**
 * Base class for Borders that includes Foundation CSS.
 * @author ilkka
 *
 */
public class FoundationBaseBorder extends Border {

	private static final long serialVersionUID = 1L;

	public FoundationBaseBorder(String id) {
		super(id);
	}
	
	public FoundationBaseBorder(String id, IModel<?> model) {
		super(id, model);
	}

	@Override
	public void renderHead(IHeaderResponse response) {
		super.renderHead(response);
		response.render(CssHeaderItem.forReference(Foundation.getFoundationCssReference()));
	}
}
