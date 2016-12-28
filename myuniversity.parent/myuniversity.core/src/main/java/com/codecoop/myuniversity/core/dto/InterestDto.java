package com.codecoop.myuniversity.core.dto;

import java.io.Serializable;

public class InterestDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String interestName;
	private Boolean flag;

	public InterestDto() {
	}

	public InterestDto(String interestName) {
		super();
		this.interestName = interestName;
	}

	@Override
	public String toString() {
		return "InterestDto [id=" + id + ", interestName=" + interestName + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getInterestName() {
		return interestName;
	}

	public void setInterestName(String interestName) {
		this.interestName = interestName;
	}

	public Boolean getFlag() {
		return flag;
	}

	public void setFlag(Boolean flag) {
		this.flag = flag;
	}

}
