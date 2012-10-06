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
	private boolean acelerometro;

	/**
	 * @param sonido
	 * @param vibracion
	 */
	public PongOpciones() {
		this.sonido = true;
		this.vibracion = true;
		this.acelerometro = false;
	}

	public static synchronized PongOpciones getInstance() {
		if (opciones == null) {
			opciones = new PongOpciones();
		}
		return opciones;
	}
	
	//---Activar o desactivar sonido
	public void toggleSound() {
		sonido = !sonido;
	}
	public boolean soundEnabled() {
		return sonido;
	}
	//---Activar o desactivar vibracion
	public void toggleVibration() {
		vibracion = !vibracion;
	}
	public boolean vibrationEnabled() {
		return vibracion;
	}
	//---Activar o desactivar acelerometro
	public void toggleAcelerometro() {
		acelerometro = !acelerometro;
	}
	public boolean AcelerometroEnabled() {
		return acelerometro;
	}
}
