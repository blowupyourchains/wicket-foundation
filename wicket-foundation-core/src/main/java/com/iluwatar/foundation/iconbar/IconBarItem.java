package com.iluwatar.foundation.iconbar;

import org.apache.wicket.request.resource.ResourceReference;

import com.iluwatar.foundation.icon.FoundationIconType;

public interface IconBarItem {

	ResourceReference getImageResourceReference();
	FoundationIconType getIconType();
	String getLabel();
	
}
