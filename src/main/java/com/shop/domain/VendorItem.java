package com.shop.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * Defines the vendor specific fields for the item
 */
@Entity
@Table(name = "vendor_item")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class VendorItem extends Item {

	@Column(name="clearance_percentage")
	private Integer clearancePercentage;

	@Column(name="rebate_amount")
	private Integer rebateAmount;

	private boolean refuberish = false;

	private boolean used = false;
	
	private Integer quantity = 0;

	private Float price;

	@Column(name = "serial_number")
	private String serialNumber;

	private Float tax;

	private Float shipping;

	@Column(name="redeemable_points")
	private Integer reedemablePoints = 0;
	
	private String manufacturer;

	public VendorItem() {
	}
	
	public VendorItem(Long id) {
		this.setId(id);
	}
	public VendorItem(Photo icon, Photo thumb, Photo glimpse) {
		super(icon, thumb, glimpse);
	}

	public Integer getReedemablePoints() {
		return reedemablePoints;
	}

	public void setReedemablePoints(Integer reedemablePoints) {
		this.reedemablePoints = reedemablePoints;
	}


	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Float getTax() {
		return tax;
	}

	public void setTax(Float tax) {
		this.tax = tax;
	}

	public Float getShipping() {
		return shipping;
	}

	public void setShipping(Float shipping) {
		this.shipping = shipping;
	}

	public Integer getClearancePercentage() {
		return clearancePercentage;
	}

	public void setClearancePercentage(Integer clearancePercentage) {
		this.clearancePercentage = clearancePercentage;
	}

	public Integer getRebateAmount() {
		return rebateAmount;
	}

	public void setRebateAmount(Integer rebateAmount) {
		this.rebateAmount = rebateAmount;
	}

	public boolean isRefuberish() {
		return refuberish;
	}

	public void setRefuberish(boolean refuberish) {
		this.refuberish = refuberish;
	}

	public boolean isUsed() {
		return used;
	}

	public void setUsed(boolean used) {
		this.used = used;
	}
	
	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	@Transient
	public void decrementQuantity(){
		this.quantity --;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime
				* result
				+ ((clearancePercentage == null) ? 0 : clearancePercentage
						.hashCode());
		result = prime * result
				+ ((manufacturer == null) ? 0 : manufacturer.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result
				+ ((quantity == null) ? 0 : quantity.hashCode());
		result = prime * result
				+ ((rebateAmount == null) ? 0 : rebateAmount.hashCode());
		result = prime
				* result
				+ ((reedemablePoints == null) ? 0 : reedemablePoints.hashCode());
		result = prime * result + (refuberish ? 1231 : 1237);
		result = prime * result
				+ ((serialNumber == null) ? 0 : serialNumber.hashCode());
		result = prime * result
				+ ((shipping == null) ? 0 : shipping.hashCode());
		result = prime * result + ((tax == null) ? 0 : tax.hashCode());
		result = prime * result + (used ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		VendorItem other = (VendorItem) obj;
		if (clearancePercentage == null) {
			if (other.clearancePercentage != null)
				return false;
		} else if (!clearancePercentage.equals(other.clearancePercentage))
			return false;
		if (manufacturer == null) {
			if (other.manufacturer != null)
				return false;
		} else if (!manufacturer.equals(other.manufacturer))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (quantity == null) {
			if (other.quantity != null)
				return false;
		} else if (!quantity.equals(other.quantity))
			return false;
		if (rebateAmount == null) {
			if (other.rebateAmount != null)
				return false;
		} else if (!rebateAmount.equals(other.rebateAmount))
			return false;
		if (reedemablePoints == null) {
			if (other.reedemablePoints != null)
				return false;
		} else if (!reedemablePoints.equals(other.reedemablePoints))
			return false;
		if (refuberish != other.refuberish)
			return false;
		if (serialNumber == null) {
			if (other.serialNumber != null)
				return false;
		} else if (!serialNumber.equals(other.serialNumber))
			return false;
		if (shipping == null) {
			if (other.shipping != null)
				return false;
		} else if (!shipping.equals(other.shipping))
			return false;
		if (tax == null) {
			if (other.tax != null)
				return false;
		} else if (!tax.equals(other.tax))
			return false;
		if (used != other.used)
			return false;
		return true;
	}

}
