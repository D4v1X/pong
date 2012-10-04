package com.davidsgame.pong.pintar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class Pongview extends SurfaceView implements SurfaceHolder.Callback{
	
	Pongthread thread;

	public Pongview(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		getHolder().addCallback(this);
	}

	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		// TODO Auto-generated method stub
		
	}

	public void surfaceCreated(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		thread = new Pongthread(getHolder(), this);
		thread.setRun(true);
		thread.start();
	}

	public void surfaceDestroyed(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		boolean retry = true;
		thread.setRun(false);
		while (retry){
			try{
				thread.join();
				retry = false;
			} catch (InterruptedException e){
				
			}
		}
		
		
	}
	
	public void onDraw(Canvas canvas){
		canvas.drawColor(Color.YELLOW);
	}

}
