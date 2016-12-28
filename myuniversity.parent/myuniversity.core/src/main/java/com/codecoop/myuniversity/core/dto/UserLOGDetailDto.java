package com.codecoop.myuniversity.core.dto;

import java.io.Serializable;

public class UserLOGDetailDto implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long userId;
	private String fullName;
	private Long UniversityId;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Long getUniversityId() {
		return UniversityId;
	}

	public void setUniversityId(Long universityId) {
		UniversityId = universityId;
	}

}
