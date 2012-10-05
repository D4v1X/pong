/**
 * 
 */
package com.davidsgame.pong.juego;

/**
 * @author David
 *
 */
public class Barra extends Elemento implements Elementomovimiento{

	public Barra(Coordenada origen, int ancho, int alto) {
		super(origen, ancho, alto);
		// TODO Auto-generated constructor stub
	}

	public void move(int x, int y) {
		// TODO Auto-generated method stub
		origen.setY(origen.getY()+y);
	}

}
