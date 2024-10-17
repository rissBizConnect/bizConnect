package org.riss.bizconnect.pd.client.model.dto;

import java.io.Serializable;
import java.sql.Date;

public class ClientDTO implements Serializable {

	private static final long serialVersionUID = -4159441270266239972L;
	private int ClientCode; //거래처코드
	private String LicenseCode; //회사코드
	private String BusinessNum; //사업자번호
	private String ClientName; //거래처명
	private String PersonCharge; //담당자명
	private String BusinessType; //거래처업종
	private String ClientTel; //거래처전화번호
	private String ClientAddr; //거래처주소
	private String ClientEmail; //거래처이메일
	private String ClientFax; //거래처팩스번호
	private String FileName; //저장파일명
	private Date ModifiDate; //수정일
	
	public ClientDTO() {
		super();
	}

	public ClientDTO(int clientCode, String licenseCode, String businessNum, String clientName, String personCharge,
			String businessType, String clientTel, String clientAddr, String clientEmail, String clientFax,
			String fileName, Date modifiDate) {
		super();
		ClientCode = clientCode;
		LicenseCode = licenseCode;
		BusinessNum = businessNum;
		ClientName = clientName;
		PersonCharge = personCharge;
		BusinessType = businessType;
		ClientTel = clientTel;
		ClientAddr = clientAddr;
		ClientEmail = clientEmail;
		ClientFax = clientFax;
		FileName = fileName;
		ModifiDate = modifiDate;
	}

	public int getClientCode() {
		return ClientCode;
	}

	public void setClientCode(int clientCode) {
		ClientCode = clientCode;
	}

	public String getLicenseCode() {
		return LicenseCode;
	}

	public void setLicenseCode(String licenseCode) {
		LicenseCode = licenseCode;
	}

	public String getBusinessNum() {
		return BusinessNum;
	}

	public void setBusinessNum(String businessNum) {
		BusinessNum = businessNum;
	}

	public String getClientName() {
		return ClientName;
	}

	public void setClientName(String clientName) {
		ClientName = clientName;
	}

	public String getPersonCharge() {
		return PersonCharge;
	}

	public void setPersonCharge(String personCharge) {
		PersonCharge = personCharge;
	}

	public String getBusinessType() {
		return BusinessType;
	}

	public void setBusinessType(String businessType) {
		BusinessType = businessType;
	}

	public String getClientTel() {
		return ClientTel;
	}

	public void setClientTel(String clientTel) {
		ClientTel = clientTel;
	}

	public String getClientAddr() {
		return ClientAddr;
	}

	public void setClientAddr(String clientAddr) {
		ClientAddr = clientAddr;
	}

	public String getClientEmail() {
		return ClientEmail;
	}

	public void setClientEmail(String clientEmail) {
		ClientEmail = clientEmail;
	}

	public String getClientFax() {
		return ClientFax;
	}

	public void setClientFax(String clientFax) {
		ClientFax = clientFax;
	}

	public String getFileName() {
		return FileName;
	}

	public void setFileName(String fileName) {
		FileName = fileName;
	}

	public Date getModifiDate() {
		return ModifiDate;
	}

	public void setModifiDate(Date modifiDate) {
		ModifiDate = modifiDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "ClientDTO [ClientCode=" + ClientCode + ", LicenseCode=" + LicenseCode + ", BusinessNum=" + BusinessNum
				+ ", ClientName=" + ClientName + ", PersonCharge=" + PersonCharge + ", BusinessType=" + BusinessType
				+ ", ClientTel=" + ClientTel + ", ClientAddr=" + ClientAddr + ", ClientEmail=" + ClientEmail
				+ ", ClientFax=" + ClientFax + ", FileName=" + FileName + ", ModifiDate=" + ModifiDate + "]";
	}
	

}
