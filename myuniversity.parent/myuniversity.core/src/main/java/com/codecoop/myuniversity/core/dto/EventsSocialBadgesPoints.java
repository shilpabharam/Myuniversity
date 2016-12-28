package com.codecoop.myuniversity.core.dto;

import java.io.Serializable;

public class EventsSocialBadgesPoints implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String badgeName;
	private String badgeDescription;
	private Integer points;

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

	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}

}
