package com.inozen.app.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="tbl_category")
public class Category {
	@Id
	private long cateCode;				// 카테고리 코드
	private String cateName;				// 카테고리 이름
	private long pCateCode;				// 상위 카테고리 코드
	private String pCateName;				// 상위 카테고리 이름
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;				// 생성일
	private String createdUserId;			// 생성 사용자 아이디
	private String createdUserName;			// 생성 사용자 이름
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedDate;				// 수정일
	private String modifiedUserId;			// 수정 사용자 아이디
	private String modifiedUserName;		// 수정 사용자 이름
	private int cateOrder;					// 순서
	private String cateStatus;				// 상태
	
	public long getCateCode() {
		return cateCode;
	}
	
	public void setCateCode(long cateCode) {
		this.cateCode = cateCode;
	}
	
	public String getCateName() {
		return cateName;
	}
	
	public void setCateName(String cateName) {
		this.cateName = cateName;
	}
	
	public long getPCateCode() {
		return pCateCode;
	}
	
	public void setPCateCode(long pCateCode) {
		this.pCateCode = pCateCode;
	}
	
	public String getPCateName() {
		return pCateName;
	}
	
	public void setPCateName(String pCateName) {
		this.pCateName = pCateName;
	}
	
	public Date getCreatedDate() {
		return createdDate;
	}
	
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	public String getCreatedUserId() {
		return createdUserId;
	}
	
	public void setCreatedUserId(String createdUserId) {
		this.createdUserId = createdUserId;
	}
	
	public String getCreatedUserName() {
		return createdUserName;
	}
	
	public void setCreatedUserName(String createdUserName) {
		this.createdUserName = createdUserName;		
	}
	
	public Date getModifiedDate() {
		return modifiedDate;
	}
	
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	
	public String getModifiedUserId() {
		return modifiedUserId;
	}
	
	public void setModifiedUserId(String modifiedUserId) {
		this.modifiedUserId = modifiedUserId;
	}
	
	public String getModifiedUserName() {
		return modifiedUserName;
	}
	
	public void setModifiedUserName(String modifiedUserName) {
		this.modifiedUserName = modifiedUserName;
	}
	
	public int getCateOrder() {
		return cateOrder;
	}
	
	public void setCateOrder(int cateOrder) {
		this.cateOrder = cateOrder;
	}
	
	public String getCateStatus() {
		return cateStatus;
	}
	
	public void setCateStatus(String cateStatus) {
		this.cateStatus = cateStatus;
	}
}
