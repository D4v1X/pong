/**
 * 
 */
package com.davidsgame.pong.juego;

import android.graphics.Rect;

/**
 * @author David
 */
public class Bola extends Elemento implements Elementomovimiento {
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

	public boolean puedoMover(int x, int y, Rect screen, Rect barraIzq,
			Rect barraDer) {
		if (!puedoMover(x, y, screen)) {
			return false;
		}
		if (chocaraCon(x, y, barraIzq)) {
			return false;
		}
		if (chocaraCon(x, y, barraDer)) {
			return false;
		}
		return true;
	}

	private boolean chocaraCon(int x, int y, Rect barra) {
		// TODO Auto-generated method stub
		if (barra.contains(origen.getX() + x, origen.getY() + y))
			return true;
		if (barra.contains(origen.getX() + x + ancho, origen.getY() + y))
			return true;
		if (barra.contains(origen.getX() + x, origen.getY() + y + alto))
			return true;
		if (barra.contains(origen.getX() + x + ancho, origen.getY() + y + alto))
			return true;
		return false;
	}

	public int rebota(int x, int y, Rect screen, Rect barraIzq, Rect barraDer) {
		if (!puedoMover(x, y, screen)) {
			switch (direccion) {
			case DCHA_ARRIBA:
				if (origen.getY() - y <= screen.top)
					direccion = DCHA_ABAJO;
				else
					return 1;
				break;
			case IZDA_ARRIBA:
				if (origen.getY() - y <= screen.top)
					direccion = IZDA_ABAJO;
				else
					return -1;
				break;
			case IZDA_ABAJO:
				if (origen.getY() + alto + y >= screen.bottom)
					direccion = IZDA_ARRIBA;
				else
					return -1;
				break;
			case DCHA_ABAJO:
				if (origen.getY() + alto + y >= screen.bottom)
					direccion = DCHA_ARRIBA;
				else
					return 1;
				break;
			}
		}
		Rect barra = null;
		if(chocaraCon(x, y, barraIzq))
			barra = barraIzq;
		if(chocaraCon(x, y, barraDer))
			barra = barraDer;
		if(barra != null) {
			switch(direccion) {
			case DCHA_ARRIBA:
				direccion = (origen.getX()+ancho < barra.left) ?
						 IZDA_ARRIBA : DCHA_ABAJO;
				break;
			case IZDA_ARRIBA:
				direccion = (origen.getX() > barra.right) ?
						DCHA_ARRIBA : IZDA_ABAJO;
				break;
			case IZDA_ABAJO:
				direccion = (origen.getX() > barra.right) ?
						IZDA_ARRIBA : DCHA_ABAJO;
				break;
			case DCHA_ABAJO:
				direccion = (origen.getX()+ancho < barra.left) ?
						IZDA_ABAJO : DCHA_ARRIBA;
				break;
			}
		}
		return 0;
	}
	
	
}
