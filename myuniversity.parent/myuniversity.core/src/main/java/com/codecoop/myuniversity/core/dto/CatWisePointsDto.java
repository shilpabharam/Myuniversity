package com.codecoop.myuniversity.core.dto;

import java.io.Serializable;
import java.util.List;

public class CatWisePointsDto implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long categoryId;
	private String categoryName;
	private List<SkillPointsDto> skills;

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

	public List<SkillPointsDto> getSkills() {
		return skills;
	}

	public void setSkills(List<SkillPointsDto> skills) {
		this.skills = skills;
	}

	@Override
	public String toString() {
		return "CatWisePointsDto [categoryId=" + categoryId + ", categoryName="
				+ categoryName + ", skills=" + skills + "]";
	}

	
}
