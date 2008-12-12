package com.inozen.app.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;							// �ε���
	private String loginId;					// �α��� ���̵�
	private String password;				// Password
	private String userName;				// ����� �̸�
	private String orgCode;					// �μ� �ڵ�
	private String orgName;					// �μ���
	private String userEmail;				// ����� �̸���
	private String telNum;					// ��ȭ��ȣ
	private String celNum;					// �ڵ��� ��ȣ
	private String officialPosition;		// ���� (��������)
	private String officialPositionCode;	// ���� (��������)
	private String officialDuty;			// ��å (���� ���� �ӹ�)
	private String officialDutyCode;		// ��å (���� ���� �ӹ�)
	private String officialGrade;			// ���� (��������)
	private String officialGradeCode;		// ���� (��������)
	private int connectCnt;					// ���� ��
	private String empCode;					// �����ڵ�
	@Temporal(TemporalType.DATE)
	private Date regDate;					// �����
	@Temporal(TemporalType.DATE)
	private Date modDate;					// ��������������
	@Temporal(TemporalType.DATE)
	private Date lastConDate;				// ���� ������
	private String empStatus;				// �������� : �����, ������.
	
	private int sex;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	
	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getTelNum() {
		return telNum;
	}

	public void setTelNum(String telNum) {
		this.telNum = telNum;
	}
	
	public String getCelNum() {
		return celNum;
	}

	public void setCelNum(String celNum) {
		this.celNum = celNum;
	}

	public String getOfficialPosition() {
		return officialPosition;
	}

	public void setOfficialPosition(String officialPosition) {
		this.officialPosition = officialPosition;
	}
	
	public String getOfficialPositionCode() {
		return officialPositionCode;
	}

	public void setOfficialPositionCode(String officialPositionCode) {
		this.officialPositionCode = officialPositionCode;
	}
	
	public String getOfficialDuty() {
		return officialDuty;
	}

	public void setOfficialDuty(String officialDuty) {
		this.officialDuty = officialDuty;
	}
	
	public String getOfficialDutyCode() {
		return officialDutyCode;
	}

	public void setOfficialDutyCode(String officialDutyCode) {
		this.officialDutyCode = officialDutyCode;
	}
	
	public String getOfficialGrade() {
		return officialGrade;
	}

	public void setOfficialGrade(String officialGrade) {
		this.officialGrade = officialGrade;
	}
	
	public String getOfficialGradeCode() {
		return officialGradeCode;
	}

	public void setOfficialGradeCode(String officialGradeCode) {
		this.officialGradeCode = officialGradeCode;
	}
	
	public int getConnectCnt() {
		return connectCnt;
	}

	public void setConnectCnt(int connectCnt) {
		this.connectCnt = connectCnt;
	}
	
	public String getEmpCode() {
		return empCode;
	}

	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}
	
	public Date getRegDate() {
		return regDate;
	}
	
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
	public Date getModDate() {
		return modDate;
	}
	
	public void setModDate(Date modDate) {
		this.modDate = modDate;
	}
	
	public Date getLastConDate() {
		return lastConDate;
	}
	
	public void setLastConDate(Date lastConDate) {
		this.lastConDate = lastConDate;
	}
	
	public String getEmpStatus() {
		return empStatus;
	}
	
	public void setEmpStatus(String empStatus) {
		this.empStatus = empStatus;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public int getSex() {
		return sex;
	}
	
}