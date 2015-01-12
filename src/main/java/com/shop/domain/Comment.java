package com.shop.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.shop.core.enums.SecurityLevel;

/**
 * Comment applies to comments made on items.
 * 
 * @author khim.ung
 * 
 */
@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name="comment")
public class Comment extends DomainObject {

	@ManyToOne
	private Item item;

	/**
	 * The person who entered the comment on the image.
	 */
	@ManyToOne
	private Person commenter;

	/**
	 * Security level determines whether this comment should be private or
	 * public
	 */
	@Enumerated(EnumType.STRING)
	private SecurityLevel securityLevel;

	@Column(length = 1000)
	private String message;
	
	/*********************************/

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Person getCommenter() {
		return commenter;
	}

	public void setCommenter(Person commenter) {
		this.commenter = commenter;
	}

	public SecurityLevel getSecurityLevel() {
		return securityLevel;
	}

	public void setSecurityLevel(SecurityLevel securityLevel) {
		this.securityLevel = securityLevel;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
