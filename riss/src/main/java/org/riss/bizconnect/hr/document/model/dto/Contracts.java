package org.riss.bizconnect.hr.document.model.dto;

import java.io.Serializable;
import java.sql.Date;

public class Contracts implements Serializable {
	
	private static final long serialVersionUID = 8621293571373691741L;
	
	private String contractsId;        // 계약서 ID (자동 증가)
    private String contractsTitle;     // 서류명
    private String contractsDate;      // 등록 날짜
    private String contractsFile;      // 파일 경로
    private String contractsDescription; // 기타 설명
    private String gId;                // 로그인 아이디
    private String comCode;            // 회사 코드

    public Contracts() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Contracts(String contractsId, String contractsTitle, String contractsDate, String contractsFile,
			String contractsDescription, String gId, String comCode) {
		super();
		this.contractsId = contractsId;
		this.contractsTitle = contractsTitle;
		this.contractsDate = contractsDate;
		this.contractsFile = contractsFile;
		this.contractsDescription = contractsDescription;
		this.gId = gId;
		this.comCode = comCode;
	}

	public String getContractsId() {
		return contractsId;
	}

	public void setContractsId(String contractsId) {
		this.contractsId = contractsId;
	}

	public String getContractsTitle() {
		return contractsTitle;
	}

	public void setContractsTitle(String contractsTitle) {
		this.contractsTitle = contractsTitle;
	}

	public String getContractsDate() {
		return contractsDate;
	}

	public void setContractsDate(String contractsDate) {
		this.contractsDate = contractsDate;
	}

	public String getContractsFile() {
		return contractsFile;
	}

	public void setContractsFile(String contractsFile) {
		this.contractsFile = contractsFile;
	}

	public String getContractsDescription() {
		return contractsDescription;
	}

	public void setContractsDescription(String contractsDescription) {
		this.contractsDescription = contractsDescription;
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
		return "Contracts [contractsId=" + contractsId + ", contractsTitle=" + contractsTitle + ", contractsDate="
				+ contractsDate + ", contractsFile=" + contractsFile + ", contractsDescription=" + contractsDescription
				+ ", gId=" + gId + ", comCode=" + comCode + "]";
	}
    
	
}
