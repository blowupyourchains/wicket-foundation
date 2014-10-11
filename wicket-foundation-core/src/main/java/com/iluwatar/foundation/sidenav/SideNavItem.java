package com.iluwatar.foundation.sidenav;

import java.io.Serializable;

public interface SideNavItem extends Serializable {

	boolean isDivider();
	boolean isHeader();
	boolean isActive();
	String getTitle();
	
}
