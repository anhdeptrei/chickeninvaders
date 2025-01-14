package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import entity.Chicken;
import entity.Heart;
import entity.Player;
import entity.Shot;
import title.Background;
import title.Gameover;
import title.TextInGame;
import title.TitleScreen;

public class GamePanel extends JPanel implements Runnable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// SCREEN SETTING
	public final int originalTileSize = 16;// 16x16 title
	public final int scale = 3;

	public final int titleSize = originalTileSize * scale;// 48x48
	public final int maxScreenCol = 16;
	public final int maxScreenRow = 12;
	public final int screenWidth = titleSize * maxScreenCol;// 768px
	public final int screenHeight = titleSize * maxScreenRow;// 576px
	//GameStage
	public int gameStage;
	public final int playStage = 1;
	public final int pauseStage = 2;
	public final int titleStage = 0;
	public final int gameoverStage = 3;
	int FPS = 60;
	Thread gameThread;
	KeyHandler keyH = new KeyHandler(this);
	Background background = new Background(this);
	TextInGame texts = new TextInGame(this);
	Gameover gameover = new Gameover(this, texts);
	public Player player = new Player(this, keyH);
	public List<Chicken> chickens = new ArrayList<Chicken>();

	public void addChicken() {
		if(gameStage==playStage) {
			Chicken s = new Chicken(this);
			chickens.add(s);
		}
	}

	public List<Shot> shots = new ArrayList<Shot>();

	public void addShot() {
		if(gameStage==playStage) {
			Shot s = new Shot(this, player);
			shots.add(s);
		}
	}

	public CollisionChecker cCheck = new CollisionChecker(this, chickens, player, shots);
	Heart heart = new Heart(this);
    TitleScreen screen = new TitleScreen(this,texts ,background);
	public GameFrame jf;
		
	// constructer
	public GamePanel(GameFrame jf) {
		this.gameStage = this.titleStage;
		this.jf=jf;
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.setFocusable(true);
	}
	
	
	
	
	
	
	// game loop
	public void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();
	}
	@Override
	public void run() {
		double drawInterval = 1000000000 / FPS;

		double delta = 0;
		double delta2 = 0;
		double delta3 = 0;

		long lastTime = System.nanoTime();
		long lastTime2 = System.nanoTime();
		long lastTime3 = System.nanoTime();

		long currentTime;
		long currentTime2;
		long currentTime3;
		while (gameThread != null) {
			currentTime = System.nanoTime();
			currentTime2 = System.nanoTime();
			currentTime3 = System.nanoTime();

			delta += (currentTime - lastTime) / drawInterval;
			delta2 += (currentTime2 - lastTime2) / drawInterval;
			delta3 += (currentTime3 - lastTime3) / drawInterval;

			lastTime = currentTime;
			lastTime2 = currentTime2;
			lastTime3 = currentTime3;
			if (delta >= 1) {
				// 1.UPDATE
				update();
				// 2.DRAW
				repaint();
				delta--;
			}
			if (delta2 >= 15) {
				addShot();
				delta2 -= 15;
			}
			if (delta3 >= 30) {
				addChicken();
				delta3 -= 30;
			}
		}
}
	public void update() {
			if(gameStage == pauseStage) {
				
			}else if(gameStage == playStage) {
				player.update();
				if (shots.size() > 0) {
					for (int i = 0; i < shots.size(); i++) {
						if (shots.get(i).y <= 0) {
							shots.remove(i);
						}	 else {
							shots.get(i).update();
						}
					}
				}
				if (chickens.size() > 0) {
					for (int i = 0; i < chickens.size(); i++) {
						if (chickens.get(i).y > screenHeight) {
							if (!chickens.get(i).isShoot)
								player.life--;
							chickens.remove(i);
						} else {
							chickens.get(i).update();
						}
					}
				}
				// Collision Check
				cCheck.checkChicken();
				cCheck.checkPlayer();
				if (player.life == 0) {
					gameStage = gameoverStage;
				}
			}
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		if(gameStage == titleStage) {
			screen.draw(g);
		}else {
			// draw background
			background.draw(g2);
			// draw player
			player.draw(g2);
			// draw shot
			for (int i = 0; i < shots.size(); i++) {
				if (!shots.get(i).isShoot)
					shots.get(i).draw(g2);
			}
			// draw chicken
			for (int i = 0; i < chickens.size(); i++) {
				if (!chickens.get(i).isShoot)
					chickens.get(i).draw(g2);
			}
			// draw Point
			g2.setFont(getFont().deriveFont(Font.ITALIC,30));
			g2.setColor(Color.white);
			String text = "Score : " + (cCheck.score);
			int x = screenWidth-texts.getWidthText(g2,text)-titleSize/2;
			int y = titleSize+texts.getHeightText(g2, text)/2;
			g2.drawString(text, x, y);
			// draw heart
			heart.draw(g2);
			if(gameStage == pauseStage) {
				drawPauseScreen(g2);
			}
			if(gameStage == gameoverStage) {
				gameover.draw(g);
			}
			g2.dispose();
		}
	}
	public void drawPauseScreen(Graphics2D g2) {
		g2.setFont(getFont().deriveFont(Font.PLAIN,30));
		String text = "Pause";
		int x = texts.getTextCenterX(g2, text);
		int y = screenHeight/2;
		g2.drawString(text, x, y);
	}
}
	
