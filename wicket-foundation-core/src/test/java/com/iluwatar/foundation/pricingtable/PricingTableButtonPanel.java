package com.iluwatar.foundation.pricingtable;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;

public class PricingTableButtonPanel extends Panel {

	private static final long serialVersionUID = 1L;

	public PricingTableButtonPanel(String id) {
		super(id);

		AjaxLink<Void> btn = new AjaxLink<Void>("btn") {

			private static final long serialVersionUID = 1L;

			@Override
			public void onClick(AjaxRequestTarget target) {
				// TODO Auto-generated method stub
			}
		};
		add(btn);
		btn.add(new Label("btnText", "Hello"));
	}
}
