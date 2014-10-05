package com.iluwatar.foundation.button;

import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.MarkupStream;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.util.lang.Args;

/**
 * Foundation styled Link.
 * http://foundation.zurb.com/docs/components/buttons.html
 * @author ilkka
 *
 * @param <T>
 */
public abstract class FoundationLink<T> extends Link<T> {

	private static final long serialVersionUID = 1L;

	private IModel<ButtonOptions> optionsModel;
	
	public FoundationLink(String id) {
		this(id, new ButtonOptions());
	}

	public FoundationLink(String id, ButtonOptions options) {
		super(id);
		Args.notNull(options, "options");
		optionsModel = Model.of(options);
		add(new FoundationButtonBehavior(optionsModel));
	}
	
	public FoundationLink(String id, IModel<T> model) {
		this(id, model, new ButtonOptions());
	}

	public FoundationLink(String id, IModel<T> model, ButtonOptions options) {
		this(id, model, Model.of(options));
	}

	public FoundationLink(String id, IModel<T> model, IModel<ButtonOptions> optionsModel) {
		super(id, model);
		Args.notNull(optionsModel, "optionsModel");
		this.optionsModel = optionsModel;
		add(new FoundationButtonBehavior(this.optionsModel));
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
