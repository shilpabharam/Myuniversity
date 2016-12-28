package com.codecoop.myuniversity.core.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EVENTS")
public class Events implements Serializable {

	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private Long id;

	@Column(name = "EVENT_NAME")
	private String eventName;

	@Column(name = "EVENT_FROM_TIME")
	private Date eventFromTime;

	@Column(name = "EVENT_TO_TIME")
	private Date eventToTime;
	
	@Column(name="KEYWORDS")
	private String keywords;

	@Column(name = "EVENT_SHORT_DESC")
	private String eventShortDesc;

	@Column(name = "EVENT_LONG_DESC")
	private String eventLongDesc;

	@Column(name = "EVENT_ADDRESS")
	private String eventAddress;

	@Column(name = "EVENT_CREATED_BY")
	private Long eventCreatedBy;

	@Column(name = "UNIVERSITY_ID")
	private Long universityId;

	@Column(name = "FEATURED")
	private Boolean featured;

	@Column(name = "CAPACITY")
	private int capacity;

	@Column(name = "EVENT_TYPE_ID")
	private Long eventTypeId;

	@Column(name = "PUBLISHED")
	private Boolean published;

	public Events() {

	}

	public Events(String eventName, Date eventFromTime, Date eventToTime,String keywords,
			String eventShortDesc, String eventLongDesc, String eventAddress,
			Long eventCreatedBy, Long universityId, Long eventTypeId,
			Boolean published) {
		super();
		this.eventName = eventName;
		this.eventFromTime = eventFromTime;
		this.eventToTime = eventToTime;
		this.keywords=keywords;
		this.eventShortDesc = eventShortDesc;
		this.eventLongDesc = eventLongDesc;
		this.eventAddress = eventAddress;
		this.eventCreatedBy = eventCreatedBy;
		this.universityId = universityId;
		this.eventTypeId = eventTypeId;
		this.published = published;
	}

	@Override
	public String toString() {
		return "Events [id=" + id + ", eventName=" + eventName
				+ ", eventFromTime=" + eventFromTime + ", eventToTime="
				+ eventToTime + ", eventShortDesc=" + eventShortDesc
				+ ", eventLongDesc=" + eventLongDesc + ", eventAddress="
				+ eventAddress + ", eventCreatedBy=" + eventCreatedBy
				+ ", universityId=" + universityId + ", eventTypeId="
				+ eventTypeId + ", published" + published + "]";
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
	
	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
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
