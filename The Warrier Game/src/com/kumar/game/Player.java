package com.kumar.game;

import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Player extends Spirit {
	
	private boolean isJump;
	private int force;
	
	// step1:- create player with this class
	private ArrayList<Bullets> bullets = new ArrayList<>();
	public Player(int x, int y) {
		this.x = x;
		this.y = y;
		this.w = this.h =100;
		this.speed =0;
		this.isVisibile = true;
		//step2:- getting image of player from this code.
		image = new ImageIcon(Player.class.getResource(PLAYER)).getImage();
	}
	
	public void jump() {
		if(!isJump) {
			this.force = -150;
			this.x+= GRAVITY+1;
			this.y+= force+GRAVITY;
			isJump = true;
		}
	}
	
	public void fall() {
		if(y<FLOOR) {
			this.x+=GRAVITY+1;
			this.force= GRAVITY+1;
			this.y+= force;
		}
		else if(y>=FLOOR) {
			this.y = FLOOR;
			isJump = false;
		}
	}
	
	public ArrayList<Bullets> getBullets() {
		return bullets;
	}

	public void setBullets(ArrayList<Bullets> bullets) {
		this.bullets = bullets;
	}

	public void move() {
		x+=speed;
		if(x<=100) {
		x = 100;
		}
		else 
		if(x>=FRAME_WIDTH-100) {
			x-=speed;
		}
	}
	
	public void fire() {
//		System.out.println("bullets fire...");
		Bullets bullet = new Bullets(this.getX()+(this.getW()/2),this.getY()+(this.getH()/2));
		bullets.add(bullet);
		
	}
	
	public void check() {
		System.out.println(" value of x is "+this.x);
		System.out.println("x"+this.getX());
		
		System.out.println("width is "+w);
		System.out.println("w is "+this.getW()/2);
	}
	
//	public static void main(String[] args) {
//		Player player= new Player(300,400);
//		
//		//System.out.println(" widht is"+player.getW());
//		player.check();
//	}
}
