package com.davidsgame.pong.juego;

public class BolaMoveThread extends Thread{
	private Bola bola;
	private boolean run;
	private int speed;
	/**
	 * @param bola
	 */
	public BolaMoveThread(Bola bola) {
		this.bola = bola;
		this.run = false;
		this.speed = 1;
	}
	
	public void setRun(boolean run){
		this.run = run;
	}
	
	public void run(){
		while (run){
			try{
				Thread.sleep(10);
			}catch (InterruptedException e){
				e.printStackTrace();
			}
			bola.move(speed, speed);
		}
	}
}
