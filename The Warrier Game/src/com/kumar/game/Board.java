package com.kumar.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

import com.kumar.utils.GameUtill;

import jaco.mp3.player.MP3Player;

public class Board extends JPanel implements GameUtill {
	Player player;
	Timer timer;
	MP3Player bgmusic;
	MP3Player pdie;
	MP3Player jump;
	MP3Player fire;
	MP3Player sfall;
	Home home;
	
	ArrayList<Spider> spiders = new ArrayList<>();

	public Board() {
		setFocusable(true);
		bindEvents();
		setSize(FRAME_WIDTH,FRAME_HEIGHT);
		player = new Player(100,FLOOR);
		home = new Home(800,350,250);
		
		spiderload();
		gameloop();
		mp3();
	}
	
	private void bulletsdraw(Graphics g) {
		
		for(Bullets bullet : player.getBullets()) {
			if(bullet.isVisibile()) {
				bullet.draw(g);
			}
		}
	}
	
	private void fall() {
		for(Spider spider: spiders) {
			if(spider.fall) {
				spider.fall();
			}
		}
	}
	
	private void spiderKill() {
		for(Bullets bullet : player.getBullets()) {
			for(Spider spider: spiders) {
				if(isCollide(spider, bullet)){
					spider.fall();
					sfall.play();
				}
			}
		}
	}
	
	private void mp3() {
		bgmusic = new MP3Player(Board.class.getResource(BGMUSIC));
		pdie = new MP3Player(Board.class.getResource(P_DIE));
		jump = new MP3Player(Board.class.getResource(JUMP));
		fire = new MP3Player(Board.class.getResource(FIRE));
		sfall = new MP3Player(Board.class.getResource(SFALL));
		bgmusic.play();
	}
	
	private void gameOver(Graphics g, String message) {
		g.setColor(Color.RED);
		g.setFont(new Font("Arial", Font.BOLD, 40));
		g.drawString(message, (FRAME_WIDTH/2)/2+50, (FRAME_HEIGHT/2));
		timer.stop();
		
	}
	
	private boolean isCollide(Spirit player, Spirit sprite) {
		int xDistance = Math.abs(player.getX() - sprite.getX());
		int yDistance = Math.abs(player.getY() - sprite.getY());
		int width = Math.max(player.getW(), sprite.getW());
		int height = Math.max(player.getH(), sprite.getH());
		return xDistance<=(width-40) && yDistance<=(height-19);
	}

	private void bindEvents() {
		
		this.addKeyListener(new KeyAdapter() {
			
		
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				player.setSpeed(0);
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
				player.setSpeed(4);
				}
				
				if(e.getKeyCode()==KeyEvent.VK_LEFT) {
					player.setSpeed(-4);
					}
				// TODO Auto-generated method stub
				if(e.getKeyCode()==KeyEvent.VK_UP) {
					player.jump();
					jump.play();
				}
				if(e.getKeyCode()==KeyEvent.VK_SPACE) {
					player.fire();
					fire.play();
				}
	
				
			}
		});
	}
	
	private void gameloop() {
	timer = new Timer(DELAY,(e)->{
			repaint();
			});
		timer.start();
			
		
	}
	private int timeLeft = TIME_LEFT;
	int mydelay = 1;
	
	private void drawTime(Graphics g) {	
		if(mydelay==60) {
			
			timeLeft--;
			mydelay = 0;
		}
		
		if(timeLeft==0) {
			gameOver(g, "GAME OVER TIME IS UP");
		}
		
		g.setColor(Color.RED);
		g.setFont(new Font("Arial",Font.BOLD,32));
		g.drawString(String.valueOf(timeLeft), FRAME_WIDTH-80, 30);
		mydelay++;
	}
	
	private void spiderload() {
		int x = 250;
		int y = 50;
		int speed = 1;
		String image_name = "";
		for(int i=1; i<=MAX_SPIDERS; i++) {
			if(i==1) {
				image_name = SPIDER;
			}
			if(i==2) {
				image_name = SPIDER2;
			}
			else {
				image_name = SPIDER3;
			}
		Spider spider = new Spider(x,y,image_name, speed);
		spiders.add(spider);
		speed+=1;
		x+=SPIDER_WIDTH;
	
		
		}
	}
	
	
	private void spiderdraw(Graphics g) {
		for(Spider spider: spiders){
			spider.draw(g);
			spider.move();
		}
	}
	
	private void drawBackGround(Graphics g) {
		ImageIcon icon = new ImageIcon(Board.class.getResource(GAMEBG));
		g.drawImage(icon.getImage(), 0, 0, FRAME_WIDTH, FRAME_HEIGHT, null);
		
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g); // clean board.
		drawBackGround(g); // draw new background.
		player.draw(g);// step 4:- call draw method with crating object of player.
		player.move();
		home.draw(g);
		spiderdraw(g);
		drawTime(g);
		for(Spider spider: spiders) {
		if(isCollide(player, spider)){
			gameOver(g, "SPIDERS BITTEN");
			bgmusic.stop();
			pdie.play();
			jump.stop();
		}
		}
		bulletsdraw(g);
		spiderKill();
		fall();
		player.fall();
		if(isCollide(player,home)){
			gameOver(g, "          You Win...   ");
			bgmusic.stop();
			pdie.play();
			jump.stop();
		}
		
	}

}

