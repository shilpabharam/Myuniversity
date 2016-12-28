package com.codecoop.myuniversity.core.dto;

import java.util.List;

public class AllPathFinderDto {
	private Integer pageNumber;
	private Integer totalRecords;

	private List<PathFinderDto> resources;

	public Integer getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}

	public Integer getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(Integer totalRecords) {
		this.totalRecords = totalRecords;
	}

	public List<PathFinderDto> getResources() {
		return resources;
	}

	public void setResources(List<PathFinderDto> resources) {
		this.resources = resources;
	}

}
