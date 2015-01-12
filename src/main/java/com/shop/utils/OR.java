package com.shop.utils;

import org.apache.commons.lang.StringUtils;

public class OR implements Join {
	private final static String joiner = "OR";
	private boolean notEmpty = false;

	private Filter[] hql;

	public OR(Filter... hql) {
		this.hql = hql;
	}

	public String join() {
		StringBuilder sb = new StringBuilder();
		boolean isFirst = true;
		for (Filter h : hql) {
			if (h.has()) {
				if (!isFirst) {
					sb.append(" ");
					sb.append(OR.joiner);
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
