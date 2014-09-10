package com.iluwatar.foundation.alert;

import java.io.Serializable;

import com.iluwatar.foundation.button.ButtonRadius;

public class AlertOptions implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private FoundationAlertColor color;
	private ButtonRadius radius;
	
	public AlertOptions() {
	}

	public AlertOptions(FoundationAlertColor color) {
		this.color = color;
	}

	public AlertOptions(ButtonRadius radius) {
		this.radius = radius;
	}

	public AlertOptions(FoundationAlertColor color, ButtonRadius radius) {
		this.color = color;
		this.radius = radius;
	}
	
	public AlertOptions(AlertOptions other) {
		this.color = other.color;
		this.radius = other.radius;
	}
	
	public FoundationAlertColor getColor() {
		return color;
	}
	
	public AlertOptions setColor(FoundationAlertColor color) {
		this.color = color;
		return this;
	}
	
	public ButtonRadius getRadius() {
		return radius;
	}
	
	public AlertOptions setRadius(ButtonRadius radius) {
		this.radius = radius;
		return this;
	}
}
