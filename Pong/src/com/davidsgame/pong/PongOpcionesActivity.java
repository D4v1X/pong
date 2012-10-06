package com.davidsgame.pong;

import com.davidsgame.pong.opciones.PongOpciones;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CheckBox;

public class PongOpcionesActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_pong_opciones);
        //--------------
        CheckBox sonido = (CheckBox) findViewById(R.id.checkBoxSonido);
        sonido.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				PongOpciones.getInstance().toggleSound();
			}
		});
        //--------------
        CheckBox vibracion = (CheckBox) findViewById(R.id.checkBoxvibracion);
        vibracion.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				PongOpciones.getInstance().toggleVibration();
			}
		});
        //---------------
        sonido.setChecked(PongOpciones.getInstance().soundEnabled());
        vibracion.setChecked(PongOpciones.getInstance().vibrationEnabled());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_pong_opciones, menu);
        return true;
    }
}
