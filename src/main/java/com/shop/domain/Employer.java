package com.shop.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name="employer")
public class Employer extends Person {
	
	@Column(name="company_name")
	private String companyName;

	@Column(length = 255)
	private String description;

	@OneToMany(mappedBy = "employer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Employment> employees = new ArrayList<Employment>();

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public List<Employment> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employment> employees) {
		this.employees = employees;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Transient
	public String identifier() {
		return this.getCompanyName() + "-" + this.getId();
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
		return this.companyName;
	}

	@Transient
	@Override
	public String getAlias(){
		return this.companyName;
	}
}
