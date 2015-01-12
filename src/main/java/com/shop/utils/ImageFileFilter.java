package com.shop.utils;
/*
 * ImageFileFilter.java
 *
 * Created: Nov 18, 2007
 * Author: Paul Munly
 * Version: 0.4
 * License: GNU General Public License, Version 2, 1991.  See http://www.gnu.org/ 
 *
 * TODO: 
 */

import java.io.File;

import javax.swing.filechooser.FileFilter;

public class ImageFileFilter extends FileFilter {
	
	String [] extensions = null;	
	String description = null;
        
    public ImageFileFilter(String ext, String desc) {
    	this.extensions = new String [1];
    	this.extensions[0] = ext;
    	this.description = desc;
    }
    
    public ImageFileFilter(String [] ext, String desc) {
    	this.extensions = new String [ext.length];
    	this.description = desc;
    	for(int i = 0 ; i < ext.length; i++) {
    		this.extensions[i] = ext[i];
    	}
    }
    
    public boolean accept(File f) {
        if(f.isDirectory()) {
            return true;
        }
        String ext = getExtension(f);
        for(int i = 0; i < this.extensions.length; i++) {
        	if(ext.compareTo(this.extensions[i]) == 0)
        		return true;
        }

        return false;
    }
   
    public String getExtension(File f) {
        if(f != null) {
            String fileName = f.getName();
            int i = fileName.lastIndexOf('.');
            if(i > 0 && i < fileName.length() - 1)
                return (fileName.substring(i+1).toLowerCase());
        }
        return "-1";
    }

    public static String getExtension(String fileName) {
        if(fileName != null) {
            int i = fileName.lastIndexOf('.');
            if(i > 0 && i < fileName.length() - 1)
                return (fileName.substring(i+1).toLowerCase());
        }
        return "-1";
    }
 
    
    public String getExtension() {    	
    	return this.extensions[0];
    }

	public String getDescription() {		
		return this.description;
	}
    
}
