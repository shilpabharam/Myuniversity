package com.codecoop.myuniversity.core.dto;

import java.util.List;

public class FilterScreenDto {

	private List<TagScreenDto> tags;
	private List<InterestScreenDto> interests;
	private List<SkillCategoryDto> SkillsCategory;
	private List<AdDto> advertisement;

	public List<TagScreenDto> getTags() {
		return tags;
	}

	public void setTags(List<TagScreenDto> tags) {
		this.tags = tags;
	}

	public List<InterestScreenDto> getInterests() {
		return interests;
	}

	public void setInterests(List<InterestScreenDto> interests) {
		this.interests = interests;
	}

	public List<SkillCategoryDto> getSkillsCategory() {
		return SkillsCategory;
	}

	public void setSkillsCategory(List<SkillCategoryDto> skillsCategory) {
		SkillsCategory = skillsCategory;
	}

	public List<AdDto> getAdvertisement() {
		return advertisement;
	}

	public void setAdvertisement(List<AdDto> advertisement) {
		this.advertisement = advertisement;
	}

	
}
