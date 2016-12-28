package com.codecoop.myuniversity.web.bean;

import java.io.Serializable;

public class EnrollEventBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long userId;
	private Long eventId;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getEventId() {
		return eventId;
	}

	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}

}
