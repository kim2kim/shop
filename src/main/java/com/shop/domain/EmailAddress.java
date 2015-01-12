package com.shop.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.shop.core.enums.EmailAddressType;
import com.shop.core.enums.VisibilityType;

@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name="email_address")
public class EmailAddress extends DomainObject {

	private boolean primaryEmail = true;

	@Column(nullable = false, unique = true)
	private String email;

	@Enumerated(EnumType.STRING)
	private EmailAddressType type;

	@Enumerated(EnumType.STRING)
	private VisibilityType visibility;

	@ManyToOne
	private Person person;
	
	public EmailAddress(){
		super();
		this.visibility = VisibilityType.PRIVATE;
	}

	public boolean isPrimaryEmail() {
		return primaryEmail;
	}

	public void setPrimaryEmail(boolean primaryEmail) {
		this.primaryEmail = primaryEmail;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public EmailAddressType getType() {
		return type;
	}

	public void setType(EmailAddressType type) {
		this.type = type;
	}

	public VisibilityType getVisibility() {
		return visibility;
	}

	public void setVisibility(VisibilityType visibility) {
		this.visibility = visibility;
	}

}
