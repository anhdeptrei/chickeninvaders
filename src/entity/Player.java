package entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity {
	GamePanel gp;
	KeyHandler keyH;
	
	public Player(GamePanel gp, KeyHandler keyH) {
		this.gp = gp;
		this.keyH = keyH;	
		setDefaultValues();
		setPlayerImage();
	}

	public void setDefaultValues() {
		x = gp.screenWidth / 2;
		y = gp.screenHeight-60;
		speed = 4;
		maxLife = 6;
		life = maxLife;
	}

	public void setPlayerImage() {
		try {
			plane = ImageIO.read(getClass().getResource("/Images/plane.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void update() {
		if (keyH.upPressed == true) {
			y=(y>=50?y-speed:50);
		} else if (keyH.downPressed == true) {
			y=(y<=gp.screenHeight?y+speed:gp.screenHeight);
		} else if (keyH.leftPressed == true) {
			x =(x<=0?0:x-speed);
		} else if (keyH.rightPressed == true) {
			x =(x>=gp.screenWidth?gp.screenWidth:x+speed);
		}
	}

	public void draw(Graphics2D g2) {
		BufferedImage Image = plane;
		g2.drawImage(Image, (x-gp.titleSize/2), (y-gp.titleSize), gp.titleSize, gp.titleSize, null);
	}

}
