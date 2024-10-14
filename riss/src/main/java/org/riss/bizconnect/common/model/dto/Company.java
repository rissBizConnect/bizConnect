package org.riss.bizconnect.common.model.dto;

import java.io.Serializable;

public class Company implements Serializable{

	private static final long serialVersionUID = 2853105822178733496L;
	
	String comCode;		//회사코드
	String comShop;		//상호
	String comType;		//업종
	String comName;		//대표자이름
	String comTel;			//번호
	String comCBR;		//사업자등록번호
	String comAddress;		//주소
	String comMail;		//메일
	String comBank;		//계좌
}
