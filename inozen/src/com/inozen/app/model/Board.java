package com.inozen.app.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.ForeignKey;


@Entity(name="tbl_board")
public class Board {
	@Id
	@Column(name="board_code")
	private Long boardCode;			// �Խ��� ���̵�
	@Column(name="board_name")
	private String boardName;			// �Խ��� �̸�
	@Column(name="board_type")
	private String boardType;			// �Խ��� ����
	@Column(name="created_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;			// ���� ����
	@Column(name="created_user_id")
	private String createdUserId;		// ���� ����� ���̵�
	@Column(name="created_user_name")
	private String createdUserName;		// ���� ����� �̸�
	@Column(name="modified_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedDate;			// ���� ����
	@Column(name="modified_user_id")
	private String modifiedUserId;		// ���� ����� ���̵�
	@Column(name="modified_user_name")
	private String modifiedUserName;	// ���� ����� �̸�
	@Column(name="board_order")
	private int boardOrder;				// �Խ��� ����
	@Column(name="board_status")
	private String boardStatus;			// �Խ��� ����
	
	@ManyToOne
	@JoinColumn(name="cate_code", nullable=false, updatable=false)
	@ForeignKey(name="FK_CATE_CODE")
	private Category category;
	
	public long getBoardCode() {
		return boardCode;
	}
	
	public void setBoardCode(long boardCode) {
		this.boardCode = boardCode;
	}
	
	public String getBoardName() {
		return boardName;
	}
	
	public void setBoardName(String boardName) {
		this.boardName = boardName;
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

	public void setCategory(Category category) {
		this.category = category;
	}

	public Category getCategory() {
		return category;
	}
}
