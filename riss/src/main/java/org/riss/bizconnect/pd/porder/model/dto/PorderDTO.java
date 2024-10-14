package org.riss.bizconnect.pd.porder.model.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class PorderDTO implements Serializable {
	private static final long serialVersionUID = 4097767075615912169L;
	
	private int porderNo; //발주번호
	private String licenseCode; //회사코드
	private String productNo; //제품번호
	private String productName; //제품이름
	private String clientCode; //거래처번호
	private String porderName; //발주제품명
	private double porderPrice; //발주금액
	private double porderTax; //발주제품 부가세
	private int porderCnt; //발주수량
	private LocalDate porderDate; //발주일
	private LocalDate sueDate; //납기일
	private String porderStatus; //발주상태
	private String fieldNum;
	
	public PorderDTO() {
		super();
		// TODO Auto-generated constructor stub
	} //창고번호

	public PorderDTO(int porderNo, String licenseCode, String productNo, String productName, String clientCode,
			String porderName, double porderPrice, double porderTax, int porderCnt, LocalDate porderDate,
			LocalDate sueDate, String porderStatus, String fieldNum) {
		super();
		this.porderNo = porderNo;
		this.licenseCode = licenseCode;
		this.productNo = productNo;
		this.productName = productName;
		this.clientCode = clientCode;
		this.porderName = porderName;
		this.porderPrice = porderPrice;
		this.porderTax = porderTax;
		this.porderCnt = porderCnt;
		this.porderDate = porderDate;
		this.sueDate = sueDate;
		this.porderStatus = porderStatus;
		this.fieldNum = fieldNum;
	}

	public int getPorderNo() {
		return porderNo;
	}

	public void setPorderNo(int porderNo) {
		this.porderNo = porderNo;
	}

	public String getLicenseCode() {
		return licenseCode;
	}

	public void setLicenseCode(String licenseCode) {
		this.licenseCode = licenseCode;
	}

	public String getProductNo() {
		return productNo;
	}

	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getClientCode() {
		return clientCode;
	}

	public void setClientCode(String clientCode) {
		this.clientCode = clientCode;
	}

	public String getPorderName() {
		return porderName;
	}

	public void setPorderName(String porderName) {
		this.porderName = porderName;
	}

	public double getPorderPrice() {
		return porderPrice;
	}

	public void setPorderPrice(double porderPrice) {
		this.porderPrice = porderPrice;
	}

	public double getPorderTax() {
		return porderTax;
	}

	public void setPorderTax(double porderTax) {
		this.porderTax = porderTax;
	}

	public int getPorderCnt() {
		return porderCnt;
	}

	public void setPorderCnt(int porderCnt) {
		this.porderCnt = porderCnt;
	}

	public LocalDate getPorderDate() {
		return porderDate;
	}

	public void setPorderDate(LocalDate porderDate) {
		this.porderDate = porderDate;
	}

	public LocalDate getSueDate() {
		return sueDate;
	}

	public void setSueDate(LocalDate sueDate) {
		this.sueDate = sueDate;
	}

	public String getPorderStatus() {
		return porderStatus;
	}

	public void setPorderStatus(String porderStatus) {
		this.porderStatus = porderStatus;
	}

	public String getFieldNum() {
		return fieldNum;
	}

	public void setFieldNum(String fieldNum) {
		this.fieldNum = fieldNum;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "PorderDTO [porderNo=" + porderNo + ", licenseCode=" + licenseCode + ", productNo=" + productNo
				+ ", productName=" + productName + ", clientCode=" + clientCode + ", porderName=" + porderName
				+ ", porderPrice=" + porderPrice + ", porderTax=" + porderTax + ", porderCnt=" + porderCnt
				+ ", porderDate=" + porderDate + ", sueDate=" + sueDate + ", porderStatus=" + porderStatus
				+ ", fieldNum=" + fieldNum + "]";
	}
	
	
}	
	
	