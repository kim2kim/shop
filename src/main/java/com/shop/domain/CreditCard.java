package com.shop.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang.StringUtils;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.shop.core.enums.CreditCardType;

@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name="credit_card")
public class CreditCard extends DomainObject {

	@ManyToOne
	private Address cardAddress;
	
	@Column(name="card_name")
	private String cardName;

	private String number;

	@Enumerated(EnumType.STRING)
	private CreditCardType type;

	@Column(name="expiration_date")
	private String expirationDate;

	@Column(name="security_code")
	private Integer securityCode;

	@Column(name="full_name")
	private String fullName;

	@ManyToOne
	private Person person;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public CreditCardType getType() {
		return type;
	}

	public void setType(CreditCardType type) {
		this.type = type;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	public Integer getSecurityCode() {
		return securityCode;
	}

	public void setSecurityCode(Integer securityCode) {
		this.securityCode = securityCode;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Address getCardAddress() {
		return cardAddress;
	}

	public void setCardAddress(Address cardAddress) {
		this.cardAddress = cardAddress;
	}

	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}
	
	@Transient
	public String getLastFour(){
		return "xxxx-xxxx-xxxx-"+StringUtils.substring(this.number, this.number.length() - 4, this.number.length());
	}

}
