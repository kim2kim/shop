package com.shop.converter;

import org.apache.commons.lang.StringUtils;

import com.shop.domain.Person;

public class PersonPersonConverter extends AbstractBaseConverter implements MessageConverter{

	public String converter(String template, Object ... objects){
		Person person1 = (Person) objects[0];
		Person person2 = (Person) objects[1];

		String message = StringUtils.replace(template, "{1}", person1.getAlias());
		message = StringUtils.replace(message, "{2}", person2.getAlias());

		StringBuilder sb = new StringBuilder();

		personhtml(sb, person1, message);
		longmsghtml(sb, message);
		personhtml(sb, person2, message);
		sb.append("<div style=\"clear:both;\"></div>");
		
		return sb.toString();
	}

}
