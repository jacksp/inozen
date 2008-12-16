package com.inozen.app.admin.menu.support;


/**
 * @author seokhoon
 */
public class MenuParams {

	private long menuCode;
	private String menuName;
	private String menuStatus;
	private long pMenuCode;
	private String pMenuName;

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	
	public String getMenuStatus() {
		return menuStatus;
	}
	
	public void setMenuStatus(String menuStatus) {
		this.menuStatus = menuStatus;
	}
	
	public long getPMenuCode() {
		return pMenuCode;
	}
	
	public void setPMenuCode(long pMenuCode) {
		this.pMenuCode = pMenuCode;
	}
	
	public String getPMenuName() {
		return pMenuName;
	}

	public void setPMenuName(String pMenuName) {
		this.pMenuName = pMenuName;
	}

	public void setMenuCode(long menuCode) {
		this.menuCode = menuCode;
	}

	public long getMenuCode() {
		return menuCode;
	}

}
