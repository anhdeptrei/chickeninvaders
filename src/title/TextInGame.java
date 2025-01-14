package title;

import java.awt.Graphics;

import main.GamePanel;

public class TextInGame extends Title {
	GamePanel gp;
	int textWidth =0;
	public TextInGame(GamePanel gp) {
		super();
		this.gp = gp;
	}
	public int getWidthText(Graphics g,String text) {
		textWidth = (int)g.getFontMetrics().getStringBounds(text, g).getWidth();
		return textWidth;
	}
	public int getHeightText(Graphics g,String text) {
		return (int)g.getFontMetrics().getStringBounds(text, g).getHeight();
	}
	public int getTextCenterX(Graphics g,String text) {
		return gp.screenWidth/2-getWidthText(g, text)/2;
	}
	public int getTextCenterY(Graphics g,String text) {
		return gp.screenHeight/2+getHeightText(g, text)/2;
	}
}
