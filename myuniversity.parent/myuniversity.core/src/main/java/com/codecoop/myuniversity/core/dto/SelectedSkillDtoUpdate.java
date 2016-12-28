package com.codecoop.myuniversity.core.dto;

import java.io.Serializable;

public class SelectedSkillDtoUpdate implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long selected_skills;
	private String startDate;
	private String endDate;

	public Long getSelected_skills() {
		return selected_skills;
	}

	public void setSelected_skills(Long selected_skills) {
		this.selected_skills = selected_skills;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "SelectedSkillDtoUpdate [selected_skills=" + selected_skills
				+ ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}

}
