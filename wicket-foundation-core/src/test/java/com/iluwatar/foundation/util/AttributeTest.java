package com.iluwatar.foundation.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.parser.XmlTag;
import org.junit.Test;

public class AttributeTest {

	@Test
	public void testSetClass() {
		
        final ComponentTag tag = new ComponentTag("div", XmlTag.TagType.OPEN_CLOSE);
        assertEquals(null, tag.getAttribute("class"));
        Attribute.setClass(tag, "pink");
        assertEquals("pink", tag.getAttribute("class"));
        Attribute.setClass(tag, "blue");
        assertEquals("blue", tag.getAttribute("class"));
		
	}
	
	@Test
	public void testAddClass() {
		
        final ComponentTag tag = new ComponentTag("div", XmlTag.TagType.OPEN_CLOSE);
        assertEquals(null, tag.getAttribute("class"));
        Attribute.addClass(tag, "pink");
        assertEquals("pink", tag.getAttribute("class"));
        Attribute.addClass(tag, "blue");
        assertEquals("pink blue", tag.getAttribute("class"));
        Attribute.addClass(tag, "blue");
        assertEquals("pink blue", tag.getAttribute("class"));
		
	}

	@Test
	public void testHasClass() {
		
        final ComponentTag tag = new ComponentTag("div", XmlTag.TagType.OPEN_CLOSE);
        Attribute.setClass(tag, "pink green blue");
        assertTrue(Attribute.hasClass(tag, "pink"));
        assertTrue(Attribute.hasClass(tag, "green"));
        assertTrue(Attribute.hasClass(tag, "blue"));
        assertFalse(Attribute.hasClass(tag, "black"));
		
	}

	@Test
	public void testRemoveClass() {
		
        final ComponentTag tag = new ComponentTag("div", XmlTag.TagType.OPEN_CLOSE);
        Attribute.setClass(tag, "pink blue red");
        assertTrue(Attribute.hasClass(tag, "pink"));
        assertTrue(Attribute.hasClass(tag, "blue"));
        assertTrue(Attribute.hasClass(tag, "red"));
        Attribute.removeClass(tag, "pink");
        assertFalse(Attribute.hasClass(tag, "pink"));
        assertTrue(Attribute.hasClass(tag, "blue"));
        assertTrue(Attribute.hasClass(tag, "red"));
        Attribute.removeClass(tag, "red");
        assertTrue(Attribute.hasClass(tag, "blue"));
        assertFalse(Attribute.hasClass(tag, "red"));
        Attribute.removeClass(tag, "blue");
        assertFalse(Attribute.hasClass(tag, "blue"));
        assertEquals("", tag.getAttribute("class"));
	}
	
	@Test
	public void testAddRemoveAttribute() {
        final ComponentTag tag = new ComponentTag("div", XmlTag.TagType.OPEN_CLOSE);
        Attribute.addAttribute(tag, "data-foobar");
        assertTrue(Attribute.hasAttribute(tag, "data-foobar"));
        Attribute.removeAttribute(tag, "data-foobar");
        assertFalse(Attribute.hasAttribute(tag, "data-foobar"));
        Attribute.addAttribute(tag, "data-dropdown", "123");
        assertEquals("123", Attribute.getAttribute(tag, "data-dropdown"));
        Attribute.removeAttribute(tag, "data-dropdown");
        assertNull(Attribute.getAttribute(tag, "data-dropdown"));
	}

	@Test
	public void testAddRemoveDataOptions() {
        final ComponentTag tag = new ComponentTag("div", XmlTag.TagType.OPEN_CLOSE);
        Attribute.setDataOptions(tag, "color:red");
        assertEquals("color:red;", Attribute.getAttribute(tag, "data-options"));
        Attribute.setDataOptions(tag, "color:brown");
        assertEquals("color:brown;", Attribute.getAttribute(tag, "data-options"));
        Attribute.addDataOptions(tag, "weight:100");
        assertEquals("color:brown;weight:100;", Attribute.getAttribute(tag, "data-options"));
        Attribute.addDataOptions(tag, "height:195");
        assertEquals("color:brown;weight:100;height:195;", Attribute.getAttribute(tag, "data-options"));
        Attribute.removeDataOptions(tag, "weight:100");
        assertEquals("color:brown;height:195;", Attribute.getAttribute(tag, "data-options"));
        Attribute.removeDataOptions(tag, "height:195");
        assertEquals("color:brown;", Attribute.getAttribute(tag, "data-options"));        
        assertTrue(Attribute.hasDataOptions(tag, "color:brown"));
	}
}
