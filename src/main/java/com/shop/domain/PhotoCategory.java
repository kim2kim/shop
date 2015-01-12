package com.shop.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.shop.core.enums.CategoryType;

/**
 * Category represents recommend, want, own, and opinion/advice. In the future,
 * we can add more categories as necessary.
 */
@Entity
@Table(name = "photo_category")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class PhotoCategory extends DomainObject {

	/**
	 * Every image will fall into one of these categories. A photo can be in
	 * more than one category. Not sure if this is supported.
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	private Photo photo;

	/**
	 * Recommend, want, own, sell, opinion
	 */
	@Enumerated(EnumType.STRING)
	private CategoryType type;

	/**
	 * Each photo category is mapped to multiple item category.  Item
	 * category is the association table to represent photcategory to items
	 */
	//@OrderBy("enteredDate")
	//@OneToMany(mappedBy="category", fetch = FetchType.LAZY)
	//private List<ItemCategory> itemCategories;

	public Photo getPhoto() {
		return photo;
	}

	public void setPhoto(Photo photo) {
		this.photo = photo;
	}

	public CategoryType getCategory() {
		return type;
	}

	public void setCategory(CategoryType category) {
		this.type = category;
	}

	public CategoryType getType() {
		return type;
	}

	public void setType(CategoryType type) {
		this.type = type;
	}
/*
	public List<ItemCategory> getItemCategories() {
		return itemCategories;
	}

	public void setItemCategories(List<ItemCategory> itemCategories) {
		this.itemCategories = itemCategories;
	}
*/
}
