package com.inozen.app.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity(name="tbl_board")
public class Board {
	@Id
	private String boardCode;
	private String boardName;
	private String categoryCode;
	private String categoryName;
	private String boardType;
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;
	private String createdUserId;
	private String createdUserName;
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedDate;
	private String modifiedUserId;
	private String modifiedUserName;
	private int boardOrder;
	private String boardStatus;
	
	public String getBoardCode() {
		return boardCode;
	}
	
	public void setBoardCode(String boardCode) {
		this.boardCode = boardCode;
	}
	
	public String getBoardName() {
		return boardName;
	}
	
	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}
	
	public String getCategoryCode() {
		return categoryCode;
	}
	
	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}
	
	public String getCategoryName() {
		return categoryName;
	}
	
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	public String getBoardType() {
		return boardType;
	}
	
	public void setBoardType(String boardType) {
		this.boardType = boardType;
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
	
	public int getBoardOrder() {
		return boardOrder;
	}
	
	public void setBoardOrder(int boardOrder) {
		this.boardOrder = boardOrder;
	}
	
	public String getBoardStatus() {
		return boardStatus;
	}
	
	public void setBoardStatus(String boardStatus) {
		this.boardStatus = boardStatus;
	}
}
