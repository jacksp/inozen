package com.inozen.app.common.tree.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;

import com.inozen.framework.data.hibernate.CriteriaUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.inozen.app.common.tree.TreeConstants;
import com.inozen.app.model.Board;
import com.inozen.app.model.Category;
import com.inozen.app.model.Menu;

@Repository
public class TreeDaoImpl implements TreeDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	private String _statusFieldName;
	private String _pCodeFieldName;
	private String _orderFiledName;
	@SuppressWarnings("unchecked")
	private Class domain;
	
	public Session getSession() {
		Session returnSession = sessionFactory.getCurrentSession();
		return returnSession;
	}
	
	private void initializedField(int type) {
		switch(type) {
			case TreeConstants.CATEGORY :
				domain = Category.class;
				_pCodeFieldName = "pCateCode";
				_statusFieldName = "cateStatus";
				_orderFiledName = "cateOrder";
				
			break;
			case TreeConstants.BOARD :
				domain = Board.class;
				_pCodeFieldName = "category.cateCode";
				_statusFieldName = "boardStatus";
				_orderFiledName = "boardOrder";
			break;
			case TreeConstants.MENU :
				domain = Menu.class;
				_pCodeFieldName = "pMenuCode";
				_statusFieldName = "menuStatus";
				_orderFiledName = "menuOrder";
			break;
			default :
				domain = Category.class;
				_pCodeFieldName = "pCateCode";
				_statusFieldName = "cateStatus";
				_orderFiledName = "cateOrder";
			break;
		}
	}

	@Override
	public void setTree(int type) {
		this.initializedField(type);
	}

	@Override
	public int getChildCount(long code) {
		Criteria c = getSession().createCriteria(domain);
		CriteriaUtils.conditionalEq(c, _statusFieldName, "1");
		CriteriaUtils.conditionalEq(c, _pCodeFieldName, code);

		int returnint = (Integer) (c.setProjection(Projections.rowCount()).uniqueResult());
		return returnint;
	}

	@Override
	public boolean isEmptyChild(long code) {
		boolean returnboolean = (getChildCount(code) > 0 ? false : true);
		return returnboolean;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List getChildren(long code) {
		Criteria c = getSession().createCriteria(domain);
		CriteriaUtils.conditionalEq(c, _statusFieldName, "1");
		CriteriaUtils.conditionalEq(c, _pCodeFieldName, code);
		c.addOrder(Order.asc(_orderFiledName));
		List returnList = c.list();
		return returnList;
	}
	
}
