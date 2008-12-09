package com.inozen.app.admin.category.support;


/**
 * @author seokhoon
 */
public class CategoryParams {

	private String cateName;
	private String cateStatus;
	private long pCateCode;

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
	
	public long getPCateCode() {
		return pCateCode;
	}
	
	public void setPCateCode(long pCateCode) {
		this.pCateCode = pCateCode;
	}

}
