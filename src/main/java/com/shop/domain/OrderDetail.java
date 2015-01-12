package com.shop.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.shop.core.enums.OrderStatus;

/**
 * Will use this to handle virtual order details.
 * 
 * @author khim.ung
 * 
 */
@Entity
@Table(name = "order_detail")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class OrderDetail extends DomainObject {

	// Merchant
	@ManyToOne
	private Person person;

	@OneToOne(cascade = CascadeType.ALL)
	private Payment payment;

	@ManyToOne(cascade = CascadeType.ALL)
	private Person buyer;
	
	@OneToMany(mappedBy = "orderDetail", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<ItemOrderDetail> itemOrders = new ArrayList<ItemOrderDetail>();

	@OneToMany(mappedBy = "orderDetail", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<PointItemOrderDetail> pointItemOrders = new ArrayList<PointItemOrderDetail>();

	public OrderDetail() {
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public List<ItemOrderDetail> getItemOrders() {
		return itemOrders;
	}

	public void setItemOrders(List<ItemOrderDetail> itemOrders) {
		this.itemOrders = itemOrders;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public List<PointItemOrderDetail> getPointItemOrders() {
		return pointItemOrders;
	}

	public void setPointItemOrders(List<PointItemOrderDetail> pointItemOrders) {
		this.pointItemOrders = pointItemOrders;
	}

	@Transient
	public List<ItemOrderDetail> getPending() {
		List<ItemOrderDetail> iods = new ArrayList<ItemOrderDetail>();
		for (ItemOrderDetail itemOrderDetail : this.itemOrders) {
			if (itemOrderDetail.getStatus() == OrderStatus.PENDING_APPROVAL) {
				iods.add(itemOrderDetail);
			}
		}
		return iods;
	}

	@Transient
	public List<ItemOrderDetail> getApproved() {
		List<ItemOrderDetail> iods = new ArrayList<ItemOrderDetail>();
		for (ItemOrderDetail itemOrderDetail : this.itemOrders) {
			if (itemOrderDetail.getStatus() == OrderStatus.APPROVED) {
				iods.add(itemOrderDetail);
			}
		}
		return iods;
	}

	@Transient
	public List<ItemOrderDetail> getCompleted() {
		List<ItemOrderDetail> iods = new ArrayList<ItemOrderDetail>();
		for (ItemOrderDetail itemOrderDetail : this.itemOrders) {
			if (itemOrderDetail.getStatus() == OrderStatus.CLOSED) {
				iods.add(itemOrderDetail);
			}
		}
		return iods;
	}

	@Transient
	public List<ItemOrderDetail> getShipped() {
		List<ItemOrderDetail> iods = new ArrayList<ItemOrderDetail>();
		for (ItemOrderDetail itemOrderDetail : this.itemOrders) {
			if (itemOrderDetail.getStatus() == OrderStatus.SHIPPED) {
				iods.add(itemOrderDetail);
			}
		}
		return iods;
	}

	@Transient
	public List<ItemOrderDetail> getReturned() {
		List<ItemOrderDetail> iods = new ArrayList<ItemOrderDetail>();
		for (ItemOrderDetail itemOrderDetail : this.itemOrders) {
			if (itemOrderDetail.getStatus() == OrderStatus.RETURNED) {
				iods.add(itemOrderDetail);
			}
		}
		return iods;
	}

	@Transient
	public List<ItemOrderDetail> getRequestReturn() {
		List<ItemOrderDetail> iods = new ArrayList<ItemOrderDetail>();
		for (ItemOrderDetail itemOrderDetail : this.itemOrders) {
			if (itemOrderDetail.getStatus() == OrderStatus.REQUEST_RETURN) {
				iods.add(itemOrderDetail);
			}
		}
		return iods;
	}

	public Person getBuyer() {
		return buyer;
	}

	public void setBuyer(Person buyer) {
		this.buyer = buyer;
	}

}
