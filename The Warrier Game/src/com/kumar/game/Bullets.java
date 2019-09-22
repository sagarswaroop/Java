package com.kumar.game;

import java.awt.Color;
import java.awt.Graphics;

public class Bullets extends Spirit{
	
	public Bullets(int x, int y) {
		this.x = x;
		this.y = y;
		this.h = this.w = 25;
		this.speed = 15;
		this.isVisibile = true;
	}
	
	@Override
	public void draw(Graphics g) {
//		System.out.println("bullets drawing....");
		g.setColor(Color.WHITE);
		g.fillOval(x, y, w, h);
		move();
		outOfFrame();
		
	}
	
	private void move() {
		this.x+=this.speed;
//		System.out.println(" value of x"+this.x);
		outOfFrame();
	}
	
	private void outOfFrame(){
//		System.out.println("bulllet class 1 st is visible is"+isVisibile);
		if(this.x>=FRAME_WIDTH) {
			isVisibile=false;
//			System.out.println("bullet class 2nd new isvisible is "+isVisibile);
			
		}
	}
	
	public void check() {
		System.out.println(" is visible is "+ isVisibile);
	}
	

}
