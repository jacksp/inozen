package com.inozen.app.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="tbl_html_page")
public class HtmlPage {
	
	@Id
	@Column(name="page_code")
	private Long pageCode;					// page's code
	@Column(name="page_name")
	private String pageName;				// page's name
	@Column(name="page_title")
	private String pageTitle;				// page's title
	@Column(name="page_meta_info1")
	private String pageMetaInfo1;			// pages' meta tag info
	@Column(name="page_meta_info2")
	private String pageMetaInfo2;			// page's meta tag info
	@Column(name="page_meta_info3")
	private String pageMetaInfo3;			// page's meta tag info
	@Column(name="page_meta_info4")
	private String pageMetaInfo4;			// page's meta tag info
	@Column(name="page_meta_info5")
	private String pageMetaInfo5;			// page's meta tag info
	@Column(name="page_tag")
	private String pageTag;					// page's text tags. split by comma ","
	@Column(name="page_location")
	private String pageLocation;			// when use .html file
	@Column(name="page_content")
	private String pageContent;				// when use database
	@Column(name="created_user_id")
	private String createdUserID;			// created user
	@Column(name="created_user_name")
	private String createdUserName;			// created user
	@Column(name="created_date")
	private Date createdDate;				// created date
	@Column(name="modified_user_id")
	private String modifiedUserID;
	@Column(name="modified_user_name")
	private String modifiedUserName;
	@Column(name="modified_date")
	private Date modifiedDate;
	@Column(name="page_status")
	private String pageStatus;				// page's status
	
	
	public long getPageCode() {
		return pageCode;
	}
	
	public void setPageCode(long pageCode) {
		this.pageCode = pageCode;
	}
	
	public String getPageName() {
		return pageName;
	}
	
	public void setPageName(String pageName) {
		this.pageName = pageName;
	}
	
	public String getPageTitle() {
		return pageTitle;
	}
	
	public void setPageTitle(String pageTitle) {
		this.pageTitle = pageTitle;
	}
	
	public String getPageMetaInfo1() {
		return pageMetaInfo1;
	}
	
	public void setPageMetaInfo1(String pageMetaInfo1) {
		this.pageMetaInfo1 = pageMetaInfo1;
	}
	
	public String getPageMetaInfo2() {
		return pageMetaInfo2;
	}
	
	public void setPageMetaInfo2(String pageMetaInfo2) {
		this.pageMetaInfo2 = pageMetaInfo2;
	}
	
	public String getPageMetaInfo3() {
		return pageMetaInfo3;
	}
	
	public void setPageMetaInfo3(String pageMetaInfo3) {
		this.pageMetaInfo3 = pageMetaInfo3;
	}
	
	public String getPageMetaInfo4() {
		return pageMetaInfo4;
	}
	
	public void setPageMetaInfo4(String pageMetaInfo4) {
		this.pageMetaInfo4 = pageMetaInfo4;
	}
	
	public String getPageMetaInfo5() {
		return pageMetaInfo5;
	}
	
	public void setPageMetaInfo5(String pageMetaInfo5) {
		this.pageMetaInfo5 = pageMetaInfo5;
	}
	
	public String getPageTag() {
		return pageTag;
	}
	
	public void setPageTag(String pageTag) {
		this.pageTag = pageTag;
	}
	
	public String getPageLocation() {
		return pageLocation;
	}
	
	public void setPageLocation(String pageLocation) {
		this.pageLocation = pageLocation;
	}
	
	public String getPageContent() {
		return pageContent;
	}
	
	public void setPageContent(String pageContent) {
		this.pageContent = pageContent;
	}
	
	public String getCreatedUserID() {
		return createdUserID;
	}
	
	public void setCreatedUserID(String createdUserID) {
		this.createdUserID = createdUserID;
	}
	
	public String getCreatedUserName() {
		return createdUserName;
	}
	
	public void setCreatedUserName(String createdUserName) {
		this.createdUserName = createdUserName;
	}
	
	public Date getCreatedDate() {
		return createdDate;
	}
	
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	public String getModifiedUserID() {
		return modifiedUserID;
	}
	
	public void setModifiedUserID(String modifiedUserID) {
		this.modifiedUserID = modifiedUserID;
	}
	
	public String getModifiedUserName() {
		return modifiedUserName;
	}
	
	public void setModifiedUserName(String modifiedUserName) {
		this.modifiedUserName = modifiedUserName;
	}
	
	public Date getModifiedDate() {
		return modifiedDate; 
	}
	
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	
	public String getPageStatus() {
		return pageStatus;
	}
	
	public void setPageStatus(String pageStatus) {
		this.pageStatus = pageStatus;
	}
}
