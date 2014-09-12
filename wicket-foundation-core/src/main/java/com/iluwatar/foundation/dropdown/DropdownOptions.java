package com.iluwatar.foundation.dropdown;

import java.io.Serializable;

import com.iluwatar.foundation.button.ButtonColor;
import com.iluwatar.foundation.button.ButtonExpansion;
import com.iluwatar.foundation.button.ButtonRadius;
import com.iluwatar.foundation.button.ButtonSize;

public class DropdownOptions implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private DropdownType type;
	private ButtonSize size;
	private ButtonColor color;
	private ButtonRadius radius;
	private ButtonExpansion expansion;

	public DropdownOptions() {
	}

	public DropdownOptions(DropdownType type) {
		this.type = type;
	}
	
	public DropdownOptions(ButtonSize size) {
		this.size = size;
	}
	
	public DropdownOptions(ButtonColor color) {
		this.color = color;
	}
	
	public DropdownOptions(ButtonRadius radius) {
		this.radius = radius;
	}

	public DropdownOptions(ButtonExpansion expansion) {
		this.expansion = expansion;
	}
	
	public DropdownOptions(DropdownOptions other) {
		this.type = other.type;
		this.size = other.size;
		this.color = other.color;
		this.radius = other.radius;
		this.expansion = other.expansion;
	}

	public ButtonSize getSize() {
		return size;
	}

	public DropdownOptions setSize(ButtonSize size) {
		this.size = size;
		return this;
	}

	public ButtonColor getColor() {
		return color;
	}

	public DropdownOptions setColor(ButtonColor color) {
		this.color = color;
		return this;
	}

	public ButtonRadius getRadius() {
		return radius;
	}

	public DropdownOptions setRadius(ButtonRadius radius) {
		this.radius = radius;
		return this;
	}

	public ButtonExpansion getExpansion() {
		return expansion;
	}

	public DropdownOptions setExpansion(ButtonExpansion expansion) {
		this.expansion = expansion;
		return this;
	}

	public DropdownType getType() {
		return type;
	}

	public DropdownOptions setType(DropdownType type) {
		this.type = type;
		return this;
	}
}
