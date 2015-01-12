package com.shop.core.enums;

/**
 * Anything that requires security preference, add it to this enum.  After creating the entity,
 * the visibility for this type will be applied on the entity.
 * 
 * @author khimung
 *
 */
public enum PermissionType {
	ALL, WANT, RECOMMEND, BOUGHT, ADVICE, SELLING, SERVICE, SCRIBBLE, NEWS, ITEMS, JOURNAL, EVENT, FRIENDS;
	
	public String getLabel() {
		return this.name();
	}

	public String getValue() {
		return this.toString();
	}
}
