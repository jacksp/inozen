package com.inozen.app.model.enumeration;

import java.util.Arrays;

import com.inozen.framework.enumeration.AbstractType;
import com.inozen.framework.enumeration.Pair;

public class MenuType extends AbstractType {
	
	public static final int CATEGORY = 10;
	public static final int BOARD = 20;
	public static final int HTML = 30;
	public static final int LINK = 40;
	
	public MenuType() {
		super(Arrays.asList(
				new Pair(CATEGORY, "카테고리"), 
				new Pair(BOARD, "게시판"),
				new Pair(HTML, "페이지"),
				new Pair(LINK, "링크"))
		);
	}
	
	private static MenuType menuType = new MenuType();
	
	public static MenuType getInstance() {
		return menuType;
	}

}
