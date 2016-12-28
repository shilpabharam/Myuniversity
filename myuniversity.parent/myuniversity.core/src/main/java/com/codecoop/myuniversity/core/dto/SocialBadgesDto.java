package com.codecoop.myuniversity.core.dto;

import java.io.Serializable;
import java.util.List;

public class SocialBadgesDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	private String badgeName;
	private String badgeDescription;
	private int numberOfEvents;
	private List<Long> departments;

	public SocialBadgesDto() {
	}

	public SocialBadgesDto(Long id, String badgeName, String badgeDescription,
			int numberOfEvents) {
		super();
		this.id = id;
		this.badgeName = badgeName;
		this.badgeDescription = badgeDescription;
		this.numberOfEvents = numberOfEvents;
	}

	@Override
	public String toString() {
		return "SocialBadgesDto [id=" + id + ", badgeName=" + badgeName
				+ ", badgeDescription=" + badgeDescription
				+ ", numberOfEvents=" + numberOfEvents + ", departments="
				+ departments + "]";
	}

	public List<Long> getDepartments() {
		return departments;
	}

	public void setDepartments(List<Long> departments) {
		this.departments = departments;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBadgeName() {
		return badgeName;
	}

	public void setBadgeName(String badgeName) {
		this.badgeName = badgeName;
	}

	public String getBadgeDescription() {
		return badgeDescription;
	}

	public void setBadgeDescription(String badgeDescription) {
		this.badgeDescription = badgeDescription;
	}

	public int getNumberOfEvents() {
		return numberOfEvents;
	}

	public void setNumberOfEvents(int numberOfEvents) {
		this.numberOfEvents = numberOfEvents;
	}

}
