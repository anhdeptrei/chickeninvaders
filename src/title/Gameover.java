package title;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class Gameover extends Title {
	GamePanel gp;
	TextInGame texts;
	public Gameover(GamePanel gp,TextInGame texts) {
		super();
		this.gp = gp;
		this.texts=texts;
		getImage();
	}
	public void getImage() {
		try {
			gameover = ImageIO.read(getClass().getResource("/Images/game-over.png"));
			arrow = ImageIO.read(getClass().getResource("/Images/arrow.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@SuppressWarnings("unused")
	public void draw(Graphics graphics) {
		BufferedImage Image = gameover;
		BufferedImage Image1 = arrow;
		Dimension d = gp.getSize();
		graphics.drawImage(gameover, 0, 0, d.width, d.height, null);

		graphics.setColor(Color.white);
		graphics.setFont(graphics.getFont().deriveFont(Font.ITALIC,30));
		String text = "Your score : "+(gp.cCheck.score);
		int x = texts.getTextCenterX(graphics, text);
		int y = gp.screenHeight/2+80;
		graphics.drawString(text, x, y);
		
		text = "Main menu";
		y+=30;
		if(commandNum == 0) {
			graphics.setFont(graphics.getFont().deriveFont(Font.ITALIC,40));
			x=texts.getTextCenterX(graphics, text)-150;
			graphics.drawString(text, x, y);
			graphics.drawImage(Image1, x-gp.titleSize-10,y-texts.getHeightText(graphics, text)/2 ,gp.titleSize,gp.titleSize/2, null);
		}else {
			graphics.setFont(graphics.getFont().deriveFont(Font.ITALIC,30));
			x=texts.getTextCenterX(graphics, text)-150;
			graphics.drawString(text, x, y);
		}
		
		text = "Quit";
		if(commandNum == 1) {
			graphics.setFont(graphics.getFont().deriveFont(Font.ITALIC,40));
			x=texts.getTextCenterX(graphics, text)+150;
			graphics.drawString(text, x, y);
			graphics.drawImage(Image1, x-gp.titleSize-10,y-texts.getHeightText(graphics, text)/2 ,gp.titleSize,gp.titleSize/2, null);
		}else {
			graphics.setFont(graphics.getFont().deriveFont(Font.ITALIC,30));
			x=texts.getTextCenterX(graphics, text)+150;
			graphics.drawString(text, x, y);
		}
	}
}
