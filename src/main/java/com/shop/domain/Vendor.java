package com.shop.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * Holds vendor specific information that a user would not have.
 * 
 * @author khim.ung
 * 
 */
@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "vendor")
public class Vendor extends Person {

	private String description;

	@Column(name="company_name")
	private String companyName;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	@Transient
	public boolean getIsSleekSwap() {
		if (this.getUserAccount().getUsername().equals("sleekswap@gmail.com")) {
			return true;
		}
		return false;
	}
	
	@Transient
	public String getFullName() {
		return companyName;
	}
	
	@Transient
	@Override
	public String getAlias(){
		return this.companyName;
	}
}
