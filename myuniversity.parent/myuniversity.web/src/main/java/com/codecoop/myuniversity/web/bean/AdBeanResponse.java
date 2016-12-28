package com.codecoop.myuniversity.web.bean;

import java.util.List;

public class AdBeanResponse {
	
	private List<AdsBeanResponse> advertisements;
	private int count;
	
	public List<AdsBeanResponse> getAdvertisements() {
		return advertisements;
	}
	public void setAdvertisements(List<AdsBeanResponse> advertisements) {
		this.advertisements = advertisements;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
}
