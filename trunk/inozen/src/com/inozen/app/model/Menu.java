package com.inozen.app.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="tbl_menu")
public class Menu {
	@Id
	@Column(name="menu_code")
	private Long menuCode;					// �޴� �ڵ�
	@Column(name="menu_name")
	private String menuName;				// �޴� �̸�
	@Column(name="p_menu_code")
	private Long pMenuCode;				// ���� �޴� �ڵ�
	@Column(name="p_menu_name")
	private String pMenuName;				// ���� �޴� �̸�
	@Column(name="menu_kind")
	private String menuKind;				// �޴� ��ġ
	@Column(name="menu_type")
	private String menuType;				// �޴� ����
	@Column(name="menu_related_code")
	private Long menuRelatedCode;			// �޴� ���� �ڵ� (ī�װ� �ڵ�, �Խ��� �ڵ�, ������ �ڵ�)
	@Column(name="menu_url")
	private String menuURL;					// �޴� url (�޴��� ��ũ�� ��� url)
	@Column(name="created_user_id")
	private String createdUserID;			// ��� ����� ���̵�
	@Column(name="created_user_name")
	private String createdUserName;			// ��� ����� �̸�
	@Column(name="created_date")
	private Date createdDate;				// ��� ����
	@Column(name="modified_user_id")
	private String modifiedUserID;			// ���� ����� ���̵�
	@Column(name="modified_user_name")
	private String modifiedUserName;		// ���� ����� �̸�
	@Column(name="modified_date")
	private Date modifiedDate;				// ���� ����
	@Column(name="menu_order")
	private int menuOrder;					// �޴� ����
	@Column(name="menu_status")
	private String menuStatus;				// �޴� ����
	
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
