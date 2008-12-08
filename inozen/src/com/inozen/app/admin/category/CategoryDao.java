package com.inozen.app.admin.category;

import java.util.List;

import com.inozen.framework.data.hibernate.HibernateDao;
import com.inozen.framework.data.support.OrderPage;

import com.inozen.app.admin.category.support.CategoryParams;
import com.inozen.app.model.Category;

public interface CategoryDao extends HibernateDao<Category, CategoryParams>{

	List<Category> tree(String code);
	
	List<Category> list(CategoryParams param, OrderPage orderPage);

}
