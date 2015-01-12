package com.shop.core.enums;

public enum Category {

	HEAD, NECK, CHEST, ARM, HANDS, WAIST, LEGS, FEET, HOME, CAR;
	
	public String getLabel() {
		return this.name();
	}

	public String getValue() {
		return this.toString();
	}

}
