package com.codecoop.myuniversity.core.dto;

import java.io.Serializable;

public class SocialBadgeDeptDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	private Long socialBadgeId;
	private Long departmentId;

	public SocialBadgeDeptDto() {
	}

	public SocialBadgeDeptDto(Long id, Long socialBadgeId, Long depatmentId) {
		super();
		this.id = id;
		this.socialBadgeId = socialBadgeId;
		this.departmentId = depatmentId;
	}

	@Override
	public String toString() {
		return "SocialBadgeDeptDto [id=" + id + ", socialBadgeId="
				+ socialBadgeId + ", depatmentId=" + departmentId + "]";
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
