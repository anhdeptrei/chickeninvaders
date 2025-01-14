package title;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class TitleScreen extends Title {
	GamePanel gp;
	TextInGame texts;
	Background bg;
	public TitleScreen(GamePanel gp , TextInGame texts,Background bg) {
		super();
		this.gp = gp;
		this.texts=texts;
		this.bg=bg;
		getImage();
	}
	public void getImage() {
		try {
			title = ImageIO.read(getClass().getResource("/Images/title.png"));
			arrow = ImageIO.read(getClass().getResource("/Images/arrow.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void draw(Graphics graphics) {
		bg.draw(graphics);
		int x=gp.titleSize/2;
		int y=100;
		BufferedImage Image = title;
		BufferedImage Image1 = arrow;
		graphics.drawImage(Image, x,y ,gp.screenWidth-gp.titleSize,gp.screenHeight/3, null);
		graphics.setColor(Color.WHITE);

		String text = "Start";
		y = texts.getTextCenterY(graphics, text);
		if(commandNum == 0) {
			graphics.setFont(graphics.getFont().deriveFont(Font.BOLD,40));
			x = texts.getTextCenterX(graphics, text);
			graphics.drawString(text, x, y);
			graphics.drawImage(Image1, x-gp.titleSize-10,y-texts.getHeightText(graphics, text)*4/7 ,gp.titleSize,gp.titleSize/2, null);
		}else {
			graphics.setFont(graphics.getFont().deriveFont(Font.BOLD,30));
			x = gp.screenWidth/2-texts.getWidthText(graphics, text)/2;
			graphics.drawString(text, x, y);
		}
		
		text = "Rule";
		y +=gp.titleSize;
		if(commandNum == 1) {
			graphics.setFont(graphics.getFont().deriveFont(Font.BOLD,40));
			x = texts.getTextCenterX(graphics,text);
			graphics.drawString(text, x, y);
			graphics.drawImage(Image1, x-gp.titleSize-10,y-texts.getHeightText(graphics, text)*4/7 ,gp.titleSize,gp.titleSize/2, null);
		}else {
			graphics.setFont(graphics.getFont().deriveFont(Font.BOLD,30));
			x = texts.getTextCenterX(graphics,text);
			graphics.drawString(text, x, y);
		}
		
		text = "Quit";
		y +=gp.titleSize;
		if(commandNum == 2) {
			graphics.setFont(graphics.getFont().deriveFont(Font.BOLD,40));
			x = texts.getTextCenterX(graphics,text);
			graphics.drawString(text, x, y);
			graphics.drawImage(Image1, x-gp.titleSize-10,y-texts.getHeightText(graphics, text)*4/7 ,gp.titleSize,gp.titleSize/2, null);
		}else {
			graphics.setFont(graphics.getFont().deriveFont(Font.BOLD,30));
			x = texts.getTextCenterX(graphics,text);
			graphics.drawString(text, x, y);
		}
	}
}
