package org.riss.bizconnect.hr.model.dto;

import java.io.Serializable;
import java.sql.Date;

public class GooutTime implements Serializable {
	private static final long serialVersionUID = 505505501604098377L;
	
	private Date goDate;
	private Date outDate;
	private Date time;
	
	public GooutTime() {
		super();
	}

	public GooutTime(Date goDate, Date outDate, Date time) {
		super();
		this.goDate = goDate;
		this.outDate = outDate;
		this.time = time;
	}

	public Date getGoDate() {
		return goDate;
	}

	public void setGoDate(Date goDate) {
		this.goDate = goDate;
	}

	public Date getOutDate() {
		return outDate;
	}

	public void setOutDate(Date outDate) {
		this.outDate = outDate;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "GooutTime [goDate=" + goDate + ", outDate=" + outDate + ", time=" + time + "]";
	}
	
}
