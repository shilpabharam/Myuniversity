package com.codecoop.myuniversity.core.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER_INTERESTS")
public class UserInterests implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private Long id;

	@Column(name = "USER_ID")
	private Long userId;
	
	@Column(name = "INTEREST_ID")
	private Long interestId;

	public UserInterests() {

	}

	@Override
	public String toString() {
		return "UserInterests [id=" + id + ", userId=" + userId
				+ ", interestId=" + interestId + "]";
	}

	public UserInterests(Long userId, Long interestId) {
		super();
		this.userId = userId;
		this.interestId = interestId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getInterestId() {
		return interestId;
	}

	public void setInterestId(Long interestId) {
		this.interestId = interestId;
	}

}
