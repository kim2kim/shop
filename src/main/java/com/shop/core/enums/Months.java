package com.shop.core.enums;


public enum Months {
	JANUARY("Jan"), FEBRUARY("Feb"), MARCH("Feb"), APRIL("Mar"), MAY("May"), JUNE("Jun"), JULY("Jul"), AUGUST("Aug"), SEPTEMBER("Sep"), OCTOBER("Oct"), NOVEMBER("Nov"), DECEMBER("Dec");
	
	private String shortName;
	
	private Months(String shortName){
		this.shortName = shortName;
	}
	
	public String getShortName(){
		return this.shortName;
	}
	
	public String getLabel() {
		return this.name();
	}

	public String getValue() {
		return this.toString();
	}

}
