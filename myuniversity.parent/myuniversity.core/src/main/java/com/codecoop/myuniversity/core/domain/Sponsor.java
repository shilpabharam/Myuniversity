package com.codecoop.myuniversity.core.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SPONSOR")
public class Sponsor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private Long id;

	@Column(name = "SPONSOR_NAME")
	private String sponsorName;

	public Sponsor() {
	}

	public Sponsor(String sponsorName) {
		super();
		this.sponsorName = sponsorName;
	}

	@Override
	public String toString() {
		return "Sponsor [id=" + id + ", sponsorName=" + sponsorName + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSponsorName() {
		return sponsorName;
	}

	public void setSponsorName(String sponsorName) {
		this.sponsorName = sponsorName;
	}

}
