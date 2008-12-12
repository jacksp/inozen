package com.inozen.app.admin.menu.support;

import org.springframework.stereotype.Component;

import com.inozen.app.model.enumeration.MenuType;

/**
 * @author seokhoon
 */
@Component
public class MenuRef {
	
	public MenuType getMenuType() {
		return MenuType.getInstance();
	}
}
