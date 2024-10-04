package org.riss.bizconnect.common.model.dto;

public class Search {
    private String keyword;     // 검색어
    private String startDate;   // 검색 시작일 (입사일, 퇴사일)
    private String endDate;     // 검색 종료일 (입사일, 퇴사일)

    // 기본 생성자
    public Search() {}

    // 매개변수 있는 생성자
    public Search(String keyword, String startDate, String endDate) {
        this.keyword = keyword;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    // Getter 및 Setter
    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
