package com.example.breakout;

public class Block extends Object{
	public static final int size = 100;
	private int score;
	boolean bx;
	boolean by;
	
	Block(int x, int y){
		super(x, y);
		score = 0;
		bx = false;
		by = false;
	}
	
	void scorePlus(){
		score++;
	}
	int getScore(){
		return score;
	}
}
