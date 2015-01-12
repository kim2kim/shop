package com.shop.core.enums;

public enum InstitutionType {
	UNIVERSITY, CITY_COLLEGE, PRIVATE_COLLEGE, CAL_STATE_UNIVERSITY, HIGHSCHOOL, MIDDLESCHOOL, ELEMENTRY, ALTERNATIVE;
	
	public String getLabel() {
		return this.name();
	}

	public String getValue() {
		return this.toString();
	}
}
