package com.codecoop.myuniversity.core.dto;

import java.io.Serializable;

public class DepartmentsDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	private String depName;
	private Boolean valid;
	private Long universityId;

	public DepartmentsDto() {
	}

	public DepartmentsDto(Long id, String depName, Boolean valid,
			Long universityId) {
		super();
		this.id = id;
		this.depName = depName;
		this.valid = valid;
		this.universityId = universityId;
	}

	

	@Override
	public String toString() {
		return "DepartmentsDto [id=" + id + ", depName=" + depName + ", valid="
				+ valid + ", universityId=" + universityId + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDepName() {
		return depName;
	}

	public void setDepName(String depName) {
		this.depName = depName;
	}

	public Boolean getValid() {
		return valid;
	}

	public void setValid(Boolean valid) {
		this.valid = valid;
	}

	public Long getUniversityId() {
		return universityId;
	}

	public void setUniversityId(Long universityId) {
		this.universityId = universityId;
	}

}
