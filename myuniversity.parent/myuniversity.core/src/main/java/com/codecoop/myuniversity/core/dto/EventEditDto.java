package com.codecoop.myuniversity.core.dto;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class EventEditDto {

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
	private String keyword;
	private String sponsor;
	private List<Long> interest;
	private List<BadgeDto> badgeDto;
	private List<SkillBadgeRowDto> SkillBadgeRowDto;
	private Map<Long, Boolean> tags;
	private Map<String, List<SkillEventDetailDto>> skills;
	private Integer totalRecords;
	private List<AdDto> advertisements;

	@Override
	public String toString() {
		return "EventDetailDto [id=" + id + ", eventName=" + eventName
				+ ", eventFromTime=" + eventFromTime + ", eventToTime="
				+ eventToTime + ", eventShortDesc=" + eventShortDesc
				+ ", eventLongDesc=" + eventLongDesc + ", eventAddress="
				+ eventAddress + ", eventCreatedBy=" + eventCreatedBy
				+ ", featured=" + featured + ", capacity=" + capacity
				+ ", evenType=" + evenType + ", published=" + published
				+ ", keyword=" + keyword + ", sponsor=" + sponsor
				+ ", interest=" + interest + ", badgeDto=" + badgeDto
				+ ",  tags=" + tags + ", skills=" + skills + ", totalRecords="
				+ totalRecords + "]";
	}

	public List<SkillBadgeRowDto> getSkillBadgeRowDto() {
		return SkillBadgeRowDto;
	}

	public void setSkillBadgeRowDto(List<SkillBadgeRowDto> skillBadgeRowDto) {
		SkillBadgeRowDto = skillBadgeRowDto;
	}

	public List<BadgeDto> getBadgeDto() {
		return badgeDto;
	}

	public void setBadgeDto(List<BadgeDto> badgeDto) {
		this.badgeDto = badgeDto;
	}

	public String getSponsor() {
		return sponsor;
	}

	public void setSponsor(String sponsor) {
		this.sponsor = sponsor;
	}

	public List<Long> getInterest() {
		return interest;
	}

	public void setInterest(List<Long> interest) {
		this.interest = interest;
	}

	public Integer getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(Integer totalRecords) {
		this.totalRecords = totalRecords;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
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

	public Map<Long, Boolean> getTags() {
		return tags;
	}

	public void setTags(Map<Long, Boolean> tags) {
		this.tags = tags;
	}

	public Map<String, List<SkillEventDetailDto>> getSkills() {
		return skills;
	}

	public void setSkills(Map<String, List<SkillEventDetailDto>> skills) {
		this.skills = skills;
	}

	public List<AdDto> getAdvertisements() {
		return advertisements;
	}

	public void setAdvertisements(List<AdDto> advertisements) {
		this.advertisements = advertisements;
	}


}
