package com.codecoop.myuniversity.core.domain;
import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SOCIAL_BADGES")
public class SocialBadges implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private Long id;

	@Column(name = "BADGE_NAME")
	private String badgeName;

	@Column(name = "BADGE_DESCRIPTION")
	private String badgeDescription;

	@Column(name = "NUMBER_OF_EVENTS")
	private int numberOfEvents;

	public SocialBadges() {

	}

	public SocialBadges(String badgeName, String badgeDescription,
			int numberOfEvents) {
		super();
		this.badgeName = badgeName;
		this.badgeDescription = badgeDescription;
		this.numberOfEvents = numberOfEvents;
	}

	@Override
	public String toString() {
		return "SocialBadges [id=" + id + ", badgeName=" + badgeName
				+ ", badgeDescription=" + badgeDescription
				+ ", numberOfEvents=" + numberOfEvents + "]";
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
