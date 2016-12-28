package com.codecoop.myuniversity.core.domain;

import static javax.persistence.GenerationType.IDENTITY;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EVENT_SOCIAL_BADGE")
public class EventSocialBadge implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private Long id;

	@Column(name = "EVENT_ID")
	private Long eventId;

	@Column(name = "SOCIAL_BADGE_ID")
	private Long socialBadgeId;

	@Column(name = "DESCRIPTION")
	private String description;

	public EventSocialBadge() {
	}

	public EventSocialBadge(Long id, Long eventId, Long socialBadgeId,
			String description) {
		super();
		this.id = id;
		this.eventId = eventId;
		this.socialBadgeId = socialBadgeId;
		this.description = description;
	}

	@Override
	public String toString() {
		return "EventSocialBadge [id=" + id + ", eventId=" + eventId
				+ ", socialBadgeId=" + socialBadgeId + ", description="
				+ description + "]";
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

	public Long getSocialBadgeId() {
		return socialBadgeId;
	}

	public void setSocialBadgeId(Long socialBadgeId) {
		this.socialBadgeId = socialBadgeId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
