package com.shop.core.enums;

import java.util.HashMap;
import java.util.Map;

public enum EmailDomain {

	YAHOO, GMAIL, HOTMAIL, SBCGLOBAL, AOL, OTHER;

	private final static Map<String, EmailDomain> map = new HashMap<String, EmailDomain>();
	static {
		map.put("YAHOO", EmailDomain.YAHOO);
		map.put("GMAIL", EmailDomain.GMAIL);
		map.put("HOTMAIL", EmailDomain.HOTMAIL);
		map.put("SBCGLOBAL", EmailDomain.SBCGLOBAL);
		map.put("AOL", EmailDomain.AOL);
		map.put("OTHER", EmailDomain.OTHER);
	}

	private String domain;

	private EmailDomain() {
		this.domain = this.name();
	}

	public static EmailDomain get(String domain) {
		return map.get(domain.toUpperCase());
	}

	public String getLabel() {
		return this.toString();
	}

	public String getValue() {
		return this.name();
	}

}
