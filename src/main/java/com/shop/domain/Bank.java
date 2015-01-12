package com.shop.domain;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import net.sourceforge.calendardate.CalendarDate;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * Used to store information on the user's virtual money and the accumulated
 * discount that they've earned. These discounts are subtracted from the total
 * discount as they are used. The amount of discount to apply to item is
 * determined by the owner of the item.
 * 
 * Since ever user has a bank account, the last time the user logged in is
 * stored with the bank table.
 * 
 * @author khim.ung
 * 
 */
@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name="bank")
public class Bank extends DomainObject {

	private Integer balance;
	private Integer discounts;
	private Integer points = 0;

	@Column(name="last_loggedin")
	private Date lastLoggedIn;

	@OneToOne
	@JoinColumn(name = "person_id")
	private Person person;

	/****************************************************/

	public Integer getBalance() {
		return balance;
	}

	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Integer getDiscounts() {
		return discounts;
	}

	public void setDiscounts(Integer discounts) {
		this.discounts = discounts;
	}

	public Date getLastLoggedIn() {
		return lastLoggedIn;
	}

	public void setLastLoggedIn(Date lastLoggedIn) {
		this.lastLoggedIn = lastLoggedIn;
	}

	@Transient
	public void updateBalance() {
		CalendarDate last = new CalendarDate(TimeZone.getDefault(), lastLoggedIn);
		CalendarDate today = new CalendarDate(TimeZone.getDefault());
		
		int daysSinceLastLoggedIn = last.daysUntil(today);
		
		if (daysSinceLastLoggedIn > 0) {
			balance = balance + 1 * daysSinceLastLoggedIn;
		}
	}

	public void updateBalance(Integer amount) {
		balance = balance + amount;
	}

	@Transient
	public boolean isRecentlyLoggedIn() {		
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTimeInMillis(lastLoggedIn.getTime());
		calendar.add(GregorianCalendar.DAY_OF_MONTH, 5);
		Date last = calendar.getTime();
		
		Date today = new Date();
		
		
		// No update will occur if you logged in today.
		return last.before(today);
	}

	@Transient
	public void updateLastLoggedIn() {
		lastLoggedIn = new Date(System.currentTimeMillis());
	}
}
