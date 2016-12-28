package com.codecoop.myuniversity.core.dto;

import java.io.Serializable;

public class EventSocialBadgeDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long eventId;
	private Long badgeId;
	private String description;
	

	public EventSocialBadgeDto() {
	}

	public EventSocialBadgeDto(Long eventId, Long badgeId, String description) {
		super();
		this.eventId = eventId;
		this.badgeId = badgeId;
		this.description = description;
	}

	public Long getEventId() {
		return eventId;
	}

	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}

	public Long getBadgeId() {
		return badgeId;
	}

	public void setBadgeId(Long badgeId) {
		this.badgeId = badgeId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
