package com.iluwatar.foundation.button;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.wicket.Page;
import org.apache.wicket.util.tester.TagTester;
import org.apache.wicket.util.tester.WicketTester;
import org.junit.Test;

import com.iluwatar.foundation.util.StringUtil;

public class FoundationBookmarkablePageLinkTest {

	@Test
	public void testBasic() {
		testButton(new WicketTester(), new FoundationTestBookmarkablePageLink(
				"btn", FoundationButtonTestPage.class), new ArrayList<String>());
	}

	@Test
	public void testAdvancedSize() {
		testButton(new WicketTester(), new FoundationTestBookmarkablePageLink("btn", FoundationButtonTestPage.class, 
				new ButtonOptions(ButtonSize.TINY)), Arrays.asList(StringUtil.EnumNameToCssClassName(ButtonSize.TINY.name())));
	}

	@Test
	public void testAdvancedColor() {
		testButton(new WicketTester(), new FoundationTestBookmarkablePageLink("btn", FoundationButtonTestPage.class, new ButtonOptions(ButtonColor.SUCCESS)), 
				Arrays.asList(StringUtil.EnumNameToCssClassName(ButtonColor.SUCCESS.name())));
	}

	@Test
	public void testAdvancedRadius() {
		testButton(new WicketTester(), new FoundationTestBookmarkablePageLink("btn", FoundationButtonTestPage.class, new ButtonOptions(ButtonRadius.RADIUS)), 
				Arrays.asList(StringUtil.EnumNameToCssClassName(ButtonRadius.RADIUS.name())));
	}

	@Test
	public void testAdvancedState() {
		testButton(new WicketTester(), new FoundationTestBookmarkablePageLink("btn", FoundationButtonTestPage.class, new ButtonOptions(ButtonState.DISABLED)), 
				Arrays.asList(StringUtil.EnumNameToCssClassName(ButtonState.DISABLED.name())));
	}

	@Test
	public void testAdvancedExpansion() {
		testButton(new WicketTester(), new FoundationTestBookmarkablePageLink("btn", FoundationButtonTestPage.class, new ButtonOptions(ButtonExpansion.EXPAND)), 
				Arrays.asList(StringUtil.EnumNameToCssClassName(ButtonExpansion.EXPAND.name())));
	}
	
	private void testButton(WicketTester tester, FoundationTestBookmarkablePageLink btn, List<String> additionalCssClassesToVerify) {
		tester.startComponentInPage(btn);
		TagTester tagTester = tester.getTagByWicketId(btn.getId());
		assertTrue(tagTester.getAttributeContains("class", FoundationButtonClassNames.BUTTON));
		for (String clazz: additionalCssClassesToVerify) {
			assertTrue(tagTester.getAttributeContains("class", clazz));
		}
	}
	
	private static class FoundationTestBookmarkablePageLink extends FoundationBookmarkablePageLink<Void> {

		private static final long serialVersionUID = 1L;
		
		public <C extends Page> FoundationTestBookmarkablePageLink(String id,
				Class<C> pageClass) {
			super(id, pageClass);
		}
		
		public <C extends Page> FoundationTestBookmarkablePageLink(String id,
				Class<C> pageClass, ButtonOptions options) {
			super(id, pageClass, options);
		}
	}
}
