package com.codecoop.myuniversity.core.dto;

import java.io.Serializable;
import java.util.List;

public class AllEventsDtoAng implements Serializable {

	private static final long serialVersionUID = 1L;

	private EventsDto general;
	private List<Long> tags;
	private List<Long> skills;
	private List<Long> interests;

	public AllEventsDtoAng(EventsDto general, List<Long> tags,
			List<Long> skills, List<Long> interests) {
		super();
		this.general = general;
		this.tags = tags;
		this.skills = skills;
		this.interests = interests;
	}

	public AllEventsDtoAng() {

	}

	@Override
	public String toString() {
		return "AllEventsDto [general=" + general + ", tags=" + tags
				+ ", skills=" + skills + "]";
	}

	public List<Long> getInterests() {
		return interests;
	}

	public void setInterests(List<Long> interests) {
		this.interests = interests;
	}

	public EventsDto getGeneral() {
		return general;
	}

	public void setGeneral(EventsDto general) {
		this.general = general;
	}

	public List<Long> getTags() {
		return tags;
	}

	public void setTags(List<Long> tags) {
		this.tags = tags;
	}

	public List<Long> getSkills() {
		return skills;
	}

	public void setSkills(List<Long> skills) {
		this.skills = skills;
	}

}
