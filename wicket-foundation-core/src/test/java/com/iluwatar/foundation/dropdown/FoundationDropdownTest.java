package com.iluwatar.foundation.dropdown;

import java.util.Arrays;

import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.util.tester.WicketTester;
import org.junit.Test;

public class FoundationDropdownTest {

	@Test
	public void renderBasicTest() { 
		WicketTester tester = new WicketTester();
		FoundationDropdown dropdown = new FoundationDropdown("id", "dropdown", new DropdownOptions(), Arrays.asList("foo", "bar", "baz")) {

			@Override
			protected WebMarkupContainer createDropdownLink(int idx, String id) {
				return new Link<String>(id) {
					@Override
					public void onClick() {}
				};
			}
			
		};
		tester.startComponentInPage(dropdown);
		tester.dumpPage();
	}
	
}
