package org.riss.bizconnect.common.model.dto;

public class Paging {
    private int currentPage;  // 현재 페이지
    private int startRow;     // 시작 행 번호
    private int rowCount;     // 한 페이지의 행 수

    // 생성자
    public Paging(int currentPage, int rowCount) {
        this.currentPage = currentPage;
        this.rowCount = rowCount;
        this.startRow = (currentPage - 1) * rowCount;
    }

    // Getter 및 Setter
    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
        this.startRow = (currentPage - 1) * rowCount;
    }

    public int getStartRow() {
        return startRow;
    }

    public int getRowCount() {
        return rowCount;
    }
}
