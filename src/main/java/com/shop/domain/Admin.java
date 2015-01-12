package com.shop.domain;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.shop.model.User;

@Entity
@Table(name="admin")
public class Admin extends DomainObject {

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "username")
	private User userAccount;

	@Basic
	@Column(name="first_name")
	private String firstName;

	@Basic
	@Column(name="last_name")
	private String lastName;

	public User getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(User userAccount) {
		this.userAccount = userAccount;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
