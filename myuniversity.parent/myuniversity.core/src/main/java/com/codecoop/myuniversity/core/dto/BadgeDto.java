package com.codecoop.myuniversity.core.dto;

public class BadgeDto {

	private String badgeName;
	private Long socialBadgeId;
	private String description;

	public BadgeDto() {
	}

	public BadgeDto(String badgeName, Long socialBadgeId, String description) {
		super();
		this.badgeName = badgeName;
		this.socialBadgeId = socialBadgeId;
		this.description = description;
	}

	public String getBadgeName() {
		return badgeName;
	}

	public void setBadgeName(String badgeName) {
		this.badgeName = badgeName;
	}

	public Long getSocialBadgeId() {
		return socialBadgeId;
	}

	public void setSocialBadgeId(Long socialBadgeId) {
		this.socialBadgeId = socialBadgeId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
