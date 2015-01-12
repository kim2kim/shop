package com.shop.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.shop.core.enums.CategoryType;


/**
 * Associate item to person
 * @author khimung
 *
 */
@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name="item_category")
public class ItemCategory extends DomainObject {

	@ManyToOne
	private Item item;
	
	/**
	 * The person who's photo category refers to.  If
	 * photoCategory is want, then this person wants the
	 * item.
	 * 
	 */
	@ManyToOne
	private Person person;
	
	@Enumerated(EnumType.STRING)
	private CategoryType category;

	private String description;

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public CategoryType getCategory() {
		return category;
	}

	public void setCategory(CategoryType category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}
