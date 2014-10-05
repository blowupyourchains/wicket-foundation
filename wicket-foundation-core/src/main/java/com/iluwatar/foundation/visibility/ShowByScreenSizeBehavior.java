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
public class ShowByScreenSizeBehavior extends FoundationBaseBehavior {

	private static final long serialVersionUID = 1L;
	
	public enum ShowByScreenSizeType { 
		SHOW_FOR_SMALL_ONLY,
		SHOW_FOR_MEDIUM_UP,
		SHOW_FOR_MEDIUM_ONLY,
		SHOW_FOR_LARGE_UP,
		SHOW_FOR_LARGE_ONLY,
		SHOW_FOR_XLARGE_UP,
		SHOW_FOR_XLARGE_ONLY,
		SHOW_FOR_XXLARGE_UP };
	
	private IModel<ShowByScreenSizeType> showTypeModel;

	public ShowByScreenSizeBehavior(IModel<ShowByScreenSizeType> showTypeModel) {
		this.showTypeModel = showTypeModel;
	}
	
	@Override
	public void onComponentTag(Component component, ComponentTag tag) {
		super.onComponentTag(component, tag);
		Attribute.addClass(tag, StringUtil.EnumNameToCssClassName(showTypeModel.getObject().name()));
	}

	@Override
	public void detach(Component component) {
		if (showTypeModel != null) {
			showTypeModel.detach();
		}
		super.detach(component);
	}
}
