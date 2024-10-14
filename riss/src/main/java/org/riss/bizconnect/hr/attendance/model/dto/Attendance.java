package org.riss.bizconnect.hr.attendance.model.dto;

import java.io.Serializable;
import java.lang.System.Logger;
import java.sql.Date;
import java.sql.Timestamp;

public class Attendance implements Serializable {
	private static final long serialVersionUID = 505505501604098377L;
	
	private String gId; 			//아이디
	private String comCode;		//회사코드
	private Date day;
	private Timestamp goDate;
	private Timestamp outDate;
	private long time;
	
	public Attendance() {
		super();
	}

	public Attendance(String gId, String comCode, Date day, Timestamp goDate, Timestamp outDate, long time) {
		super();
		this.gId = gId;
		this.comCode = comCode;
		this.day = day;
		this.goDate = goDate;
		this.outDate = outDate;
		this.time = time;
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

	public Date getDay() {
		return day;
	}

	public void setDay(Date day) {
		this.day = day;
	}

	public Timestamp getGoDate() {
		return goDate;
	}

	public void setGoDate(Timestamp goDate) {
		this.goDate = goDate;
	}

	public Timestamp getOutDate() {
		return outDate;
	}

	public void setOutDate(Timestamp outDate) {
		this.outDate = outDate;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Attendance [gId=" + gId + ", comCode=" + comCode + ", day=" + day + ", goDate=" + goDate + ", outDate="
				+ outDate + ", time=" + time + "]";
	}
	
	public void calTimestamp() { 
		this.time = (this.outDate.getTime() - this.goDate.getTime()) / 1000;
	}

	public long calSTimestamp() { 
		return this.time % 60;
	}
	
	public long calMTimestamp() { 
		return (this.time / 60) % 60;
	}
	
	public long calHTimestamp() { 
		return this.time / (60 * 60);
	}
}
