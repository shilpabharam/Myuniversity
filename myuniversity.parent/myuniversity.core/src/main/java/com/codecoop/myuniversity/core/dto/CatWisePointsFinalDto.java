package com.codecoop.myuniversity.core.dto;

import java.io.Serializable;
import java.util.List;

public class CatWisePointsFinalDto implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<CatWisePointsDto> category;

	public List<CatWisePointsDto> getCategory() {
		return category;
	}

	public void setCategory(List<CatWisePointsDto> category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "CatWisePointsFinalDto [category=" + category + "]";
	}

}
