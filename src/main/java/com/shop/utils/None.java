package com.shop.utils;

public class None implements Filter {

	private String hql;

	public None(String hql) {
		this.hql = hql;
	}

	public boolean has() {
		return hql.length() > 0 ? true : false;
	}

	public String get() {
		return hql;
	}

}
