package com.shop.domain;

import java.util.Date;
import java.util.GregorianCalendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name="request_friend")
public class RequestFriend extends DomainObject {

	@ManyToOne
	private Person requester;

	@ManyToOne
	private Person potentialFriend;

	@Column(name="confirm_friend")
	private boolean confirmFriend;

	@Column(name="reject_friend")
	private boolean rejectFriend;

	@Column(name="request_date")
	private Date requestDate;

	private boolean expired;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Person getRequester() {
		return requester;
	}

	public void setRequester(Person requester) {
		this.requester = requester;
	}

	public Person getPotentialFriend() {
		return potentialFriend;
	}

	public void setPotentialFriend(Person potentialFriend) {
		this.potentialFriend = potentialFriend;
	}

	public Date getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}

	public boolean isExpired() {
		return expired;
	}

	public void setExpired(boolean expired) {
		this.expired = expired;
	}

	public boolean isConfirmFriend() {
		return confirmFriend;
	}

	public void setConfirmFriend(boolean confirmFriend) {
		this.confirmFriend = confirmFriend;
	}

	public boolean isRejectFriend() {
		return rejectFriend;
	}

	public void setRejectFriend(boolean rejectFriend) {
		this.rejectFriend = rejectFriend;
	}

	// move into the query
	public void checkExpired() {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTimeInMillis(requestDate.getTime());
		calendar.add(GregorianCalendar.DAY_OF_MONTH, 5);
		Date expiredDate = calendar.getTime();
		
		Date today = new Date();
		
		
		if (expiredDate.before(today)) {
			expired = true;
		} else {
			expired = false;
		}
	}
}
