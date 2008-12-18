package com.inozen.app.category;

import java.util.List;

import com.inozen.framework.data.support.OrderPage;
import com.inozen.framework.service.impl.GenericServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inozen.app.category.support.CategoryParams;
import com.inozen.app.model.Category;

@Service
@Transactional
public class CategoryServiceImpl extends GenericServiceImpl<Category, CategoryDao, CategoryParams> implements CategoryService {
	@Autowired
	protected CategoryDao dao;
	protected Category entity;

	public CategoryServiceImpl() {
		super(CategoryDao.class);
	}

	@Override
	public int countChildren(long pCateCode) {
		return dao.countCategorysByPCateCode(pCateCode);
	}

	

}
