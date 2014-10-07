package com.iluwatar.foundation.icon;

import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.WebMarkupContainer;

import com.iluwatar.foundation.component.FoundationBasePanel;
import com.iluwatar.foundation.util.Attribute;
import com.iluwatar.foundation.util.StringUtil;

public class FoundationIconPanel extends FoundationBasePanel {

	private static final long serialVersionUID = 1L;

	public FoundationIconPanel(String id, FoundationIcon icon) {
		super(id);
		add(new IconContainer("icon", icon));
	}
	
	private static class IconContainer extends WebMarkupContainer {

		private static final long serialVersionUID = 1L;
		
		private FoundationIcon icon;

		public IconContainer(String id, FoundationIcon icon) {
			super(id);
			this.icon = icon;
		}
		
		@Override
		protected void onComponentTag(ComponentTag tag) {
			final String prefix = "fi-";
			Attribute.addClass(tag, prefix + StringUtil.EnumNameToCssClassName(icon.name()));
			super.onComponentTag(tag);
		}
	}
}
