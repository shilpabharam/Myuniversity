package com.codecoop.myuniversity.core.dto;

import java.io.Serializable;

public class SponsorDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	private String sponsorName;

	public SponsorDto() {
	}

	public SponsorDto(Long id, String sponsorName) {
		super();
		this.id = id;
		this.sponsorName = sponsorName;
	}

	@Override
	public String toString() {
		return "SponsorDto [id=" + id + ", sponsorName=" + sponsorName + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSponsorName() {
		return sponsorName;
	}

	public void setSponsorName(String sponsorName) {
		this.sponsorName = sponsorName;
	}

}
