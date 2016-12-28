package com.codecoop.myuniversity.web.bean;

import java.util.List;

public class EventBeanResponse {

	private List<EventDetailBean> eventBeanList;
	private Integer totalCount;

	public List<EventDetailBean> getEventBeanList() {
		return eventBeanList;
	}

	public void setEventBeanList(List<EventDetailBean> eventBeanList) {
		this.eventBeanList = eventBeanList;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

}
