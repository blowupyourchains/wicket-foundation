package com.iluwatar.foundation.splitbutton;

import java.io.Serializable;

import com.iluwatar.foundation.button.ButtonColor;
import com.iluwatar.foundation.button.ButtonRadius;
import com.iluwatar.foundation.button.ButtonSize;

public class SplitButtonOptions implements Serializable {

	private ButtonSize size;
	private ButtonColor color;
	private ButtonRadius radius;

	public SplitButtonOptions() {
	}
	
	public SplitButtonOptions(ButtonSize size) {
		this.size = size;
	}
	
	public SplitButtonOptions(ButtonColor color) {
		this.color = color;
	}
	
	public SplitButtonOptions(ButtonRadius radius) {
		this.radius = radius;
	}

	public ButtonSize getSize() {
		return size;
	}

	public void setSize(ButtonSize size) {
		this.size = size;
	}

	public ButtonColor getColor() {
		return color;
	}

	public void setColor(ButtonColor color) {
		this.color = color;
	}

	public ButtonRadius getRadius() {
		return radius;
	}

	public void setRadius(ButtonRadius radius) {
		this.radius = radius;
	}
	
}
