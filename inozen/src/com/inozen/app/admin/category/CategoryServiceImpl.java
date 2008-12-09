package com.inozen.app.admin.category;

import java.util.List;

import com.inozen.framework.data.support.OrderPage;
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

	

}
