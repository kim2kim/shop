package com.shop.domain;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name="balance")
public class Balance extends DomainObject {

	@ManyToOne
	private Person person;
	
	@Column(name="start_date")
	private Date startDate;
	
	@Column(name="end_date")
	private Date endDate;
	
	private boolean paid;

	@OneToMany(mappedBy = "balance", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<LineItemDetail> lineItems = new ArrayList<LineItemDetail>();

	public Balance() {
	}

	public Balance(Person person) {
		Calendar cal = Calendar.getInstance();
		this.setPerson(person);
		this.startDate = cal.getTime();
		cal.add(Calendar.DATE, 30);
		this.endDate = cal.getTime();
		this.paid = false;
	}

	public List<LineItemDetail> getLineItems() {
		return lineItems;
	}

	public void setLineItems(List<LineItemDetail> lineItems) {
		this.lineItems = lineItems;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public boolean isPaid() {
		return paid;
	}

	public void setPaid(boolean paid) {
		this.paid = paid;
	}

	public Double getTotal() {
		double total = 0;
		for (LineItemDetail l : this.lineItems) {
			total += l.getAmount();
		}
		return total;
	}

}
