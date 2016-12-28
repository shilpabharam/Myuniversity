package com.codecoop.myuniversity.core.dto;

import java.io.Serializable;

public class BadgeDtoUpdate implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long badgeId;
	private String description;

	public BadgeDtoUpdate() {
	}

	public Long getBadgeId() {
		return badgeId;
	}

	public void setBadgeId(Long badgeId) {
		this.badgeId = badgeId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "BadgeDtoUpdate [badgeId=" + badgeId + ", description="
				+ description + "]";
	}

}
