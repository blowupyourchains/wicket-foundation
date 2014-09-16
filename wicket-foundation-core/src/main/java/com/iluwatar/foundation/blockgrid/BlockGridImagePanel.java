package com.iluwatar.foundation.blockgrid;

import org.apache.wicket.markup.html.image.Image;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.request.resource.PackageResourceReference;

public class BlockGridImagePanel extends Panel {

	private static final long serialVersionUID = 1L;

	public BlockGridImagePanel(String id, PackageResourceReference resourceReference) {
		super(id);
		add(new Image("img", resourceReference));
	}
}
