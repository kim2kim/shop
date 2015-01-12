package com.shop.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.shop.core.enums.PermissionType;

/**
 * This associates my list of groups to a type. Assigning a group to a type
 * allows the groups visibility to the type
 * 
 * Association table that links the activity to the list of groups
 * 
 * @author khimung
 * 
 */
@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name="permission")
public class Permission extends DomainObject {

	/**
	 * The activity
	 */
	@Enumerated(EnumType.STRING)
	private PermissionType type;

	/**
	 * The groups that have access to this activity
	 */
	@OneToMany(mappedBy="permission", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	///@JoinTable(name = "permission_permissionvisibility", joinColumns = @JoinColumn(name = "permission_id"), inverseJoinColumns = @JoinColumn(name = "permissionvisibility_id"))
	private List<PermissionPermissionVisibility> permissionGroups = new ArrayList<PermissionPermissionVisibility>();

	@ManyToOne
	private Person person;

	public PermissionType getType() {
		return type;
	}

	public void setType(PermissionType type) {
		this.type = type;
	}

	public List<PermissionPermissionVisibility> getPermissionGroups() {
		return permissionGroups;
	}

	public void setPermissionGroups(
			List<PermissionPermissionVisibility> permissionGroups) {
		this.permissionGroups = permissionGroups;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
	public PermissionPermissionVisibility findGroup(PermissionVisibility pv){
		for(PermissionPermissionVisibility ppv : permissionGroups){
			if(ppv.getPermissionVisibility().getId().equals(pv.getId())){
				return ppv;
			}
		}
		return null;
	}
	
	public PermissionPermissionVisibility findGroupUnionPermission(Long permissionPermissionVisibilityId){
		for(PermissionPermissionVisibility ppv : permissionGroups){
			if(ppv.getId().equals(permissionPermissionVisibilityId)){
				return ppv;
			}
		}
		return null;
	}	
	
	public boolean hasGroup(PermissionVisibility pv){
		for(PermissionPermissionVisibility ppv : permissionGroups){
			if(ppv.getPermissionVisibility().getId().equals(pv.getId())){
				return true;
			}
		}
		return false;
	}
}
