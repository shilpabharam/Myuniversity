package com.codecoop.myuniversity.web.bean;

import java.io.Serializable;

public class UniversityBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long universityId;
	private Integer pageNumber;
	private Integer numberOfRecords;

	public Integer getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}

	public Integer getNumberOfRecords() {
		return numberOfRecords;
	}

	public void setNumberOfRecords(Integer numberOfRecords) {
		this.numberOfRecords = numberOfRecords;
	}

	public Long getUniversityId() {
		return universityId;
	}

	public void setUniversityId(Long universityId) {
		this.universityId = universityId;
	}

}
