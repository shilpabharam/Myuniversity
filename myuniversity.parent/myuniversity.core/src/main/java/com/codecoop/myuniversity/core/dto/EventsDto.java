package com.codecoop.myuniversity.core.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class EventsDto implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private String eventName;
	private Date eventFromTime;
	private Date eventToTime;
	private String eventShortDesc;
	private String eventLongDesc;
	private String keywords;
	private String eventAddress;
	private long eventCreatedBy;
	private Long universityId;
	private Boolean featured;
	private int capacity;
	private String sponsor;
	private EventTypeDto evenType;
	private List<EventInterestDto> eventInterest;
	private Boolean published;

	@Override
	public String toString() {
		return "EventsDto [id=" + id + ", eventName=" + eventName
				+ ", eventFromTime=" + eventFromTime + ", eventToTime="
				+ eventToTime + ", eventShortDesc=" + eventShortDesc
				+ ", eventLongDesc=" + eventLongDesc + ", keywords=" + keywords
				+ ", eventAddress=" + eventAddress + ", eventCreatedBy="
				+ eventCreatedBy + ", universityId=" + universityId
				+ ", featured=" + featured + ", capacity=" + capacity
				+ ", sponsor=" + sponsor + ", evenType=" + evenType
				+ ", eventInterest=" + eventInterest + ", published="
				+ published + "]";
	}

	public EventsDto() {

	}

	public String getSponsor() {
		return sponsor;
	}

	public void setSponsor(String sponsor) {
		this.sponsor = sponsor;
	}

	public List<EventInterestDto> getEventInterest() {
		return eventInterest;
	}

	public void setEventInterest(List<EventInterestDto> eventInterest) {
		this.eventInterest = eventInterest;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
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

	public long getEventCreatedBy() {
		return eventCreatedBy;
	}

	public void setEventCreatedBy(long eventCreatedBy) {
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

	public EventTypeDto getEvenType() {
		return evenType;
	}

	public void setEvenType(EventTypeDto evenType) {
		this.evenType = evenType;
	}

	public Boolean getPublished() {
		return published;
	}

	public void setPublished(Boolean published) {
		this.published = published;
	}
}
