/**
 * 
 */
package com.davidsgame.pong.juego;

import android.graphics.Rect;

/**
 * @author David
 *
 */
public class BarraMoveThread extends Thread{
	private Barra barra;
	private Rect screen;
	private Acelerometro acelerometro;
	
	private Integer xInit = null;
	private final int UMBRAL = 10;
	
	private boolean run;

	/**
	 * @param barra
	 * @param screen
	 * @param acelerometro
	 */
	public BarraMoveThread(Barra barra, Rect screen, Acelerometro acelerometro) {
		this.barra = barra;
		this.screen = screen;
		this.acelerometro = acelerometro;
	}


	public void setRun(boolean run){
		this.run = run;
	}
	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		if(xInit == null){
			xInit = acelerometro.getInclination();
		}
		while(run){
			try{
				if(Math.abs(xInit - acelerometro.getInclination()) < 200){
					Thread.sleep(5);
				}else{
					Thread.sleep(2);
				}
				//Thread.sleep(10);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			if(xInit < acelerometro.getInclination() - UMBRAL ||
					xInit < acelerometro.getInclination() + UMBRAL){
				if(barra.puedoMover(0, 1, screen)){
					barra.move(0, 1);
				}
			}
			if(xInit > acelerometro.getInclination() - UMBRAL ||
					xInit > acelerometro.getInclination() + UMBRAL){
				if(barra.puedoMover(0, -1, screen)){
					barra.move(0, -1);
				}
			}
		}
	}
	
	
}
