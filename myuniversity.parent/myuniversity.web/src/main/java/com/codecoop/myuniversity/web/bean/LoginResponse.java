package com.codecoop.myuniversity.web.bean;

import java.io.Serializable;

public class LoginResponse implements Serializable {
	private static final long serialVersionUID = 1L;
	private String status;
	private Long userId;
	private String userName;
	

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	

}
