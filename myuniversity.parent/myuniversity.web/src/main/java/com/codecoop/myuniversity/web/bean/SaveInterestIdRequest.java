package com.codecoop.myuniversity.web.bean;

import java.io.Serializable;
import java.util.List;

public class SaveInterestIdRequest implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<String> interestId;
	private String userId;

	public List<String> getInterestId() {
		return interestId;
	}

	public void setInterestId(List<String> interestId) {
		this.interestId = interestId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
