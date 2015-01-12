package com.shop.utils;

import org.apache.commons.lang.StringUtils;

public class AND implements Join {

	private final static String joiner = "AND";

	private boolean notEmpty = false;

	private Filter[] hql;

	public AND(Filter... hql) {
		this.hql = hql;
	}

	public String join() {
		StringBuilder sb = new StringBuilder();
		boolean isFirst = true;
		for (Filter h : hql) {
			if (h.has()) {
				if (!isFirst) {
					sb.append(" ");
					sb.append(AND.joiner);
				}
				sb.append(" ");
				sb.append(h.get());
				isFirst = false;
				notEmpty = true;
			}
		}
		if (StringUtils.trimToNull(sb.toString()) == null) {
			return "";
		}
		return sb.toString();
	}

	public boolean isNotEmpty() {
		return notEmpty;
	}

}
