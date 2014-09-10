package com.iluwatar.foundation.util;

import java.util.Arrays;
import java.util.Iterator;

import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.util.lang.Args;
import org.apache.wicket.util.string.StringValue;

import com.google.common.base.Splitter;

/**
 * 
 * Helper class for attributes
 *
 */
public class Attribute {

	/**
	 * Set class attribute value (overwrite)
	 * @param tag
	 * @param className
	 * @return
	 */
	public static ComponentTag setClass(ComponentTag tag, String className) {
		Args.notNull(tag, "tag");
		Args.notNull(className, "className");
		tag.put("class", className);
		return tag;
	}
	
	/**
	 * Append new value to class attribute
	 * @param tag
	 * @param className
	 * @return
	 */
	public static ComponentTag addClass(ComponentTag tag, String className) {
		Args.notNull(tag, "tag");
		Args.notNull(className, "className");
		if (!hasClass(tag, className)) {
			String value = tag.getAttribute("class");
			if (value == null) {
				tag.put("class", className);
			} else {
				tag.put("class", value + " " + className);
			}
		}
		return tag;
	}

	/**
	 * Remove single value from class attribute
	 * @param tag
	 * @param className
	 * @return
	 */
	public static ComponentTag removeClass(ComponentTag tag, String className) {
		Args.notNull(tag, "tag");
		Args.notNull(className, "className");
		if (hasClass(tag, className)) {
			Iterator<String> iterator = Splitter.on(" ").split(tag.getAttribute("class")).iterator();
			StringBuilder sb = new StringBuilder();
			while (iterator.hasNext()) {
				if (sb.length() > 0) {
					sb.append(" ");
				}
				String cname = iterator.next();
				if (!cname.equals(className)) {
					sb.append(cname);
				}
			}
			tag.put("class", sb.toString());
		}
		return tag;
	}
	
	/**
	 * Check if class attribute has value
	 * @param tag
	 * @param className
	 * @return
	 */
	public static boolean hasClass(ComponentTag tag, String className) {
		Args.notNull(tag, "tag");
		String value = tag.getAttribute("class");
		if (value == null) {
			return false;
		}
		String[] existing = value.split(" ");
		return Arrays.asList(existing).contains(className);
	}

	/**
	 * Adds attribute without value
	 * @param tag
	 * @param attribute
	 * @return
	 */
	public static ComponentTag addAttribute(ComponentTag tag, String attribute) {
		Args.notNull(tag, "tag");
		Args.notNull(attribute, "attribute");
		String v = null;
		tag.put(attribute, StringValue.valueOf(v));
		return tag;
	}

	/**
	 * Adds attribute with given value
	 * @param tag
	 * @param attribute
	 * @param value
	 * @return
	 */
	public static ComponentTag addAttribute(ComponentTag tag, String attribute, String value) {
		Args.notNull(tag, "tag");
		Args.notNull(attribute, "attribute");
		Args.notNull(value, "value");
		tag.put(attribute, value);
		return tag;
	}

	/**
	 * Adds attribute with given value
	 * @param tag
	 * @param attribute
	 * @param value
	 * @return
	 */
	public static ComponentTag addAttribute(ComponentTag tag, String attribute, boolean value) {
		Args.notNull(tag, "tag");
		Args.notNull(attribute, "attribute");
		Args.notNull(value, "value");
		tag.put(attribute, value);
		return tag;
	}

	/**
	 * Adds attribute with given value
	 * @param tag
	 * @param attribute
	 * @param value
	 * @return
	 */
	public static ComponentTag addAttribute(ComponentTag tag, String attribute, int value) {
		Args.notNull(tag, "tag");
		Args.notNull(attribute, "attribute");
		Args.notNull(value, "value");
		tag.put(attribute, value);
		return tag;
	}
	
	/**
	 * Removes attribute
	 * @param tag
	 * @param attribute
	 * @return
	 */
	public static ComponentTag removeAttribute(ComponentTag tag, String attribute) {
		Args.notNull(tag, "tag");
		Args.notNull(attribute, "attribute");
		tag.remove(attribute);
		return tag;
	}
	
	/**
	 * Test if tag contains attribute
	 * @param tag
	 * @param attribute
	 * @return
	 */
	public static boolean hasAttribute(ComponentTag tag, String attribute) {
		Args.notNull(tag, "tag");
		Args.notNull(attribute, "attribute");
		return tag.toString().contains(attribute);
	}

	/**
	 * Gets attribute value
	 * @param tag
	 * @param attribute
	 * @return
	 */
	public static String getAttribute(ComponentTag tag, String attribute) {
		Args.notNull(tag, "tag");
		Args.notNull(attribute, "attribute");
		return tag.getAttribute(attribute);
	}
}
