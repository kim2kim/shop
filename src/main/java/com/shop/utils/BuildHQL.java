package com.shop.utils;

public class BuildHQL {

	private String clause;

	public BuildHQL(String clause) {
		this.clause = clause;
	}

	public String build(Join left, Join right) {
		StringBuffer sb = new StringBuffer();
		sb.append(left.join());
		if (left.isNotEmpty()) {
			sb.append(" ");
			sb.append(clause);
			sb.append(" ");
		}
		sb.append(right.join());
		if (sb.length() > 0) {
			return " WHERE " + sb.toString();
		}
		return "";
	}

	public static String build(Join left) {
		StringBuffer sb = new StringBuffer();
		sb.append(left.join());
		if (sb.length() > 0) {
			return " WHERE " + sb.toString();
		}
		return "";
	}

}
