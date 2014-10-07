package com.iluwatar;

import java.util.ArrayList;

import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.model.IModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import com.iluwatar.foundation.blockgrid.BlockGridOptions;
import com.iluwatar.foundation.blockgrid.BlockGridType;
import com.iluwatar.foundation.blockgrid.FoundationBlockGrid;
import com.iluwatar.foundation.icon.FoundationIcon;
import com.iluwatar.foundation.icon.FoundationIconPanel;

public class FoundationIconsPage extends BasePage {

	private static final long serialVersionUID = 1L;

	public FoundationIconsPage(PageParameters params) {
		super(params);
		
		ArrayList<BlockGridOptions> optionsList = new ArrayList<>();
		optionsList.add(new BlockGridOptions(BlockGridType.SMALL_BLOCK_GRID, 2));
		optionsList.add(new BlockGridOptions(BlockGridType.LARGE_BLOCK_GRID, 4));
		ArrayList<FoundationIcon> dataList = new ArrayList<>();
		dataList.add(FoundationIcon.HEART);
		dataList.add(FoundationIcon.STAR);
		dataList.add(FoundationIcon.PLUS);
		dataList.add(FoundationIcon.MINUS);
		dataList.add(FoundationIcon.X);
		dataList.add(FoundationIcon.CHECK);
		dataList.add(FoundationIcon.UPLOAD);
		dataList.add(FoundationIcon.DOWNLOAD);
		dataList.add(FoundationIcon.WIDGET);
		dataList.add(FoundationIcon.MARKER);
		dataList.add(FoundationIcon.TRASH);
		dataList.add(FoundationIcon.PAPERCLIP);
		dataList.add(FoundationIcon.LOCK);
		dataList.add(FoundationIcon.UNLOCK);
		dataList.add(FoundationIcon.CALENDAR);
		dataList.add(FoundationIcon.CLOUD);
		dataList.add(FoundationIcon.MAGNIFYING_GLASS);
		dataList.add(FoundationIcon.ZOOM_OUT);
		dataList.add(FoundationIcon.ZOOM_IN);
		dataList.add(FoundationIcon.WRENCH);
		dataList.add(FoundationIcon.RSS);
		dataList.add(FoundationIcon.SHARE);
		dataList.add(FoundationIcon.FLAG);
		dataList.add(FoundationIcon.LIST_THUMBNAILS);
		dataList.add(FoundationIcon.LIST);
		dataList.add(FoundationIcon.THUMBNAILS);
		dataList.add(FoundationIcon.ANNOTATE);
		dataList.add(FoundationIcon.FOLDER);
		dataList.add(FoundationIcon.FOLDER_LOCK);
		dataList.add(FoundationIcon.FOLDER_ADD);
		dataList.add(FoundationIcon.CLOCK);
		dataList.add(FoundationIcon.PLAY_VIDEO);
		dataList.add(FoundationIcon.CROP);
		dataList.add(FoundationIcon.ARCHIVE);
		dataList.add(FoundationIcon.PENCIL);
		dataList.add(FoundationIcon.GRAPH_TREND);
		dataList.add(FoundationIcon.GRAPH_BAR);
		dataList.add(FoundationIcon.GRAPH_HORIZONTAL);
		dataList.add(FoundationIcon.GRAPH_PIE);
		dataList.add(FoundationIcon.CHECKBOX);
		dataList.add(FoundationIcon.MINUS_CIRCLE);
		dataList.add(FoundationIcon.X_CIRCLE);
		dataList.add(FoundationIcon.EYE);
		dataList.add(FoundationIcon.DATABASE);
		dataList.add(FoundationIcon.RESULTS);
		dataList.add(FoundationIcon.RESULTS_DEMOGRAPHICS);
		dataList.add(FoundationIcon.LIKE);
		dataList.add(FoundationIcon.DISLIKE);
		dataList.add(FoundationIcon.UPLOAD_CLOUD);
		dataList.add(FoundationIcon.CAMERA);
		dataList.add(FoundationIcon.ALERT);
		dataList.add(FoundationIcon.BOOKMARK);
		dataList.add(FoundationIcon.CONTRAST);
		dataList.add(FoundationIcon.MAIL);
		dataList.add(FoundationIcon.VIDEO);
		dataList.add(FoundationIcon.TELEPHONE);
		dataList.add(FoundationIcon.COMMENT);
		dataList.add(FoundationIcon.COMMENT_VIDEO);
		dataList.add(FoundationIcon.COMMENT_QUOTES);
		dataList.add(FoundationIcon.COMMENT_MINUS);
		dataList.add(FoundationIcon.MEGAPHONE);
		dataList.add(FoundationIcon.SOUND);
		dataList.add(FoundationIcon.ADDRESS_BOOK);
		dataList.add(FoundationIcon.BLUETOOTH);
		dataList.add(FoundationIcon.HTML5);
		dataList.add(FoundationIcon.CSS3);
		dataList.add(FoundationIcon.LAYOUT);
		dataList.add(FoundationIcon.WEB);
		dataList.add(FoundationIcon.FOUNDATION);
		add(new FoundationBlockGrid<FoundationIcon>("generalIcons", optionsList, dataList) {

			private static final long serialVersionUID = 1L;

			@Override
			public WebMarkupContainer createContent(int idx, String id,
					IModel<FoundationIcon> model) {
				return new FoundationIconPanel(id, model.getObject());
			}
		});
	}
}
