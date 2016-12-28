package com.codecoop.myuniversity.core.dto;

import java.io.Serializable;
import java.util.Date;

public class SkillScheduleDto implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long eventId;
	private Long selected_skills;
	private Date startDate;
	private Date endDate;

	public Long getEventId() {
		return eventId;
	}

	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}

	public Long getSelected_skills() {
		return selected_skills;
	}

	public void setSelected_skills(Long selected_skills) {
		this.selected_skills = selected_skills;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "SkillScheduleDto [selected_skills=" + selected_skills
				+ ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}

}
