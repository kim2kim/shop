package com.shop.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.shop.core.enums.Answer;

// links the item to the advice

@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "vote")
public class Vote extends DomainObject {

	// person who voted on the item
	@ManyToOne
	private Person person;

	// the vote
	@Enumerated(EnumType.STRING)
	private Answer answer;

	// the collection of items for this vote
	@ManyToOne
	private Advice advice;

	// the item being voted
	@ManyToOne
	private Item item;

	public Advice getAdvice() {
		return advice;
	}

	public void setAdvice(Advice advice) {
		this.advice = advice;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Answer getAnswer() {
		return answer;
	}

	public void setAnswer(Answer answer) {
		this.answer = answer;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

}
