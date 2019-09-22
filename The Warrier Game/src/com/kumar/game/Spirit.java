package com.kumar.game;

import java.awt.Graphics;
import java.awt.Image;

import com.kumar.utils.GameUtill;
// common class for players such as enemies, player.
public class Spirit implements GameUtill{
	public Spirit() {};
	protected int x;
	protected int y;
	protected int w;
	protected int h;
	protected Image image;
	protected int speed;
	protected boolean isVisibile;
	
	public Spirit(int x, int y, int w, Image image) {
		this.x = x;
		this.y = y;
		this.h= this.w = w;
		this.image = image;
		this.speed = 0;
	}
	
	public boolean isVisibile() {
		return isVisibile;
	}
	public void setVisibile(boolean isVisibile) {
		this.isVisibile = isVisibile;
	}
	// create getter setter to update them according to requirements.
	public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
		this.image = image;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getW() {
		return w;
	}
	public void setW(int w) {
		this.w = w;
	}
	public int getH() {
		return h;
	}
	public void setH(int h) {
		this.h = h;
	}
	
	public void draw(Graphics g) {
		g.drawImage(image, x, y, w, h, null);
	}
	
}
