package com.shop.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import com.shop.core.enums.Authority;

@Entity
@Table(name="authorities")
public class Authorities extends DomainObject {

	private String username;

	@Column(length = 50)
	@Enumerated(javax.persistence.EnumType.STRING)
	private Authority authority;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Authority getAuthority() {
		return authority;
	}

	public void setAuthority(Authority authority) {
		this.authority = authority;
	}

}
