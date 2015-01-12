package com.shop.core.enums;

public enum AddressType {

	HOME, WORK, BILLING, SHIPPING, BUSINESS, OTHER;

	private String type;

	private AddressType() {
		this.type = this.name();
	}

	public String getLabel() {
		return this.name();
	}

	public String getValue() {
		return this.toString();
	}

}
