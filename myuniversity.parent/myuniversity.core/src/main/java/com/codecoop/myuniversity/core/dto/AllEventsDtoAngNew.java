package com.codecoop.myuniversity.core.dto;

import java.io.Serializable;
import java.util.List;

public class AllEventsDtoAngNew implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EventsDto general;
	private List<Long> tags;
	private List<Long> skills;
	private List<Long> interests;
	private List<Long> advertisements;
	private List<SkillScheduleDto> skillSch;
	private List<EventSocialBadgeDto> socialBadge;

	public EventsDto getGeneral() {
		return general;
	}

	public List<EventSocialBadgeDto> getSocialBadge() {
		return socialBadge;
	}

	public void setSocialBadge(List<EventSocialBadgeDto> socialBadge) {
		this.socialBadge = socialBadge;
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

	public List<Long> getInterests() {
		return interests;
	}

	public void setInterests(List<Long> interests) {
		this.interests = interests;
	}
	
	public List<Long> getAdvertisements() {
		return advertisements;
	}

	public void setAdvertisements(List<Long> advertisements) {
		this.advertisements = advertisements;
	}

	public List<SkillScheduleDto> getSkillSch() {
		return skillSch;
	}

	public void setSkillSch(List<SkillScheduleDto> skillSch) {
		this.skillSch = skillSch;
	}

	@Override
	public String toString() {
		return "AllEventsDtoAngNew [general=" + general + ", tags=" + tags
				+ ", skills=" + skills + ", interests=" + interests
				+ ", skillSch=" + skillSch + ", socialBadge=" + socialBadge
				+ "]";
	}

}
