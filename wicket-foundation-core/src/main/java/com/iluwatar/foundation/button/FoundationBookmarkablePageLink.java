package com.iluwatar.foundation.button;

import org.apache.wicket.Page;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.MarkupStream;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.util.lang.Args;

/**
 * Foundation styled BookmarkablePageLink.
 * http://foundation.zurb.com/docs/components/buttons.html
 * @author ilkka
 *
 * @param <T>
 */
public class FoundationBookmarkablePageLink<T> extends BookmarkablePageLink<T> {

	private static final long serialVersionUID = 1L;
	
	private IModel<ButtonOptions> optionsModel;

	public <C extends Page> FoundationBookmarkablePageLink(String id, Class<C> pageClass) {
		this(id, pageClass, new ButtonOptions());
	}
	
	public <C extends Page> FoundationBookmarkablePageLink(String id, Class<C> pageClass, ButtonOptions options) {
		this(id, pageClass, Model.of(options));
	}

	public <C extends Page> FoundationBookmarkablePageLink(String id, Class<C> pageClass, IModel<ButtonOptions> optionsModel) {
		super(id, pageClass);
		Args.notNull(optionsModel, "optionsModel");
		this.optionsModel = optionsModel;
		add(new FoundationButtonBehavior(optionsModel));
	}
	
	public <C extends Page> FoundationBookmarkablePageLink(String id, Class<C> pageClass,
			PageParameters parameters, ButtonOptions options) {
		this(id, pageClass, parameters, Model.of(options));
	}

	public <C extends Page> FoundationBookmarkablePageLink(String id, Class<C> pageClass,
			PageParameters parameters, IModel<ButtonOptions> optionsModel) {
		super(id, pageClass, parameters);
		Args.notNull(optionsModel, "optionsModel");
		this.optionsModel = optionsModel;
		add(new FoundationButtonBehavior(optionsModel));
	}
	
	@Override
	public void onComponentTagBody(MarkupStream markupStream,
			ComponentTag openTag) {
		this.replaceComponentTagBody(markupStream, openTag, this.getDefaultModelObjectAsString());
		super.onComponentTagBody(markupStream, openTag);
	}
	
	@Override
	protected void onDetach() {
		this.optionsModel.detach();
		super.onDetach();
	}
}
