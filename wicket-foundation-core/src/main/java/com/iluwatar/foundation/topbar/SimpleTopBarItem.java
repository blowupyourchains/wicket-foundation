package com.iluwatar.foundation.topbar;

import java.util.ArrayList;
import java.util.List;

public class SimpleTopBarItem implements TopBarItem {

	private static final long serialVersionUID = 1L;
	
	private String itemId;
	private String text;
	
	private List<TopBarItem> children = new ArrayList<>();

	public SimpleTopBarItem(String itemId, String text) {
		this.itemId = itemId;
		this.text = text;
	}
	
	@Override
	public String getItemId() {
		return itemId;
	}
	
	@Override
	public String getText() {
		return text;
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
