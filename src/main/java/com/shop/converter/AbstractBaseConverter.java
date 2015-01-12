package com.shop.converter;

import org.apache.commons.lang.StringUtils;

import com.shop.domain.Item;
import com.shop.domain.Person;

public class AbstractBaseConverter {

	protected void personhtml(StringBuilder sb, Person person, String message) {
		/**
		 * TODO
		 * 
		 * Cannot get the taglib to render properly after return from server.
		 * Client can't interpret <sns>
		 */
		/*
		sb.append(StringEscapeUtils.escapeHtml("<sns:persontemplate fullName='" + person.getFullName()
				+ "' friendId='" + person.getId() + "' glimpse='"
				+ person.getDefaultFace().getGlimpse().getPath() + "' icon='"
				+ person.getDefaultFace().getIcon().getPath() + "' message='"
				+ message + "' ></sns:persontemplate>"));
		System.out.println(sb.toString());
		*/

		  sb.append("<ul><li>");
		  sb.append("<img src=\"../");
		  sb.append(person.getDefaultFace().getIcon().getPath());
		  sb.append("\" alt=\"" + person.getFullName() + "\" title=\"" +
				  message + "\"/></a></li>");
		  
		  sb.append("<li><a style=\"clear: both; float: none;\" href=\"");
		  sb.append("friendPage.do?friendId=");
		  sb.append(person.getId()); sb.append("\">");
		  sb.append(person.getFullName()); sb.append("</a></li></ul>");
	
		
/*		
		  sb.append("<ul><li><a  style=\"clear: both; float: none;\" rel=\"prettyPhoto[news]\" href=\"../");
		  sb.append(person.getDefaultFace().getGlimpse().getPath());
		  sb.append("\"><img src=\"../");
		  sb.append(person.getDefaultFace().getIcon().getPath());
		  sb.append("\" alt=\"" + person.getFullName() + "\" title=\"" +
				  message + "\"/></a></li>");
		  
		  sb.append("<li><a style=\"clear: both; float: none;\" href=\"");
		  sb.append("friendPage.do?friendId=");
		  sb.append(person.getId()); sb.append("\">");
		  sb.append(person.getFullName()); sb.append("</a></li></ul>");
*/
	}

	protected void longmsghtml(StringBuilder sb, String message) {
		//sb.append("<sns:messagetemplate message='" + message + "' ></sns:messagetemplate>");
		
		 sb.append("<span style=\"vertical-align: top;padding-left: 5px;\"><p style=\"width: 400px;\"> "); 
		 sb.append(message); 
		 sb.append("</p></span>");
	}

	protected void shortmsghtml(StringBuilder sb, String message) { 
		//sb.append("<sns:messagetemplate message='" + message + "' />");
		
		sb.append("<span style=\"vertical-align: top;padding-left: 5px;\"><p style=\"width: 200px;\"> "); 
		sb.append(StringUtils.abbreviate(message, 200)); 
		sb.append("</p></span>");
	}

	protected void itemhtml(StringBuilder sb, Item item) {
		/*
		sb.append(StringEscapeUtils.escapeHtml("<sns:itemtemplate itemName='" + item.getItemName()
				+ "' itemId='" + item.getId() + "' glimpse='"
				+ item.getGlimpse().getPath() + "' icon='"
				+ item.getIcon().getPath() + "' description='"
				+ item.getDescription() + "' ></sns:itemtemplate>"));
		*/
		  sb.append("<UL><li>"); 
		  sb.append("<img src=\"../");
		  sb.append(item.getIcon().getPath()); 
		  sb.append("\" alt=\"" +
		  item.getDescription() + "\" title=\"" + item.getItemName() +
		  "\"/></a></li>");
		  
		  sb.append("<li><a style=\"clear: both; float: none;\" href=\"javascript: void(0);"); 
		  sb.append("\" onclick=\"viewItemDetail('" + item.getId() + "')\">"); 
		  sb.append(item.getItemName()); 
		  sb.append("</a></li></ul>");		
		/*
		  sb.append("<UL><li><a style=\"clear: both; float: none;\" rel=\"prettyPhoto[news]\" href=\"../");
		  sb.append(item.getGlimpse().getPath()); 
		  sb.append("\"><img src=\"../");
		  sb.append(item.getIcon().getPath()); 
		  sb.append("\" alt=\"" +
		  item.getDescription() + "\" title=\"" + item.getItemName() +
		  "\"/></a></li>");
		  
		  sb.append("<li><a style=\"clear: both; float: none;\" href=\"javascript: void(0);"); 
		  sb.append("\" onclick=\"viewItemDetail('" + item.getId() + "')\">"); 
		  sb.append(item.getItemName()); 
		  sb.append("</a></li></ul>");
		  */
	}
}
