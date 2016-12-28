package com.codecoop.myuniversity.core.dto;

import java.util.Date;

public class SkillBadgeRowDto {

	private Long skillId;
	private String skillName;
	private Date eventStartTime;
	private Date eventEndTime;

	public SkillBadgeRowDto() {
	}

	@Override
	public String toString() {
		return "SkillBadgeRowDto [skillId=" + skillId + ", skillName="
				+ skillName + ", eventStartTime=" + eventStartTime
				+ ", eventEndTime=" + eventEndTime + "]";
	}

	public SkillBadgeRowDto(Long skillId, String skillName,
			Date eventStartTime, Date eventEndTime) {
		super();
		this.skillId = skillId;
		this.skillName = skillName;
		this.eventStartTime = eventStartTime;
		this.eventEndTime = eventEndTime;
	}

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

	public Date getEventStartTime() {
		return eventStartTime;
	}

	public void setEventStartTime(Date eventStartTime) {
		this.eventStartTime = eventStartTime;
	}

	public Date getEventEndTime() {
		return eventEndTime;
	}

	public void setEventEndTime(Date eventEndTime) {
		this.eventEndTime = eventEndTime;
	}

}
