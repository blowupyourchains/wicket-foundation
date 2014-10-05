package com.iluwatar.foundation.topbar;

import java.util.List;

import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.util.ListModel;

import com.iluwatar.foundation.component.FoundationJsPanel;
import com.iluwatar.foundation.util.Attribute;
import com.iluwatar.foundation.util.StringUtil;

/**
 * The Foundation Top Bar gives you a great way to display a complex navigation bar on small, medium or large screens.
 * http://foundation.zurb.com/docs/components/topbar.html
 * @author ilkka
 *
 */
public abstract class FoundationTopBarPanel extends FoundationJsPanel {

	private static final long serialVersionUID = 1L;

	public FoundationTopBarPanel(String id, List<TopBarItem> rightItems, List<TopBarItem> leftItems) {
		this(id, new TopBarOptions(), rightItems, leftItems);
	}
	
	public FoundationTopBarPanel(String id, TopBarOptions options, List<TopBarItem> rightItems, List<TopBarItem> leftItems) {
		this(id, Model.of(options), new ListModel<>(rightItems), new ListModel<>(leftItems));
	}
	
	public FoundationTopBarPanel(String id, IModel<TopBarOptions> optionsModel, IModel<List<TopBarItem>> rightItemsModel, 
			IModel<List<TopBarItem>> leftItemsModel) {
		super(id);
		FoundationTopBarContainer topBarContainer = new FoundationTopBarContainer("topBarContainer", optionsModel);
		add(topBarContainer);
		FoundationTopBar topBar = new FoundationTopBar("topBar", optionsModel);
		topBarContainer.add(topBar);
		WebMarkupContainer titleContainer = createTitleContainer("titleContainer");
		topBar.add(titleContainer);
		topBar.add(new FoundationItemContainer("rightContainer", rightItemsModel));
		topBar.add(new FoundationItemContainer("leftContainer", leftItemsModel));
	}
	
	public abstract WebMarkupContainer createTitleContainer(String id);
	
	public abstract WebMarkupContainer createLink(String id, String itemId);
	
	private class FoundationItemContainer extends WebMarkupContainer {

		private static final long serialVersionUID = 1L;
		
		public FoundationItemContainer(String id, final IModel<List<TopBarItem>> itemsModel) {
			super(id);
			add(new RepeatingView("item") {

				private static final long serialVersionUID = 1L;

				@Override
				protected void onPopulate() {
					this.removeAll();
					for (TopBarItem item: itemsModel.getObject()) {
						
						TopBarRecursiveLinkPanel linkPanel = new TopBarRecursiveLinkPanel(newChildId(), item) {

							private static final long serialVersionUID = 1L;

							@Override
							public WebMarkupContainer createLink(String id, String itemId) {
								return FoundationTopBarPanel.this.createLink(id, itemId);
							}
						};
						add(linkPanel);
					}
				}
			});
		}
	}
	
	private static class FoundationTopBarContainer extends WebMarkupContainer {

		private static final long serialVersionUID = 1L;
		
		private IModel<TopBarOptions> optionsModel;

		public FoundationTopBarContainer(String id, IModel<TopBarOptions> optionsModel) {
			super(id);
			this.optionsModel = optionsModel;
		}
		
		@Override
		protected void onComponentTag(ComponentTag tag) {
			TopBarOptions options = optionsModel.getObject();
			if (options.isFixed()) {
				Attribute.addClass(tag, "fixed");
			}
			if (options.isContainToGrid()) {
				Attribute.addClass(tag, "contain-to-grid");
			}
			if (options.isSticky()) {
				Attribute.addClass(tag, "sticky");
			}
			super.onComponentTag(tag);
		}
		
		@Override
		protected void onDetach() {
			optionsModel.detach();
			super.onDetach();
		}
	}
	
	private static class FoundationTopBar extends WebMarkupContainer {

		private static final long serialVersionUID = 1L;
		
		private IModel<TopBarOptions> optionsModel;

		public FoundationTopBar(String id, IModel<TopBarOptions> optionsModel) {
			super(id);
			this.optionsModel = optionsModel;
		}
		
		@Override
		protected void onComponentTag(ComponentTag tag) {
			Attribute.addClass(tag, "top-bar");
			Attribute.addAttribute(tag, "data-topbar");
			Attribute.addAttribute(tag, "role", "navigation");
			TopBarOptions options = optionsModel.getObject();
			if (options.isClickable()) {
				Attribute.addDataOptions(tag, "is_hover:false");
			}
			if (!options.getStickySizes().isEmpty()) {
				for (TopBarStickySize size : options.getStickySizes()) {
					Attribute.addDataOptions(tag, "sticky_on:" + StringUtil.EnumNameToCssClassName(size.name()));
				}
			}
			super.onComponentTag(tag);
		}
		
		@Override
		protected void onDetach() {
			optionsModel.detach();
			super.onDetach();
		}
	}
}
