package com.shop.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.shop.core.enums.AddressType;
import com.shop.core.enums.VisibilityType;

@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name="address")
public class Address extends DomainObject {

	private String street1;
	private String street2;
	private String unitNumber;
	private String city;
	private String stateOrProvince;
	private String country;
	private String postalCode;

	@Enumerated(EnumType.STRING)
	private VisibilityType visibility;

	public Address() {
		super();
		this.visibility = VisibilityType.PRIVATE;
		// this.country = "US";
	}

	@ManyToOne
	@JoinColumn(nullable = false)
	private Person person;

	private boolean primaryAddress = true;

	@Enumerated(EnumType.STRING)
	@Column(unique=true)
	private AddressType type;

	public String getStreet1() {
		return street1;
	}

	public void setStreet1(String street1) {
		this.street1 = street1;
	}

	public String getStreet2() {
		return street2;
	}

	public void setStreet2(String street2) {
		this.street2 = street2;
	}

	public String getUnitNumber() {
		return unitNumber;
	}

	public void setUnitNumber(String unitNumber) {
		this.unitNumber = unitNumber;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStateOrProvince() {
		return stateOrProvince;
	}

	public void setStateOrProvince(String stateOrProvince) {
		this.stateOrProvince = stateOrProvince;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public boolean isPrimaryAddress() {
		return primaryAddress;
	}

	public void setPrimaryAddress(boolean primaryAddress) {
		this.primaryAddress = primaryAddress;
	}

	public AddressType getType() {
		return type;
	}

	public void setType(AddressType type) {
		this.type = type;
	}

	public VisibilityType getVisibility() {
		return visibility;
	}

	public void setVisibility(VisibilityType visibility) {
		this.visibility = visibility;
	}

}
