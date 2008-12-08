package com.inozen.app.admin.category.support;

import java.util.Date;
import java.util.List;

/**
 * @author seokhoon
 */
public class CategoryParams {

	private String cateName;
	private String cateStatus;
	private String pCateCode;

	public String getCateName() {
		return cateName;
	}

	public void setCateName(String cateName) {
		this.cateName = cateName;
	}
	
	public String getCateStatus() {
		return cateStatus;
	}
	
	public void setCateStatus(String cateStatus) {
		this.cateStatus = cateStatus;
	}
	
	public String getPCateCode() {
		return pCateCode;
	}
	
	public void setPCateCode(String pCateCode) {
		this.pCateCode = pCateCode;
	}

}
