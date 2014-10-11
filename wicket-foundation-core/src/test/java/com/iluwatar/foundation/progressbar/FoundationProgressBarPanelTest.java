package com.iluwatar.foundation.progressbar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.apache.wicket.util.tester.TagTester;
import org.apache.wicket.util.tester.WicketTester;
import org.junit.Test;

import com.iluwatar.foundation.button.ButtonColor;
import com.iluwatar.foundation.button.ButtonRadius;

public class FoundationProgressBarPanelTest {

	@Test
	public void testBasic() {
		WicketTester tester = new WicketTester();
		FoundationProgressBarPanel progress = new FoundationProgressBarPanel("id", 100);
		tester.startComponentInPage(progress);
		TagTester progressContainerTag = tester.getTagByWicketId("progressContainer");
		assertEquals("progress", progressContainerTag.getAttribute("class"));
		TagTester progressTag = tester.getTagByWicketId("progress");
		assertEquals("meter", progressTag.getAttribute("class"));
	}
	
	@Test
	public void testAdvanced() {
		WicketTester tester = new WicketTester();
		ProgressBarOptions options = new ProgressBarOptions().setColor(ButtonColor.SUCCESS).setRadius(ButtonRadius.ROUND);
		FoundationProgressBarPanel progress = new FoundationProgressBarPanel("id", options, 47);
		tester.startComponentInPage(progress);
		tester.dumpPage();
		TagTester progressContainerTag = tester.getTagByWicketId("progressContainer");
		assertTrue(progressContainerTag.getAttributeContains("class", "progress"));
		assertTrue(progressContainerTag.getAttributeContains("class", "success"));
		assertTrue(progressContainerTag.getAttributeContains("class", "round"));
		TagTester progressTag = tester.getTagByWicketId("progress");
		assertEquals("meter", progressTag.getAttribute("class"));
		assertEquals("width:47%", progressTag.getAttribute("style"));
	}
}