package com.shop.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.shop.core.enums.PermissionType;
import com.shop.core.enums.VisibilityType;

/**
 * Determines the access level.  For every activity, there is a VisibilityDomain.
 * Any person that references this VisibilityDomain has access to the activity
 * associated to this VisibilityDomain.  There is one main VisibilityDomain per
 * member that determines the overall permission of that member.  If this default
 * permission is set to private, then the individual activity visibilityDomain
 * becomes important and only groups or persons with a reference to that activity's
 * visibilityDomain will have access to that activity. 
 * 
 **/
@Entity
@Table(name = "visibility_domain")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class VisibilityDomain extends DomainObject {

	/**
	 * The activity
	 */
	@Enumerated(EnumType.STRING)
	@Column(name="activity_type")
	private PermissionType activityType;

	/**
	 * This is the type... as an enum with PRIVATE, PUBLIC, and CUSTOM
	 */
	@Enumerated(EnumType.STRING)
	private VisibilityType visibility;

	/**
	 * Describes the visibility/group name
	 */
	private String name;

	@Column(name="default_visibility")
	private boolean defaultVisibility = false;

	public VisibilityType getVisibility() {
		return visibility;
	}

	public void setVisibility(VisibilityType visibility) {
		this.visibility = visibility;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isDefaultVisibility() {
		return defaultVisibility;
	}

	public void setDefaultVisibility(boolean defaultVisibility) {
		this.defaultVisibility = defaultVisibility;
	}

	public PermissionType getActivityType() {
		return activityType;
	}

	public void setActivityType(PermissionType activityType) {
		this.activityType = activityType;
	}

}
