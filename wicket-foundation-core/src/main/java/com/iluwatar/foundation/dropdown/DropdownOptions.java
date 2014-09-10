package com.iluwatar.foundation.dropdown;

import java.io.Serializable;

import com.iluwatar.foundation.button.ButtonColor;
import com.iluwatar.foundation.button.ButtonRadius;
import com.iluwatar.foundation.button.ButtonSize;

public class DropdownOptions implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private ButtonSize size;
	private ButtonColor color;
	private ButtonRadius radius;

	public DropdownOptions() {
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
	
	public DropdownOptions(DropdownOptions other) {
		this.size = other.size;
		this.color = other.color;
		this.radius = other.radius;
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
}
