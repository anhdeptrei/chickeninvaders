package main;

import java.awt.Desktop;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;

public class KeyHandler implements KeyListener {
	public boolean upPressed; 
	public boolean downPressed;
	public boolean leftPressed;
	public boolean rightPressed;
	GamePanel gp;

	public KeyHandler(GamePanel gp) {
		this.gp = gp;
	}

	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		//TITLE STAGE
		if(gp.gameStage == gp.titleStage) {
			if (code == KeyEvent.VK_W) {
				gp.screen.commandNum--;
				if(gp.screen.commandNum <0)
					gp.screen.commandNum=2;
			}
			if (code == KeyEvent.VK_S) {
				gp.screen.commandNum++;
				if(gp.screen.commandNum >2)
					gp.screen.commandNum=0;
			}
			if (code == KeyEvent.VK_UP) {
				gp.screen.commandNum--;
				if(gp.screen.commandNum <0)
					gp.screen.commandNum=2;
			}
			if (code == KeyEvent.VK_DOWN) {
				gp.screen.commandNum++;
				if(gp.screen.commandNum >2)
					gp.screen.commandNum=0;
			}
			if (code == KeyEvent.VK_ENTER) {
				if (gp.screen.commandNum == 0) {
					gp.gameStage = gp.playStage;
				}
				if(gp.screen.commandNum == 1) {
					try {
						File open = new File("./res/Images/rule.txt");
						if(!Desktop.isDesktopSupported()) {
							System.out.println("Desktop Support Not Present in the system.");
							return;
						}
						Desktop destop = Desktop.getDesktop();
						if(open.exists()) {
							destop.open(open);
						}
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				if(gp.screen.commandNum == 2) {
					System.exit(0);
				}
			}
					
			}
		//PLAY STAGE
		if(gp.gameStage == gp.playStage) {
			if (code == KeyEvent.VK_W) {
				upPressed = true;
			}
			if (code == KeyEvent.VK_S) {
				downPressed = true;
			}
			if (code == KeyEvent.VK_A) {
				leftPressed = true;
			}
			if (code == KeyEvent.VK_D) {
				rightPressed = true;
			}
			if (code == KeyEvent.VK_UP) {
				upPressed = true;
			}
			if (code == KeyEvent.VK_DOWN) {
				downPressed = true;
			}
			if (code == KeyEvent.VK_LEFT) {
				leftPressed = true;
			}
			if (code == KeyEvent.VK_RIGHT) {
				rightPressed = true;
			}
			if (code == KeyEvent.VK_ESCAPE) {
				gp.gameStage = gp.pauseStage;
			}
		} else if(gp.gameStage == gp.pauseStage) {
			if (code == KeyEvent.VK_ESCAPE) {
				gp.gameStage = gp.playStage;
			}
		}
		if(gp.gameStage == gp.gameoverStage) {
			if (code == KeyEvent.VK_A) {
				gp.gameover.commandNum--;
				if(gp.gameover.commandNum <0)
					gp.gameover.commandNum=1;
			}
			if (code == KeyEvent.VK_D) {
				gp.gameover.commandNum++;
				if(gp.gameover.commandNum >1)
					gp.gameover.commandNum=0;
			}
			if (code == KeyEvent.VK_LEFT) {
				gp.gameover.commandNum--;
				if(gp.gameover.commandNum <0)
					gp.gameover.commandNum=1;
			}
			if (code == KeyEvent.VK_RIGHT) {
				gp.gameover.commandNum++;
				if(gp.gameover.commandNum >1)
					gp.gameover.commandNum=0;
			}
			if (code == KeyEvent.VK_ENTER) {
				if (gp.gameover.commandNum == 0) {
					new GameFrame();
					gp.jf.dispose();
				}
				if(gp.gameover.commandNum == 1) {
					System.exit(0);
				}
			}
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		int code = e.getKeyCode();

		if (code == KeyEvent.VK_W) {
			upPressed =  false;
		}
		if (code == KeyEvent.VK_S) {
			downPressed = false;
		}
		if (code == KeyEvent.VK_A) {
			leftPressed = false;
		}
		if (code == KeyEvent.VK_D) {
			rightPressed = false;
		}
		if (code == KeyEvent.VK_UP) {
			upPressed = false;
		}
		if (code == KeyEvent.VK_DOWN) {
			downPressed = false;
		}
		if (code == KeyEvent.VK_LEFT) {
			leftPressed = false;
		}
		if (code == KeyEvent.VK_RIGHT) {
			rightPressed = false;
		}
	}

}
