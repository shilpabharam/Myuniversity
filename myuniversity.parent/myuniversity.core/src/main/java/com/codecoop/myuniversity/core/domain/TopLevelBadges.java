package com.codecoop.myuniversity.core.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TOP_LEVEL_BADGES")
public class TopLevelBadges implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private Long id;

	@Column(name = "TOP_BADGE_NAME")
	private String topBadgeName;

	@Column(name = "TOP_BADGE_POINTS")
	private Double topBadgePoints;

	@Column(name = "UNIVERSITY_ID")
	private Long universityId;

	public TopLevelBadges() {

	}

	public TopLevelBadges(String topBadgeName, Double topBadgePoints,
			Long universityId) {
		super();
		this.topBadgeName = topBadgeName;
		this.topBadgePoints = topBadgePoints;
		this.universityId = universityId;
	}

	@Override
	public String toString() {
		return "TopLevelBadges [id=" + id + ", topBadgeName=" + topBadgeName
				+ ", topBadgePoints=" + topBadgePoints + ", universityId="
				+ universityId + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTopBadgeName() {
		return topBadgeName;
	}

	public void setTopBadgeName(String topBadgeName) {
		this.topBadgeName = topBadgeName;
	}

	public Double getTopBadgePoints() {
		return topBadgePoints;
	}

	public void setTopBadgePoints(Double topBadgePoints) {
		this.topBadgePoints = topBadgePoints;
	}

	public Long getUniversityId() {
		return universityId;
	}

	public void setUniversityId(Long universityId) {
		this.universityId = universityId;
	}
}
