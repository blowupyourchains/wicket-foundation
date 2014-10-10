package com.iluwatar;

import org.apache.wicket.request.mapper.parameter.PageParameters;

import com.iluwatar.foundation.button.ButtonColor;
import com.iluwatar.foundation.button.ButtonRadius;
import com.iluwatar.foundation.progressbar.FoundationProgressBarPanel;
import com.iluwatar.foundation.progressbar.ProgressBarOptions;

public class ProgressBarPage extends BasePage {

	private static final long serialVersionUID = 1L;

	public ProgressBarPage(PageParameters params) {
		super(params);
		add(new FoundationProgressBarPanel("basic", 100));
		ProgressBarOptions options = new ProgressBarOptions(ButtonColor.SUCCESS).setRadius(ButtonRadius.ROUND);
		add(new FoundationProgressBarPanel("advanced", options, 80));
	}
}
