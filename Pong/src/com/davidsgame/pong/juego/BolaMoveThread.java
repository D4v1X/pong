package com.davidsgame.pong.juego;

import android.graphics.Rect;

public class BolaMoveThread extends Thread {
	private Bola bola;
	private Barra barraIzq;
	private Barra barraDer;
	private Rect screen;

	private boolean run;
	private int speed;

	/**
	 * @param bola
	 * @param barraIzq
	 * @param barraDer
	 * @param screen
	 */
	public BolaMoveThread(Bola bola, Barra barraIzq, Barra barraDer, Rect screen) {
		this.bola = bola;
		this.barraIzq = barraIzq;
		this.barraDer = barraDer;
		this.screen = screen;
		this.run = false;
		this.speed = 1;
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
			if (!bola.puedoMover(speed, speed, screen, barraIzq.getRect(), barraDer.getRect()))
				bola.rebota(speed, speed, screen, barraIzq.getRect(), barraDer.getRect());
			bola.move(speed, speed);
		}
	}
}
