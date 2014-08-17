package com.example.breakout;

import java.lang.Math;

public class Ball extends Object{
	public static final int radius = 10;
	private int vx,vy;
	
	Ball(int x, int y){
		super(x,y);
		vx = 10;
		vy = -10;
	}
	
	void ballMove(int fieldWidth, int fieldHeight){
		/*
		int dx = vx;
		int dy = vy;
		move(dx,dy);
		*/
		/* ¶’[‚É—ˆ‚½‚ç”½“] */
		if (getX() < 0 + radius ) {
            setVX(-vx);
        }
        /* ‰E’[‚É—ˆ‚½‚ç”½“] */
        if (getX() > fieldWidth - radius) {
            setVX(-vx);
        }
        /* ã’[‚É—ˆ‚½‚ç”½“] */
        if (getY() < 0 + radius) {
            setVY(-vy);
        }
        //move(-dx,-dy);
		move(vx,vy);
	}
	
	void setVX(int vx){
		this.vx = vx;
	}
	void setVY(int vy){
		this.vy = vy;
	}
	int getVX(){
		return vx;
	}
	int getVY(){
		return vy;
	}
	void playerLiflect(int px, int py){
		setVY(-getVY());
		/*
		double vSize = Math.sqrt(getX()*getX() + getY()*getY());
		double sita = ((double)px - getX()) * Math.PI/2 /Player.width  + Math.PI/2;
		setVX((int)(vSize * Math.sin(sita)));
		setVY((int)(vSize * Math.cos(sita)));
		*/
	}
}
