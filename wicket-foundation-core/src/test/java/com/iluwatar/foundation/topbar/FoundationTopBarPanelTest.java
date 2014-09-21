package com.iluwatar.foundation.topbar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.apache.wicket.util.tester.TagTester;
import org.apache.wicket.util.tester.WicketTester;
import org.junit.Test;

public class FoundationTopBarPanelTest {

	@Test
	public void test() {
		WicketTester tester = new WicketTester();
		FoundationTopBarPanel topBarPanel = new FoundationTopBarPanel("id");
		tester.startComponentInPage(topBarPanel);
		tester.dumpPage();
		TagTester topBarContainer = tester.getTagByWicketId("topBarContainer");
		TagTester topBar = tester.getTagByWicketId("topBar");
		assertEquals("top-bar", topBar.getAttribute("class"));
		assertTrue(topBar.hasAttribute("data-topbar"));
		assertTrue(topBar.getAttributeIs("role", "navigation"));
	}
}
