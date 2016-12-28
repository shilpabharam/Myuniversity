package com.codecoop.myuniversity.web.bean;

import java.io.Serializable;

public class GetInterestRequest implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long userId;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

}
