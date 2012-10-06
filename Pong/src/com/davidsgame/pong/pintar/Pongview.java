package com.davidsgame.pong.pintar;

import com.davidsgame.pong.juego.Acelerometro;
import com.davidsgame.pong.juego.Barra;
import com.davidsgame.pong.juego.BarraMoveThread;
import com.davidsgame.pong.juego.Bola;
import com.davidsgame.pong.juego.BolaMoveThread;
import com.davidsgame.pong.juego.Coordenada;
import com.davidsgame.pong.juego.Elemento;
import com.davidsgame.pong.opciones.PongOpciones;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class Pongview extends SurfaceView implements SurfaceHolder.Callback {

	private Pongthread thread;
	private BolaMoveThread bolaThread;
	private BarraMoveThread barraThread;
	
	private Elemento barraIzq;
	private Elemento barraDer;
	private Elemento bola;
	
	private Elemento elementoActivo = null;
	private int origenY;
	
	private Acelerometro acelerometro;
	

	public Pongview(Context context, Acelerometro acelerometro) {
		super(context);
		// TODO Auto-generated constructor stub
		getHolder().addCallback(this);
		this.acelerometro = acelerometro;
	}

	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		// TODO Auto-generated method stub
	}

	public void surfaceCreated(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		barraIzq = new Barra(new Coordenada(50, getHeight() / 2 - 50), 20, 100);
		barraDer = new Barra(new Coordenada(getWidth() - 70, getHeight() / 2 - 50), 20, 100);
		bola = new Bola(new Coordenada(getWidth() / 2 - 5, getHeight() / 2 - 5), 10, 10);
		//----Pintar
		thread = new Pongthread(getHolder(), this);
		thread.setRun(true);
		thread.start();
		//---Bola
		bolaThread = new BolaMoveThread((Bola)bola, (Barra)barraIzq, (Barra)barraDer, new Rect(0,0,getWidth(),getHeight()),this.getContext());
		bolaThread.setRun(true);
		bolaThread.start();
		//---Barra
		if(PongOpciones.getInstance().AcelerometroEnabled()){
			barraThread = new BarraMoveThread((Barra)barraIzq, new Rect(0, 0, getWidth(), getHeight()), acelerometro);
			barraThread.setRun(true);
			barraThread.start();
		}
		
	}

	public void surfaceDestroyed(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		boolean retry = true;
		thread.setRun(false);
		bolaThread.setRun(false);
		if(PongOpciones.getInstance().AcelerometroEnabled()){
			barraThread.setRun(false);
		}
		while (retry) {
			try {
				thread.join();
				bolaThread.join();
				if(PongOpciones.getInstance().AcelerometroEnabled()){
					barraThread.join();
				}
				retry = false;
			} catch (InterruptedException e) {

			}
		}

	}

	public void onDraw(Canvas canvas) {
		Paint paint = new Paint();
		paint.setColor(Color.YELLOW);

		canvas.drawColor(Color.DKGRAY);
		canvas.drawRect(barraIzq.getRect(), paint);
		canvas.drawRect(barraDer.getRect(), paint);
		canvas.drawRect(bola.getRect(), paint);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.view.View#onTouchEvent(android.view.MotionEvent)
	 */
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		int x = (int) event.getX();
		int y = (int) event.getY();
		
		if(!PongOpciones.getInstance().AcelerometroEnabled()){
			switch (event.getAction()) {
			case MotionEvent.ACTION_DOWN:
				// Hemos Pulsado
				if (barraIzq.getRect().contains(x, y)) {
					elementoActivo = barraIzq;
					origenY = y;
					break;
				}
				if (barraDer.getRect().contains(x, y)) {
					elementoActivo = barraDer;
					origenY = y;
					break;
				}
				break;
			case MotionEvent.ACTION_MOVE:
				// Hemos Arrastrado
				if (elementoActivo != null) {
					Barra b = (Barra) elementoActivo;
					if (b.puedoMover(0, y - origenY, new Rect(0, 0, getWidth(), getHeight())))
						b.move(0, y - origenY);
				}
				origenY = y;
				break;
			case MotionEvent.ACTION_UP:
				// Hemos Levantado
				elementoActivo = null;
				break;
			default:
				break;
			}
		}
		return true;
	}

}
