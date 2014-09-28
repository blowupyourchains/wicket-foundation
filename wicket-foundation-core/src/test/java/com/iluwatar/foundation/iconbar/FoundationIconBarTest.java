package com.iluwatar.foundation.iconbar;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.request.resource.PackageResourceReference;
import org.apache.wicket.util.tester.WicketTester;
import org.junit.Test;

public class FoundationIconBarTest {

	@Test
	public void testBasic() {
		WicketTester tester = new WicketTester();
		List<IconBarItem> items = new ArrayList<>();
		items.add(new IconBarResourceItem(new PackageResourceReference(this.getClass(), "fi-arrow-down.svg"), "Down"));
		items.add(new IconBarResourceItem(new PackageResourceReference(this.getClass(), "fi-arrow-left.svg"), "Left"));
		items.add(new IconBarResourceItem(new PackageResourceReference(this.getClass(), "fi-arrow-right.svg"), "Right"));
		FoundationIconBar iconBar = new FoundationIconBar("id", new IconBarOptions(), items);
		tester.startComponentInPage(iconBar);
		tester.dumpPage();
	}
}
