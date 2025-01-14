package title;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class Background extends Title {
	GamePanel gp;

	public Background(GamePanel gp) {
		super();
		this.gp = gp;
		getBackgroundImage();
	}
	public void getBackgroundImage() {
		try {
			space = ImageIO.read(getClass().getResource("/Images/space.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@SuppressWarnings("unused")
	public void draw(Graphics g) {
		BufferedImage Image = space;
		Dimension d = gp.getSize();
		g.drawImage(space, 0, 0, d.width, d.height, null);
	}
}
