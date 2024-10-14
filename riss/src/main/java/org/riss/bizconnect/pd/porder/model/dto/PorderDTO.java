package org.riss.bizconnect.pd.porder.model.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class PorderDTO implements Serializable {
	private static final long serialVersionUID = 4097767075615912169L;
	
	private int PorderNo; //���ֹ�ȣ
	private String LicenseCode; //ȸ���ڵ�
	private String ProductNo; //��ǰ��ȣ
	private String ClientCode; //�ŷ�ó��ȣ
	private String PorderName; //������ǰ��
	private double PorderPrice; //���ֱݾ�
	private double PorderTax; //������ǰ �ΰ���
	private int PorderCnt; //���ּ���
	private LocalDate PorderDate; //������
	private LocalDate DueDate; //������
	private String PorderStatus; //���ֻ���
	private String FieldNum; //â���ȣ
	
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