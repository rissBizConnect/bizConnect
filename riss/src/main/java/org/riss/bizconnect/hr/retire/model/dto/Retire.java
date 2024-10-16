package org.riss.bizconnect.hr.retire.model.dto;

import java.io.Serializable;
import java.sql.Date;

import org.springframework.web.bind.annotation.RequestParam;



public class Retire implements Serializable {
   
	private static final long serialVersionUID = -4691352981300651599L;
	
	private String retNo; 		// 퇴직자 사번
    private String gid; 		// 유저 GID
	private Date userEntryDate; // 입사일
    private Date retDate; 		// 퇴사일
    private int retTotalDate; 	// 총 근무일
    private String retType;		// 고용형태
    private String exitReason;	// 비고
    private String comCode;		// 회사코드
	private String status;		// 퇴직자 -> 사원

	
	public Retire() {
		super();
	}

	public Retire(String retNo, String gid, Date retDate, String retType, String comCode, Date userEntryDate, String status) {
        this.retNo = retNo;
        this.gid = gid;
        this.retDate = retDate;
        this.retType = retType;
        this.comCode = comCode;
        this.userEntryDate = userEntryDate;
        this.status = status;
    }

	public Retire(String retNo, String gid, Date retDate, int retTotalDate, String retType, String exitReason,
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

	public int getRetTotalDate() {
		return retTotalDate;
	}

	public void setRetTotalDate(int retTotalDate) {
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Retire [retNo=" + retNo + ", gid=" + gid + ", userEntryDate=" + userEntryDate + ", retDate=" + retDate
				+ ", retTotalDate=" + retTotalDate + ", retType=" + retType + ", exitReason=" + exitReason
				+ ", comCode=" + comCode + ", status=" + status + "]";
	}

	
}
