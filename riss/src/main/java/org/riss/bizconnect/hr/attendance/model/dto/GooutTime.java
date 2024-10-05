package org.riss.bizconnect.hr.attendance.model.dto;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

public class GooutTime implements Serializable {
	private static final long serialVersionUID = 505505501604098377L;
	
	private Date day;
	private Timestamp goDate;
	private Timestamp outDate;
	private Timestamp time;
	
	public GooutTime() {
		super();
	}

	public GooutTime(Date day, Timestamp goDate, Timestamp outDate, Timestamp time) {
		super();
		this.day = day;
		this.goDate = goDate;
		this.outDate = outDate;
		this.time = time;
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

	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "GooutTime [day=" + day + ", goDate=" + goDate + ", outDate=" + outDate + ", time=" + time + "]";
	}
	
}
