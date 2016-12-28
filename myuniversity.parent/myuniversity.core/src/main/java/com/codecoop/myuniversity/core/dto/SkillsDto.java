package com.codecoop.myuniversity.core.dto;

import java.io.Serializable;

public class SkillsDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String skillName;
	private String categoryName;
	private Boolean flag;

	@Override
	public String toString() {
		return "SkillsDto [id=" + id + ", skillName=" + skillName
				+ ", categoryName=" + categoryName + ", flag=" + flag + "]";
	}

	public SkillsDto(Long id, String skillName, String categoryName,
			Boolean flag) {
		super();
		this.id = id;
		this.skillName = skillName;
		this.categoryName = categoryName;
		this.flag = flag;
	}

	public SkillsDto(){
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Boolean getFlag() {
		return flag;
	}

	public void setFlag(Boolean flag) {
		this.flag = flag;
	}
}
