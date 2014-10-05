package com.iluwatar.foundation.button;

import org.apache.wicket.ajax.markup.html.form.AjaxSubmitLink;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.MarkupStream;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.util.lang.Args;

/**
 * Foundation styles AjaxSubmitLink.
 * http://foundation.zurb.com/docs/components/buttons.html
 * @author ilkka
 *
 */
public class FoundationAjaxSubmitLink extends AjaxSubmitLink {

	private static final long serialVersionUID = 1L;

	private IModel<ButtonOptions> optionsModel;

	public FoundationAjaxSubmitLink(String id) {
		this(id, new ButtonOptions());
	}
	
	public FoundationAjaxSubmitLink(String id, ButtonOptions options) {
		this(id, Model.of(options));
	}

	public FoundationAjaxSubmitLink(String id, IModel<ButtonOptions> optionsModel) {
		super(id);
		Args.notNull(optionsModel, "optionsModel");
		this.optionsModel = optionsModel;
		add(new FoundationButtonBehavior(this.optionsModel));
	}
	
	public FoundationAjaxSubmitLink(String id, Form<?> form, ButtonOptions options) {
		this(id, form, Model.of(options));
	}

	public FoundationAjaxSubmitLink(String id, Form<?> form, IModel<ButtonOptions> optionsModel) {
		super(id, form);
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
