package entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class Shot extends Entity {

	GamePanel gp;
	Player pl;

	public Shot(GamePanel gp, Player pl) {
		this.gp = gp;
		this.pl = pl;
		this.setDefaultValues();
		this.setShotImage();
	}

	public void setDefaultValues() {
		x = pl.x;
		y = pl.y;
		speed = 7;
	}

	public void setShotImage() {
		try {
			shotImage = ImageIO.read(getClass().getResource("/Images/shot.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void update() {
		y-=speed;
	}

	public void draw(Graphics2D g2) {
		BufferedImage Image = shotImage;
		g2.drawImage(Image, x-gp.titleSize/4, y-70, gp.titleSize/2, gp.titleSize, null);
	}

}
