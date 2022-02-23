package com.khauminhduy.image.resize.core;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Graphics2DExample {

	public BufferedImage resizeImage(BufferedImage originalImage, int targetWidth, int targetHeight) {
		BufferedImage resizeImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_BGR);
		Graphics2D graphics2d = resizeImage.createGraphics();
		return resizeImage;
	}
	
}
