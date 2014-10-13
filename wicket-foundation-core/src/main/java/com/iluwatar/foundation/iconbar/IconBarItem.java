package com.iluwatar.foundation.iconbar;

import org.apache.wicket.request.resource.ResourceReference;

import com.iluwatar.foundation.icon.FoundationIconType;

/**
 * Interface for the icon bar item.
 * @author ilkka
 *
 */
public interface IconBarItem {

	ResourceReference getImageResourceReference();
	FoundationIconType getIconType();
	String getLabel();
	
}
