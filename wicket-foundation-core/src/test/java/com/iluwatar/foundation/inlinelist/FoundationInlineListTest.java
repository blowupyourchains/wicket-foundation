package com.iluwatar.foundation.inlinelist;

import java.util.Arrays;
import java.util.List;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.link.AbstractLink;
import org.apache.wicket.util.tester.WicketTester;
import org.junit.Test;

public class FoundationInlineListTest {

	@Test
	public void testBasic() {
		WicketTester tester = new WicketTester();
		List<String> titles = Arrays.asList("Foo", "Bar", "Baz");
		FoundationInlineList inlineList = new FoundationInlineList("id", titles) {

			private static final long serialVersionUID = 1L;

			@Override
			public AbstractLink createLink(String id, int idx) {
				return new AjaxLink<Void>(id) {

					@Override
					public void onClick(AjaxRequestTarget target) {
					}
					
				};
			}
			
		};
		tester.startComponentInPage(inlineList);
		tester.dumpPage();
	}

}
