package com.shop.utils;

public class LIKE implements Filter {
	private final static String filter = "=";

	private StringBuilder hql = new StringBuilder();

	public LIKE(String parameterName, String field, Object fieldValue) {
		if (fieldValue != null) {
			hql.append(field);
			hql.append(" ");
			hql.append(LIKE.filter);
			hql.append(" ");
			hql.append(parameterName);
		}
	}

	public boolean has() {
		return hql.length() > 0 ? true : false;
	}

	public String get() {
		return hql.toString();
	}

}
