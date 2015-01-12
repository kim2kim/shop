package com.shop.core.enums;

import java.util.HashMap;
import java.util.Map;

public enum SecurityLevel {
	PRIVATE, PUBLIC, FRIENDS;

	private final static Map<String, SecurityLevel> map = new HashMap<String, SecurityLevel>();
	static {
		map.put("PRIVATE", SecurityLevel.PRIVATE);
		map.put("PUBLIC", SecurityLevel.PUBLIC);
		map.put("FRIENDS", SecurityLevel.FRIENDS);
	}
	
	public static SecurityLevel get(String key){
		return map.get(key);
	}

	public String getLabel() {
		return this.toString();
	}

	public String getValue() {
		return this.name();
	}

}
