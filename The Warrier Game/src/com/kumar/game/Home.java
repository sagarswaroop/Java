package com.kumar.game;

import javax.swing.ImageIcon;

import com.kumar.utils.GameUtill;

public class Home extends Spirit{
	protected Home(int x,int y,int h) {
		this.x = x;
		this.y = y;
		this.h = h;
		this.w = this.h;
		image = new ImageIcon(Home.class.getResource(HOME)).getImage();
//		System.out.println("home class is calling");
	}
	
	
	
	
	
	
	

}
