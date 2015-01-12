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

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * This is like facebook's wall.
 */
@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name="scribble")
public class Scribble extends DomainObject {

	@ManyToOne
	private Person scribbler;

	@ManyToOne
	private Person person;

	@Column(length = 1000)
	private String message;
	
	@Column(name = "has_read")
	private boolean hasRead;

	@OneToMany(mappedBy = "scribble", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<ScribbleTag> tags = new ArrayList<ScribbleTag>();

	@OneToMany(mappedBy = "scribble", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<ScribbleVisibilityDomain> scribbleVisibilities = new ArrayList<ScribbleVisibilityDomain>();

	private String category;
	
	public Scribble(){
		this.hasRead = false;
	}

	public boolean isHasRead() {
		return hasRead;
	}

	public void setHasRead(boolean hasRead) {
		this.hasRead = hasRead;
	}



	public Person getScribbler() {
		return scribbler;
	}

	public void setScribbler(Person scribbler) {
		this.scribbler = scribbler;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public List<ScribbleTag> getTags() {
		return tags;
	}

	public void setTags(List<ScribbleTag> tags) {
		this.tags = tags;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public List<ScribbleVisibilityDomain> getScribbleVisibilities() {
		return scribbleVisibilities;
	}

	public void setScribbleVisibilities(
			List<ScribbleVisibilityDomain> scribbleVisibilities) {
		this.scribbleVisibilities = scribbleVisibilities;
	}

}
