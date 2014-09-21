package com.iluwatar.foundation.topbar;

import org.apache.wicket.util.tester.WicketTester;
import org.junit.Test;

public class FoundationTopBarPanelTest {

	@Test
	public void test() {
		WicketTester tester = new WicketTester();
		FoundationTopBarPanel topBar = new FoundationTopBarPanel("id");
		tester.startComponentInPage(topBar);
		tester.dumpPage();
	}
}
