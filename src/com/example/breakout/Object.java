package com.example.breakout;

public class Object {
	private int x, y;
	
	Object(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public void setX(int x){
		this.x = x;
	}
	public void setY(int y){
		this.y = y;
	}
	public void move(int dx, int dy){
		this.x += dx;
		this.y += dy;
	}
}
