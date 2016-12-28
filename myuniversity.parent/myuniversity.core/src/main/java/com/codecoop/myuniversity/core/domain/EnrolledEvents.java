package com.codecoop.myuniversity.core.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ENROLLED_EVENTS")
public class EnrolledEvents implements Serializable {

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

	@Column(name = "EVENT_ID")
	private Long eventId;

	@Column(name = "IS_COMPLETED")
	private Boolean isCompleted;

	@Column(name = "IS_ATTENDED")
	private Boolean isAttended;

	@Column(name = "EVENT_CHECKED_IN")
	private Boolean eventCheckedIn;

	@Column(name = "DELETED_FLAG")
	private Boolean deletedFlag;

	public EnrolledEvents() {

	}

	public EnrolledEvents(Long id, Long userId, Long eventId,
			Boolean isCompleted, Boolean isAttended, Boolean eventCheckedIn,
			Boolean deletedFlag) {
		super();
		this.id = id;
		this.userId = userId;
		this.eventId = eventId;
		this.isCompleted = isCompleted;
		this.isAttended = isAttended;
		this.eventCheckedIn = eventCheckedIn;
		this.deletedFlag = deletedFlag;
	}

	@Override
	public String toString() {
		return "EnrolledEvents [id=" + id + ", userId=" + userId + ", eventId="
				+ eventId + ", isCompleted=" + isCompleted + ", isAttended="
				+ isAttended + ", eventCheckedIn=" + eventCheckedIn
				+ ", deletedFlag=" + deletedFlag + "]";
	}

	public Boolean getDeletedFlag() {
		return deletedFlag;
	}

	public void setDeletedFlag(Boolean deletedFlag) {
		this.deletedFlag = deletedFlag;
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

	public Long getEventId() {
		return eventId;
	}

	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}

	public Boolean getIsCompleted() {
		return isCompleted;
	}

	public void setIsCompleted(Boolean isCompleted) {
		this.isCompleted = isCompleted;
	}

	public Boolean getIsAttended() {
		return isAttended;
	}

	public void setIsAttended(Boolean isAttended) {
		this.isAttended = isAttended;
	}

	public Boolean getEventCheckedIn() {
		return eventCheckedIn;
	}

	public void setEventCheckedIn(Boolean eventCheckedIn) {
		this.eventCheckedIn = eventCheckedIn;
	}

}
