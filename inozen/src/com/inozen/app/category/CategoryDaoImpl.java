package com.inozen.app.category;


import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;

import com.inozen.framework.data.hibernate.CriteriaUtils;
import com.inozen.framework.data.hibernate.HibernateGenericDao;

import org.springframework.stereotype.Repository;

import com.inozen.app.category.support.CategoryParams;
import com.inozen.app.model.Category;

@Repository
public class CategoryDaoImpl extends HibernateGenericDao<Category, CategoryParams> implements CategoryDao {

	@Override
	protected Criteria addRestrictions(Criteria c, CategoryParams params) {
		CriteriaUtils.ilike(c, "cateName", params.getCateName(), MatchMode.ANYWHERE);
		CriteriaUtils.conditionalEq(c, "pCateCode", params.getPCateCode());
		return c;
	}

	/*
	 * @see com.inozen.app.admin.category.CategoryDao#countCategorysByPCateCode(long)
	 */
	@Override
	public int countCategorysByPCateCode(long pCateCode) {
		Long count = (Long)getSession().createQuery("select count(*) from tbl_category a where a.pCateCode=:pCateCode")
		.setParameter("pCateCode", pCateCode).uniqueResult();
		return count.intValue();
	}
}
