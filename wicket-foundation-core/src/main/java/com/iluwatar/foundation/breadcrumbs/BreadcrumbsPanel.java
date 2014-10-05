package com.iluwatar.foundation.breadcrumbs;

import java.util.List;

import org.apache.wicket.Page;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.MarkupStream;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import com.iluwatar.foundation.component.FoundationBasePanel;
import com.iluwatar.foundation.util.Attribute;

/**
 * Breadcrumbs come in handy to show a navigation trail for users clicking through a site or app.
 * http://foundation.zurb.com/docs/components/breadcrumbs.html
 * @author ilkka
 *
 */
public class BreadcrumbsPanel extends FoundationBasePanel {

	private static final long serialVersionUID = 1L;

	public BreadcrumbsPanel(String id, IModel<List<BreadcrumbsItem>> model) {
		super(id);
		RepeatingView rv = new RepeatingView("items");
		add(rv);
		for (BreadcrumbsItem item: model.getObject()) {
			rv.add(new BreadcrumbsLink(rv.newChildId(), item.getClazz(), Model.of(item.getTitle()), item.isDisabled()));
		}
	}
	
	private static class BreadcrumbsLink extends BookmarkablePageLink<Void> {
		
		private static final long serialVersionUID = 1L;
		private IModel<String> titleModel;
		private boolean disabled;
		
		public BreadcrumbsLink(String id, Class<? extends Page> clazz, IModel<String> titleModel, boolean disabled) {
			super(id, clazz);
			this.titleModel = titleModel;
			this.disabled = disabled;
		}

		@Override
		protected void onComponentTag(ComponentTag tag) {
			if (getPage().getClass().equals(super.getPageClass())) {
				Attribute.setClass(tag, BreadcrumbsClassNames.CURRENT);
			} else {
				Attribute.removeClass(tag, BreadcrumbsClassNames.CURRENT);
			}
			if (disabled) {
				Attribute.addClass(tag, BreadcrumbsClassNames.UNAVAILABLE);
			} else {
				Attribute.removeClass(tag, BreadcrumbsClassNames.UNAVAILABLE);
			}
			super.onComponentTag(tag);
		}
		
		@Override
		public void onComponentTagBody(MarkupStream markupStream,
				ComponentTag openTag) {
			this.replaceComponentTagBody(markupStream, openTag, titleModel.getObject());
			super.onComponentTagBody(markupStream, openTag);
		}
		
		@Override
		protected void onDetach() {
			this.titleModel.detach();
			super.onDetach();
		}
	}
}
