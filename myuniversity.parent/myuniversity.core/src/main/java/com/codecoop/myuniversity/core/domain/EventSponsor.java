package com.codecoop.myuniversity.core.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EVENT_SPONSOR")
public class EventSponsor implements Serializable {

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

	@Column(name = "SPONSOR_ID")
	private Long sponsorId;

	public EventSponsor() {
	}

	public EventSponsor(Long eventId, Long sponsorId) {
		super();
		this.eventId = eventId;
		this.sponsorId = sponsorId;
	}

	@Override
	public String toString() {
		return "EventSponsor [id=" + id + ", eventId=" + eventId
				+ ", sponsorId=" + sponsorId + "]";
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

	public Long getSponsorId() {
		return sponsorId;
	}

	public void setSponsorId(Long sponsorId) {
		this.sponsorId = sponsorId;
	}

}
