package com.shop.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.log4j.Logger;

import com.shop.utils.FormatedToStringStyle;

@MappedSuperclass
public class DomainObject implements Serializable {

	private static final long serialVersionUID = 1L;

	private static Logger log = Logger.getLogger(DomainObject.class);
	
	private final static int max_violation = 5;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long id;

	private Long version;

	@Column(name="create_date")
	private Date enteredDate;

	/**
	 * Used to determine if content is inappropriate
	 */
	private Integer flags = 0;

	private boolean active = true;

	public DomainObject() {
		this.enteredDate = new Date(System.currentTimeMillis());
		this.active = true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Date getEnteredDate() {
		return enteredDate;
	}

	public void setEnteredDate(Date enteredDate) {
		this.enteredDate = enteredDate;
	}

	public Integer getFlags() {
		return flags;
	}

	public void setFlags(Integer flags) {
		this.flags = flags;
	}

	@Transient
	public String getTitle() {
		return this.getClass().getName() + ":" + getId();
	}

	public boolean equals(Object obj) {
		if (!(obj instanceof DomainObject)) {
			return false;
		}

		if ((getId() == null) || (((DomainObject) obj).getId() == null)) {
			return false;
		}

		return getId().equals(((DomainObject) obj).getId());
	}

	public int hashCode() {
		if (this.getId() == null) {
			return super.hashCode();
		}

		return this.getId().hashCode();
	}

	@Transient
	public void flagged(){
		this.flags ++;
	}
	
	@Transient
	public boolean violator(){
		if(this.flags >= this.max_violation){
			return true;
		}
		return false;
	}

	@Transient
	public String toJSONString() {
		return ToStringBuilder.reflectionToString(this,
				FormatedToStringStyle.FORMATED_TO_STRING_STYLE);
	}

}
