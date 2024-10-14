package org.riss.bizconnect.main.notice.model.dto;

import java.sql.Date;

public class Notice implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private int noticeNo;              // 공지글 번호
    private String noticeTitle;        // 공지 제목
    private Date noticeDate;           // 공지 등록 날짜
    private String noticeWriter;       // 공지 작성자
    private String noticeContent;      // 공지 내용
    private String originalFilePath;   // 원본 첨부 파일 경로
    private String renameFilePath;     // 변경된 첨부 파일 경로
    private String importance;         // 중요도 (Y/N)
    private Date impEndDate;           // 중요도 종료 날짜
    private int readCount;             // 조회수
    private String comCode;            // 회사 코드 (외래 키)

    // 기본 생성자
    public Notice() {
        super();
        // 기본값 설정
        this.importance = "N";  // 기본 중요도를 'N'으로 설정
        this.readCount = 1;     // 조회수를 1로 기본 설정
    }

    // 모든 필드를 포함한 생성자
    public Notice(int noticeNo, String noticeTitle, Date noticeDate, String noticeWriter, String noticeContent,
                  String originalFilePath, String renameFilePath, String importance, Date impEndDate,
                  int readCount, String comCode) {
        this.noticeNo = noticeNo;
        this.noticeTitle = noticeTitle;
        this.noticeDate = noticeDate;
        this.noticeWriter = noticeWriter;
        this.noticeContent = noticeContent;
        this.originalFilePath = originalFilePath;
        this.renameFilePath = renameFilePath;
        this.importance = importance;
        this.impEndDate = impEndDate;
        this.readCount = readCount;
        this.comCode = comCode;
    }

    // getter와 setter 메소드
    public int getNoticeNo() {
        return noticeNo;
    }

    public void setNoticeNo(int noticeNo) {
        this.noticeNo = noticeNo;
    }

    public String getNoticeTitle() {
        return noticeTitle;
    }

    public void setNoticeTitle(String noticeTitle) {
        this.noticeTitle = noticeTitle;
    }

    public Date getNoticeDate() {
        return noticeDate;
    }

    public void setNoticeDate(Date noticeDate) {
        this.noticeDate = noticeDate;
    }

    public String getNoticeWriter() {
        return noticeWriter;
    }

    public void setNoticeWriter(String noticeWriter) {
        this.noticeWriter = noticeWriter;
    }

    public String getNoticeContent() {
        return noticeContent;
    }

    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent;
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

    @Override
    public String toString() {
        return "Notice [noticeNo=" + noticeNo + ", noticeTitle=" + noticeTitle + ", noticeDate=" + noticeDate
                + ", noticeWriter=" + noticeWriter + ", noticeContent=" + noticeContent + ", originalFilePath="
                + originalFilePath + ", renameFilePath=" + renameFilePath + ", importance=" + importance
                + ", impEndDate=" + impEndDate + ", readCount=" + readCount + ", comCode=" + comCode + "]";
    }
}
