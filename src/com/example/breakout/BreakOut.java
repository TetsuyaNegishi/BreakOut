package com.example.breakout;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;

public class BreakOut extends android.view.View{
	private Paint paint = new Paint();
	private Player player;
	private Ball ball;
	private Block block;
	
	BreakOut(Context context){
		super(context);
		setBackgroundColor(Color.WHITE);
		//player = new Player(getWidth()/2, getHeight()*3/4);
		//ball = new Ball(getWidth()/2, getHeight()*3/4-player.height-Ball.radius);
		player = new Player(256, 600);
		ball = new Ball(256, 600-Player.height-20);
		block = new Block(256, 150);
	}
	
	@Override
	public void onDraw(Canvas canvas){
		paint.setColor(Color.RED);
		showPlayer(canvas);
		showBall(canvas);
		showBlock(canvas);
		moveObject();
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event){
		int action = event.getAction();
		int x = (int)event.getX();
		int y = (int)event.getY();
		switch(action & MotionEvent.ACTION_MASK){
		case MotionEvent.ACTION_DOWN:
			player.setX(x);
			break;
		case MotionEvent.ACTION_MOVE:
			int dx = x - player.getX();
			player.move(dx, 0);
			break;
		}
		return true;
	}
	
	void moveObject(){
		int dx = ball.getVX();
		int dy = ball.getVY();
		//ball.move(dx, dy);
		Collision();
		//ball.move(-dx, -dy);
		ball.ballMove(getWidth(), getHeight());		
	}
	
	void showPlayer(Canvas canvas){
		paint.setColor(Color.RED);
		canvas.drawRect(player.getX()-Player.width, player.getY()-Player.height, 
				player.getX()+Player.width, player.getY()+Player.height, paint);
	}
	
	void showBall(Canvas canvas){
		paint.setColor(Color.RED);
		canvas.drawCircle(ball.getX(), ball.getY(), Ball.radius, paint);
	}
	
	void showBlock(Canvas canvas){
		paint.setColor(Color.BLACK);
		canvas.drawRect(block.getX()-Block.size, block.getY()-Block.size, 
				block.getX()+Block.size, block.getY()+Block.size, paint);
		paint.setColor(Color.WHITE);
		paint.setTextSize(100);
		canvas.drawText(String.format("%d", block.getScore()), block.getX()-50, block.getY()+50, paint);
	}
	
	void Collision(){
		if( ((ball.getY()-Ball.radius) < player.getY()) &&
			((ball.getY()+Ball.radius) > player.getY()) &&
			( ball.getX() < player.getX()+Player.width) &&
			( ball.getX() > player.getX()-Player.width) )
			ball.playerLiflect(player.getX(), player.getY());

		if(	( ball.getX()+Ball.radius > block.getX()-Block.size) &&
			( ball.getX()-Ball.radius < block.getX()+Block.size) ){
			if(block.by == true){
				ball.setVX(-ball.getVX());
				block.scorePlus();
			}else
				block.bx = true;
		}else
			block.bx = false;
		
		if( ((ball.getY()+Ball.radius) > block.getY()-Block.size) &&
			((ball.getY()-Ball.radius) < block.getY()+Block.size) ){
			if(block.bx == true){
				ball.setVY(-ball.getVY());
				block.scorePlus();
			}else
				block.by = true;
				paint.setColor(Color.BLUE);
		}else
			block.by = false;
	}
}