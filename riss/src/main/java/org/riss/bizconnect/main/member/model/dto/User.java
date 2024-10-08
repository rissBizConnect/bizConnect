package org.riss.bizconnect.main.member.model.dto;

// src/main/java/org/riss/bizconnect/main/member/model/dto/User.java
public class User implements java.io.Serializable {
    private static final long serialVersionUID = -2119372912749016520L;

    private String gID;        // GID
    private String userPw;     // USER_PW
    private String comCode;    // COM_CODE
    private String userName;   // USER_NAME
    private String userRole;   // USER_ROLE

    // Constructors, getters, setters, toString...

    public User() {
        super();
    }

    public User(String gID, String userPw, String comCode) {
        super();
        this.gID = gID;
        this.userPw = userPw;
        this.comCode = comCode;
    }

    public String getgID() {
        return gID;
    }

    public void setgID(String gID) {
        this.gID = gID;
    }

    public String getUserPw() {
        return userPw;
    }

    public void setUserPw(String userPw) {
        this.userPw = userPw;
    }

    public String getComCode() {
        return comCode;
    }

    public void setComCode(String comCode) {
        this.comCode = comCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }
}
