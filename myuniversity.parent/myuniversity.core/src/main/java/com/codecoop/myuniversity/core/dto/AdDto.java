package com.codecoop.myuniversity.core.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class AdDto implements Serializable {

	private static final long serialVersionUID = 1322421558164373517L;
	private Long id;
	private String name;
	private Date fromDate;
	private Date toDate;
	private String webURL;
	private boolean isPublished;
	private String description;
	private Long uniId;
	private Date dateCreated;
	
	private String userCreated;
	private Date dateModified;
	private String userModified;
		

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
	public boolean isPublished() {
		return isPublished;
	}
	public void setPublished(boolean isPublished) {
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
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	public String getUserCreated() {
		return userCreated;
	}
	public void setUserCreated(String userCreated) {
		this.userCreated = userCreated;
	}
	public Date getDateModified() {
		return dateModified;
	}
	public void setDateModified(Date dateModified) {
		this.dateModified = dateModified;
	}
	public String getUserModified() {
		return userModified;
	}
	public void setUserModified(String userModified) {
		this.userModified = userModified;
	}
}
