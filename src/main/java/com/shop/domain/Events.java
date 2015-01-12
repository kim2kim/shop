package com.shop.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.shop.core.enums.VisibilityType;

@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name="events")
public class Events extends DomainObject {

	@OneToMany(mappedBy="event", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	// @JoinTable(name = "guest_person", joinColumns = @JoinColumn(name ="event_id"), inverseJoinColumns = @JoinColumn(name = "guest_id"))
	private List<GuestPerson> guests = new ArrayList<GuestPerson>();

	@OneToMany(mappedBy="event",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	// @JoinTable(name = "accept_person", joinColumns = @JoinColumn(name =
	// "event_id"), inverseJoinColumns = @JoinColumn(name = "accept_id"))
	private List<AcceptPerson> accept = new ArrayList<AcceptPerson>();

	@OneToMany(mappedBy="event",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	// @JoinTable(name = "decline_person", joinColumns = @JoinColumn(name =
	// "event_id"), inverseJoinColumns = @JoinColumn(name = "decline_id"))
	private List<DeclinePerson> decline = new ArrayList<DeclinePerson>();

	@OneToMany(mappedBy="event", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	// @JoinTable(name = "considering_person", joinColumns = @JoinColumn(name =
	// "event_id"), inverseJoinColumns = @JoinColumn(name = "considering_id"))
	private List<ConsideringPerson> considering = new ArrayList<ConsideringPerson>();
	
	@OneToMany(mappedBy="event", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<EventsComment> comments = new ArrayList<EventsComment>();

	private String title;

	private String host;

	private String location;

	@Column(name="start_time")
	private String startTime;

	@Column(name="end_time")
	private String endTime;

	@Column(length = 2000)
	private String description;

	@Column(name="start_date")
	private Date startDate;

	@Column(name="end_date")
	private Date endDate;

	/**
	 * Not sure why this is here.  It is not used anywhere.
	 */
	@Enumerated(EnumType.STRING)
	private VisibilityType listVisibility;

	@ManyToOne
	private Person person;

	@OneToMany(mappedBy = "event", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<EventTag> tags = new ArrayList<EventTag>();

	@OneToMany(mappedBy = "event", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<EventVisibility> eventVisibilities = new ArrayList<EventVisibility>();

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<GuestPerson> getGuests() {
		return guests;
	}

	public void setGuests(List<GuestPerson> guests) {
		this.guests = guests;
	}

	public List<AcceptPerson> getAccept() {
		return accept;
	}

	public void setAccept(List<AcceptPerson> accept) {
		this.accept = accept;
	}

	public List<DeclinePerson> getDecline() {
		return decline;
	}

	public void setDecline(List<DeclinePerson> decline) {
		this.decline = decline;
	}

	public List<ConsideringPerson> getConsidering() {
		return considering;
	}

	public void setConsidering(List<ConsideringPerson> considering) {
		this.considering = considering;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public List<EventTag> getTags() {
		return tags;
	}

	public void setTags(List<EventTag> tags) {
		this.tags = tags;
	}

	public VisibilityType getListVisibility() {
		return listVisibility;
	}

	public void setListVisibility(VisibilityType listVisibility) {
		this.listVisibility = listVisibility;
	}

	public List<EventVisibility> getEventVisibilities() {
		return eventVisibilities;
	}

	public void setEventVisibilities(List<EventVisibility> eventVisibilities) {
		this.eventVisibilities = eventVisibilities;
	}

	public List<EventsComment> getComments() {
		return comments;
	}

	public void setComments(List<EventsComment> comments) {
		this.comments = comments;
	}

	@Transient
	public List<Person> getGuestList() {
		List<Person> list = new ArrayList<Person>();
		for (GuestPerson gp : this.guests) {
			list.add(gp.getPerson());
		}
		for (AcceptPerson ap : this.accept) {
			list.add(ap.getPerson());
		}
		for (ConsideringPerson cp : this.considering) {
			list.add(cp.getPerson());
		}
		for (DeclinePerson dp : this.decline) {
			list.add(dp.getPerson());
		}
		return list;
	}

	@Transient
	public GuestPerson findGuestPerson(Person person) {
		for (GuestPerson gp : this.guests) {
			if (gp.getPerson().getId().equals(person.getId())) {
				return gp;
			}
		}
		return null;
	}

	@Transient
	public AcceptPerson findAcceptPerson(Person person) {
		for (AcceptPerson gp : this.accept) {
			if (gp.getPerson().getId().equals(person.getId())) {
				return gp;
			}
		}
		return null;
	}

	@Transient
	public DeclinePerson findDeclinePerson(Person person) {
		for (DeclinePerson gp : this.decline) {
			if (gp.getPerson().getId().equals(person.getId())) {
				return gp;
			}
		}
		return null;
	}

	@Transient
	public ConsideringPerson findConsideringPerson(Person person) {
		for (ConsideringPerson gp : this.considering) {
			if (gp.getPerson().getId().equals(person.getId())) {
				return gp;
			}
		}
		return null;
	}
	
	@Transient
	public EventsComment findComment(Long commentId) {
		for (EventsComment c : this.comments) {
			if (c.getId().equals(commentId)) {
				return c;
			}
		}
		return null;
	}

}
