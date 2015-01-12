package com.shop.converter;

import org.apache.commons.lang.StringUtils;

import com.shop.domain.Person;

public class PersonIntegerConverter extends AbstractBaseConverter implements MessageConverter {

	public String converter(String template, Object... objects) {
		Person person = (Person) objects[0];
		Integer count = (Integer) objects[1];

		String message = StringUtils.replace(template, "{1}", "");
		message = StringUtils.replace(message, "{2}", "" + count);

		StringBuilder sb = new StringBuilder();
		personhtml(sb, person, message);
		longmsghtml(sb, message);
				
		return sb.toString();
	}

}
