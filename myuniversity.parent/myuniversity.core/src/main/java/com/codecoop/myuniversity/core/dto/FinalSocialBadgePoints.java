package com.codecoop.myuniversity.core.dto;

import java.util.List;

public class FinalSocialBadgePoints {
	private Double goldBadges;
	private Double silverBadges;
	private Double bronzeBadges;
	private List<EventsSocialBadgesPointsFinal> socialBadges;
	

	public Double getGoldBadges() {
		return goldBadges;
	}

	public void setGoldBadges(Double goldBadges) {
		this.goldBadges = goldBadges;
	}

	public Double getSilverBadges() {
		return silverBadges;
	}

	public void setSilverBadges(Double silverBadges) {
		this.silverBadges = silverBadges;
	}

	public Double getBronzeBadges() {
		return bronzeBadges;
	}

	public void setBronzeBadges(Double bronzeBadges) {
		this.bronzeBadges = bronzeBadges;
	}

	public List<EventsSocialBadgesPointsFinal> getSocialBadges() {
		return socialBadges;
	}

	public void setSocialBadges(List<EventsSocialBadgesPointsFinal> socialBadges) {
		this.socialBadges = socialBadges;
	}

}
