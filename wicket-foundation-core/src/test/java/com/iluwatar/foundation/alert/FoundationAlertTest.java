package com.iluwatar.foundation.alert;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.apache.wicket.model.Model;
import org.apache.wicket.util.tester.TagTester;
import org.apache.wicket.util.tester.WicketTester;
import org.junit.Test;

public class FoundationAlertTest {

	@Test
	public void testBasic() {
		WicketTester tester = new WicketTester();
		FoundationAlert alert = new FoundationAlert("alert", Model.of("hello world"), new AlertOptions());
		tester.startComponentInPage(alert);
		TagTester alertTag = tester.getTagByWicketId("alert");
		assertTrue(alertTag.getMarkup().contains(FoundationAlertClassNames.DATA_ALERT));
		assertTrue(alertTag.getAttributeIs("class", FoundationAlertClassNames.ALERT));
		assertTrue(alertTag.hasChildTag("a"));
		TagTester bodyTag = tester.getTagByWicketId("body");
		assertEquals("hello world", bodyTag.getValue());
	}
}
