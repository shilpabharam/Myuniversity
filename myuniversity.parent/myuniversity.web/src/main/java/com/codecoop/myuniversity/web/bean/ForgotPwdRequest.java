package com.codecoop.myuniversity.web.bean;

import java.io.Serializable;

public class ForgotPwdRequest implements Serializable {
	private static final long serialVersionUID = 1L;
	private String email;
	private String type;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
