package org.riss.bizconnect.hr.retiree.model.dto;

import java.io.Serializable;

public class RetireDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String retireId;
    private String retireName;
    private String user_entry_date;
    private String ret_date;
    private String ret_type;

    // 기본 생성자
    public RetireDTO() {}

    // 매개변수가 있는 생성자
    public RetireDTO(String retireId, String retireName, String user_entry_date, String ret_date, String ret_type) {
        this.retireId = retireId;
        this.retireName = retireName;
        this.user_entry_date = user_entry_date;
        this.ret_date = ret_date;
        this.ret_type = ret_type;
    }

    // Getter 및 Setter
    public String getRetireId() {
        return retireId;
    }

    public void setRetireId(String retireId) {
        this.retireId = retireId;
    }

    public String getRetireName() {
        return retireName;
    }

    public void setRetireName(String retireName) {
        this.retireName = retireName;
    }

    public String getUser_entry_date() {
        return user_entry_date;
    }

    public void setUser_entry_date(String user_entry_date) {
        this.user_entry_date = user_entry_date;
    }

    public String getRet_date() {
        return ret_date;
    }

    public void setRet_date(String ret_date) {
        this.ret_date = ret_date;
    }

    public String getRet_type() {
        return ret_type;
    }

    public void setRet_type(String ret_type) {
        this.ret_type = ret_type;
    }

    @Override
    public String toString() {
        return "RetireDTO [retireId=" + retireId + ", retireName=" + retireName + ", user_entry_date=" + user_entry_date + ", ret_date=" + ret_date + ", ret_type=" + ret_type + "]";
    }
}
