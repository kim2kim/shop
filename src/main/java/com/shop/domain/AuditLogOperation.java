package com.shop.domain;

public enum AuditLogOperation {
	insert(1921L), // preserve old attribute values
	update(1923L), // preserve old attribute values
	delete(1920L), // preserve old attribute values
	load(1922L); // preserve old attribute values

	private long val;

	AuditLogOperation(long val) {
		this.val = val;
	}

	public long val() {
		return val;
	}

	static public AuditLogOperation get(long val) {
		if (val == load.val)
			return load;
		if (val == update.val)
			return update;
		if (val == insert.val)
			return insert;
		if (val == delete.val)
			return delete;
		return null;
	}
}
