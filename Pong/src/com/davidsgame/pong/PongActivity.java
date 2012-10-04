package com.davidsgame.pong;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

public class PongActivity extends Activity{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(
        		WindowManager.LayoutParams.FLAG_FULLSCREEN,
        		WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_pong);
        //-------------------
        TextView play = (TextView)findViewById(R.id.play_button);
        play.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), R.string.menu_play, Toast.LENGTH_SHORT).show();
				juego();
			}

		});
      //-------------------
        TextView options = (TextView)findViewById(R.id.options_button);
        options.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), R.string.menu_options, Toast.LENGTH_SHORT).show();
			}
		});
        
      //-------------------
        TextView exit = (TextView)findViewById(R.id.exit_button);
        exit.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), R.string.menu_exit, Toast.LENGTH_SHORT).show();
			}
		});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_pong, menu);
        return true;
    }
    
	private void juego() {
		// TODO Auto-generated method stub
		Intent juego = new Intent(this, Pongjuego.class);
		this.startActivity(juego);
	}

}
