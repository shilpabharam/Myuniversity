package com.codecoop.myuniversity.web.bean;

import java.io.Serializable;

public class RegistrationRequst implements Serializable {

	private static final long serialVersionUID = 1L;
	private String fullName;
	private String email;
	private String password;
	private Integer phoneNumber;
	private Integer deviceId;
	private String deviceType;
	private Double deviceOsVersion;
	private String deviceAppToken;

	private Double appVersion;

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

	public Integer getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Integer phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Integer getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(Integer deviceId) {
		this.deviceId = deviceId;
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

}
