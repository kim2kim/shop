package com.shop.core.enums;

public enum Authority {
	ROLE_BUSINESS, ROLE_MERCHANT, ROLE_USER, ROLE_ADMIN, IS_AUTHENTICATED_REMEMBERED;

	public String getLabel() {
		return this.toString();
	}

	public String getValue() {
		return this.toString();
	}

}