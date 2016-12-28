package com.codecoop.myuniversity.core.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "THEMEBADGE")
public class ThemeBadge implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private Long id;

	@Column(name = "THEME_BADGE_NAME")
	private String themeBadgeName;

	@Column(name = "THEME_BADGE_POINTS")
	private Double themeBadgePoints;

	public ThemeBadge() {
	}

	public ThemeBadge(String themeBadgeName, Double themeBadgePoints) {
		super();
		this.themeBadgeName = themeBadgeName;
		this.themeBadgePoints = themeBadgePoints;
	}

	@Override
	public String toString() {
		return "ThemeBadge [id=" + id + ", themeBadgeName=" + themeBadgeName
				+ ", themeBadgePoints=" + themeBadgePoints + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getThemeBadgeName() {
		return themeBadgeName;
	}

	public void setThemeBadgeName(String themeBadgeName) {
		this.themeBadgeName = themeBadgeName;
	}

	public Double getThemeBadgePoints() {
		return themeBadgePoints;
	}

	public void setThemeBadgePoints(Double themeBadgePoints) {
		this.themeBadgePoints = themeBadgePoints;
	}

}
