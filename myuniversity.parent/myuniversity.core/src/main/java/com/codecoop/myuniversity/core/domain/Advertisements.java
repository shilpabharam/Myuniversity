package com.codecoop.myuniversity.core.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "ADVERTISEMENTS")
public class Advertisements implements Serializable {
	private static final long serialVersionUID = 8060006331272036763L;
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private Long id; 
	
	@Column(name = "UNI_ID")
	private Long uniId;
	
	@Column(name = "AD_NAME")
	private String adName; 
	
	@Column(name = "FROM_DATE")
	private Date fromDate; 
	
	@Column(name = "TO_DATE")
	private Date toDate; 
	
	@Column(name = "AD_WEB_URL")
	private String adWebURL; 
	
	@Column(name = "AD_PUBLISHED")
	private boolean adPublished; 
	
	@Column(name = "AD_DESCRIPTION")
	private String adDescription;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATE_CREATED", length = 19)
	private Date dateCreated;
	
	@Column(name = "USER_CREATED")
	private String userCreated;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATE_MODIFIED", length = 19)
	private Date dateModified;
	
	@Column(name = "USER_MODIFIED")
	private String userModified;
		
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUniId() {
		return uniId;
	}
	public void setUniId(Long uniId) {
		this.uniId = uniId;
	}
	public String getAdName() {
		return adName;
	}
	public void setAdName(String adName) {
		this.adName = adName;
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
	public String getAdWebURL() {
		return adWebURL;
	}
	public void setAdWebURL(String adWebURL) {
		this.adWebURL = adWebURL;
	}
	public boolean isAdPublished() {
		return adPublished;
	}
	public void setAdPublished(boolean adPublished) {
		this.adPublished = adPublished;
	}
	public String getAdDescription() {
		return adDescription;
	}
	public void setAdDescription(String adDescription) {
		this.adDescription = adDescription;
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
