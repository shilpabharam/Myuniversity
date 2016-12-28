package com.codecoop.myuniversity.web.bean;

import java.io.Serializable;

public class SaveInterestRequest implements Serializable {

	private static final long serialVersionUID = 1L;
	private String interestName;

	public String getInterestName() {
		return interestName;
	}

	public void setInterestName(String interestName) {
		this.interestName = interestName;
	}

}
