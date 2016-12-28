package com.codecoop.myuniversity.core.dto;

import java.util.List;

public class SkillCategoryDto {

	private Long id;
	private String categoryName;
	List<SkillScreenDto> skiills;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public List<SkillScreenDto> getSkiills() {
		return skiills;
	}

	public void setSkiills(List<SkillScreenDto> skiills) {
		this.skiills = skiills;
	}

}
