package com.codecoop.myuniversity.core.dto;

import java.io.Serializable;

public class CategoryScoreDto implements Serializable{

	private static final long serialVersionUID = 1L;
	private Long categoryId;
	private String categoryName;
	private Integer points;
	
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
	public Integer getPoints() {
		return points;
	}
	public void setPoints(Integer points) {
		this.points = points;
	}
	
	
}
