package com.shop.core.enums;

/**
 * For the future, might be nice to be able to customize pages based on age group.
 * 
 * @author khim.ung
 *
 */
public enum GroupType {
	ADULT, TEEN, CHILDREN, ELDERLY;
	public String getLabel() {
		return this.name();
	}

	public String getValue() {
		return this.toString();
	}

}
