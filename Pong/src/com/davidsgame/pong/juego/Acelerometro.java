package com.davidsgame.pong.juego;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

public class Acelerometro implements SensorEventListener{
	private SensorManager sm = null;
	private int x;
	/**
	 * @param sm
	 */
	public Acelerometro(Context context) {
		this.sm = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
	}
	
	public void register(){
		sm.registerListener(this, sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_GAME);
	}
	
	public void unregister(){
		sm.unregisterListener(this);
	}
	
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// TODO Auto-generated method stub
		
	}
	public void onSensorChanged(SensorEvent event) {
		// TODO Auto-generated method stub
		if(event.sensor.getType() == Sensor.TYPE_ACCELEROMETER){
			x = Math.round(event.values[0]*100);
		}
	}

	/**
	 * @return the x
	 */
	public int getInclination() {
		return x;
	}
	
	
}
