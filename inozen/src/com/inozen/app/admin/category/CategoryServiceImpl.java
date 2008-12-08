package com.inozen.app.admin.category;

import java.util.List;

import com.inozen.framework.service.impl.GenericServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inozen.app.admin.category.support.CategoryParams;
import com.inozen.app.model.Category;

@Service
@Transactional
public class CategoryServiceImpl extends GenericServiceImpl<Category, CategoryDao, CategoryParams> implements CategoryService {
	protected CategoryDao dao;
	protected Category entity;

	public CategoryServiceImpl() {
		super(CategoryDao.class);
	}

	
	/**
	 * execute in read-only transaction.
	 */
	@Override
	@Transactional(readOnly = true)
	public List<Category> tree(String code) {
		return dao.tree(code);
	}


	@Override
	public List<Category> saveCategory(String code) {
		return null;
	}


}
