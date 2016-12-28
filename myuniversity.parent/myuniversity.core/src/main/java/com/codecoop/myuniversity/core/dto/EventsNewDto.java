package com.codecoop.myuniversity.core.dto;

import java.util.Date;

public class EventsNewDto {

	private Long id;
	private String eventName;
	private Date eventFromTime;
	private Date eventToTime;
	private String eventShortDesc;
	private String eventLongDesc;
	private String eventAddress;
	private Long eventCreatedBy;
	private Long universityId;
	private Boolean featured;
	private int capacity;
	private Long eventTypeId;
	private Boolean published;
	private Boolean enrollEvent;

	public Boolean getEnrollEvent() {
		return enrollEvent;
	}

	public void setEnrollEvent(Boolean enrollEvent) {
		this.enrollEvent = enrollEvent;
	}

	public Long getEventTypeId() {
		return eventTypeId;
	}

	public void setEventTypeId(Long eventTypeId) {
		this.eventTypeId = eventTypeId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public Date getEventFromTime() {
		return eventFromTime;
	}

	public void setEventFromTime(Date eventFromTime) {
		this.eventFromTime = eventFromTime;
	}

	public Date getEventToTime() {
		return eventToTime;
	}

	public void setEventToTime(Date eventToTime) {
		this.eventToTime = eventToTime;
	}

	public String getEventShortDesc() {
		return eventShortDesc;
	}

	public void setEventShortDesc(String eventShortDesc) {
		this.eventShortDesc = eventShortDesc;
	}

	public String getEventLongDesc() {
		return eventLongDesc;
	}

	public void setEventLongDesc(String eventLongDesc) {
		this.eventLongDesc = eventLongDesc;
	}

	public String getEventAddress() {
		return eventAddress;
	}

	public void setEventAddress(String eventAddress) {
		this.eventAddress = eventAddress;
	}

	public Long getEventCreatedBy() {
		return eventCreatedBy;
	}

	public void setEventCreatedBy(Long eventCreatedBy) {
		this.eventCreatedBy = eventCreatedBy;
	}

	public Long getUniversityId() {
		return universityId;
	}

	public void setUniversityId(Long universityId) {
		this.universityId = universityId;
	}

	public Boolean getFeatured() {
		return featured;
	}

	public void setFeatured(Boolean featured) {
		this.featured = featured;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public Boolean getPublished() {
		return published;
	}

	public void setPublished(Boolean published) {
		this.published = published;
	}

}
