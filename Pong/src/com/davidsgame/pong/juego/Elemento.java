/**
 * 
 */
package com.davidsgame.pong.juego;

import android.graphics.Rect;

/**
 * @author David
 *
 */
public abstract class Elemento {
	protected Coordenada origen;
	protected int ancho;
	protected int alto;
	/**
	 * @param origen
	 * @param ancho
	 * @param alto
	 */
	public Elemento(Coordenada origen, int ancho, int alto) {
		this.origen = origen;
		this.ancho = ancho;
		this.alto = alto;
	}
	/**
	 * @return the origen
	 */
	public Coordenada getOrigen() {
		return origen;
	}
	
	public int getOrigenX(){
		return origen.getX();
	}
	
	public int getOrigenY(){
		return origen.getY();
	}
	/**
	 * @param origen the origen to set
	 */
	public void setOrigen(Coordenada origen) {
		this.origen = origen;
	}
	
	public void setOrigenX(int x){
		origen.setX(x);
	}
	
	public void setOrigenY(int y){
		origen.setY(y);
	}
	/**
	 * @return the ancho
	 */
	public int getAncho() {
		return ancho;
	}
	/**
	 * @param ancho the ancho to set
	 */
	public void setAncho(int ancho) {
		this.ancho = ancho;
	}
	/**
	 * @return the alto
	 */
	public int getAlto() {
		return alto;
	}
	/**
	 * @param alto the alto to set
	 */
	public void setAlto(int alto) {
		this.alto = alto;
	}
	
	public Rect getRect(){
		return new Rect(getOrigenX(), getOrigenY(), getOrigenX()+ancho, getOrigenY()+alto);
	}
	
	public boolean puedoMover (int x, int y, Rect screen){
		return screen.contains(origen.getX()+x, origen.getY()+y, origen.getX()+ancho+x, origen.getY()+alto+y);
	}
	

}
