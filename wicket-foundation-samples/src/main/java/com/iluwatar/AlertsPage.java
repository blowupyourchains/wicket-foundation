package com.iluwatar;

import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import com.iluwatar.foundation.alert.AlertOptions;
import com.iluwatar.foundation.alert.FoundationAlert;
import com.iluwatar.foundation.alert.FoundationAlertColor;
import com.iluwatar.foundation.button.FoundationButtonRadius;

public class AlertsPage extends BasePage {

	private static final long serialVersionUID = 1L;

	public AlertsPage(PageParameters params) {
		super(params);
		add(new FoundationAlert("basic", Model.of("This is standard alert.")));
		
		add(new FoundationAlert("successRadius", Model.of("This is a success alert with a radius. "),
				new AlertOptions(FoundationAlertColor.SUCCESS, FoundationButtonRadius.RADIUS)));
		add(new FoundationAlert("warningRound", Model.of("This is a warning alert that is rounded. "),
				new AlertOptions(FoundationAlertColor.WARNING, FoundationButtonRadius.ROUND)));
		add(new FoundationAlert("infoRadius", Model.of("This is an info alert with a radius. "),
				new AlertOptions(FoundationAlertColor.INFO, FoundationButtonRadius.RADIUS)));
		add(new FoundationAlert("alertRound", Model.of("This is an alert - alert that is rounded. "),
				new AlertOptions(FoundationAlertColor.ALERT, FoundationButtonRadius.ROUND)));
		add(new FoundationAlert("secondary", Model.of("This is a secondary alert. "),
				new AlertOptions(FoundationAlertColor.SECONDARY)));
	}
}
