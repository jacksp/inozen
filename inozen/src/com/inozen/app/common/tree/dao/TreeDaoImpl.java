package com.inozen.app.common.tree.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;

import com.inozen.framework.data.hibernate.CriteriaUtils;
import com.inozen.framework.data.support.OrderPage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.inozen.app.common.tree.domain.Tree;
import com.inozen.app.model.Category;

@Repository
public class TreeDaoImpl implements TreeDao {
	
	/** Logger available to subclasses */
	private Log logger = LogFactory.getLog(this.getClass());

	@Autowired 
	private SessionFactory sessionFactory;
	
	private static final int CATEGORY = 1;
	
	private String statusFieldName;
	private String pCodeFieldName;
	private String orderFieldName;
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	private void initializedField(int type) {
		switch(type) {
			case CATEGORY :
				pCodeFieldName = "pCateCode";
				statusFieldName = "cateStatus";
				orderFieldName = "cateOrder";
			break;
			default :
				pCodeFieldName = "pCateCode";
				statusFieldName = "cateStatus";
				orderFieldName = "cateOrder";
			break;
		}
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Tree> tree(int type, String code) {
		
		this.initializedField(type);
		
		Criteria c = getSession().createCriteria(Category.class);
		CriteriaUtils.conditionalEq(c, statusFieldName, "1");
		CriteriaUtils.ilike(c, pCodeFieldName, code, MatchMode.EXACT);
		
		getChildren(code);

		return c.list();
	}

	@Override
	public int getChildCount(String code) {
		Criteria c = getSession().createCriteria(Category.class);
		CriteriaUtils.conditionalEq(c, statusFieldName, "1");
		CriteriaUtils.ilike(c, pCodeFieldName, code, MatchMode.EXACT);
		
		return (Integer)(c.setProjection(Projections.rowCount()).uniqueResult());
	}

	@Override
	public List<Tree> getChildren(String code) {
		Criteria c = getSession().createCriteria(Category.class);
		CriteriaUtils.conditionalEq(c, statusFieldName, "1");
		CriteriaUtils.ilike(c, pCodeFieldName, code, MatchMode.EXACT);
		c.addOrder(Order.desc(orderFieldName));
		
		logger.debug("c.list():::::::::::::::"+c.list());
		
		for(int i=0; i<c.list().size(); i++) {
			c.list().get(i);
		}
		return null;
	}

	@Override
	public boolean isEmptyChild(String code) {
		return (getChildCount(code) > 0 ? false : true);
	}
	
	
	
	
}
