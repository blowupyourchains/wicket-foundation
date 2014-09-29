package com.iluwatar.foundation.iconbar;

import org.apache.wicket.request.resource.ResourceReference;

public interface IconBarItem {

	ResourceReference getImageResourceReference();
	String getFontId();
	String getLabel();
	
}
