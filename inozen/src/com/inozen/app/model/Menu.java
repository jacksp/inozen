package com.inozen.app.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="tbl_menu")
public class Menu {
	@Id
	@Column(name="menu_code")
	private Long menuCode;					// 메뉴 코드
	@Column(name="menu_name")
	private String menuName;				// 메뉴 이름
	@Column(name="p_menu_code")
	private Long pMenuCode;				// 상위 메뉴 코드
	@Column(name="p_menu_name")
	private String pMenuName;				// 상위 메뉴 이름
	@Column(name="menu_kind")
	private String menuKind;				// 메뉴 위치
	@Column(name="menu_type")
	private String menuType;				// 메뉴 종류
	@Column(name="menu_related_code")
	private Long menuRelatedCode;			// 메뉴 관련 코드 (카테고리 코드, 게시판 코드, 페이지 코드)
	@Column(name="menu_url")
	private String menuURL;					// 메뉴 url (메뉴가 링크인 경우 url)
	@Column(name="created_user_id")
	private String createdUserID;			// 등록 사용자 아이디
	@Column(name="created_user_name")
	private String createdUserName;			// 등록 사용자 이름
	@Column(name="created_date")
	private Date createdDate;				// 등록 일자
	@Column(name="modified_user_id")
	private String modifiedUserID;			// 수정 사용자 아이디
	@Column(name="modified_user_name")
	private String modifiedUserName;		// 수정 사용자 이름
	@Column(name="modified_date")
	private Date modifiedDate;				// 수정 일자
	@Column(name="menu_order")
	private int menuOrder;					// 메뉴 순서
	@Column(name="menu_status")
	private String menuStatus;				// 메뉴 상태
	
	public void setMenuCode(long menuCode) {
		this.menuCode = menuCode;
	}
	public Long getMenuCode() {
		return menuCode;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setPMenuCode(long pMenuCode) {
		this.pMenuCode = pMenuCode;
	}
	public Long getPMenuCode() {
		return pMenuCode;
	}
	public void setPMenuName(String pMenuName) {
		this.pMenuName = pMenuName;
	}
	public String getPMenuName() {
		return pMenuName;
	}
	public void setMenuKind(String menuKind) {
		this.menuKind = menuKind;
	}
	public String getMenuKind() {
		return menuKind;
	}
	public void setMenuType(String menuType) {
		this.menuType = menuType;
	}
	public String getMenuType() {
		return menuType;
	}
	public void setMenuURL(String menuURL) {
		this.menuURL = menuURL;
	}
	public String getMenuURL() {
		return menuURL;
	}
	public void setCreatedUserID(String createdUserID) {
		this.createdUserID = createdUserID;
	}
	public String getCreatedUserID() {
		return createdUserID;
	}
	public void setCreatedUserName(String createdUserName) {
		this.createdUserName = createdUserName;
	}
	public String getCreatedUserName() {
		return createdUserName;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setModifiedUserID(String modifiedUserID) {
		this.modifiedUserID = modifiedUserID;
	}
	public String getModifiedUserID() {
		return modifiedUserID;
	}
	public void setModifiedUserName(String modifiedUserName) {
		this.modifiedUserName = modifiedUserName;
	}
	public String getModifiedUserName() {
		return modifiedUserName;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setMenuOrder(int menuOrder) {
		this.menuOrder = menuOrder;
	}
	public int getMenuOrder() {
		return menuOrder;
	}
	public void setMenuStatus(String menuStatus) {
		this.menuStatus = menuStatus;
	}
	public String getMenuStatus() {
		return menuStatus;
	}
	public void setMenuRelatedCode(long menuRelatedCode) {
		this.menuRelatedCode = menuRelatedCode;
	}
	public long getMenuRelatedCode() {
		return menuRelatedCode;
	}
}
