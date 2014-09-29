package com.iluwatar.foundation.iconbar;

import org.apache.wicket.request.resource.ResourceReference;

public class IconBarFontItem implements IconBarItem {

	private String fontId;
	private String text;

	public IconBarFontItem(String fontId, String text) {
		this.fontId = fontId;
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
	public String getFontId() {
		return fontId;
	}
}
