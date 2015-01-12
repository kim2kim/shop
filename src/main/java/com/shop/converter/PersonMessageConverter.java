package com.shop.converter;

import org.apache.commons.lang.StringUtils;

import com.shop.domain.Person;

public class PersonMessageConverter extends AbstractBaseConverter implements MessageConverter{

	public String converter(String template, Object ... objects){
		Person person = (Person) objects[0];
		String update = (String) objects[1];

		String message = StringUtils.replace(template, "{1}", person.getAlias());
		message = StringUtils.replace(message, "{2}", update);
		
		StringBuilder sb = new StringBuilder();

		personhtml(sb, person, message);		
		longmsghtml(sb, message);
		return sb.toString();
	}

	
}
