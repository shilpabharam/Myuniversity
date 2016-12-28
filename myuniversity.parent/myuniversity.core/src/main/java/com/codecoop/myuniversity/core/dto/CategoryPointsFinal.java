package com.codecoop.myuniversity.core.dto;

import java.io.Serializable;
import java.util.List;

public class CategoryPointsFinal implements Serializable {

	private static final long serialVersionUID = 1L;
	private String loboBadgeName;
	private List<CategoryScoreDto> categoryPoints;

	public String getLoboBadgeName() {
		return loboBadgeName;
	}

	public void setLoboBadgeName(String loboBadgeName) {
		this.loboBadgeName = loboBadgeName;
	}

	public List<CategoryScoreDto> getCategoryPoints() {
		return categoryPoints;
	}

	public void setCategoryPoints(List<CategoryScoreDto> categoryPoints) {
		this.categoryPoints = categoryPoints;
	}

}
