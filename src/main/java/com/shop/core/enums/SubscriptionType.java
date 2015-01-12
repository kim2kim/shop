package com.shop.core.enums;

public enum SubscriptionType {

	// Services are cheaper than selling
	// both service and selling will have additional % charge
	// This is the max # of service or selling products you can have per subscription.
	// There is no restriction on the # of transactions per account
	DEFAULT("None", 0, (float)0.00), STANDARD("Standard Package", 1, (float)1.0),  ENHANCED("Enhanced Package", 10, (float)10.0), PREMIUM("Premium Package", 50, (float)50.0), PARTNERS("Partner Package", 1000, (float)1000.00);

	private int max;
	private float price;
	private String itemName;

	SubscriptionType(String itemName, int max, float price) {
		this.itemName = itemName;
		this.max = max;
		this.price = price;
	}

	public int getMax() {
		return max;
	}
	
	public float getPrice(){
		return price;
	}

	public String getLabel() {
		return this.getItemName() + " $" + this.getPrice();
	}

	public String getValue() {
		return this.toString();
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public void setPrice(float price) {
		this.price = price;
	}

}
