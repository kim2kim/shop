package com.shop.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.shop.core.enums.CartStatus;

@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name="reward_cart")
public class RewardCart extends DomainObject {

	@ManyToOne
	private PointItem item;

	@ManyToOne
	private ShoppingCart shoppingCart;
	
	@ManyToOne
	private Person person;

	private int quantity = 0;
	
	@Enumerated(EnumType.STRING)
	private CartStatus status;
	
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

	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}

	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public CartStatus getStatus() {
		return status;
	}

	public void setStatus(CartStatus status) {
		this.status = status;
	}

	public void increment() {
		this.quantity++;
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
	public float getPriceTotal() {
		float total = 0;
		for (int i = 0; i < quantity; i++) {
			total = total + item.getPrice();
		}
		return total;
	}

	@Transient
	public float getTotal() {
		return (this.getPriceTotal() * this.item.getTax())
				+ this.getShippingTotal();
	}

}
