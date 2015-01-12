package com.shop.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.shop.core.exception.SleekSwapDBException;

//import com.myshopnshare.core.audit.AuditLogException;

@Entity
@Table(name = "audit_log")
public class AuditLog extends DomainObject implements Comparable<AuditLog> {

	private String username;
	private Date timeStamp;
	private long action;
	private String clazz;
	private Long recordId;
	private HashSet<String> updatedFieldSet;
	private String preUpdateSerializedObject;

	@Basic
	@Column(nullable = false)
	public long getAction() {
		return action;
	}

	@Transient
	public AuditLogOperation getOperation() {
		return AuditLogOperation.get(getAction());
	}

	public void setAction(long action) {
		this.action = action;
	}

	public void setAction(AuditLogOperation action) {
		this.action = action.val();
	}

	public String getClazz() {
		return clazz;
	}

	public void setClazz(String clazz) {
		this.clazz = clazz;
	}

	public Long getRecordId() {
		return recordId;
	}

	public void setRecordId(Long recordId) {
		this.recordId = recordId;
	}

	public void setRecordId(Serializable id) {
		if (id instanceof Long) {
			this.recordId = (Long) id;
		} else {
			throw new SleekSwapDBException("Not really a DB Exception.  object of class " + clazz
					+ " uses a non-Long id");
		}
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUpdatedFields() {
		if (null == updatedFieldSet || updatedFieldSet.isEmpty())
			return null;
		StringBuffer sb = new StringBuffer();
		sb.append(", "); // start and end with ", " so we can search the fields
		// (see dao.search())
		for (String fld : updatedFieldSet) {
			sb.append(fld).append(", ");
		}
		return sb.toString();
	}

	public void setUpdatedFields(String updatedFields) {
		if (null == updatedFields || updatedFields.trim().equals("")) {
			updatedFieldSet = null;
			return;
		}
		if (null == updatedFieldSet)
			updatedFieldSet = new HashSet<String>();
		String[] flds = updatedFields.split(", ");
		for (int i = 0; i < flds.length; ++i) {
			String fld = flds[i].trim();
			if (!fld.equals("")) {
				updatedFieldSet.add(fld);
			}
		}
	}

	/**
	 * transient
	 */
	@Transient
	public HashSet<String> getUpdatedFieldSet() {
		return updatedFieldSet;
	}

	public void setUpdatedFieldSet(HashSet<String> updatedFieldSet) {
		this.updatedFieldSet = updatedFieldSet;
	}

	/**
	 * transient
	 */
	@Transient
	public String getPreUpdateSerializedObject() {
		return preUpdateSerializedObject;
	}

	public void setPreUpdateSerializedObject(String preUpdateSerializedObject) {
		this.preUpdateSerializedObject = preUpdateSerializedObject;
	}

	public String toString() {
		StringBuilder str = new StringBuilder();

		str.append(clazz);
		if (getOperation() != null) {
			str.append(' ');
			str.append(getOperation().name());
		}

		str.append("; id=");
		str.append(recordId);

		return str.toString();
	}

	// todo: Please implement compareTo method
	public int compareTo(AuditLog o) {
		return 0;
	}
}
