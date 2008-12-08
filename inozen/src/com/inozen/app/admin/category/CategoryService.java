package com.inozen.app.admin.category;

import java.util.List;

import com.inozen.framework.service.GenericService;

import com.inozen.app.admin.category.support.CategoryParams;
import com.inozen.app.model.Category;

public interface CategoryService extends GenericService<Category, CategoryDao, CategoryParams>{
	
	List<Category> tree(String code);
	
	List<Category> saveCategory(String pCode);
	
}
