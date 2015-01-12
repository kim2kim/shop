package com.shop.core.enums;


/*
 * Activities are Comment, wall/snap back/Me/House/Town/Country.  This is used by permission to set what groups
 * have access to what activity.
 */
public enum ActivityType {
	// List all things that a user might want to set permission on.
	COMMENT, IMAGE, SNAP, NEWS, PROFILE, INFORMATION, CONTACT;

	private String activity;

	private ActivityType() {
		this.activity = this.name();
	}

}
