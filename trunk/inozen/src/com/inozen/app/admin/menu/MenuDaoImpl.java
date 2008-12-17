package com.inozen.app.admin.menu;


import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;

import com.inozen.framework.data.hibernate.CriteriaUtils;
import com.inozen.framework.data.hibernate.HibernateGenericDao;

import org.springframework.stereotype.Repository;

import com.inozen.app.admin.menu.support.MenuParams;
import com.inozen.app.model.Menu;

@Repository
public class MenuDaoImpl extends HibernateGenericDao<Menu, MenuParams> implements MenuDao {

	@Override
	protected Criteria addRestrictions(Criteria c, MenuParams params) {
		CriteriaUtils.ilike(c, "menuName", params.getMenuName(), MatchMode.ANYWHERE);
		CriteriaUtils.conditionalEq(c, "pMenuCode", params.getPMenuCode());
		return c;
	}

	@Override
	public int countMenuByPMenuCode(long menuCode) {
		Long count = (Long)getSession().createQuery("select count(*) from tbl_menu a where a.pMenuCode=:pMenuCode")
		.setParameter("pMenuCode", menuCode).uniqueResult();
		return count.intValue();
	}

}
