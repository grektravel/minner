package ru.lessons.lesson_13.test;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Test {

	public static void main(String[] args) throws IOException {
		BufferedImage image;
		image = ImageIO.read(new File("images/bomb.gif"));

	}

}
