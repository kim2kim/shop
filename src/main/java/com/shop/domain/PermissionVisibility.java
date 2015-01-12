package com.shop.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * 
 * Like Friend but for groups. Instead of containing just 1 friend and person,
 * this holds a list of people per person.
 * 
 * It also maps to a list of permissions. Permissions indicate the different
 * activity this group has access to. If the group is not part of the
 * Permissions group list, then this group does not have access to the activity
 * for that Permission.
 * 
 * 
 * This should have been named UserGroup
 * 
 * @author khimung
 * 
 */
@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name="permission_visibility")
public class PermissionVisibility extends DomainObject {

	/**
	 * The activity the group has access to
	 */
	@OneToMany(mappedBy = "permissionVisibility", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	// @JoinTable(name = "permission_permissionvisibility", joinColumns =
	// @JoinColumn(name = "permissionvisibility_id"), inverseJoinColumns =
	// @JoinColumn(name = "permission_id"))
	private List<PermissionPermissionVisibility> permissions = new ArrayList<PermissionPermissionVisibility>();

	@OneToOne(mappedBy="permissionVisibility")
	private GroupPerson groupPerson;
	/**
	 * the group may or may not have a permission set to it. No permission means
	 * 
	 * @ManyToOne private VisibilityDomain visibilityDomain;
	 */

	/**
	 * This is here becuase we want to be able to allow having a list of friends
	 * in a group without having a visibilitydomain associated. Hence,
	 * visibility domain can be null if this is not part of an activity
	 */
	@OneToMany(mappedBy = "permissionVisibility", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	// @JoinTable(name = "permissionvisibilitydomain", joinColumns =
	// @JoinColumn(name = "visibility_id"), inverseJoinColumns =
	// @JoinColumn(name = "friend_id"))
	private List<PermissionVisibilityPerson> friends = new ArrayList<PermissionVisibilityPerson>();

	@Column(name="group_name")
	private String groupName;

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public List<PermissionPermissionVisibility> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<PermissionPermissionVisibility> permissions) {
		this.permissions = permissions;
	}

	public List<PermissionVisibilityPerson> getFriends() {
		return friends;
	}

	public void setFriends(List<PermissionVisibilityPerson> friends) {
		this.friends = friends;
	}

	public GroupPerson getGroupPerson() {
		return groupPerson;
	}

	public void setGroupPerson(GroupPerson groupPerson) {
		this.groupPerson = groupPerson;
	}
	
	public List<Person> getPermissionVisibilityFriends(){
		List<Person> flist = new ArrayList<Person>();
		for(PermissionVisibilityPerson p : friends){
			flist.add(p.getFriend());
		}
		return flist;
	}

	public List<Permission> getPermissionVisibilityPermissions(){
		List<Permission> flist = new ArrayList<Permission>();
		for(PermissionPermissionVisibility p : permissions){
			flist.add(p.getPermission());
		}
		return flist;		
	}
}
