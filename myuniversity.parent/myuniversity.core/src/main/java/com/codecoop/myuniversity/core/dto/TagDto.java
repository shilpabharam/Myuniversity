package com.codecoop.myuniversity.core.dto;

import java.io.Serializable;

public class TagDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String tagName;
	private Boolean flag;

	public TagDto(Long id, String tagName, Boolean flag) {
		super();
		this.id = id;
		this.tagName = tagName;
		this.flag = flag;
	}

	public TagDto() {

	}

	@Override
	public String toString() {
		return "TagDto [id=" + id + ", tagName=" + tagName + ", flag=" + flag
				+ "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public Boolean getFlag() {
		return flag;
	}

	public void setFlag(Boolean flag) {
		this.flag = flag;
	}

}
