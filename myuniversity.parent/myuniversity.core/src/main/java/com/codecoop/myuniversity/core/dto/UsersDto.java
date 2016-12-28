package com.codecoop.myuniversity.core.dto;

import java.io.Serializable;

import com.codecoop.myuniversity.core.domain.Roles;

public class UsersDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String status;
	private Integer statusCode;
	private String fullName;
	private String password;
	private String email;
	private boolean isActive;
	private Integer phoneNumber;
	private Integer deviveId;
	private String deviceType;
	private Double deviceOsVersion;
	private String deviceAppToken;
	private Double appVersion;
	private Roles userRole;

	public UsersDto() {
	}

	public UsersDto(Long id, String status, Integer statusCode,
			String fullName, String password, String email, boolean isActive,
			Integer phoneNumber, Integer deviveId, String deviceType,
			Double deviceOsVersion, String deviceAppToken, Double appVersion,
			Roles userRole) {
		super();
		this.id = id;
		this.status = status;
		this.statusCode = statusCode;
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
	}

	@Override
	public String toString() {
		return "UsersDto [id=" + id + ", fullName=" + fullName + ", password="
				+ password + ", email=" + email + ", isActive=" + isActive
				+ ", phoneNumber=" + phoneNumber + ", deviveId=" + deviveId
				+ ", deviceType=" + deviceType + ", deviceOsVersion="
				+ deviceOsVersion + ", deviceAppToken=" + deviceAppToken
				+ ", appVersion=" + appVersion + ", userRole=" + userRole + "]";
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

	public Roles getUserRole() {
		return userRole;
	}

	public void setUserRole(Roles userRole) {
		this.userRole = userRole;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

}
