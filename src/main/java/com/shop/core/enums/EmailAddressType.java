package com.shop.core.enums;

public enum EmailAddressType {
	WORK, PERSONAL, PAYPAL;
	
	public String getLabel() {
		return this.name();
	}

	public String getValue() {
		return this.toString();
	}

}
