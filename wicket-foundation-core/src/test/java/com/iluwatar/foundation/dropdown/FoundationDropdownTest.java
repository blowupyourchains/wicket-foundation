package com.iluwatar.foundation.dropdown;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.util.tester.TagTester;
import org.apache.wicket.util.tester.WicketTester;
import org.junit.Test;

public class FoundationDropdownTest {

	@Test
	public void renderDropdownTest() { 
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
		TagTester btnTag = tester.getTagByWicketId("btn");
		TagTester containerTag = tester.getTagByWicketId("container");
		assertEquals(btnTag.getAttribute("data-dropdown"), containerTag.getAttribute("id"));
		assertEquals("a", btnTag.getName());
		assertTrue(containerTag.getMarkup().contains("data-dropdown-content"));
		assertEquals("f-dropdown", containerTag.getAttribute("class"));
		assertEquals(3, tester.getTagsByWicketId("item").size());
		assertEquals(3, tester.getTagsByWicketId("link").size());
		assertEquals(3, tester.getTagsByWicketId("body").size());
		assertEquals(tester.getTagsByWicketId("body").get(0).getValue(), "foo");
		assertEquals(tester.getTagsByWicketId("body").get(1).getValue(), "bar");
		assertEquals(tester.getTagsByWicketId("body").get(2).getValue(), "baz");
	}
	
	@Test
	public void renderDropdownLinkTest() { 
		WicketTester tester = new WicketTester();
		FoundationDropdown dropdown = new FoundationDropdown("id", "dropdown", new DropdownOptions(DropdownType.DROPDOWNLINK), Arrays.asList("foo", "bar", "baz")) {

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
		TagTester btnTag = tester.getTagByWicketId("btn");
		TagTester containerTag = tester.getTagByWicketId("container");
		assertEquals(btnTag.getAttribute("data-dropdown"), containerTag.getAttribute("id"));
		assertEquals("a", btnTag.getName());
		assertEquals("button", btnTag.getAttribute("class"));
		assertTrue(containerTag.getMarkup().contains("data-dropdown-content"));
		assertEquals("f-dropdown", containerTag.getAttribute("class"));
		assertEquals(3, tester.getTagsByWicketId("item").size());
		assertEquals(3, tester.getTagsByWicketId("link").size());
		assertEquals(3, tester.getTagsByWicketId("body").size());
		assertEquals(tester.getTagsByWicketId("body").get(0).getValue(), "foo");
		assertEquals(tester.getTagsByWicketId("body").get(1).getValue(), "bar");
		assertEquals(tester.getTagsByWicketId("body").get(2).getValue(), "baz");
	}
		
	@Test
	public void renderDropdownButtonTest() { 
		WicketTester tester = new WicketTester();
		FoundationDropdown dropdown = new FoundationDropdown("id", "dropdown", new DropdownOptions(DropdownType.DROPDOWNBUTTON), Arrays.asList("foo", "bar", "baz")) {

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
		TagTester btnTag = tester.getTagByWicketId("btn");
		TagTester containerTag = tester.getTagByWicketId("container");
		assertEquals(btnTag.getAttribute("data-dropdown"), containerTag.getAttribute("id"));
		assertEquals("button", btnTag.getName());
		assertTrue(btnTag.getAttributeContains("class", "button"));
		assertTrue(btnTag.getAttributeContains("class", "dropdown"));
		assertTrue(containerTag.getMarkup().contains("data-dropdown-content"));
		assertEquals("f-dropdown", containerTag.getAttribute("class"));
		assertEquals(3, tester.getTagsByWicketId("item").size());
		assertEquals(3, tester.getTagsByWicketId("link").size());
		assertEquals(3, tester.getTagsByWicketId("body").size());
		assertEquals(tester.getTagsByWicketId("body").get(0).getValue(), "foo");
		assertEquals(tester.getTagsByWicketId("body").get(1).getValue(), "bar");
		assertEquals(tester.getTagsByWicketId("body").get(2).getValue(), "baz");
	}			
}
