package com.shop.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/*
 * When the user is about to pay, we have a page that allows the user to pick
 * credit card and pay pal emails.
 * That submit will go to a PaymentController where a payment will be collected before
 * confirming the user.
 */
@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name="payment")
public class Payment extends DomainObject {

	@ManyToOne
	private Person person;

	private String name;

	@ManyToOne
	private Phone contact;

	@ManyToOne
	private EmailAddress paypalAccount;

	@ManyToOne
	private CreditCard creditCards;

	@ManyToOne
	private Address shippingAddress;

	@ManyToOne
	private Address billingAddress;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public Address getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}

	public EmailAddress getPaypalAccount() {
		return paypalAccount;
	}

	public void setPaypalAccount(EmailAddress paypalAccount) {
		this.paypalAccount = paypalAccount;
	}

	public CreditCard getCreditCards() {
		return creditCards;
	}

	public void setCreditCards(CreditCard creditCards) {
		this.creditCards = creditCards;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Phone getContact() {
		return contact;
	}

	public void setContact(Phone contact) {
		this.contact = contact;
	}

}
