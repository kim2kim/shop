package com.shop.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name="journal_visibility")
public class JournalVisibility extends DomainObject {

	@ManyToOne
	private Journal journal;

	@ManyToOne
	private VisibilityDomain visibilityDomain;

	public JournalVisibility(){
		
	}
	
	public JournalVisibility(Journal journal, VisibilityDomain vd){
		this.journal = journal;
		this.visibilityDomain = vd;
		
	}
	
	public Journal getJournal() {
		return journal;
	}

	public void setJournal(Journal journal) {
		this.journal = journal;
	}

	public VisibilityDomain getVisibilityDomain() {
		return visibilityDomain;
	}

	public void setVisibilityDomain(VisibilityDomain visibilityDomain) {
		this.visibilityDomain = visibilityDomain;
	}

}
