package com.shop.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name="person_tag")
public class PersonTag extends DomainObject {

	private String tag;

	@ManyToOne
	private Person person;

	/**
	 * I forgot why we are adding description to tag. It was in the note.
	 */
	private String description;

	public PersonTag() {
	}

	public PersonTag(Person person, String tag) {
		this.setTag(tag);
		this.setPerson(person);
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}
