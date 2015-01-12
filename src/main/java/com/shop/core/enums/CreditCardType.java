package com.shop.core.enums;


public enum CreditCardType {

	VISA, MASTER_CARD, DISCOVERY, AMERICAN_EXPRESS;

	public String getLabel() {
		return this.name();
	}

	public String getValue() {
		return this.toString();
	}

}
