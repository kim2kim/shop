package com.shop.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.shop.core.enums.UserType;

@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name="face")
public class Face extends DomainObject {

	@ManyToOne
	private Person person;

	/**
	 * Indicates whether this photo is the face photo
	 */
	@Column(name="default_face")
	private boolean defaultFace;

	@Column(length = 256)
	private String caption;

	/**
	 * Identifies whether this image belongs to a vendor or a user
	 */
	@Enumerated(EnumType.STRING)
	private UserType type;

	@OneToOne(cascade = CascadeType.ALL)
	private Photo icon;

	@OneToOne(cascade = CascadeType.ALL)
	private Photo mini;

	@OneToOne(cascade = CascadeType.ALL)
	private Photo glimpse;

	/**
	 * We are using fetch eager since we are applying the thumbnail to both text
	 * and image preferences
	 */
	@OneToOne(cascade = CascadeType.ALL)
	private Photo thumbnail;

	public boolean isDefaultFace() {
		return defaultFace;
	}

	public void setDefaultFace(boolean defaultFace) {
		this.defaultFace = defaultFace;
	}

	public UserType getType() {
		return type;
	}

	public void setType(UserType type) {
		this.type = type;
	}

	public Photo getMini() {
		return mini;
	}

	public void setMini(Photo mini) {
		this.mini = mini;
	}

	public Photo getIcon() {
		return icon;
	}

	public void setIcon(Photo icon) {
		this.icon = icon;
	}

	public Photo getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(Photo thumbnail) {
		this.thumbnail = thumbnail;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public Photo getGlimpse() {
		return glimpse;
	}

	public void setGlimpse(Photo glimpse) {
		this.glimpse = glimpse;
	}

	@Transient
	public boolean isApplication() {
		return this.glimpse.isApplication();
	}
}
