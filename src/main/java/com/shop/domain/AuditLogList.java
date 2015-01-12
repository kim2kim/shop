package com.shop.domain;

import java.util.Collections;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "audit_log_list")
public class AuditLogList extends DomainObject implements NonLogable {

	@OneToMany(cascade = CascadeType.ALL, targetEntity = com.shop.domain.AuditLog.class)
	@JoinColumn(name = "audit_log_list_id")
	// @IndexColumn(name = "logIndex")
	private List<AuditLog> logs;

	public List<AuditLog> getLogs() {
		return Collections.unmodifiableList(logs);
	}

	public void setLogs(List<AuditLog> logs) {
		this.logs = logs;
	}

	public void add(AuditLog auditLog) {
		logs.add(auditLog);
	}

	public void clear() {
		logs.clear();
	}
}
