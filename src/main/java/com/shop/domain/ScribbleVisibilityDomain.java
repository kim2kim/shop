package com.shop.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "scribble_visibility_domain")
public class ScribbleVisibilityDomain extends DomainObject {

	public ScribbleVisibilityDomain(Scribble scribble, VisibilityDomain visibility){
		this.scribble = scribble;
		this.visibilityDomain = visibility;
	}
	
	@ManyToOne
	private Scribble scribble;

	@ManyToOne
	private VisibilityDomain visibilityDomain;

	public Scribble getScribble() {
		return scribble;
	}

	public void setScribble(Scribble scribble) {
		this.scribble = scribble;
	}

	public VisibilityDomain getVisibilityDomain() {
		return visibilityDomain;
	}

	public void setVisibilityDomain(VisibilityDomain visibilityDomain) {
		this.visibilityDomain = visibilityDomain;
	}

}
