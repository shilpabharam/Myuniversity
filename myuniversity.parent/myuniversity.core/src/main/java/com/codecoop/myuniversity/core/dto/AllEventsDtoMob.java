package com.codecoop.myuniversity.core.dto;

import java.util.Date;
import java.util.Map;

public class AllEventsDtoMob {

	private Long id;
	private String eventName;
	private Date eventFromTime;
	private Date eventToTime;
	private String eventShortDesc;
	private String eventLongDesc;
	private String eventAddress;
	private long eventCreatedBy;
	private Boolean featured;
	private int capacity;
	private String evenType;
	private Boolean published;
	private Boolean enrollEvent;

	public Boolean getEnrollEvent() {
		return enrollEvent;
	}

	public void setEnrollEvent(Boolean enrollEvent) {
		this.enrollEvent = enrollEvent;
	}

	private Map<String, Boolean> tags;
	private Map<String, Boolean> interest;
	private Map<String, Integer> skills;

	@Override
	public String toString() {
		return "AllEventsDtoMob [id=" + id + ", eventName=" + eventName
				+ ", eventFromTime=" + eventFromTime + ", eventToTime="
				+ eventToTime + ", eventShortDesc=" + eventShortDesc
				+ ", eventLongDesc=" + eventLongDesc + ", eventAddress="
				+ eventAddress + ", eventCreatedBy=" + eventCreatedBy
				+ ", featured=" + featured + ", capacity=" + capacity
				+ ", evenType=" + evenType + ", published=" + published
				+ ", enrollEvent=" + enrollEvent + ", tags=" + tags
				+ ", interest=" + interest + ", skills=" + skills + "]";
	}

	public Long getId() {
		return id;
	}

	public Map<String, Boolean> getInterest() {
		return interest;
	}

	public void setInterest(Map<String, Boolean> interest) {
		this.interest = interest;
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

	public long getEventCreatedBy() {
		return eventCreatedBy;
	}

	public void setEventCreatedBy(long eventCreatedBy) {
		this.eventCreatedBy = eventCreatedBy;
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

	public String getEvenType() {
		return evenType;
	}

	public void setEvenType(String evenType) {
		this.evenType = evenType;
	}

	public Boolean getPublished() {
		return published;
	}

	public void setPublished(Boolean published) {
		this.published = published;
	}

	public Map<String, Boolean> getTags() {
		return tags;
	}

	public void setTags(Map<String, Boolean> tags) {
		this.tags = tags;
	}

	public Map<String, Integer> getSkills() {
		return skills;
	}

	public void setSkills(Map<String, Integer> skills) {
		this.skills = skills;
	}

}
