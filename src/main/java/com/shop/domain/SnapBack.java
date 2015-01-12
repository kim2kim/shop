package com.shop.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * This is like facebook's wall.
 */
@Entity
@Table(name="snap_back")
public class SnapBack extends DomainObject {

	@ManyToOne
	private Person snapper;

	@ManyToOne
	private Person person;

	@Column(length = 500)
	private String message;

	@Column(name="date_entered")
	private Date dateEntered;

	public Person getSnapper() {
		return snapper;
	}

	public void setSnapper(Person snapper) {
		this.snapper = snapper;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getDateEntered() {
		return dateEntered;
	}

	public void setDateEntered(Date dateEntered) {
		this.dateEntered = dateEntered;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}
