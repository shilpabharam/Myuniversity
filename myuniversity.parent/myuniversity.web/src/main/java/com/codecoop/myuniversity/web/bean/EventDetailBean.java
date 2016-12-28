package com.codecoop.myuniversity.web.bean;

import java.util.Date;

public class EventDetailBean {
	
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
	
}
