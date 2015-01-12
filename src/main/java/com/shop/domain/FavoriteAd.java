package com.shop.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="favorite_ad")
public class FavoriteAd extends DomainObject {

	@ManyToOne
	private Person person;

	@ManyToOne
	private Ads ads;

	@Column(name="default_favorite")
	private boolean defaultFavorite;

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Ads getAds() {
		return ads;
	}

	public void setAds(Ads ads) {
		this.ads = ads;
	}

	public boolean isDefaultFavorite() {
		return defaultFavorite;
	}

	public void setDefaultFavorite(boolean defaultFavorite) {
		this.defaultFavorite = defaultFavorite;
	}
	
	

}
