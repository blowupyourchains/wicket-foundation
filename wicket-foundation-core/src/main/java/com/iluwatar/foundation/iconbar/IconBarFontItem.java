package com.iluwatar.foundation.iconbar;

import org.apache.wicket.request.resource.ResourceReference;

import com.iluwatar.foundation.icon.FoundationIconType;

public class IconBarFontItem implements IconBarItem {

	private String text;
	private FoundationIconType iconType;

	public IconBarFontItem(FoundationIconType iconType, String text) {
		this.iconType = iconType;
		this.text = text;
	}
	
	@Override
	public ResourceReference getImageResourceReference() {
		return null;
	}

	@Override
	public String getLabel() {
		return text;
	}

	@Override
	public FoundationIconType getIconType() {
		return iconType;
	}
}
