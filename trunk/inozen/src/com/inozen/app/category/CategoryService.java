package com.inozen.app.category;

import java.util.List;

import com.inozen.framework.data.support.OrderPage;
import com.inozen.framework.service.GenericService;

import com.inozen.app.category.support.CategoryParams;
import com.inozen.app.model.Category;

public interface CategoryService extends GenericService<Category, CategoryDao, CategoryParams>{
	int countChildren(long pCateCode);
}
