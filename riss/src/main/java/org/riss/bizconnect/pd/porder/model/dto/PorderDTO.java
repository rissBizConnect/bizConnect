package org.riss.bizconnect.pd.porder.model.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class PorderDTO implements Serializable {
	private static final long serialVersionUID = 4097767075615912169L;
	
	private int PorderNo; //발주번호
	private String LicenseCode; //회사코드
	private String ProductNo; //제품번호
	private String ClientCode; //거래처번호
	private String PorderName; //발주제품명
	private double PorderPrice; //발주금액
	private double PorderTax; //발주제품 부가세
	private int PorderCnt; //발주수량
	private LocalDate PorderDate; //발주일
	private LocalDate DueDate; //납기일
	private String PorderStatus; //발주상태
	private String FieldNum; //창고번호
	
	public PorderDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PorderDTO(int porderNo, String licenseCode, String productNo, String clientCode, String porderName,
			double porderPrice, double porderTax, int porderCnt, LocalDate porderDate, LocalDate dueDate,
			String porderStatus, String fieldNum) {
		super();
		PorderNo = porderNo;
		LicenseCode = licenseCode;
		ProductNo = productNo;
		ClientCode = clientCode;
		PorderName = porderName;
		PorderPrice = porderPrice;
		PorderTax = porderTax;
		PorderCnt = porderCnt;
		PorderDate = porderDate;
		DueDate = dueDate;
		PorderStatus = porderStatus;
		FieldNum = fieldNum;
	}
	public int getPorderNo() {
		return PorderNo;
	}
	public void setPorderNo(int porderNo) {
		PorderNo = porderNo;
	}
	public String getLicenseCode() {
		return LicenseCode;
	}
	public void setLicenseCode(String licenseCode) {
		LicenseCode = licenseCode;
	}
	public String getProductNo() {
		return ProductNo;
	}
	public void setProductNo(String productNo) {
		ProductNo = productNo;
	}
	public String getClientCode() {
		return ClientCode;
	}
	public void setClientCode(String clientCode) {
		ClientCode = clientCode;
	}
	public String getPorderName() {
		return PorderName;
	}
	public void setPorderName(String porderName) {
		PorderName = porderName;
	}
	public double getPorderPrice() {
		return PorderPrice;
	}
	public void setPorderPrice(double porderPrice) {
		PorderPrice = porderPrice;
	}
	public double getPorderTax() {
		return PorderTax;
	}
	public void setPorderTax(double porderTax) {
		PorderTax = porderTax;
	}
	public int getPorderCnt() {
		return PorderCnt;
	}
	public void setPorderCnt(int porderCnt) {
		PorderCnt = porderCnt;
	}
	public LocalDate getPorderDate() {
		return PorderDate;
	}
	public void setPorderDate(LocalDate porderDate) {
		PorderDate = porderDate;
	}
	public LocalDate getDueDate() {
		return DueDate;
	}
	public void setDueDate(LocalDate dueDate) {
		DueDate = dueDate;
	}
	public String getPorderStatus() {
		return PorderStatus;
	}
	public void setPorderStatus(String porderStatus) {
		PorderStatus = porderStatus;
	}
	public String getFieldNum() {
		return FieldNum;
	}
	public void setFieldNum(String fieldNum) {
		FieldNum = fieldNum;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "PorderDTO [PorderNo=" + PorderNo + ", LicenseCode=" + LicenseCode + ", ProductNo=" + ProductNo
				+ ", ClientCode=" + ClientCode + ", PorderName=" + PorderName + ", PorderPrice=" + PorderPrice
				+ ", PorderTax=" + PorderTax + ", PorderCnt=" + PorderCnt + ", PorderDate=" + PorderDate + ", DueDate="
				+ DueDate + ", PorderStatus=" + PorderStatus + ", FieldNum=" + FieldNum + "]";
	}
	
	

}
