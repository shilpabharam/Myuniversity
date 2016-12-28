package com.codecoop.myuniversity.core.dto;

import java.io.Serializable;

public class EventInterestDto implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private String interestName;

	@Override
	public String toString() {
		return "EventInterestDto [id=" + id + ", interestName=" + interestName
				+ "]";
	}
	public EventInterestDto(){
		
	}

	public EventInterestDto(Long id, String interestName) {
		super();
		this.id = id;
		this.interestName = interestName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getInterestName() {
		return interestName;
	}

	public void setInterestName(String interestName) {
		this.interestName = interestName;
	}

}
