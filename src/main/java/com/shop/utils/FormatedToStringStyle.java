package com.shop.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.SystemUtils;
import org.apache.commons.lang.builder.ToStringStyle;

public class FormatedToStringStyle extends ToStringStyle {
	public static final FormatedToStringStyle FORMATED_TO_STRING_STYLE = new FormatedToStringStyle();

	private FormatedToStringStyle() {
		super();
		this.setUseClassName(false);
		this.setUseIdentityHashCode(false);
		this.setUseFieldNames(true);
		this.setFieldSeparator(SystemUtils.LINE_SEPARATOR + " ");
		this.setFieldSeparatorAtStart(true);
		this.setContentStart("{");
		this.setContentEnd("}");
	}

	protected void appendDetail(StringBuffer buffer, String fieldName,
			Object value) {
		if (value instanceof Date) {
			value = new SimpleDateFormat("MM/dd/yyyy").format(value);
		}
		buffer.append(value);
	}

}
