package com.codecoop.myuniversity.core.dto;

import java.util.Date;

public class PathFinderDto {

	private Long id;
	private String title;
	private String notes;
	private Date createdDate;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Override
	public String toString() {
		return "ResourceDto [id=" + id + ", title=" + title + ", notes="
				+ notes + ", createdDate=" + createdDate + "]";
	}

}
