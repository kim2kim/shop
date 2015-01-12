package com.shop.utils.photo;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.log4j.Logger;

public class CreateThumbnail {
	private final static Logger log = Logger.getLogger(CreateThumbnail.class);
	private Image image;

	public CreateThumbnail(String fileName) {
		image = getImage(fileName);
	}

	public Image getImage(String fullPath) {
		try {
			System.out.println("fullPath " + fullPath);
			return ImageIO.read(new File(fullPath));
		} catch (IOException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public void scale(int width, int height) {
		image = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
	}

	public void saveThumbnail(File file, String imageType, int width, int height) {
		image = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		if (image != null) {
			BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			Graphics g = bi.getGraphics();
			g.drawImage(image, 0, 0, null);
			try {
				ImageIO.write(bi, imageType, file);
			} catch (IOException ioe) {
				log.error("Error occured saving thumbnail");
			}
		} else {
			log.error("Thumbnail has not yet been created");
		}
	}

}
