package com.iluwatar.foundation.blockgrid;

import org.apache.wicket.markup.html.image.Image;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.request.resource.PackageResourceReference;

/**
 * Image content item for the FoundationBlockGrid component.
 * @author ilkka
 *
 */
public class BlockGridImageContent extends Panel {

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * @param id - Wicket id.
	 * @param resourceReference - Resource reference for the image.
	 */
	public BlockGridImageContent(String id, PackageResourceReference resourceReference) {
		super(id);
		add(new Image("img", resourceReference));
	}
}
