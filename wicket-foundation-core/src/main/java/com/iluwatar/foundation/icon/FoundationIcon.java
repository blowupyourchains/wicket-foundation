package com.iluwatar.foundation.icon;

import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.WebMarkupContainer;

import com.iluwatar.foundation.util.Attribute;
import com.iluwatar.foundation.util.StringUtil;

public class FoundationIcon extends WebMarkupContainer {

	private static final long serialVersionUID = 1L;
	
	private FoundationIconType iconType;

	private FoundationIconSize iconSize;

	public FoundationIcon(String id, FoundationIconType iconType) {
		this(id, iconType, null);
	}

	public FoundationIcon(String id, FoundationIconType iconType, FoundationIconSize iconSize) {
		super(id);
		this.iconType = iconType;
		this.iconSize = iconSize;
	}
	
	@Override
	protected void onComponentTag(ComponentTag tag) {
		final String prefix = "fi-";
		Attribute.addClass(tag, prefix + StringUtil.EnumNameToCssClassName(iconType.name()));
		if (iconSize != null) {
			Attribute.addClass(tag, StringUtil.EnumNameToCssClassName(iconSize.name()));
		}
		super.onComponentTag(tag);
	}
}
