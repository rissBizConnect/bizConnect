package org.riss.bizconnect.pd.porder.dto;

import java.io.Serializable;

public class PorderDTO implements Serializable {

	private static final long serialVersionUID = 9127824007978854935L;
	
	private String test;

	public PorderDTO() {
		super();
	}

	public PorderDTO(String test) {
		super();
		this.test = test;
	}

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}	
