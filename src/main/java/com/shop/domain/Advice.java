package com.shop.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

// group the items for voting 

@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name="advice")
public class Advice extends DomainObject {

	@OneToMany(mappedBy="advice", cascade = CascadeType.ALL)
	private List<Vote> votes = new ArrayList<Vote>();

	@ManyToOne
	private Person person;

	public List<Vote> getVotes() {
		return votes;
	}

	public void setVotes(List<Vote> votes) {
		this.votes = votes;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}
