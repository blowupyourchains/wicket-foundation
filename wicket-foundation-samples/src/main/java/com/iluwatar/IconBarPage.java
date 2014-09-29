package com.iluwatar;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.request.resource.PackageResourceReference;

import com.iluwatar.foundation.iconbar.FoundationIconBar;
import com.iluwatar.foundation.iconbar.IconBarItem;
import com.iluwatar.foundation.iconbar.IconBarResourceItem;

public class IconBarPage extends BasePage {

	private static final long serialVersionUID = 1L;

	public IconBarPage(PageParameters params) {
		super(params);
		
		List<IconBarItem> items = new ArrayList<>();
		items.add(new IconBarResourceItem(new PackageResourceReference(this.getClass(), "fi-bookmark.svg"), "Bookmark"));
		items.add(new IconBarResourceItem(new PackageResourceReference(this.getClass(), "fi-home.svg"), "Home"));
		items.add(new IconBarResourceItem(new PackageResourceReference(this.getClass(), "fi-info.svg"), "Info"));
		items.add(new IconBarResourceItem(new PackageResourceReference(this.getClass(), "fi-like.svg"), "Like"));
		items.add(new IconBarResourceItem(new PackageResourceReference(this.getClass(), "fi-mail.svg"), "Mail"));
		FoundationIconBar basic = new FoundationIconBar("basic", items);
		add(basic);
		
		
//        <div class="icon-bar five-up">
//        <a class="item"> <img
//            src="../assets/img/images/fi-home.svg">
//            <label>Home</label>
//        </a> <a class="item"> <img
//            src="../assets/img/images/fi-bookmark.svg">
//            <label>Bookmark</label>
//        </a> <a class="item"> <img
//            src="../assets/img/images/fi-info.svg">
//            <label>Info</label>
//        </a> <a class="item"> <img
//            src="../assets/img/images/fi-mail.svg">
//            <label>Mail</label>
//        </a> <a class="item"> <img
//            src="../assets/img/images/fi-like.svg">
//            <label>Like</label>
//        </a>
//    </div>
		
	}

}
