package com.codecoop.myuniversity.core.dto;

import java.io.Serializable;

public class EventSponsorDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	private Long eventId;
	private Long sponsorId;

	public EventSponsorDto() {
	}

	public EventSponsorDto(Long id, Long eventId, Long sponsorId) {
		super();
		this.id = id;
		this.eventId = eventId;
		this.sponsorId = sponsorId;
	}

	@Override
	public String toString() {
		return "EventSponsorDto [id=" + id + ", eventId=" + eventId
				+ ", sponsorId=" + sponsorId + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getEventId() {
		return eventId;
	}

	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}

	public Long getSponsorId() {
		return sponsorId;
	}

	public void setSponsorId(Long sponsorId) {
		this.sponsorId = sponsorId;
	}

}
