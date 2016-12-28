package com.codecoop.myuniversity.core.dto;

import java.io.Serializable;

public class SkillsMobDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String categoryName;
	private Integer totalSubSkills;

	@Override
	public String toString() {
		return "SkillsMobDto [categoryName=" + categoryName
				+ ", totalSubSkills=" + totalSubSkills + "]";
	}

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

	public Integer getTotalSubSkills() {
		return totalSubSkills;
	}

	public void setTotalSubSkills(Integer totalSubSkills) {
		this.totalSubSkills = totalSubSkills;
	}

}
