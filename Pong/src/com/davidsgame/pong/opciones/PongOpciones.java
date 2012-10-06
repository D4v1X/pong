/**
 * 
 */
package com.davidsgame.pong.opciones;

/**
 * @author David
 * 
 */
public class PongOpciones {
	private static PongOpciones opciones = null;
	private boolean sonido;
	private boolean vibracion;

	/**
	 * @param sonido
	 * @param vibracion
	 */
	public PongOpciones() {
		this.sonido = true;
		this.vibracion = true;
	}

	public static synchronized PongOpciones getInstance() {
		if (opciones == null) {
			opciones = new PongOpciones();
		}
		return opciones;
	}

	public void toggleSound() {
		sonido = !sonido;
	}

	public void toggleVibration() {
		vibracion = !vibracion;
	}

	public boolean soundEnabled() {
		return sonido;
	}

	public boolean vibrationEnabled() {
		return vibracion;
	}

}
