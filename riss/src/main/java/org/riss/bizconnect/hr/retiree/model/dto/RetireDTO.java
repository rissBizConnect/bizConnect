package org.riss.bizconnect.hr.retiree.model.dto;

import java.util.Date;

public class RetireDTO {
    private int retNo;              // 퇴직 번호
    private String comCode;         // 회사 코드
    private String retType;         // 퇴직 유형
    private String retExitReason;   // 퇴직 사유
    private Date retDate;           // 퇴직일
    private Date retTotalDate;      // 총 근무일
    private String userName;
	
    public RetireDTO() {
		super();
	}
    
    public RetireDTO(int retNo, String comCode, String retType, String retExitReason, Date retDate, Date retTotalDate, String userName)  {
		super();
		this.retNo = retNo;
		this.comCode = comCode;
		this.retType = retType;
		this.retExitReason = retExitReason;
		this.retDate = retDate;
		this.retTotalDate = retTotalDate;
		this.userName = userName;
	}

	public int getRetNo() {
		return retNo;
	}

	public void setRetNo(int retNo) {
		this.retNo = retNo;
	}

	public String getComCode() {
		return comCode;
	}

	public void setComCode(String comCode) {
		this.comCode = comCode;
	}

	public String getRetType() {
		return retType;
	}

	public void setRetType(String retType) {
		this.retType = retType;
	}

	public String getRetExitReason() {
		return retExitReason;
	}

	public void setRetExitReason(String retExitReason) {
		this.retExitReason = retExitReason;
	}

	public Date getRetDate() {
		return retDate;
	}

	public void setRetDate(Date retDate) {
		this.retDate = retDate;
	}

	public Date getRetTotalDate() {
		return retTotalDate;
	}

	public void setRetTotalDate(Date retTotalDate) {
		this.retTotalDate = retTotalDate;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "RetireDTO [retNo=" + retNo + ", comCode=" + comCode + ", retType=" + retType + ", retExitReason="
				+ retExitReason + ", retDate=" + retDate + ", retTotalDate=" + retTotalDate + ", userName=" + userName
				+ "]";
	}

	
	
    

}