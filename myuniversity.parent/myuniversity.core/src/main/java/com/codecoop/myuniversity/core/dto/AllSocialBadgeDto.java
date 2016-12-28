package com.codecoop.myuniversity.core.dto;

import java.io.Serializable;
import java.util.List;

public class AllSocialBadgeDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private SocialBadgesDto general;
	private List<Long> departments;

	public AllSocialBadgeDto() {
	}

	public AllSocialBadgeDto(SocialBadgesDto general, List<Long> departments) {
		super();
		this.general = general;
		this.departments = departments;
	}

	@Override
	public String toString() {
		return "AllSocialBadgeDto [general=" + general + ", departments="
				+ departments + "]";
	}

	public SocialBadgesDto getGeneral() {
		return general;
	}

	public void setGeneral(SocialBadgesDto general) {
		this.general = general;
	}

	public List<Long> getDepartments() {
		return departments;
	}

	public void setDepartments(List<Long> departments) {
		this.departments = departments;
	}

}
