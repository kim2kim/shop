package com.shop.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name="point_item")
public class PointItem extends Item {

	private Integer quantity = 0;

	private Float price;

	@Column(name = "serial_number")
	private String serialNumber;

	private Float tax;

	private Float shipping;

	@Column(name="redeemable_points")
	private Integer reedemablePoints = 0;

	public PointItem() {
	}

	public PointItem(Long id) {
		this.setId(id);
	}

	public PointItem(Photo icon, Photo thumb, Photo glimpse) {
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

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public void decrementQuantity() {
		this.quantity--;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result
				+ ((quantity == null) ? 0 : quantity.hashCode());
		result = prime
				* result
				+ ((reedemablePoints == null) ? 0 : reedemablePoints.hashCode());
		result = prime * result
				+ ((serialNumber == null) ? 0 : serialNumber.hashCode());
		result = prime * result
				+ ((shipping == null) ? 0 : shipping.hashCode());
		result = prime * result + ((tax == null) ? 0 : tax.hashCode());
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
		PointItem other = (PointItem) obj;
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
		if (reedemablePoints == null) {
			if (other.reedemablePoints != null)
				return false;
		} else if (!reedemablePoints.equals(other.reedemablePoints))
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
		return true;
	}

}
