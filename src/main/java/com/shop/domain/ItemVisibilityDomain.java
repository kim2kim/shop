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
@Table(name="item_visibility_domain")
public class ItemVisibilityDomain extends DomainObject {
	
	public ItemVisibilityDomain(Item item, VisibilityDomain vd){
		super();
		this.item = item;
		this.visibilityDomain = vd;
	}

	@ManyToOne
	private Item item;

	@ManyToOne
	private VisibilityDomain visibilityDomain;

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public VisibilityDomain getVisibilityDomain() {
		return visibilityDomain;
	}

	public void setVisibilityDomain(VisibilityDomain visibilityDomain) {
		this.visibilityDomain = visibilityDomain;
	}

}
