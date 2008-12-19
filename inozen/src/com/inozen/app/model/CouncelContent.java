package com.inozen.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity(name="tbl_councel_content")
public class CouncelContent {
	
	@Id
	@SequenceGenerator(initialValue=1, name="SEQ_COUNCEL", sequenceName="SEQ_COUNCEL", allocationSize=10)
	@Column(name="councel_code")
	private int councelCode;
	@Column(name="social_number")
	private String socialNumber;
	@Column(name="cel_phone_number")
	private String celPhoneNumber;
	@Column(name="sms")
	private String sms;
	@Column(name="email")
	private String email;
	@Column(name="password")
	private String password;
	@Column(name="progress_status")
	private String progressStatus;
	
	//TODO 공개여부 추가해야 한다.
	
	
	@OneToOne(mappedBy="councelContent")
	private Content boardContent;

	public void setSocialNumber(String socialNumber) {
		this.socialNumber = socialNumber;
	}

	public String getSocialNumber() {
		return socialNumber;
	}

	public void setCelPhoneNumber(String celPhoneNumber) {
		this.celPhoneNumber = celPhoneNumber;
	}

	public String getCelPhoneNumber() {
		return celPhoneNumber;
	}

	public void setSms(String sms) {
		this.sms = sms;
	}

	public String getSms() {
		return sms;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setBoardContent(Content boardContent) {
		this.boardContent = boardContent;
	}

	public Content getBoardContent() {
		return boardContent;
	}

	public void setCouncelCode(int councelCode) {
		this.councelCode = councelCode;
	}

	public int getCouncelCode() {
		return councelCode;
	}

	public void setProgressStatus(String progressStatus) {
		this.progressStatus = progressStatus;
	}

	public String getProgressStatus() {
		return progressStatus;
	}

}
