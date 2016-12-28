package com.codecoop.myuniversity.core.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SOCIAL_BADGE_POINTS")
public class SocialBadgePoints implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private Long id;

	@Column(name = "SOCIAL_BADGE_NAME")
	private String socialBadgeName;

	@Column(name = "SOCIAL_BADGE_POINTS")
	private Double socialBadgePoints;

	@Column(name = "UNIVERSITY_ID")
	private Long universityId;

	public SocialBadgePoints() {
	}

	public SocialBadgePoints(Long id, String socialBadgeName,
			Double socialBadgePoints, Long universityId) {
		super();
		this.id = id;
		this.socialBadgeName = socialBadgeName;
		this.socialBadgePoints = socialBadgePoints;
		this.universityId = universityId;
	}

	@Override
	public String toString() {
		return "SocialBadgePoints [id=" + id + ", socialBadgeName="
				+ socialBadgeName + ", socialBadgePoints=" + socialBadgePoints
				+ ", universityId=" + universityId + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSocialBadgeName() {
		return socialBadgeName;
	}

	public void setSocialBadgeName(String socialBadgeName) {
		this.socialBadgeName = socialBadgeName;
	}

	public Double getSocialBadgePoints() {
		return socialBadgePoints;
	}

	public void setSocialBadgePoints(Double socialBadgePoints) {
		this.socialBadgePoints = socialBadgePoints;
	}

	public Long getUniversityId() {
		return universityId;
	}

	public void setUniversityId(Long universityId) {
		this.universityId = universityId;
	}

}
