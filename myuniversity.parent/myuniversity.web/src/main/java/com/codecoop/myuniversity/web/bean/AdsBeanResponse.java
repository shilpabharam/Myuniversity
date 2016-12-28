package com.codecoop.myuniversity.web.bean;

import java.util.Date;

public class AdsBeanResponse {
	
	private Long id;
	private String name;
	private Date fromDate;
	private Date toDate;
	private String webURL;
	private String isPublished;
	private String description;
	private Long uniId;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getFromDate() {
		return fromDate;
	}
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	public Date getToDate() {
		return toDate;
	}
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	public String getWebURL() {
		return webURL;
	}
	public void setWebURL(String webURL) {
		this.webURL = webURL;
	}
	public String getIsPublished() {
		return isPublished;
	}
	public void setIsPublished(String isPublished) {
		this.isPublished = isPublished;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getUniId() {
		return uniId;
	}
	public void setUniId(Long uniId) {
		this.uniId = uniId;
	}
	
}
