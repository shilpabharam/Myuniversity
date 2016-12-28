package com.codecoop.myuniversity.core.dto;

import java.io.Serializable;

public class SkillBadgeDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String skillBadgeName;
	private Double skillBadgePoints;
	private Long universityId;

	public SkillBadgeDto() {
	}

	public SkillBadgeDto(Long id, String skillBadgeName,
			Double skillBadgePoints, Long universityId) {
		super();
		this.id = id;
		this.skillBadgeName = skillBadgeName;
		this.skillBadgePoints = skillBadgePoints;
		this.universityId = universityId;
	}

	@Override
	public String toString() {
		return "SkillBadgeDto [id=" + id + ", skillBadgeName=" + skillBadgeName
				+ ", skillBadgePoints=" + skillBadgePoints + ", universityId="
				+ universityId + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSkillBadgeName() {
		return skillBadgeName;
	}

	public void setSkillBadgeName(String skillBadgeName) {
		this.skillBadgeName = skillBadgeName;
	}

	public Double getSkillBadgePoints() {
		return skillBadgePoints;
	}

	public void setSkillBadgePoints(Double skillBadgePoints) {
		this.skillBadgePoints = skillBadgePoints;
	}

	public Long getUniversityId() {
		return universityId;
	}

	public void setUniversityId(Long universityId) {
		this.universityId = universityId;
	}

}
