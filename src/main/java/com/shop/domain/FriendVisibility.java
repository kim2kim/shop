package com.shop.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name="friend_visibility")
public class FriendVisibility extends DomainObject {

	@ManyToOne
	private Friend friend;

	@ManyToOne
	private VisibilityDomain visibilityDomain;

	public FriendVisibility(){}
	
	public FriendVisibility(Friend friend, VisibilityDomain vd){
		this.friend = friend;
		this.visibilityDomain = vd;
	}
	
	public Friend getFriend() {
		return friend;
	}

	public void setFriend(Friend friend) {
		this.friend = friend;
	}

	public VisibilityDomain getVisibilityDomain() {
		return visibilityDomain;
	}

	public void setVisibilityDomain(VisibilityDomain visibilityDomain) {
		this.visibilityDomain = visibilityDomain;
	}

}
