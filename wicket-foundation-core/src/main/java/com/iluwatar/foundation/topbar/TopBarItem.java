package com.iluwatar.foundation.topbar;

import java.io.Serializable;
import java.util.List;

public interface TopBarItem extends Serializable {

	String getItemId();
	String getText();
	List<TopBarItem> getChildren();
	boolean hasChildren();
	void addChild(TopBarItem item);
	
}
