package com.shop.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.apache.commons.lang.StringUtils;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="profile")
public class Profile extends DomainObject {

	@OneToOne
	private Person person;

	@OneToMany(mappedBy = "profile", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Employment> employments = new ArrayList<Employment>();

	@OneToMany(mappedBy = "profile", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Education> educations = new ArrayList<Education>();

	private String aim;

	@Column(length = 500)
	private String expertise;

	private String language;

	@Column(length = 500)
	private String about;

	@Column(length = 500)
	private String activities;

	public String getExpertise() {
		return expertise;
	}

	public void setExpertise(String expertise) {
		this.expertise = expertise;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public String getActivities() {
		return activities;
	}

	public void setActivities(String activities) {
		this.activities = activities;
	}

	public List<Employment> getEmployments() {
		return employments;
	}

	public void setEmployments(List<Employment> employments) {
		this.employments = employments;
	}

	public List<Education> getEducations() {
		return educations;
	}

	public void setEducations(List<Education> educations) {
		this.educations = educations;
	}

	public String getAim() {
		return aim;
	}

	public void setAim(String aim) {
		this.aim = aim;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
	public Employment findEmployment(String employmentId){
		if(StringUtils.trimToNull(employmentId) != null){
			for(Employment e : this.employments){
				if(e.getId().equals(Long.parseLong(employmentId))){
					return e;
				}
			}
		}
		return null;
	}

	public Education findEducation(String educationId){
		if(StringUtils.trimToNull(educationId) != null){
			for(Education e : this.educations){
				if(e.getId().equals(Long.parseLong(educationId))){
					return e;
				}
			}
		}
		return null;
	}
	
	public List<Employment> getActiveEmployments(){
		List<Employment> list = new ArrayList<Employment>();
		for(Employment e : this.employments){
			if(e.isActive()){
				list.add(e);
			}
		}
		return list;
	}

	public List<Education> getActiveEducations(){
		List<Education> list = new ArrayList<Education>();
		for(Education e : this.educations){
			if(e.isActive()){
				list.add(e);
			}
		}
		return list;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((about == null) ? 0 : about.hashCode());
		result = prime * result
				+ ((activities == null) ? 0 : activities.hashCode());
		result = prime * result + ((aim == null) ? 0 : aim.hashCode());
		result = prime * result
				+ ((expertise == null) ? 0 : expertise.hashCode());
		result = prime * result
				+ ((language == null) ? 0 : language.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Profile other = (Profile) obj;
		if (about == null) {
			if (other.about != null)
				return false;
		} else if (!about.equals(other.about))
			return false;
		if (activities == null) {
			if (other.activities != null)
				return false;
		} else if (!activities.equals(other.activities))
			return false;
		if (aim == null) {
			if (other.aim != null)
				return false;
		} else if (!aim.equals(other.aim))
			return false;
		if (expertise == null) {
			if (other.expertise != null)
				return false;
		} else if (!expertise.equals(other.expertise))
			return false;
		if (language == null) {
			if (other.language != null)
				return false;
		} else if (!language.equals(other.language))
			return false;
		return true;
	}

}
