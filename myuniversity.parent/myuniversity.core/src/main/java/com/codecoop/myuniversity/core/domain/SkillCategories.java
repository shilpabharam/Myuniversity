package com.codecoop.myuniversity.core.domain;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SKILL_CATEGORIES")
public class SkillCategories {
	
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "CATEGORY_NAME")
	private String categoryName;

	public SkillCategories(){
		
	}
	
	public SkillCategories(String categoryName) {
		super();
		this.categoryName = categoryName;
	}

	@Override
	public String toString() {
		return "SkillCategories [id=" + id + ", categoryName=" + categoryName
				+ "]";
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
	
	

}
