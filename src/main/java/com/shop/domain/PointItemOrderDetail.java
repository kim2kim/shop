package com.shop.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.shop.core.enums.OrderStatus;

/**
 * Only vendor items are purchasable with real money.
 */
@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name="point_item_order_detail")
public class PointItemOrderDetail extends DomainObject {

	/**
	 * Represents the single transaction/order that this item order is part of.
	 */
	@ManyToOne
	private OrderDetail orderDetail;

	@Enumerated(EnumType.STRING)
	private OrderStatus status;

	@ManyToOne
	private Person person;

	@Column(name="tracking_number")
	private String trackingNumber;

	/**
	 * What item this order detail represents
	 */
	@ManyToOne
	private PointItem item;

	/**
	 * The amount of item purchased.
	 */
	private int quantity;

	/**
	 * An invoice for the order
	 */
	private String invoice;

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public PointItem getItem() {
		return item;
	}

	public void setItem(PointItem item) {
		this.item = item;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getInvoice() {
		return invoice;
	}

	public void setInvoice(String invoice) {
		this.invoice = invoice;
	}

	public OrderDetail getOrderDetail() {
		return orderDetail;
	}

	public void setOrderDetail(OrderDetail orderDetail) {
		this.orderDetail = orderDetail;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Transient
	public float getShippingTotal() {
		float total = 0;
		for (int i = 0; i < quantity; i++) {
			total = total + item.getShipping();
		}
		return total;
	}

	@Transient
	public float getTaxTotal() {
		float total = 0;
		for (int i = 0; i < quantity; i++) {
			total = total + item.getTax();
		}
		return total;
	}

	@Transient
	public float getPriceTotal() {
		float total = 0;
		for (int i = 0; i < quantity; i++) {
			total = total + item.getPrice();
		}
		return total;
	}

	@Transient
	public float getTotal() {
		return (this.getPriceTotal() * (1 + item.getTax()))
				+ this.getShippingTotal();
	}

	public String getTrackingNumber() {
		return trackingNumber;
	}

	public void setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
	}

}
