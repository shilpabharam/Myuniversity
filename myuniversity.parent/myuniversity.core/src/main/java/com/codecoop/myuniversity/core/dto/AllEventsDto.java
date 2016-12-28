package com.codecoop.myuniversity.core.dto;

import java.io.Serializable;
import java.util.List;

public class AllEventsDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private EventsDto general;
	private List<TagDto> tags;
	private List<SkillsDto> skills;

	public AllEventsDto(EventsDto general, List<TagDto> tags, List<SkillsDto> skills) {
		super();
		this.general = general;
		this.tags = tags;
		this.skills = skills;
	}

	public AllEventsDto() {

	}

	@Override
	public String toString() {
		return "AllEventsDto [general=" + general + ", tags=" + tags
				+ ", skills=" + skills + "]";
	}

	public EventsDto getGeneral() {
		return general;
	}

	public void setGeneral(EventsDto general) {
		this.general = general;
	}

	public List<TagDto> getTags() {
		return tags;
	}

	public void setTags(List<TagDto> tags) {
		this.tags = tags;
	}

	public List<SkillsDto> getSkills() {
		return skills;
	}

	public void setSkills(List<SkillsDto> skills) {
		this.skills = skills;
	}

}
