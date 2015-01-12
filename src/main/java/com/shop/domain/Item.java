package com.shop.domain;

/**
 * @author khim.ung
 * @version
 */
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.shop.core.enums.AddressType;
import com.shop.core.enums.CategoryType;
import com.shop.core.enums.ItemType;
import com.shop.core.enums.VisibilityType;

/**
 * Item is information on the photo's that the users uploaded.
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name="item")
public class Item extends DomainObject {

	/*
	 * This is the person who uploaded this item.
	 */
	@ManyToOne
	private Person person;
	
	@Column(name="external_link")
	private String externalLink;
	
	@Column(name="resource_link")
	private String resourceLink;

	private Boolean subscribed;

	private String title;

	private String subtitle;
	
	private Integer visited = 0;
	
	@Column(name="yes_no")
	private Boolean yesNo;
	
	@OneToOne(mappedBy="item", cascade=CascadeType.ALL)
	private ItemRating itemRating;

	/**
	 * HTML text that the users define to decorates the description of the
	 * photo. We will be stripping out embedded links to other photos.
	 * 
	 */
	@Column(length = 500)
	private String description;

	@Column(name = "item_name")
	private String itemName;

	/**
	 * Identifies whether this image belongs to a vendor or a user
	 */
	@Enumerated(EnumType.STRING)
	private ItemType type;

	/**
	 * We are using fetch eager since we are applying the thumbnail to both text
	 * and image preferences
	 */
	@OneToOne(cascade = CascadeType.ALL)
	private Photo thumbnail;

	/**
	 * We are using fetch eager since we are applying the icon to both text and
	 * image preferences
	 */
	@OneToOne(cascade = CascadeType.ALL)
	private Photo icon;

	@OneToOne(cascade = CascadeType.ALL)
	private Photo glimpse;

	@OrderBy("enteredDate DESC")
	@OneToMany(mappedBy = "item", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<ItemTag> tags = new ArrayList<ItemTag>();

	@OrderBy("enteredDate DESC")
	@OneToMany(mappedBy = "item", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Comment> comments = new ArrayList<Comment>();

	@OneToMany(mappedBy = "item", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Commercial> commercials = new ArrayList<Commercial>();

	@OneToMany(mappedBy = "item", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<ItemVisibilityDomain> itemVisibilities = new ArrayList<ItemVisibilityDomain>();

	/**
	 * Maps the item to the photo category This item is either under want,
	 * recommend, opinion, or own
	 */
	@OrderBy("enteredDate")
	@OneToMany(mappedBy = "item", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<ItemCategory> itemCategories = new ArrayList<ItemCategory>();

	/***************************************************************/

	public Item() {
		super();
		this.setItemRating(new ItemRating(this));
		this.yesNo = true;
	}

	public Item(Photo icon, Photo thumb, Photo glimpse) {
		super();
		this.setItemRating(new ItemRating(this));
		this.setIcon(icon);
		this.setThumbnail(thumb);
		this.setGlimpse(glimpse);
	}

	public Boolean getYesNo() {
		return yesNo;
	}

	public void setYesNo(Boolean yesNo) {
		this.yesNo = yesNo;
	}

	public ItemRating getItemRating() {
		return itemRating;
	}

	public void setItemRating(ItemRating itemRating) {
		this.itemRating = itemRating;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public ItemType getType() {
		return type;
	}

	public void setType(ItemType type) {
		this.type = type;
	}

	public Photo getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(Photo thumbnail) {
		this.thumbnail = thumbnail;
	}

	public List<ItemTag> getTags() {
		return tags;
	}

	public void setTags(List<ItemTag> tags) {
		this.tags = tags;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public List<ItemCategory> getItemCategories() {
		return itemCategories;
	}

	public void setItemCategories(List<ItemCategory> itemCategories) {
		this.itemCategories = itemCategories;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Photo getIcon() {
		return icon;
	}

	public void setIcon(Photo icon) {
		this.icon = icon;
	}

	public Photo getGlimpse() {
		return glimpse;
	}

	public void setGlimpse(Photo glimpse) {
		this.glimpse = glimpse;
	}

	public List<Commercial> getCommercials() {
		return commercials;
	}

	public void setCommercials(List<Commercial> commercials) {
		this.commercials = commercials;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public Boolean getSubscribed() {
		return subscribed;
	}

	public void setSubscribed(Boolean subscribed) {
		this.subscribed = subscribed;
	}

	public List<ItemVisibilityDomain> getItemVisibilities() {
		return itemVisibilities;
	}

	public void setItemVisibilities(List<ItemVisibilityDomain> itemVisibilities) {
		this.itemVisibilities = itemVisibilities;
	}

	public String getExternalLink() {
		return externalLink;
	}

	public void setExternalLink(String externalLink) {
		this.externalLink = externalLink;
	}

	public Integer getVisited() {
		return visited;
	}

	public void setVisited(Integer visited) {
		this.visited = visited;
	}

	public String getResourceLink() {
		return resourceLink;
	}

	public void setResourceLink(String resourceLink) {
		this.resourceLink = resourceLink;
	}

	@Transient
	public boolean isProducts() {
		if (getType() == ItemType.VENDOR) {
			return true;
		}
		return false;
	}
	
	@Transient
	public boolean isRewards() {
		if (getType() == ItemType.POINT) {
			return true;
		}
		return false;
	}
	
	
	@Transient
	public boolean getIsSelling() {
		for (ItemCategory c : this.itemCategories) {
			if (c.getCategory() == CategoryType.SELLING
					|| c.getCategory() == CategoryType.SERVICE
					|| c.getCategory() == CategoryType.POINT) {
				return true;
			}
		}
		return false;
	}

	@Transient
	public boolean getIsService() {
		for (ItemCategory c : this.itemCategories) {
			if (c.getCategory() == CategoryType.SERVICE) {
				return true;
			}
		}
		return false;
	}

	@Transient
	public ItemCategory categoryFor(String category) {
		for (ItemCategory ic : this.itemCategories) {
			if (ic.getCategory() == CategoryType.valueOf(category)
					&& ic.getCategory() != CategoryType.RECOMMEND) {
				return ic;
			}
		}
		return null;
	}

	@Transient
	public boolean hasCategory(CategoryType category) {
		for (ItemCategory ic : itemCategories) {
			if (ic.getCategory() == category) {
				return true;
			}
		}
		return false;
	}
	
	@Transient
	public String getVendorName(){
		if(person instanceof Vendor || person instanceof Employer || person instanceof Institution){
			return person.getAlias();
		}else {
			return person.getFullName();
		}
	}

	public String getLocation(){
		for(Address a : person.getAddresses()){
			if(a.isActive() && a.getType() == AddressType.BUSINESS && a.getVisibility() == VisibilityType.PUBLIC){
				return a.getStreet1() + " " + a.getCity() + " " + a.getStateOrProvince() + " " + a.getPostalCode() + " " + a.getCountry();
			}
		}
		return "";
	}
	
	public void increment(){
		this.visited ++;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result
				+ ((itemName == null) ? 0 : itemName.hashCode());
		result = prime * result + ((person == null) ? 0 : person.hashCode());
		result = prime * result
				+ ((subscribed == null) ? 0 : subscribed.hashCode());
		result = prime * result
				+ ((subtitle == null) ? 0 : subtitle.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((visited == null) ? 0 : visited.hashCode());
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
		Item other = (Item) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (itemName == null) {
			if (other.itemName != null)
				return false;
		} else if (!itemName.equals(other.itemName))
			return false;
		if (person == null) {
			if (other.person != null)
				return false;
		} else if (!person.equals(other.person))
			return false;
		if (subscribed == null) {
			if (other.subscribed != null)
				return false;
		} else if (!subscribed.equals(other.subscribed))
			return false;
		if (subtitle == null) {
			if (other.subtitle != null)
				return false;
		} else if (!subtitle.equals(other.subtitle))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (visited == null) {
			if (other.visited != null)
				return false;
		} else if (!visited.equals(other.visited))
			return false;
		return true;
	}

}
