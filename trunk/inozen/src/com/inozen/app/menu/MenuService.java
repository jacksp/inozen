package com.inozen.app.menu;


import com.inozen.framework.service.GenericService;

import com.inozen.app.menu.support.MenuParams;
import com.inozen.app.model.Menu;

public interface MenuService extends GenericService<Menu, MenuDao, MenuParams>{
	int countChildren(long pMenuCode);
	
	Menu getMenuInfo(long menuCode);
}
