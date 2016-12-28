package com.codecoop.myuniversity.core.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EVENT_SKILL_SCHEDULE")
public class EventSkillSchedule implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private Long id;

	@Column(name = "EVENT_ID")
	private Long eventId;

	@Column(name = "EVENT_SKILL_ID")
	private Long eventSkillId;

	@Column(name = "EVENT_START_TIME")
	private Date eventStartTime;

	@Column(name = "EVENT_END_TIME")
	private Date eventEndTime;

	public EventSkillSchedule() {
	}

	public EventSkillSchedule(Long id, Long eventId, Long eventSkillId,
			Date eventStartTime, Date eventEndTime) {
		super();
		this.id = id;
		this.eventId = eventId;
		this.eventSkillId = eventSkillId;
		this.eventStartTime = eventStartTime;
		this.eventEndTime = eventEndTime;
	}

	@Override
	public String toString() {
		return "EventSkillSchedule [id=" + id + ", eventId=" + eventId
				+ ", eventSkillId=" + eventSkillId + ", eventStartTime="
				+ eventStartTime + ", eventEndTime=" + eventEndTime + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getEventId() {
		return eventId;
	}

	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}

	public Long getEventSkillId() {
		return eventSkillId;
	}

	public void setEventSkillId(Long eventSkillId) {
		this.eventSkillId = eventSkillId;
	}

	public Date getEventStartTime() {
		return eventStartTime;
	}

	public void setEventStartTime(Date eventStartTime) {
		this.eventStartTime = eventStartTime;
	}

	public Date getEventEndTime() {
		return eventEndTime;
	}

	public void setEventEndTime(Date eventEndTime) {
		this.eventEndTime = eventEndTime;
	}

}
