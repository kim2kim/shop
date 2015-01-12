package com.shop.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "group_person")
public class GroupPerson extends DomainObject {

	@ManyToOne
	private Person person;

	@OneToOne(cascade = CascadeType.ALL)
	private PermissionVisibility permissionVisibility;

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public PermissionVisibility getPermissionVisibility() {
		return permissionVisibility;
	}

	public void setPermissionVisibility(
			PermissionVisibility permissionVisibility) {
		this.permissionVisibility = permissionVisibility;
	}

	public List<Person> getFriends(){
		return this.permissionVisibility.getPermissionVisibilityFriends();
	}
	
	public PermissionVisibilityPerson getPermissionVisibilityFriend(Person friend){
		for(PermissionVisibilityPerson pvf : this.permissionVisibility.getFriends()){
			if(pvf.getFriend().getId().equals(friend.getId())){
				return pvf;
			}
		}
		return null;
	}
	
	public List<Permission> getPermissions(){
		return this.permissionVisibility.getPermissionVisibilityPermissions();
	}
}
