package org.riss.bizconnect.main.member.model.dto;

public class User implements java.io.Serializable {
	private static final long serialVersionUID = -2119372912749016520L;
	
	private String gID;				//	GID	VARCHAR2(20 BYTE)
	private String userName;	//	USER_NAME	VARCHAR2(20 BYTE)
	private String userPw;		//	USER_PW	VARCHAR2(50 BYTE)
	
	public User() {
		super();
	}

	public User(String gID, String userName, String userPw) {
		super();
		this.gID = gID;
		this.userName = userName;
		this.userPw = userPw;
	}

	public String getgID() {
		return gID;
	}

	public void setgID(String gID) {
		this.gID = gID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "User [gID=" + gID + ", userName=" + userName + ", userPw=" + userPw + "]";
	}

	
	
	
}
