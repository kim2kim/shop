package com.shop.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "permissionvisibility_person")
public class PermissionVisibilityPerson extends DomainObject {

	@ManyToOne
	private Person friend;

	@ManyToOne
	private PermissionVisibility permissionVisibility;

	public Person getFriend() {
		return friend;
	}

	public void setFriend(Person friend) {
		this.friend = friend;
	}

	public PermissionVisibility getPermissionVisibility() {
		return permissionVisibility;
	}

	public void setPermissionVisibility(PermissionVisibility permissionVisibility) {
		this.permissionVisibility = permissionVisibility;
	}
	
}
