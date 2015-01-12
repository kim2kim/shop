package com.shop.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.shop.core.enums.CartStatus;

/**
 * Expire all previous shopping carts upon log in to allow users to keep their
 * shopping carts while they are logged in
 * 
 * @author khim.ung
 * 
 */
@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name="shopping_cart")
public class ShoppingCart extends DomainObject {

	@OneToMany(mappedBy = "shoppingCart", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<CartItem> cartItems = new ArrayList<CartItem>();

	@OneToMany(mappedBy = "shoppingCart", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<RewardCart> rewardsItems = new ArrayList<RewardCart>();

	@OneToOne
	private Person person;

	public List<CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	public List<RewardCart> getRewardsItems() {
		return rewardsItems;
	}

	public void setRewardsItems(List<RewardCart> rewardsItems) {
		this.rewardsItems = rewardsItems;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public void addItemToCart(VendorItem item) {
		for (CartItem q : cartItems) {
			if (q.getItem().equals(item)) {
				q.increment();
				return;
			}
		}

		CartItem cartItem = new CartItem();
		cartItem.setItem(item);
		cartItem.setQuantity(1);
		cartItem.setPerson(person);
		cartItem.setShoppingCart(person.getShoppingCart());
		cartItem.setStatus(CartStatus.ADDED);
		this.getCartItems().add(cartItem);
	}

	public void addItemToCart(PointItem item) {
		for (RewardCart q : this.rewardsItems) {
			if (q.getItem().equals(item)) {
				q.increment();
				return;
			}
		}

		RewardCart cartItem = new RewardCart();
		cartItem.setItem(item);
		cartItem.setQuantity(1);
		cartItem.setPerson(person);
		cartItem.setShoppingCart(person.getShoppingCart());
		cartItem.setStatus(CartStatus.ADDED);
		this.getRewardsItems().add(cartItem);
	}

	@Transient
	public int getCartSize() {
		int total = 0;
		for (CartItem i : this.getCartItems()) {
			total = total + i.getQuantity();
		}
		for (RewardCart i : this.getRewardsItems()) {
			total = total + i.getQuantity();
		}
		return total;
	}

	/*
	 * @Transient public int getTaxTotal(){ int total = 0; for(CartItem q :
	 * cartItems){ total = total + q.getTaxTotal(); } return total; }
	 */

	@Transient
	public float getPriceTotal() {
		float total = 0;
		for (CartItem q : cartItems) {
			total = total + q.getPriceTotal();
		}
		return total;
	}

	@Transient
	public float getShippingTotal() {
		float total = 0;
		for (CartItem q : cartItems) {
			total = total + q.getShippingTotal();
		}
		return total;
	}

	@Transient
	public float getGrandTotal() {
		float total = 0;
		for (CartItem q : cartItems) {
			total = total + q.getTotal();
		}
		return total;
	}

	public CartItem findCartItem(Long cartItemId) {
		for (CartItem c : this.cartItems) {
			if (c.getId().equals(cartItemId)) {
				return c;
			}
		}
		return null;
	}

	@Transient
	public int getQuantityTotalFor(Item item) {
		int total = 0;
		for (CartItem q : cartItems) {
			if (q.getItem().getId().equals(item.getId())) {
				return q.getQuantity();
			}
		}
		return total;
	}

	@Transient
	public int getRemainingQuantityFor(int desiredQuantity, int total, Item item) {
		int remainingQuantity = total - this.getQuantityTotalFor(item);
		if(desiredQuantity >  remainingQuantity){
			return remainingQuantity;
		}
		return desiredQuantity;
	}

	
	/** REWARDS STUFF **/
	@Transient
	public float getRewardPriceTotal() {
		float total = 0;
		for (RewardCart q : rewardsItems) {
			total = total + q.getPriceTotal();
		}
		return total;
	}

	@Transient
	public int getRewardQuantityTotalFor(Item item) {
		int total = 0;
		for (RewardCart q : rewardsItems) {
			if (q.getItem().getId().equals(item.getId())) {
				return q.getQuantity();
			}
		}
		return total;
	}

	@Transient
	public int getRewardRemainingQuantityFor(int desiredQuantity, int total, Item item) {
		int remainingQuantity = total - this.getRewardQuantityTotalFor(item);
		if(desiredQuantity >  remainingQuantity){
			return remainingQuantity;
		}
		return desiredQuantity;
	}
	
	@Transient
	public float getRewardPriceTotalFor(Item item) {
		float total = 0;
		for (RewardCart q : rewardsItems) {
			if (q.getItem().getId().equals(item.getId())) {
				total = total + q.getPriceTotal();
			}
		}
		return total;
	}

	@Transient
	public float getRewardShippingTotal() {
		float total = 0;
		for (RewardCart q : rewardsItems) {
			total = total + q.getShippingTotal();
		}
		return total;
	}

	@Transient
	public float getRewardGrandTotal() {
		float total = 0;
		for (RewardCart q : rewardsItems) {
			total = total + q.getTotal();
		}
		return total;
	}

	public RewardCart findRewardItem(Long rewardItemId) {
		for (RewardCart c : this.rewardsItems) {
			if (c.getId().equals(rewardItemId)) {
				return c;
			}
		}
		return null;
	}

}
