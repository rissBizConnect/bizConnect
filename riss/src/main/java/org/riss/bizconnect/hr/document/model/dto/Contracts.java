package org.riss.bizconnect.hr.document.model.dto;

import java.io.Serializable;
import java.sql.Date;

public class Contracts implements Serializable {
	
	private static final long serialVersionUID = 8621293571373691741L;
	
	private String certificateId;        // 계약서 ID (자동 증가)
    private String certificateTitle;     // 서류명
    private String certificateDate;      // 등록 날짜
    private String certificateFile;      // 파일 경로
    private String certificateDescription; // 기타 설명
    private String gId;                // 로그인 아이디
    private String comCode;            // 회사 코드

    public Contracts() {
		super();
		// TODO Auto-generated constructor stub
	}
    
	public Contracts(String certificateId, String certificateTitle, String certificateDate, String certificateFile,
			String certificateDescription, String gId, String comCode) {
		super();
		this.certificateId = certificateId;
		this.certificateTitle = certificateTitle;
		this.certificateDate = certificateDate;
		this.certificateFile = certificateFile;
		this.certificateDescription = certificateDescription;
		this.gId = gId;
		this.comCode = comCode;
	}
	
	public String getCertificateId() {
		return certificateId;
	}
	
	public void setCertificateId(String certificateId) {
		this.certificateId = certificateId;
	}
	
	public String getCertificateTitle() {
		return certificateTitle;
	}
	
	public void setCertificateTitle(String certificateTitle) {
		this.certificateTitle = certificateTitle;
	}
	
	public String getCertificateDate() {
		return certificateDate;
	}
	
	public void setCertificateDate(String certificateDate) {
		this.certificateDate = certificateDate;
	}
	
	public String getCertificateFile() {
		return certificateFile;
	}
	
	public void setCertificateFile(String certificateFile) {
		this.certificateFile = certificateFile;
	}
	
	public String getCertificateDescription() {
		return certificateDescription;
	}
	
	public void setCertificateDescription(String certificateDescription) {
		this.certificateDescription = certificateDescription;
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
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public String toString() {
		return "Contracts [certificateId=" + certificateId + ", certificateTitle=" + certificateTitle
				+ ", certificateDate=" + certificateDate + ", certificateFile=" + certificateFile
				+ ", certificateDescription=" + certificateDescription + ", gId=" + gId + ", comCode=" + comCode + "]";
	}

	public void setContractsFile(String certificateFile) {
		this.certificateFile = certificateFile;
		
	}
	
    
	
	
	
}
