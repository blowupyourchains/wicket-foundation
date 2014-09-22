package com.iluwatar.foundation.topbar;

import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;

import com.iluwatar.foundation.component.FoundationBasePanel;
import com.iluwatar.foundation.util.Attribute;

public abstract class FoundationTopBarTitlePanel extends FoundationBasePanel {

	private static final long serialVersionUID = 1L;

	public FoundationTopBarTitlePanel(String id, IModel<String> titleModel, 
			IModel<TopBarMenuLayout> menuLayoutModel, IModel<String> menuTitleModel) {
		super(id);
		WebMarkupContainer link = createTitleLink("titleLink");
		add(link);
		link.add(new Label("titleLabel", titleModel));
		add(new FoundationTopBarMenuContainer("menuContainer", menuLayoutModel, menuTitleModel));
	}
	
	abstract WebMarkupContainer createTitleLink(String id);
	
	private static class FoundationTopBarMenuContainer extends WebMarkupContainer {

		private static final long serialVersionUID = 1L;
		
		private IModel<TopBarMenuLayout> menuLayoutModel;

		public FoundationTopBarMenuContainer(String id, IModel<TopBarMenuLayout> menuLayoutModel, 
				IModel<String> menuTitleModel) {
			super(id);
			this.menuLayoutModel = menuLayoutModel;
			Label menuTitle = new Label("menuTitle", menuTitleModel);
			add(menuTitle);
			TopBarMenuLayout layout = menuLayoutModel.getObject();
			if (!layout.equals(TopBarMenuLayout.TITLE) && !layout.equals(TopBarMenuLayout.TITLE_AND_ICON)) {
				menuTitle.setVisible(false);
			}
		}

		@Override
		protected void onComponentTag(ComponentTag tag) {
			TopBarMenuLayout layout = menuLayoutModel.getObject();
			Attribute.addClass(tag, "toggle-topbar");
			if (layout.equals(TopBarMenuLayout.ICON) || layout.equals(TopBarMenuLayout.TITLE_AND_ICON)) {
				Attribute.addClass(tag, "menu-icon");
			}
			super.onComponentTag(tag);
		}
		
		@Override
		protected void onDetach() {
			menuLayoutModel.detach();
			super.onDetach();
		}
	}
}
