package entity;

import java.awt.Graphics2D;
import java.io.IOException;
import javax.imageio.ImageIO;

import main.GamePanel;

public class Heart extends Entity {
	GamePanel gp;

	public Heart(GamePanel gp) {
		this.gp = gp;
		this.setHeartImage();
	}
	public void setHeartImage() {
		try {
			Heart3 = ImageIO.read(getClass().getResource("/Images/heart_blank.png"));
			Heart1 = ImageIO.read(getClass().getResource("/Images/heart_full.png"));
			Heart2 = ImageIO.read(getClass().getResource("/Images/heart_half.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void draw(Graphics2D g2) {
		int x= 	gp.titleSize/2;
		int y = gp.titleSize/2;
		int i=0;
		while (i< gp.player.maxLife/2) {
			g2.drawImage(Heart3, x, y,gp.titleSize,gp.titleSize, null);
			i++;
			x+= gp.titleSize;
		}
		x= 	gp.titleSize/2;
		y = gp.titleSize/2;
		i=0;
		while (i< gp.player.life) {
			g2.drawImage(Heart2, x, y,gp.titleSize,gp.titleSize, null);
			i++;
			if(i<gp.player.life) {
				g2.drawImage(Heart1, x, y,gp.titleSize,gp.titleSize, null);
			}
			i++;
			x+= gp.titleSize;
		}
	}

}
