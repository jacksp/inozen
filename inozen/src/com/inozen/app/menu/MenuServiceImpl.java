package com.inozen.app.menu;


import com.inozen.framework.service.impl.GenericServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inozen.app.menu.support.MenuParams;
import com.inozen.app.model.Menu;

@Service
@Transactional
public class MenuServiceImpl extends GenericServiceImpl<Menu, MenuDao, MenuParams> implements MenuService {
	@Autowired
	protected MenuDao dao;
	protected Menu entity;

	public MenuServiceImpl() {
		super(MenuDao.class);
	}

	@Override
	public int countChildren(long menuCode) {
		return dao.countMenuByPMenuCode(menuCode);
	}

	@Override
	public Menu getMenuInfo(long menuCode) {
		return dao.get(menuCode);
	}

}
