package com.iluwatar.foundation.alert;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.iluwatar.foundation.button.FoundationButtonRadius;


public class AlertOptionsTest {

	@Test
	public void testBasic() {
		AlertOptions options = new AlertOptions();
		AlertOptions options2 = new AlertOptions(options);
		options2 = options2.setColor(FoundationAlertColor.SECONDARY).setRadius(FoundationButtonRadius.ROUND);
		AlertOptions options3 = new AlertOptions(FoundationAlertColor.SECONDARY);
		AlertOptions options4 = new AlertOptions(FoundationButtonRadius.ROUND);
		assertEquals(FoundationAlertColor.SECONDARY, options3.getColor());
		assertEquals(FoundationButtonRadius.ROUND, options4.getRadius());
		AlertOptions options5 = new AlertOptions(FoundationAlertColor.SECONDARY, FoundationButtonRadius.ROUND);
	}
}
