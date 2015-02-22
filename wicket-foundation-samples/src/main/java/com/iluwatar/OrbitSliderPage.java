package com.iluwatar;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.model.util.ListModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.request.resource.PackageResourceReference;

import com.iluwatar.foundation.orbitslider.FoundationOrbitSlider;
import com.iluwatar.foundation.orbitslider.OrbitSliderItem;

public class OrbitSliderPage extends BasePage {

	private static final long serialVersionUID = 1L;

	public OrbitSliderPage(PageParameters params) {
		super(params);
		List<OrbitSliderItem> items = new ArrayList<>();
		items.add(new OrbitSliderItem("1", new PackageResourceReference(this.getClass(), "andromeda-orbit.jpg"), "Caption 1"));
		items.add(new OrbitSliderItem("2", new PackageResourceReference(this.getClass(), "launch-orbit.jpg"), "Caption 2"));
		items.add(new OrbitSliderItem("3", new PackageResourceReference(this.getClass(), "satelite-orbit.jpg"), "Caption 3"));
		FoundationOrbitSlider orbitSlider = new FoundationOrbitSlider("orbitSlider", new ListModel<>(items));
		add(orbitSlider);
	}
}
