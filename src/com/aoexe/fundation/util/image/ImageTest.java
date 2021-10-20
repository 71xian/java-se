package com.aoexe.fundation.util.image;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageTest {

	static int k = 0;
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		File file = new File("D:/good.jpg");
		File output = new File("D:/output.jpg");
		if (!output.exists()) {
			output.createNewFile();
		}
		BufferedImage image = ImageIO.read(new FileInputStream(file));
		BufferedImage blur = GaussianBlur.blur(image, 128);
		ImageIO.write(blur, "jpg", output);
		
	}
}
