package com.shop.domain;


public class ItemShippingDetail extends DomainObject {

	private ItemOrderDetail itemOrderDetail;
	private int shippingAmount;
	private int handlingAmount;

	public ItemOrderDetail getItemOrderDetail() {
		return itemOrderDetail;
	}

	public void setItemOrderDetail(ItemOrderDetail itemOrderDetail) {
		this.itemOrderDetail = itemOrderDetail;
	}

	public int getShippingAmount() {
		return shippingAmount;
	}

	public void setShippingAmount(int shippingAmount) {
		this.shippingAmount = shippingAmount;
	}

	public int getHandlingAmount() {
		return handlingAmount;
	}

	public void setHandlingAmount(int handlingAmount) {
		this.handlingAmount = handlingAmount;
	}

}
