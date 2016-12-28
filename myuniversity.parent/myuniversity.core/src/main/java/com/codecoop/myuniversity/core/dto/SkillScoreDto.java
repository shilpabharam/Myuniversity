package com.codecoop.myuniversity.core.dto;

import java.io.Serializable;

public class SkillScoreDto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Long eventId;
	private Long categoryId;
	private String categoryName;
	private Long skillId;
	private String skillName;
	private Integer points;
	
	public Long getEventId() {
		return eventId;
	}
	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
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
	public Integer getPoints() {
		return points;
	}
	public void setPoints(Integer points) {
		this.points = points;
	}
	@Override
	public String toString() {
		return "SkillScoreDto [eventId=" + eventId + ", categoryId="
				+ categoryId + ", categoryName=" + categoryName + ", skillId="
				+ skillId + ", skillName=" + skillName + ", points=" + points
				+ "]";
	}
	
	
	
}
