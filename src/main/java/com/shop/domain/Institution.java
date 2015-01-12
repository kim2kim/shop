package com.shop.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.shop.core.enums.InstitutionType;

@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name="institution")
public class Institution extends Person {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name="institution_type")
	private InstitutionType institutionType;
	
	@Column(name="institution_name")
	private String institutionName;

	@Column(name="school_district")
	private String schoolDistrict;

	private String mascot;

	@Column(length = 255)
	private String description;

	@OneToMany(mappedBy = "institution", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Education> educations = new ArrayList<Education>();

	public InstitutionType getInstitutionType() {
		return institutionType;
	}

	public void setInstitutionType(InstitutionType institutionType) {
		this.institutionType = institutionType;
	}

	public List<Education> getEducations() {
		return educations;
	}

	public void setEducations(List<Education> educations) {
		this.educations = educations;
	}

	public String getInstitutionName() {
		return institutionName;
	}

	public void setInstitutionName(String institutionName) {
		this.institutionName = institutionName;
	}

	public String getSchoolDistrict() {
		return schoolDistrict;
	}

	public void setSchoolDistrict(String schoolDistrict) {
		this.schoolDistrict = schoolDistrict;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMascot() {
		return mascot;
	}

	public void setMascot(String mascot) {
		this.mascot = mascot;
	}

	@Transient
	public String identifier() {
		return this.getInstitutionName() + "-" + this.getInstitutionType()
				+ "-" + this.getId();
	}
	
	@Transient
	public String getFullName() {
		return this.institutionName;
	}

	@Transient
	@Override
	public String getAlias(){
		return this.institutionName;
	}
}
