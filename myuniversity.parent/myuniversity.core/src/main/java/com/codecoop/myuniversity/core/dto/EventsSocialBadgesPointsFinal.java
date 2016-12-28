package com.codecoop.myuniversity.core.dto;

import java.util.List;

public class EventsSocialBadgesPointsFinal {

	private Long id;
	private String badgeName;
	private String badgeDescription;
	private Double noOfBadges;
	List<String> departmets;

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

	public Double getNoOfBadges() {
		return noOfBadges;
	}

	public void setNoOfBadges(Double noOfBadges) {
		this.noOfBadges = noOfBadges;
	}

	public List<String> getDepartmets() {
		return departmets;
	}

	public void setDepartmets(List<String> departmets) {
		this.departmets = departmets;
	}

}
