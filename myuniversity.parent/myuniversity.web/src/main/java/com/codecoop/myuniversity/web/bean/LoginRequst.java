package com.codecoop.myuniversity.web.bean;

import java.io.Serializable;

public class LoginRequst implements Serializable {
	private static final long serialVersionUID = 1L;
	private String emailId;
	private String password;

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
