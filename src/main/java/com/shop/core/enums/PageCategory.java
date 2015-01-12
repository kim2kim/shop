package com.shop.core.enums;

public enum PageCategory {

	ME, HOUSE, TOWN, COUNTRY;

	private String pageCategory;

	private PageCategory() {
		this.pageCategory = this.name();
	}

	public String getLabel() {
		return this.name();
	}

	public void setLabel() {

	}

	public String getValue() {
		return this.toString();
	}

}
