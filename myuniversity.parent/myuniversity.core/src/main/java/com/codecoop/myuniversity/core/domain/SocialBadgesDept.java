package com.codecoop.myuniversity.core.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SOCIAL_BADGES_DEPARTMENTS")
public class SocialBadgesDept implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private Long id;

	@Column(name = "SOCIAL_BADGE_ID")
	private Long socialBadgeId;

	@Column(name = "DEPARTMENT_ID")
	private Long departmentId;

	public SocialBadgesDept() {
	}

	public SocialBadgesDept(Long id, Long socialBadgeId, Long departmentId) {
		super();
		this.id = id;
		this.socialBadgeId = socialBadgeId;
		this.departmentId = departmentId;
	}

	@Override
	public String toString() {
		return "SocialBadgesDept [id=" + id + ", socialBadgeId="
				+ socialBadgeId + ", departmentId=" + departmentId + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getSocialBadgeId() {
		return socialBadgeId;
	}

	public void setSocialBadgeId(Long socialBadgeId) {
		this.socialBadgeId = socialBadgeId;
	}

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

}
