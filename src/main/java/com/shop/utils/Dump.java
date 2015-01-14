package com.shop.utils;

import java.awt.Image;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.shop.utils.photo.CreateThumbnail;

public class Dump {
	private static transient final Logger log = LoggerFactory.getLogger(Dump.class);
	
	private Resource adsPath;
	private Resource facesPath;
	private Resource itemsPath;
	private Resource productsPath;
	private Resource videosPath;
	
	public Dump(Resource adsPath, Resource facesPath, Resource itemsPath, Resource productspath, Resource videosPath ){
		this.adsPath = adsPath;
		this.facesPath = facesPath;
		this.itemsPath = itemsPath;
		this.productsPath = productsPath;
		this.videosPath = videosPath;
	}
	
	public Resource getAdsPath() {
		return adsPath;
	}

	public Resource getFacesPath() {
		return facesPath;
	}



	public Resource getItemsPath() {
		return itemsPath;
	}



	public Resource getProductsPath() {
		return productsPath;
	}



	public Resource getVideosPath() {
		return videosPath;
	}
	
	public static String dump(CommonsMultipartFile fileData, String category, String root) {
		String masterFile = null;

		if (fileData.getOriginalFilename().endsWith("txt")) {
			make(root + "feeds/", fileData.getOriginalFilename());
			try {
				fileData.transferTo(new File(root + "feeds/" + fileData.getOriginalFilename()));
			}catch(IOException e){
				log.error("failed to upload file "+fileData.getOriginalFilename());
			}
			// make sure this is at the end of the form
		} else {
			make(root + category + "/", fileData.getOriginalFilename());
			try{
				fileData.transferTo(new File(root + category + "/" + fileData.getOriginalFilename()));
			}catch(IOException e){
				log.error("failed to upload file "+fileData.getOriginalFilename());
			}
			masterFile = fileData.getOriginalFilename();
		}
		return masterFile;
	}

	
	public static String dump(List items, String category, String root) {
		Iterator itr = items.iterator();

		String masterFile = null;

		while (itr.hasNext()) {
			FileItem item = (FileItem) itr.next();
			if (item.isFormField()) {
			} else {
				String itemName = item.getName();
				
				if(itemName.contains("\\")){
					int index = itemName.lastIndexOf("\\");
					itemName = itemName.substring(index + 1, itemName.length());
					
					log.debug("itemName: " + itemName);
				}
				
				File itemFile = new File(itemName);
				itemName = itemFile.getName();

				if (itemName.endsWith("txt")) {
					make(root + "feeds/", itemName);
					try {
						item.write(new File(root + "feeds/" +itemName));
					} catch (Exception e) {
						log.error("Unable to save master file.");
					}
					masterFile = root + "feeds/" +itemName;

					// make sure this is at the end of the form
				} else {
					make(root + category + "/", itemName);
					try {
						item.write(new File(root + category + "/" + itemName));
					} catch (Exception e) {
						log.error("Unable to save IMAGE.");
					}
					log.debug("File saved as " + root + itemName);
					
					masterFile = itemName;
				}
			}
		}
		return masterFile;
	}
	
	
	public static void make(String dir, String fileName){
		File d = new File(dir);
		if (!d.exists()) {
			d.mkdirs();
		}
		File f = new File(dir + fileName);
		if(!f.exists()){
			try {
				f.createNewFile();
			} catch (IOException e) {
				log.error("Unable to create file " + f.getAbsolutePath());
			}
		}
	}	
	
	public static String dump(DataInputStream in, int formDataLength,
			int lastIndex, String boundary, String root) throws IOException {
		
		log.debug("formDataLength " + formDataLength + "");
		
		byte dataBytes[] = new byte[formDataLength];
		int byteRead = 0;
		int totalBytesRead = 0;
		byte[] imageBytes = new byte[in.available()];
		in.readFully(imageBytes);
		
		log.debug(new String(imageBytes));
		
		while (totalBytesRead < formDataLength) {
			byteRead = in.read(dataBytes, totalBytesRead, formDataLength);
			totalBytesRead += byteRead;
		}

		String file = new String(dataBytes);
		String saveFile = file.substring(file.indexOf("filename=\"") + 10);
				
		saveFile = saveFile.substring(0, saveFile.indexOf("\n"));
		saveFile = saveFile.substring(saveFile.lastIndexOf("\\") + 1, saveFile
				.indexOf("\""));

		if(StringUtils.trimToNull(saveFile) == null){
			return null;
		}
		
		// out.print(dataBytes);

		// out.println(boundary);
		int pos;
		pos = file.indexOf("filename=\"");
		pos = file.indexOf("\n", pos) + 1;
		pos = file.indexOf("\n", pos) + 1;
		pos = file.indexOf("\n", pos) + 1;

		int boundaryLocation = file.indexOf(boundary, pos) - 4;
		int startPos = ((file.substring(0, pos)).getBytes()).length;
		int endPos = ((file.substring(0, boundaryLocation)).getBytes()).length;

		//createDirectory(root);
		make(root, saveFile);

		//FileOutputStream fileOut = new FileOutputStream(root
		//		+ saveFile);	

        log.debug("dataBytes " + dataBytes + " startPos " + startPos + " endPos " + endPos + " endPos - startPos " + (endPos - startPos));
		
        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File(root + saveFile)))){
    		bos.write(dataBytes, startPos, (endPos - startPos));
        }
        
		//fileOut.write(dataBytes);
		
        //fileOut.write(dataBytes, startPos, (endPos - startPos));
		//fileOut.flush();
		//fileOut.close();

		return saveFile;
	}

	public static String makeMini(String relativeRoot, String root, String saveFile) {
		createDirectory(root + "minis");
		
		System.out.println("root " + root);
		
		System.out.println("saveFile " + saveFile);
		
		CreateThumbnail ct = new CreateThumbnail(root + saveFile);
		
		System.out.println("path " + root+saveFile);

		Image image = ct.getImage(root + saveFile);
		float h = image.getHeight(null);
		float w = image.getWidth(null);
		
		int height = image.getHeight(null);
		int width = image.getWidth(null);
		if(height > 20){
			width = 20;
			height = (int)((20.0/w) * h);
			if(height > 20){
				h = height;
				w = 20;
				width = (int)((20.0/h) * w);
				height = 20;
			}
		}		
		
		log.debug("File: " + root + "minis/mini-" + saveFile);
		ct.saveThumbnail(new File(root + "minis/mini-" + saveFile),
				ImageFileFilter.getExtension(saveFile), width, height);
		return relativeRoot + "minis/mini-" + saveFile;
	}
	
	public static String makeIcon(String relativeRoot, String root, String saveFile) {
		createDirectory(root + "icons");
		
		CreateThumbnail ct = new CreateThumbnail(root + saveFile);

		Image image = ct.getImage(root + saveFile);
		float h = image.getHeight(null);
		float w = image.getWidth(null);
		
		int height = image.getHeight(null);
		int width = image.getWidth(null);
		if(height > 70){
			width = 70;
			height = (int)((70/w) * h);
			if(height > 70){
				h = height;
				w = 70;
				width = (int)((70.0/h) * w);
				height = 70;
			}			
		}		
		
		log.debug("File: " + root + "icons/icon-" + saveFile);
		ct.saveThumbnail(new File(root + "icons/icon-" + saveFile),
				ImageFileFilter.getExtension(saveFile), width, height);
		return relativeRoot + "icons/icon-" + saveFile;
	}

	public static String makeThumbnail(String relativeRoot, String root, String saveFile) {
		createDirectory(root + "thumbs");

		CreateThumbnail ct = new CreateThumbnail(root + saveFile);

		Image image = ct.getImage(root + saveFile);
		float h = image.getHeight(null);
		float w = image.getWidth(null);
		
		int height = image.getHeight(null);
		int width = image.getWidth(null);
		if(height > 200){
			width = 200;
			height = (int)((200/w) * h);
			if(height > 200){
				h = height;
				w = 200;
				width = (int)((200.0/h) * w);
				height = 200;
			}
		}		
		
		ct.saveThumbnail(
				new File(root + "thumbs/thumb-" + saveFile),
				ImageFileFilter.getExtension(saveFile), width, height);
		return relativeRoot + "thumbs/thumb-" + saveFile;
	}

	public static String makeGlimpse(String relativeRoot, String root, String saveFile) {
		createDirectory(root + "glimpses");
		       
		CreateThumbnail ct = new CreateThumbnail(root + saveFile);

		Image image = ct.getImage(root + saveFile);
		float h = image.getHeight(null);
		float w = image.getWidth(null);

		int height = image.getHeight(null);
		int width = image.getWidth(null);
		if(height > 500){
			width = 500;
			height = (int)((500/w) * h);
			if(height > 500){
				h = height;
				w = 500;
				width = (int)((500.0/h) * w);
				height = 500;
			}
		}

		ct.saveThumbnail(
				new File(root + "glimpses/glimpse-" + saveFile),
				ImageFileFilter.getExtension(saveFile), width, height);
		return relativeRoot + "glimpses/glimpse-" + saveFile;
	} 
	
	private static void createDirectory(String path) {
		File faceDirectory = new File(path);
		log.debug("Creating: " + faceDirectory.getAbsolutePath());
		if (!faceDirectory.exists()) {
			faceDirectory.mkdirs();
		}
	}
	
}
