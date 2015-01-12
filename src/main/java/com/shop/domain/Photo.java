package com.shop.domain;

import java.net.URL;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * The photo uploaded by the users.
 * 
 * @author khim.ung
 * 
 */
@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name="photo")
public class Photo extends DomainObject {
	public final static Photo GENERIC_DEFAULT_MINI = new Photo();
	public final static Photo GENERIC_DEFAULT_ICON = new Photo();
	public final static Photo GENERIC_DEFAULT_THUMB = new Photo();
	public final static Photo GENERIC_DEFAULT_GLIMPSE = new Photo();
	
	public final static Photo MALE_DEFAULT_MINI = new Photo();
	public final static Photo MALE_DEFAULT_ICON = new Photo();
	public final static Photo MALE_DEFAULT_THUMB = new Photo();
	public final static Photo MALE_DEFAULT_GLIMPSE = new Photo();
	
	public final static String GENERIC_DEFAULT_PHOTO_THUMB = "faces/default/thumbs/thumb-myshopnshare-generic.png";
	public final static String GENERIC_DEFAULT_PHOTO_MINI = "faces/default/minis/mini-myshopnshare-generic.png";
	public final static String GENERIC_DEFAULT_PHOTO_ICON = "faces/default/icons/icon-myshopnshare-generic.png";
	public final static String GENERIC_DEFAULT_PHOTO_GLIMPSE = "faces/default/glimpses/glimpse-myshopnshare-generic.png";
	
	public final static String MALE_DEFAULT_PHOTO_THUMB = "faces/default/thumbs/thumb-myshopnshare-male.png";
	public final static String MALE_DEFAULT_PHOTO_ICON = "faces/default/icons/icon-myshopnshare-male.png";
	public final static String MALE_DEFAULT_PHOTO_MINI = "faces/default/minis/mini-myshopnshare-male.png";
	public final static String MALE_DEFAULT_PHOTO_GLIMPSE = "faces/default/glimpses/glimpse-myshopnshare-male.png";

	public final static Photo FEMALE_DEFAULT_MINI = new Photo();
	public final static Photo FEMALE_DEFAULT_ICON = new Photo();
	public final static Photo FEMALE_DEFAULT_THUMB = new Photo();
	public final static Photo FEMALE_DEFAULT_GLIMPSE = new Photo();
	
	public final static String FEMALE_DEFAULT_PHOTO_THUMB = "faces/default/thumbs/thumb-myshopnshare-female.png";
	public final static String FEMALE_DEFAULT_PHOTO_ICON = "faces/default/icons/icon-myshopnshare-female.png";
	public final static String FEMALE_DEFAULT_PHOTO_MINI = "faces/default/minis/mini-myshopnshare-female.png";
	public final static String FEMALE_DEFAULT_PHOTO_GLIMPSE = "faces/default/glimpses/glimpse-myshopnshare-female.png";
	
	/** business **/
	public final static Photo BIZ_DEFAULT_MINI = new Photo();
	public final static Photo BIZ_DEFAULT_ICON = new Photo();
	public final static Photo BIZ_DEFAULT_THUMB = new Photo();
	public final static Photo BIZ_DEFAULT_GLIMPSE = new Photo();
	
	public final static String BIZ_DEFAULT_PHOTO_THUMB = "faces/default/thumbs/thumb-myshopnshare-biz.png";
	public final static String BIZ_DEFAULT_PHOTO_ICON = "faces/default/icons/icon-myshopnshare-biz.png";
	public final static String BIZ_DEFAULT_PHOTO_MINI = "faces/default/minis/mini-myshopnshare-biz.png";
	public final static String BIZ_DEFAULT_PHOTO_GLIMPSE = "faces/default/glimpses/glimpse-myshopnshare-biz.png";

	/** institutions **/
	public final static Photo INS_DEFAULT_MINI = new Photo();
	public final static Photo INS_DEFAULT_ICON = new Photo();
	public final static Photo INS_DEFAULT_THUMB = new Photo();
	public final static Photo INS_DEFAULT_GLIMPSE = new Photo();
	
	public final static String INS_DEFAULT_PHOTO_THUMB = "faces/default/thumbs/thumb-myshopnshare-ins.png";
	public final static String INS_DEFAULT_PHOTO_ICON = "faces/default/icons/icon-myshopnshare-ins.png";
	public final static String INS_DEFAULT_PHOTO_MINI = "faces/default/minis/mini-myshopnshare-ins.png";
	public final static String INS_DEFAULT_PHOTO_GLIMPSE = "faces/default/glimpses/glimpse-myshopnshare-ins.png";

	/** Merchants **/
	public final static Photo MER_DEFAULT_MINI = new Photo();
	public final static Photo MER_DEFAULT_ICON = new Photo();
	public final static Photo MER_DEFAULT_THUMB = new Photo();
	public final static Photo MER_DEFAULT_GLIMPSE = new Photo();
	
	public final static String MER_DEFAULT_PHOTO_THUMB = "faces/default/thumbs/thumb-myshopnshare-mer.png";
	public final static String MER_DEFAULT_PHOTO_ICON = "faces/default/icons/icon-myshopnshare-mer.png";
	public final static String MER_DEFAULT_PHOTO_MINI = "faces/default/minis/mini-myshopnshare-mer.png";
	public final static String MER_DEFAULT_PHOTO_GLIMPSE = "faces/default/glimpses/glimpse-myshopnshare-mer.png";

	
	/** 
	 * Dont need to do this once the database is set up
	 */
	static {
		GENERIC_DEFAULT_GLIMPSE.setPath(Photo.GENERIC_DEFAULT_PHOTO_GLIMPSE);
		GENERIC_DEFAULT_GLIMPSE.setSystem("LOCAL");
		GENERIC_DEFAULT_THUMB.setPath(Photo.GENERIC_DEFAULT_PHOTO_THUMB);
		GENERIC_DEFAULT_THUMB.setSystem("LOCAL");
		GENERIC_DEFAULT_MINI.setPath(Photo.GENERIC_DEFAULT_PHOTO_MINI);
		GENERIC_DEFAULT_MINI.setSystem("LOCAL");
		GENERIC_DEFAULT_ICON.setPath(Photo.GENERIC_DEFAULT_PHOTO_ICON);
		GENERIC_DEFAULT_ICON.setSystem("LOCAL");
		
		MALE_DEFAULT_MINI.setPath(Photo.MALE_DEFAULT_PHOTO_MINI);
		MALE_DEFAULT_MINI.setSystem("Local");		
		MALE_DEFAULT_ICON.setPath(Photo.MALE_DEFAULT_PHOTO_ICON);
		MALE_DEFAULT_ICON.setSystem("Local");
		MALE_DEFAULT_THUMB.setPath(Photo.MALE_DEFAULT_PHOTO_THUMB);
		MALE_DEFAULT_THUMB.setSystem("Local");	
		MALE_DEFAULT_GLIMPSE.setPath(Photo.MALE_DEFAULT_PHOTO_GLIMPSE);
		MALE_DEFAULT_GLIMPSE.setSystem("Local");	
		
		FEMALE_DEFAULT_MINI.setPath(Photo.FEMALE_DEFAULT_PHOTO_MINI);
		FEMALE_DEFAULT_MINI.setSystem("Local");		
		FEMALE_DEFAULT_ICON.setPath(Photo.FEMALE_DEFAULT_PHOTO_ICON);
		FEMALE_DEFAULT_ICON.setSystem("Local");
		FEMALE_DEFAULT_THUMB.setPath(Photo.FEMALE_DEFAULT_PHOTO_THUMB);
		FEMALE_DEFAULT_THUMB.setSystem("Local");	
		FEMALE_DEFAULT_GLIMPSE.setPath(Photo.FEMALE_DEFAULT_PHOTO_GLIMPSE);
		FEMALE_DEFAULT_GLIMPSE.setSystem("Local");	
		
		MER_DEFAULT_MINI.setPath(Photo.MER_DEFAULT_PHOTO_MINI);
		MER_DEFAULT_MINI.setSystem("Local");		
		MER_DEFAULT_ICON.setPath(Photo.MER_DEFAULT_PHOTO_ICON);
		MER_DEFAULT_ICON.setSystem("Local");
		MER_DEFAULT_THUMB.setPath(Photo.MER_DEFAULT_PHOTO_THUMB);
		MER_DEFAULT_THUMB.setSystem("Local");	
		MER_DEFAULT_GLIMPSE.setPath(Photo.MER_DEFAULT_PHOTO_GLIMPSE);
		MER_DEFAULT_GLIMPSE.setSystem("Local");
		
		INS_DEFAULT_MINI.setPath(Photo.INS_DEFAULT_PHOTO_MINI);
		INS_DEFAULT_MINI.setSystem("Local");		
		INS_DEFAULT_ICON.setPath(Photo.INS_DEFAULT_PHOTO_ICON);
		INS_DEFAULT_ICON.setSystem("Local");
		INS_DEFAULT_THUMB.setPath(Photo.INS_DEFAULT_PHOTO_THUMB);
		INS_DEFAULT_THUMB.setSystem("Local");	
		INS_DEFAULT_GLIMPSE.setPath(Photo.INS_DEFAULT_PHOTO_GLIMPSE);
		INS_DEFAULT_GLIMPSE.setSystem("Local");

		BIZ_DEFAULT_MINI.setPath(Photo.BIZ_DEFAULT_PHOTO_MINI);
		BIZ_DEFAULT_MINI.setSystem("Local");		
		BIZ_DEFAULT_ICON.setPath(Photo.BIZ_DEFAULT_PHOTO_ICON);
		BIZ_DEFAULT_ICON.setSystem("Local");
		BIZ_DEFAULT_THUMB.setPath(Photo.BIZ_DEFAULT_PHOTO_THUMB);
		BIZ_DEFAULT_THUMB.setSystem("Local");	
		BIZ_DEFAULT_GLIMPSE.setPath(Photo.BIZ_DEFAULT_PHOTO_GLIMPSE);
		BIZ_DEFAULT_GLIMPSE.setSystem("Local");
	}

	private String path;
	/**
	 * Indicates where the photo is stored
	 */
	private String system;

	/**
	 * The serialized image
	 */
	@Lob
	private byte[] content;

	/*********************************************/

	public Photo(){
		this.setSystem("CUSTOM");
	}
	
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getSystem() {
		return system;
	}

	public void setSystem(String system) {
		this.system = system;
	}

	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}

	@Transient
	public URL getImageURL() {
		String fullPath = "images/" + path;
		URL url = getClass().getClassLoader().getResource(fullPath);
		return url;
	}

	@Transient
	public boolean isApplication() {
		return this.system.equals("Local") ? true : false;
	}
}
