package com.shop.core.enums;


public enum Gender {

	FEMALE, MALE;

	private String gender;

	private Gender() {
		this.gender = this.name();
	}

	public String getLabel() {
		return this.name();
	}

	public String getValue() {
		return this.toString();
	}

}
