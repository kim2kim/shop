package com.shop.domain;

import java.util.ArrayList;
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

/**
 * This is like facebook's wall.
 */
@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name="journal")
public class Journal extends DomainObject {

	@ManyToOne
	private Person person;

	@Column(length = 1000)
	private String entry;

	@OneToMany(mappedBy = "journal", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<JournalTag> tags= new ArrayList<JournalTag>();

	@OneToMany(mappedBy = "journal", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<JournalVisibility> journalVisibilities = new ArrayList<JournalVisibility>();

	private String category;

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public String getEntry() {
		return entry;
	}

	public void setEntry(String entry) {
		this.entry = entry;
	}

	public List<JournalTag> getTags() {
		return tags;
	}

	public void setTags(List<JournalTag> tags) {
		this.tags = tags;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public List<JournalVisibility> getJournalVisibilities() {
		return journalVisibilities;
	}

	public void setJournalVisibilities(List<JournalVisibility> journalVisibilities) {
		this.journalVisibilities = journalVisibilities;
	}

}
