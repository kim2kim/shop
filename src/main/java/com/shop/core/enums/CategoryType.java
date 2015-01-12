package com.shop.core.enums;

public enum CategoryType {
	RECOMMEND("red"), WANT("green"), BOUGHT("blue"), ADVICE("yellow"), SELLING(
			"orange"), SERVICE("purple"), POINT("brown");

	private String color;

	private CategoryType(String color) {
		this.color = color;
	}

	public String getColor() {
		return color;
	}

	public String getLabel() {
		return this.name();
	}

	public String getValue() {
		return this.toString();
	}

}
