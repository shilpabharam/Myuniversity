package com.codecoop.myuniversity.core.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "INTERESTS")
public class Interests implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private Long id;

	@Column(name = "INTEREST_NAME")
	private String interestName;

	@Column(name = "UNIVERSITY_ID")
	private Long universityId;

	public Interests() {

	}

	public Interests(String interestName, Long universityId) {
		super();
		this.interestName = interestName;
		this.universityId = universityId;
	}

	@Override
	public String toString() {
		return "Interests [id=" + id + ", interestName=" + interestName
				+ ", universityId=" + universityId + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getInterestName() {
		return interestName;
	}

	public void setInterestName(String interestName) {
		this.interestName = interestName;
	}

	public Long getUniversityId() {
		return universityId;
	}

	public void setUniversityId(Long universityId) {
		this.universityId = universityId;
	}
}
