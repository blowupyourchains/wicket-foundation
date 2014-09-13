package com.iluwatar;

import java.util.Arrays;
import java.util.List;

import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import com.iluwatar.foundation.dropdown.DropdownOptions;
import com.iluwatar.foundation.dropdown.DropdownType;
import com.iluwatar.foundation.dropdown.FoundationContentDropdown;
import com.iluwatar.foundation.dropdown.FoundationDropdown;

public class DropdownsPage extends BasePage {

	private static final long serialVersionUID = 1L;

	public DropdownsPage(PageParameters params) {
		super(params);
		
		List<String> links = Arrays.asList("First link", "Second link", "Third link");
		FoundationDropdown basicDropdown = new FoundationDropdown("basicDropdown", "Has Dropdown", new DropdownOptions(), links) {
				@Override
				protected WebMarkupContainer createDropdownLink(int idx,
						String id) {
					return new Link<String>(id) {
						@Override
						public void onClick() {}
					};
				}
		};
		add(basicDropdown);
		
		final String content = "<p>Some text that people will think is awesome! Some text that people will think is awesome! Some text that people will think is awesome!</p>";
		FoundationContentDropdown basicContentDropdown = new FoundationContentDropdown("basicContentDropdown", "Has Content Dropdown", new DropdownOptions(), content);
		add(basicContentDropdown);
		
		List<String> advancedLinks = Arrays.asList("This is a link", "This is another", "Yet another");
		FoundationDropdown advancedDropdownLink = new FoundationDropdown("advancedDropdownLink", "Link Dropdown", new DropdownOptions(DropdownType.DROPDOWNLINK), advancedLinks) {
				@Override
				protected WebMarkupContainer createDropdownLink(int idx,
						String id) {
					return new Link<String>(id) {
						@Override
						public void onClick() {}
					};
				}
		};
		add(advancedDropdownLink);		
	}
}
