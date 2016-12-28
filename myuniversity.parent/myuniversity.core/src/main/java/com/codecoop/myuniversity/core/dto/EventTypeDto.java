package com.codecoop.myuniversity.core.dto;

import java.io.Serializable;

public class EventTypeDto implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private String eventType;

	@Override
	public String toString() {
		return "EventTypeDto [id=" + id + ", eventType=" + eventType + "]";
	}

	public EventTypeDto(){
		
	}
	
	public EventTypeDto(Long id, String eventType) {
		super();
		this.id = id;
		this.eventType = eventType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

}
