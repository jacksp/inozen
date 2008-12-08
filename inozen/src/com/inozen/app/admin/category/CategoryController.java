package com.inozen.app.admin.category;

import com.inozen.framework.web.GenericController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.inozen.app.admin.category.support.CategoryParams;
import com.inozen.app.admin.category.support.CategoryRef;
import com.inozen.app.admin.category.support.CategoryValidator;
import com.inozen.app.model.Category;

@Controller
@RequestMapping("/admin/category/*.do")
public class CategoryController extends GenericController<Category, CategoryService, CategoryRef, CategoryValidator, CategoryParams> {
	protected CategoryService service;

	protected CategoryController() {
		super(Category.class, CategoryService.class, CategoryRef.class, CategoryValidator.class);
		this.order = "cateOrder asc";
	}
	
	/**
	 * This method handels ${urlbase}/main.do GET method request.
	 */
	@RequestMapping("/admin/category/main.do")
	public void main() {
	}
	
}