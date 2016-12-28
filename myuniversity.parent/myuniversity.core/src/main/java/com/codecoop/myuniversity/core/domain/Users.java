package com.codecoop.myuniversity.core.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USERS")
public class Users implements Serializable {

	private static final long serialVersionUID = 7781718773643632464L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private Long id;

	@Column(name = "FULLNAME")
	private String fullName;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "IS_ACTIVE")
	private boolean isActive;

	@Column(name = "PHONE_NUMBER")
	private Integer phoneNumber;

	@Column(name = "DEVICE_ID")
	private Integer deviveId;

	@Column(name = "DEVICE_TYPE")
	private String deviceType;

	@Column(name = "DEVICE_OS_VERSION")
	private Double deviceOsVersion;

	@Column(name = "DEVICE_APP_TOKEN")
	private String deviceAppToken;

	@Column(name = "APP_VERSION")
	private Double appVersion;

	@Column(name = "USER_ROLE")
	private Long userRole;

	@Column(name = "UNIVERSITY_ID")
	private Long universityId;

	public Users() {

	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", fullName=" + fullName + ", password="
				+ password + ", email=" + email + ", isActive=" + isActive
				+ ", phoneNumber=" + phoneNumber + ", deviveId=" + deviveId
				+ ", deviceType=" + deviceType + ", deviceOsVersion="
				+ deviceOsVersion + ", deviceAppToken=" + deviceAppToken
				+ ", appVersion=" + appVersion + ", userRole=" + userRole
				+ ", universityId=" + universityId + "]";
	}

	public Users(Long id, String fullName, String password, String email,
			boolean isActive, Integer phoneNumber, Integer deviveId,
			String deviceType, Double deviceOsVersion, String deviceAppToken,
			Double appVersion, Long userRole, Long universityId) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.password = password;
		this.email = email;
		this.isActive = isActive;
		this.phoneNumber = phoneNumber;
		this.deviveId = deviveId;
		this.deviceType = deviceType;
		this.deviceOsVersion = deviceOsVersion;
		this.deviceAppToken = deviceAppToken;
		this.appVersion = appVersion;
		this.userRole = userRole;
		this.universityId = universityId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Integer getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Integer phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Integer getDeviveId() {
		return deviveId;
	}

	public void setDeviveId(Integer deviveId) {
		this.deviveId = deviveId;
	}

	public String getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	public String getDeviceAppToken() {
		return deviceAppToken;
	}

	public void setDeviceAppToken(String deviceAppToken) {
		this.deviceAppToken = deviceAppToken;
	}

	public Double getDeviceOsVersion() {
		return deviceOsVersion;
	}

	public void setDeviceOsVersion(Double deviceOsVersion) {
		this.deviceOsVersion = deviceOsVersion;
	}

	public Double getAppVersion() {
		return appVersion;
	}

	public void setAppVersion(Double appVersion) {
		this.appVersion = appVersion;
	}

	public Long getUserRole() {
		return userRole;
	}

	public void setUserRole(Long userRole) {
		this.userRole = userRole;
	}

	public Long getUniversityId() {
		return universityId;
	}

	public void setUniversityId(Long universityId) {
		this.universityId = universityId;
	}

}
