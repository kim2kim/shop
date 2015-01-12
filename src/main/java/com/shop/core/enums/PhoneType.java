package com.shop.core.enums;


public enum PhoneType {

	HOME, WORK, CELL, PAYPAL, OTHER;

	public String getLabel() {
		return this.name();
	}

	public String getValue() {
		return this.toString();
	}

}
