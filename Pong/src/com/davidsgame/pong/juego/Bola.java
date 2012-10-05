/**
 * 
 */
package com.davidsgame.pong.juego;


/**
 * @author David
 *
 */
public class Bola extends Elemento implements Elementomovimiento{
	public static final int DCHA_ARRIBA = 1;
	public static final int IZDA_ARRIBA = 2;
	public static final int IZDA_ABAJO = 3;
	public static final int DCHA_ABAJO = 4;
	private int direccion;

	public Bola(Coordenada origen, int ancho, int alto) {
		super(origen, ancho, alto);
		// TODO Auto-generated constructor stub
		direccion = 1;
		
	}

	public void move(int x, int y) {
		// TODO Auto-generated method stub
		switch (direccion) {
		case DCHA_ARRIBA:
			origen.setX(origen.getX() + x);
			origen.setY(origen.getY() - y);
			break;
		case IZDA_ARRIBA:
			origen.setX(origen.getX() - x);
			origen.setY(origen.getY() - y);
			break;
		case IZDA_ABAJO:
			origen.setX(origen.getX() - x);
			origen.setY(origen.getY() + y);
			break;
		case DCHA_ABAJO:
			origen.setX(origen.getX() + x);
			origen.setY(origen.getY() + y);
			break;

		default:
			break;
		}
	}

}
