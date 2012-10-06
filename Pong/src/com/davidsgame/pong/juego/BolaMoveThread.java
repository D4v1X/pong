package com.davidsgame.pong.juego;

import com.davidsgame.pong.R;

import android.content.Context;
import android.graphics.Rect;
import android.media.MediaPlayer;
import android.os.Vibrator;

public class BolaMoveThread extends Thread {
	private Bola bola;
	private Barra barraIzq;
	private Barra barraDer;
	private Rect screen;

	private boolean run;
	private int speed;
	
	private Vibrator v = null;
	private MediaPlayer mp;

	/**
	 * @param bola
	 * @param barraIzq
	 * @param barraDer
	 * @param screen
	 */
	public BolaMoveThread(Bola bola, Barra barraIzq, Barra barraDer, Rect screen, Context context) {
		this.bola = bola;
		this.barraIzq = barraIzq;
		this.barraDer = barraDer;
		this.screen = screen;
		this.run = false;
		this.speed = 1;
		this.v = (Vibrator)context.getSystemService(Context.VIBRATOR_SERVICE);
		this.mp = MediaPlayer.create(context, R.raw.pong);
	}

	public void setRun(boolean run) {
		this.run = run;
	}

	public void run() {
		while (run) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (!bola.puedoMover(speed, speed, screen, barraIzq.getRect(), barraDer.getRect())){
				mp.start();
				bola.rebota(speed, speed, screen, barraIzq.getRect(), barraDer.getRect());
				if(bola.puedoMover(speed, speed, screen)){
					v.vibrate(50);
				}
			}
				
			bola.move(speed, speed);
		}
	}
}
