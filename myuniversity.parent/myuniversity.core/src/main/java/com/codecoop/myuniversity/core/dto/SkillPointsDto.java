package com.codecoop.myuniversity.core.dto;

import java.io.Serializable;

public class SkillPointsDto implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long skillId;
	private String skillName;
	private Integer points;

	public Long getSkillId() {
		return skillId;
	}

	public void setSkillId(Long skillId) {
		this.skillId = skillId;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}

	@Override
	public String toString() {
		return "SkillPointsDto [skillId=" + skillId + ", skillName="
				+ skillName + ", points=" + points + "]";
	}

	
}
