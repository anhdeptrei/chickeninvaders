package main;

import java.util.List;

import entity.Chicken;
import entity.Player;
import entity.Shot;

public class CollisionChecker {
	GamePanel gp;
	List<Chicken> chicken;
	Player player;
	List<Shot> shot;
	public int score = 0;
	public CollisionChecker(GamePanel gp,List<Chicken> chicken,Player player,List<Shot> shot) {
		this.gp = gp;
		this.chicken=chicken;
		this.player=player;
		this.shot=shot;
		checkChicken();
		checkPlayer();
	}
	public void checkChicken() { 
		for (int i = 0; i < shot.size(); i++) {
			for (int j = 0; j < chicken.size(); j++) {
				if (shot.get(i).x >= chicken.get(j).x
						&& shot.get(i).x <= chicken.get(j).x + gp.titleSize 
						&& shot.get(i).y <= chicken.get(j).y +100
						&& shot.get(i).y >= chicken.get(j).y + gp.titleSize
						&& !shot.get(i).isShoot 
						&& !chicken.get(j).isShoot) {
					chicken.get(j).isShoot=true;
					shot.get(i).isShoot=true;
					score++;
				}
			}
		}
	}
	public void checkPlayer() {
		for(int i=0;i<chicken.size();i++)
		{
			if(player.x>=chicken.get(i).x
					&& player.x <= chicken.get(i).x+gp.titleSize 
					&& player.y >= chicken.get(i).y
					&& player.y <= chicken.get(i).y+ gp.titleSize
					&& !chicken.get(i).isShoot) {
				player.collision = true;
				chicken.get(i).isShoot=true;
				player.life--;
			}
		}
	}
}
