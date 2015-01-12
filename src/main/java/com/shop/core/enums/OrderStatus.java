package com.shop.core.enums;

public enum OrderStatus {

	PENDING_APPROVAL, APPROVED, SHIPPED, CLOSED, REQUEST_RETURN, RETURNED;
	
	public String getLabel() {
		return this.name();
	}

	public String getValue() {
		return this.toString();
	}

}
