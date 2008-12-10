package com.inozen.app.model;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="tbl_category")
public class Category {
	@Id
	@Column(name="cate_code")
	private long cateCode;				// ī�װ� �ڵ�
	@Column(name="cate_name")
	private String cateName;				// ī�װ� �̸�
	@Column(name="p_cate_code")
	private long pCateCode;				// ���� ī�װ� �ڵ�
	@Column(name="p_cate_name")
	private String pCateName;				// ���� ī�װ� �̸�
	@Column(name="created_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;				// ������
	@Column(name="created_user_id")
	private String createdUserId;			// ���� ����� ���̵�
	@Column(name="created_user_name")
	private String createdUserName;			// ���� ����� �̸�
	@Column(name="modified_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedDate;				// ������
	@Column(name="modified_user_id")
	private String modifiedUserId;			// ���� ����� ���̵�
	@Column(name="modified_user_name")
	private String modifiedUserName;		// ���� ����� �̸�
	@Column(name="cate_order")
	private int cateOrder;					// ����
	@Column(name="cate_status")
	private String cateStatus;				// ����
	
	@OneToMany
	@JoinColumn(name="cate_code")
	private Collection<Board> board;					// �Խ���
	
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
	
	public Collection<Board> getBoard() {
		return board;
	}
	
	public void setBoard(Collection<Board> board) {
		this.board = board;
	}
}
