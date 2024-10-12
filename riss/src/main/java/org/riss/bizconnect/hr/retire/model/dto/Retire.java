package org.riss.bizconnect.hr.retire.model.dto;

import java.io.Serializable;
import java.util.Date;

import org.riss.bizconnect.common.model.dto.Member;

public class Retire implements Serializable {
   
	private static final long serialVersionUID = -4691352981300651599L;
	
	private String retNo; 		// 퇴직자 사번
    private String gid; 		// 유저 GID
    private Date retDate; 		// 퇴사일
    private int retTotalDate; 	// 총 근무일
    private String retType;		// 고용형태
    private String ExitReason;	// 비고
    private String comCode;		// 회사코드
	private String status;		// 퇴직자 -> 사원
	
	public Retire() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	private Member member;
	
	public Retire(String retNo, String gid, Date retDate, int retTotalDate, String retType, String exitReason,
			String comCode, String status) {
		super();
		this.retNo = retNo;
		this.gid = gid;
		this.retDate = retDate;
		this.retTotalDate = retTotalDate;
		this.retType = retType;
		ExitReason = exitReason;
		this.comCode = comCode;
		this.status = status;
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
		return ExitReason;
	}

	public void setExitReason(String exitReason) {
		ExitReason = exitReason;
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

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Retire [retNo=" + retNo + ", gid=" + gid + ", retDate=" + retDate + ", retTotalDate=" + retTotalDate
				+ ", retType=" + retType + ", ExitReason=" + ExitReason + ", comCode=" + comCode + ", status=" + status
				+ "]";
	}

	
	
	
	
	
}
