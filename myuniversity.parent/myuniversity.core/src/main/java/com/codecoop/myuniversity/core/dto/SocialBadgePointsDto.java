package com.codecoop.myuniversity.core.dto;

import java.io.Serializable;

public class SocialBadgePointsDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	private String socialBadgeName;
	private Double socialBadgePoints;
	private Long universityId;

	public SocialBadgePointsDto() {
	}

	public SocialBadgePointsDto(Long id, String socialBadgeName,
			Double socialBadgePoints, Long universityId) {
		super();
		this.id = id;
		this.socialBadgeName = socialBadgeName;
		this.socialBadgePoints = socialBadgePoints;
		this.universityId = universityId;
	}

	@Override
	public String toString() {
		return "SocialBadgePointsDto [id=" + id + ", socialBadgeName="
				+ socialBadgeName + ", socialBadgePoints=" + socialBadgePoints
				+ ", universityId=" + universityId + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSocialBadgeName() {
		return socialBadgeName;
	}

	public void setSocialBadgeName(String socialBadgeName) {
		this.socialBadgeName = socialBadgeName;
	}

	public Double getSocialBadgePoints() {
		return socialBadgePoints;
	}

	public void setSocialBadgePoints(Double socialBadgePoints) {
		this.socialBadgePoints = socialBadgePoints;
	}

	public Long getUniversityId() {
		return universityId;
	}

	public void setUniversityId(Long universityId) {
		this.universityId = universityId;
	}

}
