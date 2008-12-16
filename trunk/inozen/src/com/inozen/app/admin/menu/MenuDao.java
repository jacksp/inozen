package com.inozen.app.admin.menu;


import com.inozen.framework.data.GenericDao;

import com.inozen.app.admin.menu.support.MenuParams;
import com.inozen.app.model.Menu;

public interface MenuDao extends GenericDao<Menu, MenuParams>{
	int countMenuByPMenuCode(long menuCode);
	
}
