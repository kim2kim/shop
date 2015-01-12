package com.shop.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * This is an association table between visibility domain and person
 * @author khim.ung
 *
 */
@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name="person_visibility_domain")
public class PersonVisibilityDomain extends DomainObject {

	@ManyToOne
	private Person person;

	@ManyToOne
	private VisibilityDomain visibilityDomain;
	
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public VisibilityDomain getVisibilityDomain() {
		return visibilityDomain;
	}

	public void setVisibilityDomain(VisibilityDomain visibilityDomain) {
		this.visibilityDomain = visibilityDomain;
	}

}
