package com.iluwatar.foundation.visibility;

import org.apache.wicket.Component;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.model.IModel;

import com.iluwatar.foundation.behavior.FoundationBaseBehavior;
import com.iluwatar.foundation.util.Attribute;
import com.iluwatar.foundation.util.StringUtil;

/**
 * Visibility classes let you show or hide elements based on screen size or device orientation.
 * http://foundation.zurb.com/docs/components/visibility.html
 * @author ilkka
 *
 */
public class HideByScreenSizeBehavior extends FoundationBaseBehavior {

	private static final long serialVersionUID = 1L;
	
	public enum HideByScreenSizeType { 
		HIDE_FOR_SMALL_ONLY,
		HIDE_FOR_MEDIUM_UP,
		HIDE_FOR_MEDIUM_ONLY,
		HIDE_FOR_LARGE_UP,
		HIDE_FOR_LARGE_ONLY,
		HIDE_FOR_XLARGE_UP,
		HIDE_FOR_XLARGE_ONLY,
		HIDE_FOR_XXLARGE_UP };
	
	private IModel<HideByScreenSizeType> hideTypeModel;

	public HideByScreenSizeBehavior(IModel<HideByScreenSizeType> hideTypeModel) {
		this.hideTypeModel = hideTypeModel;
	}
	
	@Override
	public void onComponentTag(Component component, ComponentTag tag) {
		super.onComponentTag(component, tag);
		Attribute.addClass(tag, StringUtil.EnumNameToCssClassName(hideTypeModel.getObject().name()));
	}

	@Override
	public void detach(Component component) {
		if (hideTypeModel != null) {
			hideTypeModel.detach();
		}
		super.detach(component);
	}
}
