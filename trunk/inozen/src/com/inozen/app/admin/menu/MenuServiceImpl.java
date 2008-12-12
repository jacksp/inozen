package com.inozen.app.admin.menu;


import com.inozen.framework.service.impl.GenericServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inozen.app.admin.menu.support.MenuParams;
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


}
