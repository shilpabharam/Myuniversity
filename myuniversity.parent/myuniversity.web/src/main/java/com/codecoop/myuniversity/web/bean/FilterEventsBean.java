package com.codecoop.myuniversity.web.bean;

import java.io.Serializable;
import java.util.List;

public class FilterEventsBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long userId;
	private String searchParam;
	private String fromDate;
	private String toDate;
	private List<Long> skillIds;
	private List<Long> tagIds;
	private List<Long> interestIds;
	private Integer pageNumber;
	private Integer numberOfRecords;
	private Boolean featured;
	private Boolean enrolled;
	private Boolean upcoming;

	public Boolean getUpcoming() {
		return upcoming;
	}

	public void setUpcoming(Boolean upcoming) {
		this.upcoming = upcoming;
	}

	public Boolean getEnrolled() {
		return enrolled;
	}

	public void setEnrolled(Boolean enrolled) {
		this.enrolled = enrolled;
	}

	public Boolean getFeatured() {
		return featured;
	}

	public void setFeatured(Boolean featured) {
		this.featured = featured;
	}

	public Integer getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}

	public Integer getNumberOfRecords() {
		return numberOfRecords;
	}

	public void setNumberOfRecords(Integer numberOfRecords) {
		this.numberOfRecords = numberOfRecords;
	}

	@Override
	public String toString() {
		return "FilterEventsBean [userId=" + userId + ", searchParam="
				+ searchParam + ", fromDate=" + fromDate + ", toDate=" + toDate
				+ ", skillIds=" + skillIds + ", tagIds=" + tagIds
				+ ", interestIds=" + interestIds + "]";
	}

	public String getSearchParam() {
		return searchParam;
	}

	public void setSearchParam(String searchParam) {
		this.searchParam = searchParam;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	public List<Long> getSkillIds() {
		return skillIds;
	}

	public void setSkillIds(List<Long> skillIds) {
		this.skillIds = skillIds;
	}

	public List<Long> getTagIds() {
		return tagIds;
	}

	public void setTagIds(List<Long> tagIds) {
		this.tagIds = tagIds;
	}

	public List<Long> getInterestIds() {
		return interestIds;
	}

	public void setInterestIds(List<Long> interestIds) {
		this.interestIds = interestIds;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

}
