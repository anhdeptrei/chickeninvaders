package main;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class GameFrame extends JFrame{
	GamePanel gp;
	public GameFrame() {
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setTitle("Chicken Invaders");
		
		this.gp=new GamePanel(this);
		this.add(gp);
		this.pack();
		
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		gp.startGameThread();
	}
}
