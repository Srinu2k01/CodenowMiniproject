package com.cmr.prj.util;

public class LoginRecord {
	private String username;
	private String password;
	public LoginRecord() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LoginRecord(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
