package com.iluwatar.foundation.button;

import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.MarkupStream;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.util.lang.Args;

/**
 * Foundation styled Button.
 * http://foundation.zurb.com/docs/components/buttons.html
 * @author ilkka
 *
 */
public class FoundationButton extends Button {

	private static final long serialVersionUID = 1L;
	
	private IModel<ButtonOptions> optionsModel;

	public FoundationButton(String id) {
		this(id, new ButtonOptions());
	}

	public FoundationButton(String id, ButtonOptions options) {
		super(id);
		Args.notNull(options, "options");
		optionsModel = Model.of(options);
		add(new FoundationButtonBehavior(optionsModel));
	}
	
	public FoundationButton(String id, IModel<String> model) {
		super(id, model);
		optionsModel = Model.of(new ButtonOptions());
		add(new FoundationButtonBehavior(optionsModel));
	}

	public FoundationButton(String id, IModel<String> model, ButtonOptions options) {
		this(id, model, Model.of(options));
	}
	
	public FoundationButton(String id, IModel<String> model, IModel<ButtonOptions> optionsModel) {
		super(id, model);
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
