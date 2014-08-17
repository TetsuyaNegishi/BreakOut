package com.example.breakout;

import java.util.Timer;
import java.util.TimerTask;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

public class MainActivity extends ActionBarActivity {
	private Handler handler = new Handler();
	View view;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		view = new BreakOut(this);
		setContentView(view);
		
		Timer timer = new Timer(false);
		
		timer.schedule(new TimerTask(){
			public void run(){
				handler.post(new Runnable(){
					public void run(){
						view.invalidate();
					}
				});
			}
		}, 0, 30);
	}

}
