package com.davidsgame.pong.juego;

import com.davidsgame.pong.R;
import com.davidsgame.pong.opciones.PongOpciones;

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
	
	private Marcador marcador;
	private boolean punto;
	private int bolaInitX;
	private int bolaInitY;

	/**
	 * @param bola
	 * @param barraIzq
	 * @param barraDer
	 * @param screen
	 */
	public BolaMoveThread(Bola bola, Barra barraIzq, Barra barraDer, Rect screen, Context context, Marcador marcador) {
		this.bola = bola;
		this.barraIzq = barraIzq;
		this.barraDer = barraDer;
		this.screen = screen;
		this.run = false;
		this.speed = 1;
		this.v = (Vibrator)context.getSystemService(Context.VIBRATOR_SERVICE);
		this.mp = MediaPlayer.create(context, R.raw.pong);
		this.marcador = marcador;
		this.punto = false;
		this.bolaInitX = bola.getOrigenX();
		this.bolaInitY = bola.getOrigenY();
	}

	public void setRun(boolean run) {
		this.run = run;
	}
	
	public void reiniciarBola(){
		bola.setOrigenX(bolaInitX);
		bola.setOrigenY(bolaInitY);
	}

	public void run() {
		while (run) {
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(punto) {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if(!marcador.finpartida()) {
					punto = false;
				}
				continue;
			}
			if(!bola.puedoMover(speed, speed, screen,
					barraIzq.getRect(), barraDer.getRect())) {
				switch(bola.rebota(speed, speed, screen,
						barraIzq.getRect(), barraDer.getRect())) {
				case 0:
					if(PongOpciones.getInstance().soundEnabled())
						mp.start();
					if(bola.puedoMover(speed, speed, screen) &&
							PongOpciones.getInstance().vibrationEnabled())
							v.vibrate(50);
					break;
				case -1:
					marcador.setPuntosDer();
					reiniciarBola();
					punto = true;
					break;
				case 1:
					marcador.setPuntosIzq();
					reiniciarBola();
					punto = true;
					break;
				}
			}	
			bola.move(speed, speed);
		}
	}
}
