package com.shop.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "permission_permissionvisibility")
public class PermissionPermissionVisibility extends DomainObject {

	@ManyToOne
	private Permission permission;
	
	@ManyToOne
	private PermissionVisibility permissionVisibility;
	
	public Permission getPermission() {
		return permission;
	}
	public void setPermission(Permission permission) {
		this.permission = permission;
	}
	public PermissionVisibility getPermissionVisibility() {
		return permissionVisibility;
	}
	public void setPermissionVisibility(PermissionVisibility permissionVisibility) {
		this.permissionVisibility = permissionVisibility;
	}
	
	
}
