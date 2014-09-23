package com.iluwatar.foundation.topbar;

import java.util.ArrayList;
import java.util.List;

public class SimpleTopBarItem implements TopBarItem {

	private static final long serialVersionUID = 1L;
	
	private String itemId;
	
	private List<TopBarItem> children = new ArrayList<>();

	public SimpleTopBarItem(String itemId) {
		this.itemId = itemId;
	}
	
	@Override
	public String getItemId() {
		return itemId;
	}

	@Override
	public List<TopBarItem> getChildren() {
		return children;
	}

	@Override
	public boolean hasChildren() {
		return children.size() > 0;
	}

	@Override
	public void addChild(TopBarItem item) {
		children.add(item);
	}
}
