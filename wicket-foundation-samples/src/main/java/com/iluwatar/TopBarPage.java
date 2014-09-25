package com.iluwatar;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import com.iluwatar.foundation.topbar.FoundationTopBarPanel;
import com.iluwatar.foundation.topbar.FoundationTopBarTitlePanel;
import com.iluwatar.foundation.topbar.SimpleTopBarItem;
import com.iluwatar.foundation.topbar.TopBarItem;
import com.iluwatar.foundation.topbar.TopBarMenuLayout;

public class TopBarPage extends BasePage {

	private static final long serialVersionUID = 1L;

	public TopBarPage(PageParameters params) {
		super(params);
		
		List<TopBarItem> rightItems = new ArrayList<>();
		rightItems.add(new SimpleTopBarItem("rightButtonActive", "Right Button Active"));
		SimpleTopBarItem rightButtonDropdown = new SimpleTopBarItem("rightButtonDropdown", "Right Button Dropdown");
		rightButtonDropdown.addChild(new SimpleTopBarItem("firstLinkInDropdown", "First link in dropdown"));
		rightButtonDropdown.addChild(new SimpleTopBarItem("activeLinkInDropdown", "Active link in dropdown"));
		rightItems.add(rightButtonDropdown);
		
		List<TopBarItem> leftItems = new ArrayList<>();
		leftItems.add(new SimpleTopBarItem("leftButton", "Left Button"));
		
		add(new FoundationTopBarPanel("basic", rightItems, leftItems) {

			@Override
			public WebMarkupContainer createTitleContainer(String id) {
				return new FoundationTopBarTitlePanel(id, Model.of("Home"), Model.of(TopBarMenuLayout.TITLE_AND_ICON), Model.of("Menu")) {
					@Override
					public WebMarkupContainer createTitleLink(String id) {
						return new Link(id) {
							@Override
							public void onClick() {
							}
						};
					}
				};
			}

			@Override
			public WebMarkupContainer createLink(String id, final String itemId) {
				return new AjaxLink<Void>(id) {

					@Override
					public void onClick(AjaxRequestTarget target) {
						target.appendJavaScript(String.format("alert('%s');", itemId));
					}
					
				};
			}
		});
	}
}
