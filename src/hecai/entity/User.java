package hecai.entity;

import java.io.Serializable;

public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int userId;
	private String userName;
	private String userPwd;
	private String userType;
	
	public User() {
	}
	public User( String userName, String userPwd) {
		this.userName = userName;
		this.userPwd = userPwd;
	}
	public User(int userId, String userName, String userType) {
		this.userId = userId;
		this.userName = userName;
		this.userType = userType;
	}
	public User(int userId, String userName, String userPwd, String userType) {
		this.userId = userId;
		this.userName = userName;
		this.userPwd = userPwd;
		this.userType = userType;
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userPwd=" + userPwd + ", userType=" + userType
				+ "]";
	}
}
