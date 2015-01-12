package com.shop.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "visibilitydomain_person")
public class VisibilityDomainPerson extends DomainObject {

	@ManyToOne
	private Person person;
	
	@OneToOne(fetch = FetchType.EAGER)
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
