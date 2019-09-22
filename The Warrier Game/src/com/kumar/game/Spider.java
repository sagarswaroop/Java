	package com.kumar.game;

import javax.swing.ImageIcon;

public class Spider extends Spirit{
	
	boolean fall = false;
	int force = GRAVITY;
	
	// step 1:- crating enemies(spiders) by this class.
	protected Spider(int x, int y, String ImageName, int speed) {
		this.x = x;
		this.y = y;
		this.h = this.w = 100;
		this.speed = speed;
		
		// step 2:- there are multiple enemies. so, image name variable where is the all images are stored.
		this.image = new ImageIcon(Spider.class.getResource(ImageName)).getImage();
//		System.out.println("spider class invoking...");
		this.isVisibile = true;
	}
	
	protected void move() {
		if(!fall) {
			y+= speed;
			changdirection();	
		}
		
	}
	
	protected void changdirection() {
		if(y>=FLOOR) {
			speed = speed *-1;
		}
		
		if(y<=40) {
			speed = speed* -1;
		}
	}
	
	protected void fall() {
		speed = 0;
		fall = true;
		if(y<=FRAME_HEIGHT+200) {
			y+= force;
			force+= GRAVITY+2;
		}
		
		if(y>FRAME_HEIGHT+200) {
			isVisibile = false;
		}
		
	}

}
