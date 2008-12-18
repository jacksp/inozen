package com.inozen.app.category;


import com.inozen.framework.data.GenericDao;

import com.inozen.app.category.support.CategoryParams;
import com.inozen.app.model.Category;

public interface CategoryDao extends GenericDao<Category, CategoryParams>{
	int countCategorysByPCateCode(long pCateCode);
}
