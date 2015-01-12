package com.shop.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.shop.core.enums.PhoneType;
import com.shop.core.enums.VisibilityType;

@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name="phone")
public class Phone extends DomainObject {

	private String area;
	private String number;
	
	@Column(name="country_code")
	private String countryCode;
	
	@Column(name="primary_phone")
	private boolean primaryPhone = true;
	
	@Enumerated(EnumType.STRING)
	private VisibilityType visibility;

	@ManyToOne
	private Person person;

	@Enumerated(EnumType.STRING)
	private PhoneType type;
		
	public Phone(){
		super();
		this.visibility = VisibilityType.PRIVATE;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public boolean isPrimaryPhone() {
		return primaryPhone;
	}

	public void setPrimaryPhone(boolean primaryPhone) {
		this.primaryPhone = primaryPhone;
	}

	public PhoneType getType() {
		return type;
	}

	public void setType(PhoneType type) {
		this.type = type;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public VisibilityType getVisibility() {
		return visibility;
	}

	public void setVisibility(VisibilityType visibility) {
		this.visibility = visibility;
	}

}
