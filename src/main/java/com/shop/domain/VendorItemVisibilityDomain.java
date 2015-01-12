package com.shop.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * The association table between item and visibility domain
 * 
 * @author khim.ung
 * 
 */
@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "vendor_item_visibility_domain")
public class VendorItemVisibilityDomain extends DomainObject {
	
	public VendorItemVisibilityDomain(VendorItem item, VisibilityDomain vd){
		super();
		this.item = item;
		this.visibilityDomain = vd;
	}

	@ManyToOne
	private VendorItem item;

	@ManyToOne
	private VisibilityDomain visibilityDomain;

	public VendorItem getItem() {
		return item;
	}

	public void setItem(VendorItem item) {
		this.item = item;
	}

	public VisibilityDomain getVisibilityDomain() {
		return visibilityDomain;
	}

	public void setVisibilityDomain(VisibilityDomain visibilityDomain) {
		this.visibilityDomain = visibilityDomain;
	}

}
