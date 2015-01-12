package com.shop.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name="event_visibility")
public class EventVisibility extends DomainObject {

	@ManyToOne
	private Events event;

	@ManyToOne(cascade = CascadeType.PERSIST)
	private VisibilityDomain visibilityDomain;

	public EventVisibility(){}
	
	public EventVisibility(Events event, VisibilityDomain vd){
		this.event = event;
		this.visibilityDomain = vd;
	}
	
	public Events getEvent() {
		return event;
	}
	

	public void setEvent(Events event) {
		this.event = event;
	}

	public VisibilityDomain getVisibilityDomain() {
		return visibilityDomain;
	}

	public void setVisibilityDomain(VisibilityDomain visibilityDomain) {
		this.visibilityDomain = visibilityDomain;
	}

}
