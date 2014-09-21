package com.iluwatar.foundation.topbar;

import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import com.iluwatar.foundation.component.FoundationJsPanel;
import com.iluwatar.foundation.util.Attribute;
import com.iluwatar.foundation.util.StringUtil;

public class FoundationTopBarPanel extends FoundationJsPanel {

	private static final long serialVersionUID = 1L;

	public FoundationTopBarPanel(String id) {
		this(id, new TopBarOptions());
	}
	
	public FoundationTopBarPanel(String id, TopBarOptions options) {
		this(id, Model.of(options));
	}
	
	public FoundationTopBarPanel(String id, IModel<TopBarOptions> optionsModel) {
		super(id);
		FoundationTopBarContainer topBarContainer = new FoundationTopBarContainer("topBarContainer", optionsModel);
		add(topBarContainer);
		FoundationTopBar topBar = new FoundationTopBar("topBar", optionsModel);
		topBarContainer.add(topBar);
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
