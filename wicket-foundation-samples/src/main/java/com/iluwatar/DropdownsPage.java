package com.iluwatar;

import java.util.Arrays;
import java.util.List;

import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import com.iluwatar.foundation.dropdown.DropdownOptions;
import com.iluwatar.foundation.dropdown.FoundationDropdown;

public class DropdownsPage extends BasePage {

	private static final long serialVersionUID = 1L;

	public DropdownsPage(PageParameters params) {
		super(params);
		List<String> links = Arrays.asList("First link", "Second link", "Third link");
		FoundationDropdown basic = new FoundationDropdown("basic", "Dropdown Button", new DropdownOptions(), links) {

				@Override
				protected WebMarkupContainer createDropdownLink(int idx,
						String id) {
					return new Link<String>(id) {
						@Override
						public void onClick() {}
					};
				}
			
		};
		add(basic);
	}
}
