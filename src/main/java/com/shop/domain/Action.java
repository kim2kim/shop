package com.shop.domain;

import com.shop.converter.MessageConverter;
import com.shop.converter.PersonIntegerConverter;
import com.shop.converter.PersonItemConverter;
import com.shop.converter.PersonMessageConverter;
import com.shop.converter.PersonPersonConverter;
import com.shop.converter.PersonPersonItemConverter;

/**
 * Action is used by Feed to generate feed messages.
 * 
 * @author khim.ung
 * 
 */
public enum Action {
		MESSAGE(false, "message", "{2}", PersonMessageConverter.class),
		UPDATE(false, "update", "{1} says {2}", PersonMessageConverter.class), 
		FRIENDS(false, "friends", "{1} and {2} are now friends",
				PersonPersonConverter.class), 
		BOUGHT(true, "bought",
				"{1} bought {2}", PersonItemConverter.class),
				
		WANT(true, "want",
				"{1} wants {2}", PersonItemConverter.class), 
		ADVICE(true, "advice",
				"{1} wants advice on {2}", PersonItemConverter.class), 
		RECOMMEND(true,
				"recommend", "{1} recommends {2} to {3}",
				PersonPersonItemConverter.class), 
		UPLOAD(true, "upload",
				"{1} has uploaded {2} items.",
				PersonIntegerConverter.class),
				
		COMMENT(true, "comment",
				"{1} commented on {2}", PersonItemConverter.class), 
				
		SCRIBBLE(false, 
				"scribble", "{1} scribbled on {2}'s page",
				PersonPersonConverter.class), 
		SELLING(true, "selling",
						"{1} is selling {2}", PersonItemConverter.class),
		SERVICE(true, "service",
								"{1} is offering {2}.", PersonItemConverter.class),
		POINT(true, "point",
				"{1} is rewarding {2} in exchange for points earned from purchases.", PersonItemConverter.class),
		JOURNAL( true, "journal", "{1} has a new journal entry", PersonMessageConverter.class), 
		EVENT( true, "event", "{1} added a new event {2}", PersonMessageConverter.class),
		COMMERCIAL( true, "commercial", "{1} has uploaded a new commercial", PersonMessageConverter.class),
		INSTITUTION( true, "institution", "{1} attended {2}", PersonPersonConverter.class),
		MEMBER( true, "member", "{1} has a new member {2}", PersonPersonConverter.class),
		NEW_MEMBER( true, "new member", "{1} has joined SleekSwap", PersonMessageConverter.class),
		NEW_INSTITUTION( true, "new institution", "SleekSwap has a new institution, {1}", PersonMessageConverter.class),
		NEW_EMPLOYER( true, "new employer", "SleekSwap has a new business, {1}", PersonMessageConverter.class),
		EMPLOYED(true, "employed", "{1} works for {2}", PersonPersonConverter.class),
		JOIN_BUSINESS( true, "join business", "{1} joined the business {2}", PersonPersonConverter.class),
		JOIN_INST( true, "join institution", "{1} joined the institution {2}", PersonPersonConverter.class);
		
		/**
		 * Determines how the message will be presented
		 */
		private String messageTemplate;
	
		private Class converterClazz;
		
		private boolean world;
	
		private Action(boolean world, String name, String messageTemplate, Class converterClazz) {
			this.messageTemplate = messageTemplate;
			this.converterClazz = converterClazz;
			this.world = world;
		}
	
		public String convert(Object... objects) {
			try {
				MessageConverter converter = (MessageConverter) Class.forName(
						this.converterClazz.getName()).newInstance();
				return converter.converter(this.messageTemplate, objects);
			} catch (InstantiationException e) {
				return "Error in message retrieval";
			} catch (IllegalAccessException e) {
				return "Error in message retrieval";
			} catch (ClassNotFoundException e) {
				return "Error in message retrieval";
			}
		}
	
		public String getMessageTemplate() {
			return messageTemplate;
		}
		
		public Class getConverterClazz() {
			return converterClazz;
		}
		
		public boolean isWorld() {
			return world;
		}

}
