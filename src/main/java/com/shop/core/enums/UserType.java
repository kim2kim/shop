package com.shop.core.enums;


public enum UserType {

	MERCHANT, USER, ADS, INSTITUTION, BUSINESS_SERVICE, SLEEKSWAP;

	public String getLabel() {
		return this.name();
	}

	public String getValue() {
		return this.toString();
	}

}
