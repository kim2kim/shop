package com.shop.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * Identifies who is friends with who and what visibility are they in.
 * 
 * If we want to be ambitious, we can use this relationship table to decide how
 * the user wants to arrange their friend and so forth. A friend specific
 * setting. Maybe they want to view this particular friend in a special setting
 * for instance. Not sure where I am going with this.
 * 
 * @author khim.ung
 * 
 */
@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name="friend")
public class Friend extends DomainObject {

	@ManyToOne
	private Person friend;

	@ManyToOne
	private Person person;

	private String color;

	@OneToMany(mappedBy = "friend", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<FriendVisibility> friendVisibilities = new ArrayList<FriendVisibility>();

	public Friend() {
	}

	public Friend(Person person, Person friend) {
		this.setPerson(person);
		this.setFriend(friend);
	}

	public Person getFriend() {
		return friend;
	}

	public void setFriend(Person friend) {
		this.friend = friend;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public List<FriendVisibility> getFriendVisibilities() {
		return friendVisibilities;
	}

	public void setFriendVisibilities(List<FriendVisibility> friendVisibilities) {
		this.friendVisibilities = friendVisibilities;
	}

}
