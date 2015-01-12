package com.shop.core.enums;

public enum Location {

	LIVING_ROOM("Living Room"), KITCHEN("Kitchen"), DINING_ROOM("Dining Room"), BATHROOM(
			"Bathroom"), BEDROOM("Bedroom"), GARAGE("Garage"), ATTIC("Attic"), FRONT_YARD(
			"Front Yard"), BACK_YARD("Back Yard"), POARCH("Poarch"), BALCONY(
			"Balcony"), HALLWAY("Hallway"), CLOSET("Closet"), CITY("City"), COUNTRY("Country");

	private String location;

	private Location(String location) {
		this.location = location;
	}
}
