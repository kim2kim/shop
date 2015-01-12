package com.shop.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ads")
public class Ads extends DomainObject {

	/*
	 * public Ads() { super(); this.clicks = 0; }
	 */
	@Column(length = 10000)
	private String description;
	
	@Column(name="company_name")
	private String companyName;

	private Integer clicks = 0;

	@Column(name="file_name")
	private String fileName;

	@ManyToOne
	private Person sponsor;

	@Column(name="sponsor_site")
	private String sponsorSite;

	private String price;

	@Column(name="age_range")
	private Integer ageRange;

	@ManyToOne(cascade = CascadeType.ALL)
	private Photo thumbnail;

	@ManyToOne(cascade = CascadeType.ALL)
	private Photo icon;

	@ManyToOne(cascade = CascadeType.ALL)
	private Photo glimpse;

	@OneToMany(mappedBy="ads", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<AdsTag> tags = new ArrayList<AdsTag>();

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Photo getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(Photo thumbnail) {
		this.thumbnail = thumbnail;
	}

	public Photo getIcon() {
		return icon;
	}

	public void setIcon(Photo icon) {
		this.icon = icon;
	}

	public Photo getGlimpse() {
		return glimpse;
	}

	public void setGlimpse(Photo glimpse) {
		this.glimpse = glimpse;
	}

	public List<AdsTag> getTags() {
		return tags;
	}

	public void setTags(List<AdsTag> tags) {
		this.tags = tags;
	}

	public Integer getClicks() {
		return clicks;
	}

	public void setClicks(Integer clicks) {
		this.clicks = clicks;
	}

	public Person getSponsor() {
		return sponsor;
	}

	public void setSponsor(Person sponsor) {
		this.sponsor = sponsor;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getSponsorSite() {
		return sponsorSite;
	}

	public void setSponsorSite(String sponsorSite) {
		this.sponsorSite = sponsorSite;
	}

	public void incrementClick() {
		this.clicks++;
	}

	public Integer getAgeRange() {
		return ageRange;
	}

	public void setAgeRange(Integer ageRange) {
		this.ageRange = ageRange;
	}

}
