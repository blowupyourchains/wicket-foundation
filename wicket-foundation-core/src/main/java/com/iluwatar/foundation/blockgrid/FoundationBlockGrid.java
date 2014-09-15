package com.iluwatar.foundation.blockgrid;

import java.util.List;

import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.util.ListModel;

import com.iluwatar.foundation.component.FoundationBasePanel;
import com.iluwatar.foundation.util.Attribute;
import com.iluwatar.foundation.util.StringUtil;

public abstract class FoundationBlockGrid<T> extends FoundationBasePanel {

	private static final long serialVersionUID = 1L;

	public FoundationBlockGrid(String id, BlockGridOptions options, List<T> modelObjects) {
		this(id, Model.of(options),new ListModel<T>(modelObjects));
	}
	
	public FoundationBlockGrid(String id, IModel<BlockGridOptions> optionsModel, IModel<List<T>> models) {
		super(id);
		BlockGridContainer container = new BlockGridContainer("container", optionsModel);
		add(container);
		container.add(new ListView<T>("item", models) {

			private static final long serialVersionUID = 1L;

			@Override
			protected void populateItem(ListItem<T> item) {
				WebMarkupContainer content = FoundationBlockGrid.this.createContent(item.getIndex(), "content", item.getModel());
				item.add(content);
			}
		});
	}
	
	public abstract WebMarkupContainer createContent(int idx, String id, IModel<T> model);
	
	private class BlockGridContainer extends WebMarkupContainer {

		private static final long serialVersionUID = 1L;
		
		private IModel<BlockGridOptions> optionsModel;

		public BlockGridContainer(String id, IModel<BlockGridOptions> model) {
			super(id);
			this.optionsModel = model;
		}
		
		@Override
		protected void onComponentTag(ComponentTag tag) {
			String cssClass = resolveCssClass(optionsModel.getObject());
			Attribute.setClass(tag, cssClass);
			super.onComponentTag(tag);
		}
		
		private String resolveCssClass(BlockGridOptions options) {
			String typeName = StringUtil.EnumNameToCssClassName(options.getType().name());
			return String.format("%s-%d", typeName, options.getColumnCount());
		}

		@Override
		protected void onDetach() {
			optionsModel.detach();
			super.onDetach();
		}
	}
}
