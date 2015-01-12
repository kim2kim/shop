package com.shop.domain;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="rating")
public class Rating extends DomainObject {

	private Integer count = 1;
	private Integer rating = 5;

	@OneToOne
	private Person person;

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getRating() {
		return rating;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public Integer recalculate(Integer rating){
		this.setRating(rating);
		this.setCount(count ++);
		return this.average();
	}

	public Integer average() {
		if(count == 0) return 0;
		return rating / count;
	}
}
