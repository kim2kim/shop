package com.shop.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.shop.core.enums.Authority;

@Entity
@Table(name="confirm_email")
public class ConfirmEmail extends DomainObject {

	@Column(unique = true, nullable = true)
	private String email;

	@ManyToOne
	private EmailAddress emailAddress;

	@Column(name="random_key", unique = true, nullable = false)
	private String randomKey;

	@Column(nullable = false)
	private String password;

	@Enumerated(EnumType.STRING)
	private Authority authority;

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	public String getRandomKey() {
		return randomKey;
	}

	public void setRandomKey(String randomKey) {
		this.randomKey = randomKey;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Authority getAuthority() {
		return authority;
	}

	public void setAuthority(Authority authority) {
		this.authority = authority;
	}

	public EmailAddress getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(EmailAddress emailAddress) {
		this.emailAddress = emailAddress;
	}

}
