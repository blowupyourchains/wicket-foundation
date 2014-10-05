package com.iluwatar.foundation.button;

import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.MarkupStream;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.util.lang.Args;

/**
 * Foundation styles AjaxLink.
 * http://foundation.zurb.com/docs/components/buttons.html
 * @author ilkka
 *
 * @param <T>
 */
public abstract class FoundationAjaxLink<T> extends AjaxLink<T> {

	private static final long serialVersionUID = 1L;

	private IModel<ButtonOptions> optionsModel;
	
	public FoundationAjaxLink(String id) {
		this(id, new ButtonOptions());
	}

	public FoundationAjaxLink(String id, ButtonOptions options) {
		super(id);
		Args.notNull(options, "options");
		optionsModel = Model.of(options);
		add(new FoundationButtonBehavior(optionsModel));
	}
	
	public FoundationAjaxLink(String id, IModel<T> model) {
		this(id, model, new ButtonOptions());
	}

	public FoundationAjaxLink(String id, IModel<T> model, ButtonOptions options) {
		this(id, model, Model.of(options));
	}

	public FoundationAjaxLink(String id, IModel<T> model, IModel<ButtonOptions> optionsModel) {
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
