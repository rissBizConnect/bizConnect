package org.riss.bizconnect.common.model.dto;

import java.io.Serializable;
import java.sql.Date;

public class Member implements Serializable {
	private static final long serialVersionUID = 662131242686852907L;
	
	private String gId; 			//아이디
	private String comCode;		//회사코드
	private String userPW;		//비밀번호
	private String userName;		//이름
	private String userJob;		//직원분류
	private String userRegNo;		//주민번호
	private String userPhone;		//전화버놓
	private String userEmail;		//이메일
	private String userAddr;		//주소
	private Date userEntry;		//입사일
	private int userPay;			//기본급
	private String userContract;		//계약서
	private String userAccount;		//계좌번호
	private String userCard;		//카드번호
	private String userRole;		//권한
	private String userFacePictPath;	//얼굴 사진 주소
	
	public Member() {
		super();
	}


	public Member(String gId, String comCode, String userPW, String userName, String userRegNo, Date userEntry,
			String userContract, String userRole) {
		super();
		this.gId = gId;
		this.comCode = comCode;
		this.userPW = userPW;
		this.userName = userName;
		this.userRegNo = userRegNo;
		this.userEntry = userEntry;
		this.userContract = userContract;
		this.userRole = userRole;
	}

	public Member(String gId, String comCode, String userPW, String userName, String userJob, String userRegNo,
			String userPhone, String userEmail, String userAddr, Date userEntry, int userPay, String userContract,
			String userAccount, String userCard, String userRole, String userFacePictPath) {
		super();
		this.gId = gId;
		this.comCode = comCode;
		this.userPW = userPW;
		this.userName = userName;
		this.userJob = userJob;
		this.userRegNo = userRegNo;
		this.userPhone = userPhone;
		this.userEmail = userEmail;
		this.userAddr = userAddr;
		this.userEntry = userEntry;
		this.userPay = userPay;
		this.userContract = userContract;
		this.userAccount = userAccount;
		this.userCard = userCard;
		this.userRole = userRole;
		this.userFacePictPath = userFacePictPath;
	}

	public String getgId() {
		return gId;
	}

	public void setgId(String gId) {
		this.gId = gId;
	}

	public String getComCode() {
		return comCode;
	}

	public void setComCode(String comCode) {
		this.comCode = comCode;
	}

	public String getUserPW() {
		return userPW;
	}

	public void setUserPW(String userPW) {
		this.userPW = userPW;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserJob() {
		return userJob;
	}

	public void setUserJob(String userJob) {
		this.userJob = userJob;
	}

	public String getUserRegNo() {
		return userRegNo;
	}

	public void setUserRegNo(String userRegNo) {
		this.userRegNo = userRegNo;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserAddr() {
		return userAddr;
	}

	public void setUserAddr(String userAddr) {
		this.userAddr = userAddr;
	}

	public Date getUserEntry() {
		return userEntry;
	}

	public void setUserEntry(Date userEntry) {
		this.userEntry = userEntry;
	}

	public int getUserPay() {
		return userPay;
	}

	public void setUserPay(int userPay) {
		this.userPay = userPay;
	}

	public String getUserContract() {
		return userContract;
	}

	public void setUserContract(String userContract) {
		this.userContract = userContract;
	}

	public String getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public String getUserCard() {
		return userCard;
	}

	public void setUserCard(String userCard) {
		this.userCard = userCard;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public String getUserFacePictPath() {
		return userFacePictPath;
	}

	public void setUserFacePictPath(String userFacePictPath) {
		this.userFacePictPath = userFacePictPath;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Member [gId=" + gId + ", comCode=" + comCode + ", userPW=" + userPW + ", userName=" + userName
				+ ", userJob=" + userJob + ", userRegNo=" + userRegNo + ", userPhone=" + userPhone + ", userEmail="
				+ userEmail + ", userAddr=" + userAddr + ", userEntry=" + userEntry + ", userPay=" + userPay
				+ ", userContract=" + userContract + ", userAccount=" + userAccount + ", userCard=" + userCard
				+ ", userRole=" + userRole + ", userFacePictPath=" + userFacePictPath + "]";
	}
	
	
}
