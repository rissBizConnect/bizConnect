package org.riss.bizconnect.support.model.dto;

import java.sql.Date;

public class Support implements java.io.Serializable {
    

	private static final long serialVersionUID = -1729591638720595983L;
	private int supportNo;              // 공지글 번호
    private String supportTitle;        // 공지 제목
    private Date supportDate;           // 공지 등록 날짜
    private String supportWriter;       // 공지 작성자
    private String supportContent;      // 공지 내용
    private String originalFilePath;   // 원본 첨부 파일 경로
    private String renameFilePath;     // 변경된 첨부 파일 경로
    private String importance;         // 중요도 (Y/N)
    private Date impEndDate;           // 중요도 종료 날짜
    private int readCount;             // 조회수
    private String comCode;            // 회사 코드 (외래 키)

    // 기본 생성자
    public Support() {
        super();
        // 기본값 설정

        this.readCount = 1;     // 조회수를 1로 기본 설정
    }
    
    
    public Support(int supportNo, String supportTitle, Date supportDate, String supportWriter, String supportContent,
			String originalFilePath, String renameFilePath, String importance, Date impEndDate, int readCount,
			String comCode) {
		super();
		this.supportNo = supportNo;
		this.supportTitle = supportTitle;
		this.supportDate = supportDate;
		this.supportWriter = supportWriter;
		this.supportContent = supportContent;
		this.originalFilePath = originalFilePath;
		this.renameFilePath = renameFilePath;
		this.importance = importance;
		this.impEndDate = impEndDate;
		this.readCount = readCount;
		this.comCode = comCode;
	}

    
	

	public int getSupportNo() {
		return supportNo;
	}


	public void setSupportNo(int supportNo) {
		this.supportNo = supportNo;
	}


	public String getSupportTitle() {
		return supportTitle;
	}


	public void setSupportTitle(String supportTitle) {
		this.supportTitle = supportTitle;
	}


	public Date getSupportDate() {
		return supportDate;
	}


	public void setSupportDate(Date supportDate) {
		this.supportDate = supportDate;
	}


	public String getSupportWriter() {
		return supportWriter;
	}


	public void setSupportWriter(String supportWriter) {
		this.supportWriter = supportWriter;
	}


	public String getSupportContent() {
		return supportContent;
	}


	public void setSupportContent(String supportContent) {
		this.supportContent = supportContent;
	}


	public String getOriginalFilePath() {
		return originalFilePath;
	}


	public void setOriginalFilePath(String originalFilePath) {
		this.originalFilePath = originalFilePath;
	}


	public String getRenameFilePath() {
		return renameFilePath;
	}


	public void setRenameFilePath(String renameFilePath) {
		this.renameFilePath = renameFilePath;
	}


	public String getImportance() {
		return importance;
	}


	public void setImportance(String importance) {
		this.importance = importance;
	}


	public Date getImpEndDate() {
		return impEndDate;
	}


	public void setImpEndDate(Date impEndDate) {
		this.impEndDate = impEndDate;
	}


	public int getReadCount() {
		return readCount;
	}


	public void setReadCount(int readCount) {
		this.readCount = readCount;
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
		return "Support [supportNo=" + supportNo + ", supportTitle=" + supportTitle + ", supportDate=" + supportDate
				+ ", supportWriter=" + supportWriter + ", supportContent=" + supportContent + ", originalFilePath="
				+ originalFilePath + ", renameFilePath=" + renameFilePath + ", importance=" + importance
				+ ", impEndDate=" + impEndDate + ", readCount=" + readCount + ", comCode=" + comCode + "]";
	}

    
	
}