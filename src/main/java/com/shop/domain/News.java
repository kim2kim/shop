package com.shop.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * 
 * @author khim.ung
 * 
 */
@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name="news")
public class News extends DomainObject {

	/*
	 * This is the person who performed the action. If the security level is set
	 * to private, they are the only person who can see the feed.
	 */
	@ManyToOne
	private Person person;
	
	private Boolean world;

	/**
	 * Use the template from the Action class to generate a message.
	 */
	@Column(length = 2000)
	private String message;
	
	@Enumerated(EnumType.STRING)
	private Action action;

	/**
	 * You can make comments on feeds.
	 */
	@OneToMany(mappedBy = "news", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<NewsComment> comments = new ArrayList<NewsComment>();

	@OneToMany(mappedBy = "news", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<NewsVisibilityDomain> newsVisibility = new ArrayList<NewsVisibilityDomain>();

	public Action getAction() {
		return action;
	}

	public void setAction(Action action) {
		this.action = action;
	}

	public List<NewsComment> getComments() {
		return comments;
	}

	public void setComments(List<NewsComment> comments) {
		this.comments = comments;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<NewsVisibilityDomain> getNewsVisibility() {
		return newsVisibility;
	}

	public void setNewsVisibility(List<NewsVisibilityDomain> newsVisibility) {
		this.newsVisibility = newsVisibility;
	}

	public Boolean isWorld() {
		return world;
	}

	public void setWorld(Boolean world) {
		this.world = world;
	}

}
