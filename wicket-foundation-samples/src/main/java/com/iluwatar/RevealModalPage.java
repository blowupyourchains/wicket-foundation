package com.iluwatar;

import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import com.iluwatar.foundation.revealmodal.FoundationRevealModal;

public class RevealModalPage extends BasePage {

	private static final long serialVersionUID = 1L;

	public RevealModalPage(PageParameters params) {
		super(params);
		final String content = "<h2>Awesome. I have it.</h2><p class=\"lead\">Your couch. It is mine.</p><p>I&#39;m a cool paragraph that lives inside of an even cooler modal. Wins!</p><a class=\"close-reveal-modal\">&#215;</a>";
		add(new FoundationRevealModal("basic", Model.of("Click Me For A Modal"), Model.of(content)));
	}
}
