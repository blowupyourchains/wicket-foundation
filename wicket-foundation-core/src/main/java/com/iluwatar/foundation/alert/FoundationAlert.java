package com.iluwatar.foundation.alert;

import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.util.lang.Args;

import com.iluwatar.foundation.component.FoundationJsPanel;
import com.iluwatar.foundation.util.Attribute;
import com.iluwatar.foundation.util.StringUtil;

public class FoundationAlert extends FoundationJsPanel {

	private static final long serialVersionUID = 1L;
	private IModel<AlertOptions> optionsModel;

	public FoundationAlert(String id, IModel<String> titleModel) {
		this(id, titleModel, new AlertOptions());
	}
	
	public FoundationAlert(String id, IModel<String> titleModel, AlertOptions options) {
		this(id, titleModel, Model.of(options));
	}
	
	public FoundationAlert(String id, IModel<String> titleModel, IModel<AlertOptions> optionsModel) {
		super(id);
		Args.notNull(titleModel, "titleModel");
		add(new Label("body", titleModel));
		Args.notNull(optionsModel, "optionsModel");
		this.optionsModel = optionsModel;
	}
	
	@Override
	protected void onComponentTag(ComponentTag tag) {
		Attribute.addAttribute(tag, FoundationAlertClassNames.DATA_ALERT);
		Attribute.setClass(tag, FoundationAlertClassNames.ALERT);
		AlertOptions options = optionsModel.getObject();
		if (options.getColor() != null) {
			Attribute.addClass(tag, StringUtil.EnumNameToCssClassName(options.getColor().name()));
		}
		if (options.getRadius() != null) {
			Attribute.addClass(tag, StringUtil.EnumNameToCssClassName(options.getRadius().name()));
		}
		super.onComponentTag(tag);
	}
	
	@Override
	protected void onDetach() {
		optionsModel.detach();
		super.onDetach();
	}
}
