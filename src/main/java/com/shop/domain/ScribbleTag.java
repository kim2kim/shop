package com.shop.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name="scribble_tag")
public class ScribbleTag extends DomainObject {

	@ManyToOne
	private Scribble scribble;

	private String tag;

	public Scribble getScribble() {
		return scribble;
	}

	public void setScribble(Scribble scribble) {
		this.scribble = scribble;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

}
