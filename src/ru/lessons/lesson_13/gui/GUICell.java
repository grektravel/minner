package ru.lessons.lesson_13.gui;

import ru.lessons.lesson_13.Cell;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * TODO: comment
 * 
 * @author parsentev
 * @since 08.04.2015
 */
public class GUICell implements Cell<Graphics> {

	private boolean bomb = false;
	private boolean suggectEmpty = false;
	private boolean suggectBomb = false;
	private int besideBomb = -1;

	public int getBesideBomb() {
		return besideBomb;
	}

	public void setBesideBomb(int besideBomb) {
		this.besideBomb = besideBomb;
	}

	public boolean isBomb() {
		return bomb;
	}

	public boolean isSuggestBomb() {
		return suggectBomb;
	}

	public boolean isSuggestEmpty() {
		return suggectEmpty;
	}

	public void suggectEmpty() {
		suggectEmpty = true;
	}

	public void suggectBomb() {
		suggectBomb = true;
	}

	public void setBomb() {
		bomb = true;
	}

	public void draw(Graphics paint, boolean real) {

	}

	public void draw(Graphics paint, int x, int y, boolean real) {
		if (real) {
			if (bomb) {
				try {
					BufferedImage image;
					image = ImageIO.read(new File("images/bomb.gif"));
					paint.drawImage(image, x - 12, y - 12, 25, 25, null);
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				paint.drawString(String.valueOf(besideBomb), x, y);
			}
		} else {
			if (suggectBomb) {
				try {
					BufferedImage image;
					image = ImageIO.read(new File("images/flag.png"));
					paint.drawImage(image, x - 12, y - 12, 25, 25, null);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (suggectEmpty) {
				paint.drawString(String.valueOf(besideBomb), x, y);
			}
			if ((suggectEmpty)&&(bomb)) {
				try {
					BufferedImage image;
					image = ImageIO.read(new File("images/bomb.gif"));
					paint.drawImage(image, x - 12, y - 12, 25, 25, null);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
