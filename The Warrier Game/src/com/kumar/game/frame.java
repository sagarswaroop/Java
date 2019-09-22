package com.kumar.game;

import javax.swing.JFrame;

import com.kumar.utils.GameUtill;

public class frame extends JFrame implements GameUtill{
	public frame() {
		setSize(FRAME_WIDTH,FRAME_HEIGHT);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setTitle(TITLE);
		Board board = new Board();
		this.add(board);
		setVisible(true);
	}
	
	public static void main(String[] args) {
	// TODO Auto-generated method stub
		new frame();
	}

}
