package com.shop.converter;

import org.apache.commons.lang.StringUtils;

import com.shop.domain.Item;
import com.shop.domain.Person;

public class PersonPersonItemConverter extends AbstractBaseConverter implements MessageConverter{

	public String converter(String template, Object ... objects){
		Person person1 = (Person) objects[0];
		Person person2 = (Person) objects[1];
		Item item = (Item) objects[2];
		
		String message = StringUtils.replace(template, "{1}", person1.getAlias());
		message = StringUtils.replace(message, "{2}", item.getItemName());
		message = StringUtils.replace(message, "{3}", person2.getAlias());
		
		StringBuilder sb = new StringBuilder();

		itemhtml(sb, item);
		personhtml(sb, person1, message);
		shortmsghtml(sb, message);
		personhtml(sb, person2, message);

		return sb.toString();
	}

}
