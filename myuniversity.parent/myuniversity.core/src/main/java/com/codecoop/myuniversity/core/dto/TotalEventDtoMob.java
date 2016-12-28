package com.codecoop.myuniversity.core.dto;

import java.io.Serializable;
import java.util.List;

public class TotalEventDtoMob implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer totalEvents;
	private Integer PageNumber;
	List<AllEventsDtoMob> allEvents;

	public Integer getTotalEvents() {
		return totalEvents;
	}

	public void setTotalEvents(Integer totalEvents) {
		this.totalEvents = totalEvents;
	}

	public Integer getPageNumber() {
		return PageNumber;
	}

	public void setPageNumber(Integer pageNumber) {
		PageNumber = pageNumber;
	}

	public List<AllEventsDtoMob> getAllEvents() {
		return allEvents;
	}

	public void setAllEvents(List<AllEventsDtoMob> allEvents) {
		this.allEvents = allEvents;
	}

}
