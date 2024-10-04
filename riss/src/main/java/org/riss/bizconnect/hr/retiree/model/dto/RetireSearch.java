package org.riss.bizconnect.hr.retiree.model.dto;

import java.io.Serializable;

public class RetireSearch implements Serializable {
    private String name;        // 검색할 퇴직자 이름
    private String entryYear;   // 검색할 입사년도
    private String retireYear;  // 검색할 퇴직년도
    private String retireType;   // 검색할 고용형태

    // 기본 생성자
    public RetireSearch() {}

    // 매개변수 있는 생성자
    public RetireSearch(String name, String entryYear, String retireYear, String retireType) {
        this.name = name;
        this.entryYear = entryYear;
        this.retireYear = retireYear;
        this.retireType = retireType;
    }

    // Getter와 Setter
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEntryYear() { return entryYear; }
    public void setEntryYear(String entryYear) { this.entryYear = entryYear; }
    public String getRetireYear() { return retireYear; }
    public void setRetireYear(String retireYear) { this.retireYear = retireYear; }
    public String getRetireType() { return retireType; }
    public void setRetireType(String retireType) { this.retireType = retireType; }

    @Override
    public String toString() {
        return "RetireSearch [name=" + name + ", entryYear=" + entryYear + ", retireYear=" + retireYear 
                + ", retireType=" + retireType + "]";
    }
}
