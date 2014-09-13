package com.iluwatar;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import com.iluwatar.foundation.dropdown.DropdownOptions;
import com.iluwatar.foundation.dropdown.DropdownType;
import com.iluwatar.foundation.dropdown.FoundationDropdown;

public class DropdownButtonsPage extends BasePage {

	private static final long serialVersionUID = 1L;

	public DropdownButtonsPage(PageParameters params) {
		super(params);
		
		List<String> links = Arrays.asList("This is a link", "This is another", "Yet another");
		add(createDropdownButton("basic", "Dropdown Button", links, new DropdownOptions(DropdownType.DROPDOWNBUTTON)));
	}
	
	private FoundationDropdown createDropdownButton(String id, String title, List<String> links, DropdownOptions options) {
		return new FoundationDropdown(id, title, options, Collections.unmodifiableList(links)) {
				@Override
				protected WebMarkupContainer createDropdownLink(int idx, String id) {
					return new Link<String>(id) {
						@Override
						public void onClick() {}
					};
				}
		};
	}
}
