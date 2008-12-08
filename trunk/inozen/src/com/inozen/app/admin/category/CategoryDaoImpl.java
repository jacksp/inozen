package com.inozen.app.admin.category;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;

import com.inozen.framework.data.hibernate.CriteriaUtils;
import com.inozen.framework.data.hibernate.HibernateGenericDao;
import com.inozen.framework.data.support.OrderPage;

import org.springframework.stereotype.Repository;

import com.inozen.app.admin.category.support.CategoryParams;
import com.inozen.app.model.Category;

@Repository
public class CategoryDaoImpl extends HibernateGenericDao<Category, CategoryParams> implements CategoryDao {

	@Override
	protected Criteria addRestrictions(Criteria c, CategoryParams params) {
		CriteriaUtils.ilike(c, "cateName", params.getCateName(), MatchMode.ANYWHERE);
		return c;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Category> tree(String code) {
		Criteria c = getSession().createCriteria(this.domainClass);
		CriteriaUtils.conditionalEq(c, "cateStatus", "1");
		CriteriaUtils.ilike(c, "pCateCode", code, MatchMode.EXACT);

		return c.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Category> list(CategoryParams params, OrderPage orderPage) {
		
		// rowcount
		orderPage.setRowcount(
			(Integer)(addRestrictions(getSession().createCriteria(this.domainClass), params)
			.setProjection(Projections.rowCount()).uniqueResult()));
		
		Criteria c = 
			addRestrictions(getSession().createCriteria(this.domainClass), params);
		// pages list
		orderPage.applyPage(c);
		orderPage.applyOrder(c);

		return c.list();
	}
}
