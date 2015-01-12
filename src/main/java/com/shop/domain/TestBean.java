package com.shop.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="testbean")
public class TestBean extends DomainObject {

	private String name;
	private String last;

	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
