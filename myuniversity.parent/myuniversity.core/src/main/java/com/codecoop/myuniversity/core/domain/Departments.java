package com.codecoop.myuniversity.core.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DEPARTMENTS")
public class Departments implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private Long id;

	@Column(name = "DEP_NAME")
	private String depName;

	@Column(name = "VALID")
	private Boolean valid;

	@Column(name = "UNIVERSITY_ID")
	private Long universityId;

	public Departments() {

	}

	public Departments(String depName, Boolean valid, Long universityId) {
		super();
		this.depName = depName;
		this.valid = valid;
		this.universityId = universityId;
	}

	@Override
	public String toString() {
		return "Departments [id=" + id + ", depName=" + depName + ", valid="
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
