package org.riss.bizconnect.hr.retire.model.dto;

import java.io.Serializable;
import java.sql.Date;

public class Retire implements Serializable {
   
	private static final long serialVersionUID = -4691352981300651599L;
	
	private String retNo; 		// 퇴직자 사번
    private String gid; 		// 유저 GID
    private Date retDate; 		// 퇴사일
    private String retTotalDate; 	// 총 근무일
    private String retType;		// 고용형태
    private String exitReason;	// 비고
    private String comCode;		// 회사코드
	private String status;		// 퇴직자 -> 사원
	private Date userEntryDate;
	
	public Retire() {
		super();
	}

	public Retire(String retNo, String gid, Date retDate, String retType, String comCode, Date userEntryDate) {
		super();
		this.retNo = retNo;
		this.gid = gid;
		this.retDate = retDate;
		this.retType = retType;
		this.comCode = comCode;
		this.userEntryDate = userEntryDate;
	}

	public Retire(String retNo, String gid, Date retDate, String retTotalDate, String retType, String exitReason,
			String comCode, String status, Date userEntryDate) {
		super();
		this.retNo = retNo;
		this.gid = gid;
		this.retDate = retDate;
		this.retTotalDate = retTotalDate;
		this.retType = retType;
		this.exitReason = exitReason;
		this.comCode = comCode;
		this.status = status;
		this.userEntryDate = userEntryDate;
	}

	public String getRetNo() {
		return retNo;
	}

	public void setRetNo(String retNo) {
		this.retNo = retNo;
	}

	public String getGid() {
		return gid;
	}

	public void setGid(String gid) {
		this.gid = gid;
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

	public String getRetType() {
		return retType;
	}

	public void setRetType(String retType) {
		this.retType = retType;
	}

	public String getExitReason() {
		return exitReason;
	}

	public void setExitReason(String exitReason) {
		this.exitReason = exitReason;
	}

	public String getComCode() {
		return comCode;
	}

	public void setComCode(String comCode) {
		this.comCode = comCode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getUserEntryDate() {
		return userEntryDate;
	}

	public void setUserEntryDate(Date userEntryDate) {
		this.userEntryDate = userEntryDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Retire [retNo=" + retNo + ", gid=" + gid + ", retDate=" + retDate + ", retTotalDate=" + retTotalDate
				+ ", retType=" + retType + ", exitReason=" + exitReason + ", comCode=" + comCode + ", status=" + status
				+ ", userEntryDate=" + userEntryDate + "]";
	}
	
	
	
}
