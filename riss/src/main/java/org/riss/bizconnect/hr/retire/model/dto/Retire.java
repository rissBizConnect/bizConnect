package org.riss.bizconnect.hr.retire.model.dto;

import java.io.Serializable;
import java.sql.Date;


public class Retire implements Serializable {
   
	private static final long serialVersionUID = -4691352981300651599L;
	
	private String retNo; 		 // 퇴직자 사번
	private String retType;		 // 고용형태
    private Date userEntryDate;  // 입사일
    private Date retDate; 		 // 퇴사일
    private String retTotalDate; // 총 근무일
    private String retExitReason; // 비고
    private boolean status;		 // 퇴직자 -> 사원 'N'
    private String comCode; 	 // 회사코드
    private String gid;			 // 유저 GID

    public Retire() {
		super();
	}

	public Retire(String retNo, String retType, Date userEntryDate, Date retDate, String retTotalDate,
			String retExitreson, String comCode, String gid) {
		super();
		this.retNo = retNo;
		this.retType = retType;
		this.userEntryDate = userEntryDate;
		this.retDate = retDate;
		this.retTotalDate = retTotalDate;
		this.retExitReason = retExitreson;
		this.comCode = comCode;
		this.gid = gid;
	}

	public String getRetNo() {
		return retNo;
	}

	public void setRetNo(String retNo) {
		this.retNo = retNo;
	}

	public String getRetType() {
		return retType;
	}

	public void setRetType(String retType) {
		this.retType = retType;
	}

	public Date getUserEntryDate() {
		return userEntryDate;
	}

	public void setUserEntryDate(Date userEntryDate) {
		this.userEntryDate = userEntryDate;
	}

	public Date getRetDate() {
		return retDate;
	}

	public void setRetDate(Date retDate) {
		this.retDate = retDate;
	}

	public String getRetTotalDate() {
		return retTotalDate;
	}

	public void setRetTotalDate(String retTotalDate) {
		this.retTotalDate = retTotalDate;
	}

	public String getRetExitreson() {
		return retExitReason;
	}

	public void setRetExitreson(String retExitreson) {
		this.retExitReason = retExitreson;
	}

	public String getComCode() {
		return comCode;
	}

	public void setComCode(String comCode) {
		this.comCode = comCode;
	}

	public String getGid() {
		return gid;
	}

	public void setGid(String gid) {
		this.gid = gid;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Retire [retNo=" + retNo + ", retType=" + retType + ", userEntryDate=" + userEntryDate + ", retDate="
				+ retDate + ", retTotalDate=" + retTotalDate + ", retExitreson=" + retExitReason + ", comCode=" + comCode
				+ ", gid=" + gid + "]";
	}



	
}
