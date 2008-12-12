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
	private int id;							// 인덱스
	private String loginId;					// 로그인 아이디
	private String password;				// Password
	private String userName;				// 사용자 이름
	private String orgCode;					// 부서 코드
	private String orgName;					// 부서명
	private String userEmail;				// 사용자 이메일
	private String telNum;					// 전화번호
	private String celNum;					// 핸드폰 번호
	private String officialPosition;		// 직위 (조직서열)
	private String officialPositionCode;	// 직위 (조직서열)
	private String officialDuty;			// 직책 (단위 조직 임무)
	private String officialDutyCode;		// 직책 (단위 조직 임무)
	private String officialGrade;			// 직급 (연공서열)
	private String officialGradeCode;		// 직급 (연공서열)
	private int connectCnt;					// 접속 수
	private String empCode;					// 직원코드
	@Temporal(TemporalType.DATE)
	private Date regDate;					// 등록일
	@Temporal(TemporalType.DATE)
	private Date modDate;					// 최종정보수정일
	@Temporal(TemporalType.DATE)
	private Date lastConDate;				// 최종 접속일
	private String empStatus;				// 직원상태 : 사용함, 사용안함.
	
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