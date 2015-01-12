package com.shop.core.enums;


/**
 * This will be a table with the values, private, public, and custom(user defined privileges)
 * 
 * @author khim.ung
 *
 */
public enum VisibilityType{

	PRIVATE, PUBLIC, CUSTOM;

	public String getLabel() {
		return this.name();
	}

	public String getValue() {
		return this.toString();
	}

}
