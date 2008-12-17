package com.inozen.app.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ForeignKey;

@Entity(name="tbl_board_content")
public class Content {
	@Id
	@Column(name="content_code")
	private Long contentCode;
	
	@ManyToOne
	@JoinColumn(name="board_code", nullable=false, updatable=false)
	@ForeignKey(name="FK_BOARD_CODE")
	private Board board;
	
	@Column(name="content_title")
	private String contentTitle;
	@Column(name="content")
	private String content;
	@Column(name="created_user_id")
	private String createdUserID;
	@Column(name="created_user_name")
	private String createdUserName;
	@Column(name="created_date")
	private Date createdDate;
	@Column(name="modified_user_id")
	private String modifiedUserID;
	@Column(name="modified_user_name")
	private String modifiedUserName;
	@Column(name="modified_date")
	private Date modifiedDate;
	@Column(name="p_content_code")
	private Long pContentCode;
	@Column(name="content_order")
	private int contentOrder;
	@Column(name="content_status")
	private String contentStatus;
	@Column(name="view_cnt")
	private int viewCnt;
	
	public void setContentCode(long contentCode) {
		this.contentCode = contentCode;
	}
	public long getContentCode() {
		return contentCode;
	}
	public void setBoard(Board board) {
		this.board = board;
	}
	public Board getBoard() {
		return board;
	}
	public void setContentTitle(String contentTitle) {
		this.contentTitle = contentTitle;
	}
	public String getContentTitle() {
		return contentTitle;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getContent() {
		return content;
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
	public void setPContentCode(long pContentCode) {
		this.pContentCode = pContentCode;
	}
	public long getPContentCode() {
		return pContentCode;
	}
	public void setContentOrder(int contentOrder) {
		this.contentOrder = contentOrder;
	}
	public int getContentOrder() {
		return contentOrder;
	}
	public void setContentStatus(String contentStatus) {
		this.contentStatus = contentStatus;
	}
	public String getContentStatus() {
		return contentStatus;
	}
	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}
	public int getViewCnt() {
		return viewCnt;
	}
	
}
