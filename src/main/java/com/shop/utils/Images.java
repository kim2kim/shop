package com.shop.utils;


import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class Images {
	private static transient final Log log = LogFactory
	.getLog(Images.class);

	public static final String IM_PATH = "common/images/swing/";

    /** Singleton Design Pattern */
    private static Images instance;
    public static Images getInstance() {
        if (instance == null) instance = new Images();
        return instance;
    }

    public Image getImage(String relativeURLPath) {
        String fullPath = IM_PATH + relativeURLPath;
        URL url = getClass().getClassLoader().getResource(fullPath);
        try {
            if (url == null) return ImageIO.read(new File(fullPath));
            else return new ImageIcon(url).getImage();
        } catch (IOException ex) {
        	log.error(ex.getMessage());
            return null;
        }
    }

    public ImageIcon getImageIcon(String relativeURLPath) {
        Image image = getImage(relativeURLPath);
        if (image == null) return null;
        return new ImageIcon(image);
    }

    public static Image scale(Image image, int width, int height) {
        if (image == null) {
            return image;
        }
        return image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
    }

    public ImageIcon getImageIcon(String relativeURLPath, int width, int height) {
        Image image = getImage(relativeURLPath);
        if (image == null) return null;
        Image scaledImage = scale(image, width, height);
        return new ImageIcon(scaledImage);
    }

    public ImageIcon getSmallIcon(String relativeURLPath) {
        return getImageIcon(relativeURLPath, 16, 16);
    }

    public ImageIcon getLargeIcon(String relativeURLPath) {
        return getImageIcon(relativeURLPath, 24, 24);
    }
}