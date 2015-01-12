package com.shop.core.enums;

public enum EventStatusType {
	ACCEPT, DECLINE, CONSIDERING;
	
	public String getLabel() {
		return this.name();
	}

	public String getValue() {
		return this.toString();
	}

}
