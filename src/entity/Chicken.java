package entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import main.GamePanel;

public class Chicken extends Entity {
	GamePanel gp;

	public Chicken(GamePanel gp) {
		this.gp = gp;
		this.setChickenImage();
		this.setDefaultValues();
	}
	public void setDefaultValues() {
		y=-gp.titleSize;
		Random rd= new Random();
		x=rd.nextInt((gp.screenWidth-gp.titleSize)+1);
		speed = 1;
	}
	public void setChickenImage() {
		try {
			chickenImage = ImageIO.read(getClass().getResource("/Images/chicken.png"));
			collision = true;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void update() {
		y+=speed;
	}
	public void draw(Graphics2D g2) {
		BufferedImage Image = chickenImage;
		g2.drawImage(Image, x, y, gp.titleSize, gp.titleSize, null);
	}

}
