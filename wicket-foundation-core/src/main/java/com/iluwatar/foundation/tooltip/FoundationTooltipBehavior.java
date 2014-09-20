package com.iluwatar.foundation.tooltip;

import org.apache.wicket.Component;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.util.lang.Args;

import com.iluwatar.foundation.behavior.FoundationJsBehavior;
import com.iluwatar.foundation.util.Attribute;
import com.iluwatar.foundation.util.StringUtil;

public class FoundationTooltipBehavior extends FoundationJsBehavior {

	private static final long serialVersionUID = 1L;
	
	private IModel<String> titleModel;
	private IModel<TooltipOptions> optionsModel;

	public FoundationTooltipBehavior(String title) {
		this(title, new TooltipOptions());
	}
	
	public FoundationTooltipBehavior(String title, TooltipOptions options) {
		this(Model.of(title), Model.of(options));
	}
	
	public FoundationTooltipBehavior(IModel<String> titleModel, IModel<TooltipOptions> optionsModel) {
		Args.notNull(titleModel, "titleModel");
		Args.notNull(optionsModel, "optionsModel");
		this.titleModel = titleModel;
		this.optionsModel = optionsModel;
	}	

	@Override
	public void onComponentTag(Component component, ComponentTag tag) {
		Attribute.addAttribute(tag, "data-tooltip");
		Attribute.addAttribute(tag, "aria-haspopup", true);
		Attribute.addClass(tag, "has-tip");
		Attribute.addAttribute(tag, "title", titleModel.getObject());
		TooltipOptions options = optionsModel.getObject();
		if (options.isDisableForTouch()) {
			Attribute.addAttribute(tag, "data-options", "disable_for_touch: true");
		}
		if (options.getPosition() != null) {
			Attribute.addClass(tag, StringUtil.EnumNameToCssClassName(options.getPosition().name()));
		}
		if (options.getRadius() != null) {
			Attribute.addClass(tag, StringUtil.EnumNameToCssClassName(options.getRadius().name()));
		}
		if (options.getVisibility() != null) {
			String value = "show_on: " + StringUtil.EnumNameToCssClassName(options.getVisibility().name());
			Attribute.addAttribute(tag, "data-options", value);
		}
		super.onComponentTag(component, tag);
	}
	
	@Override
	public void detach(Component component) {
		titleModel.detach();
		optionsModel.detach();
		super.detach(component);
	}
}
