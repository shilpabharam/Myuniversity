package com.codecoop.myuniversity.core.domain;

import static javax.persistence.GenerationType.IDENTITY;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SKILLS")
public class Skills implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private Long id;

	@Column(name = "SKILL_NAME")
	private String skillName;

	@Column(name = "UNIVERSITY_ID")
	private Long universityId;

	@Column(name = "SKILL_CATEGORY_ID")
	private Long skillCategoryId;

	public Skills() {

	}

	public Skills(String skillName, Long skillCategoryId, Long universityId) {
		super();
		this.skillName = skillName;
		this.skillCategoryId = skillCategoryId;
		this.universityId = universityId;
	}

	@Override
	public String toString() {
		return "Skills [id=" + id + ", skillName=" + skillName
				+ ", skillCategoryId=" + skillCategoryId + ", universityId="
				+ universityId + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	public Long getSkillCategoryId() {
		return skillCategoryId;
	}

	public void setSkillCategoryId(Long skillCategoryId) {
		this.skillCategoryId = skillCategoryId;
	}

	public Long getUniversityId() {
		return universityId;
	}

	public void setUniversityId(Long universityId) {
		this.universityId = universityId;
	}
}
