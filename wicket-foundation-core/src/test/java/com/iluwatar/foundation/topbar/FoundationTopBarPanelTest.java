package com.iluwatar.foundation.topbar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.EnumSet;

import org.apache.wicket.util.tester.TagTester;
import org.apache.wicket.util.tester.WicketTester;
import org.junit.Test;

public class FoundationTopBarPanelTest {

	@Test
	public void testBasic() {
		WicketTester tester = new WicketTester();
		FoundationTopBarPanel topBarPanel = new FoundationTopBarPanel("id");
		tester.startComponentInPage(topBarPanel);
		TagTester topBarContainer = tester.getTagByWicketId("topBarContainer");
		TagTester topBar = tester.getTagByWicketId("topBar");
		assertEquals("top-bar", topBar.getAttribute("class"));
		assertTrue(topBar.hasAttribute("data-topbar"));
		assertTrue(topBar.getAttributeIs("role", "navigation"));
	}

	@Test
	public void testFixed() {
		WicketTester tester = new WicketTester();
		TopBarOptions options = new TopBarOptions().setFixed(true);
		FoundationTopBarPanel topBarPanel = new FoundationTopBarPanel("id", options);
		tester.startComponentInPage(topBarPanel);
		TagTester topBarContainer = tester.getTagByWicketId("topBarContainer");
		assertTrue(topBarContainer.getAttributeContains("class", "fixed"));
		TagTester topBar = tester.getTagByWicketId("topBar");
	}
	
	@Test
	public void testPosition() {
		WicketTester tester = new WicketTester();
		TopBarOptions options = new TopBarOptions().setClickable(true).setContainToGrid(true)
				.setSticky(true).setStickySizes(EnumSet.of(TopBarStickySize.LARGE));
		FoundationTopBarPanel topBarPanel = new FoundationTopBarPanel("id", options);
		tester.startComponentInPage(topBarPanel);
		tester.dumpPage();
		TagTester topBarContainer = tester.getTagByWicketId("topBarContainer");
		assertTrue(topBarContainer.getAttributeContains("class", "contain-to-grid"));
		assertTrue(topBarContainer.getAttributeContains("class", "sticky"));
		TagTester topBar = tester.getTagByWicketId("topBar");
		assertTrue(topBar.getAttributeContains("data-options", "is_hover:false"));
		assertTrue(topBar.getAttributeContains("data-options", "sticky_on:large"));
	}
}
