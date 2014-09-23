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

public abstract class FoundationTopBarPanel extends FoundationJsPanel {

	private static final long serialVersionUID = 1L;

	public FoundationTopBarPanel(String id, List<TopBarItem> rightItems, List<TopBarItem> leftItems) {
		this(id, new TopBarOptions(), rightItems, leftItems);
	}
	
	public FoundationTopBarPanel(String id, TopBarOptions options, List<TopBarItem> rightItems, List<TopBarItem> leftItems) {
		this(id, Model.of(options), new ListModel<>(rightItems), new ListModel<>(leftItems));
	}
	
	public FoundationTopBarPanel(String id, IModel<TopBarOptions> optionsModel, IModel<List<TopBarItem>> rightItems, IModel<List<TopBarItem>> leftItems) {
		super(id);
		FoundationTopBarContainer topBarContainer = new FoundationTopBarContainer("topBarContainer", optionsModel);
		add(topBarContainer);
		FoundationTopBar topBar = new FoundationTopBar("topBar", optionsModel);
		topBarContainer.add(topBar);
		WebMarkupContainer titleContainer = createTitleContainer("titleContainer");
		topBar.add(titleContainer);
		topBar.add(new FoundationItemContainer("rightContainer"));
		topBar.add(new FoundationItemContainer("leftContainer"));
	}
	
	public abstract WebMarkupContainer createTitleContainer(String id);
	
	private static class FoundationItemContainer extends WebMarkupContainer {

		private static final long serialVersionUID = 1L;
		
		public FoundationItemContainer(String id) {
			super(id);
			add(new RepeatingView("item"));
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
