package com.davidsgame.pong.juego;

public class Marcador {
	public static final int MAX_PUNT = 9;
	
	private int puntosIzq;
	private int puntosDer;
	/**
	 * 
	 */
	public void iniciarMarcador() {
		this.puntosIzq = 0;
		this.puntosDer = 0;
	}
	
	public Marcador(int puntosIzq2, int puntosDer2){
		puntosIzq = puntosIzq2;
		puntosDer = puntosDer2;
	}

	/**
	 * @return the puntosIzq
	 */
	public int getPuntosIzq() {
		return puntosIzq;
	}

	/**
	 * @param puntosIzq the puntosIzq to set
	 */
	public void setPuntosIzq() {
		this.puntosIzq++;
	}

	/**
	 * @return the puntosDer
	 */
	public int getPuntosDer() {
		return puntosDer;
	}

	/**
	 * @param puntosDer the puntosDer to set
	 */
	public void setPuntosDer() {
		this.puntosDer++;
	}
	
	public boolean finpartida(){
		return puntosDer == MAX_PUNT || puntosIzq == MAX_PUNT;
	}
	
}
