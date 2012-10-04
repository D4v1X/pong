package com.davidsgame.pong.pintar;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class Pongthread extends Thread{
	private SurfaceHolder sh;
	private Pongview view;
	private boolean run;
	
	public Pongthread(SurfaceHolder sh, Pongview view) {
		this.sh = sh;
		this.view = view;
		this.run = false;
	}
	
	/**
	 * @param run the run to set
	 */
	public void setRun(boolean run) {
		this.run = run;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Canvas canvas;
		while(run){
			canvas = null;
			try{
				canvas = sh.lockCanvas(null);
				synchronized (sh) {
					view.onDraw(canvas);
				}
			}finally{
				if(canvas != null)
					sh.unlockCanvasAndPost(canvas);
			}
		}
	}




}
