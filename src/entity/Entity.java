package entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Entity {
	public int x,y;
	public int speed;
	public int maxLife;
	public int life;
	public boolean isShoot = false;
	public BufferedImage plane;
	public BufferedImage shotImage;
	public BufferedImage chickenImage;
	public BufferedImage Heart1;
	public BufferedImage Heart2;
	public BufferedImage Heart3;
	public boolean collision = false;
	public Rectangle solidArea;
	public boolean collisionOn = false;
}
