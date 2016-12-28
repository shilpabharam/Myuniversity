package com.codecoop.myuniversity.core.dto;

import java.util.Date;
import java.util.List;

public class UpdateEventDto {

	private Long id;
	private String eventName;
	private Date eventFromTime;
	private Date eventToTime;
	private String eventShortDesc;
	private String eventLongDesc;
	private String keyword;
	private String eventAddress;
	private long eventCreatedBy;
	private Long universityId;
	private Boolean featured;
	private int capacity;
	private String sponsor;
	private Long eventTypeId;
	private String evenType;
	private Boolean published;
	private List<Long> tags;
	private List<Long> interest;
	private List<Long> advertisements;
	private List<SelectedSkillDtoUpdate> skillBadgeRowDto;
	private List<BadgeDtoUpdate> badgeDto;

	public String getEvenType() {
		return evenType;
	}

	public void setEvenType(String evenType) {
		this.evenType = evenType;
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

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
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

	public String getSponsor() {
		return sponsor;
	}

	public void setSponsor(String sponsor) {
		this.sponsor = sponsor;
	}

	public Long getEventTypeId() {
		return eventTypeId;
	}

	public void setEventTypeId(Long eventTypeId) {
		this.eventTypeId = eventTypeId;
	}

	public Boolean getPublished() {
		return published;
	}

	public void setPublished(Boolean published) {
		this.published = published;
	}

	public List<Long> getTags() {
		return tags;
	}

	public void setTags(List<Long> tags) {
		this.tags = tags;
	}

	public List<Long> getInterest() {
		return interest;
	}

	public void setInterest(List<Long> interest) {
		this.interest = interest;
	}

	public List<Long> getAdvertisements() {
		return advertisements;
	}

	public void setAdvertisements(List<Long> advertisements) {
		this.advertisements = advertisements;
	}

	public List<SelectedSkillDtoUpdate> getSkillBadgeRowDto() {
		return skillBadgeRowDto;
	}

	public void setSkillBadgeRowDto(List<SelectedSkillDtoUpdate> skillBadgeRowDto) {
		this.skillBadgeRowDto = skillBadgeRowDto;
	}

	public List<BadgeDtoUpdate> getBadgeDto() {
		return badgeDto;
	}

	public void setBadgeDto(List<BadgeDtoUpdate> badgeDto) {
		this.badgeDto = badgeDto;
	}

	@Override
	public String toString() {
		return "UpdateEventDto [id=" + id + ", eventName=" + eventName
				+ ", eventFromTime=" + eventFromTime + ", eventToTime="
				+ eventToTime + ", eventShortDesc=" + eventShortDesc
				+ ", eventLongDesc=" + eventLongDesc + ", keyword=" + keyword
				+ ", eventAddress=" + eventAddress + ", eventCreatedBy="
				+ eventCreatedBy + ", universityId=" + universityId
				+ ", featured=" + featured + ", capacity=" + capacity
				+ ", sponsor=" + sponsor + ", eventTypeId=" + eventTypeId
				+ ", evenType=" + evenType + ", published=" + published
				+ ", tags=" + tags + ", interest=" + interest
				+ ", skillBadgeRowDto=" + skillBadgeRowDto + ", badgeDto="
				+ badgeDto + "]";
	}

	
}
