package com.codecoop.myuniversity.core.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SKILL_BADGES")
public class SkillBadges implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private Long id;

	@Column(name = "SKILL_BADGE_NAME")
	private String skillBadgeName;

	@Column(name = "SKILL_BADGE_POINTS")
	private Double skillBadgePoints;

	@Column(name = "UNIVERSITY_ID")
	private Long universityId;

	public SkillBadges() {

	}

	public SkillBadges(Long id, String skillBadgeName, Double skillBadgePoints,
			Long universityId) {
		super();
		this.id = id;
		this.skillBadgeName = skillBadgeName;
		this.skillBadgePoints = skillBadgePoints;
		this.universityId = universityId;
	}

	@Override
	public String toString() {
		return "SkillBadges [id=" + id + ", skillBadgeName=" + skillBadgeName
				+ ", skillBadgePoints=" + skillBadgePoints + ", universityId="
				+ universityId + "]";
	}

	public Long getUniversityId() {
		return universityId;
	}

	public void setUniversityId(Long universityId) {
		this.universityId = universityId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSkillBadgeName() {
		return skillBadgeName;
	}

	public void setSkillBadgeName(String skillBadgeName) {
		this.skillBadgeName = skillBadgeName;
	}

	public Double getSkillBadgePoints() {
		return skillBadgePoints;
	}

	public void setSkillBadgePoints(Double skillBadgePoints) {
		this.skillBadgePoints = skillBadgePoints;
	}

}
