package com.davidsgame.pong;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

public class PongActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(
        		WindowManager.LayoutParams.FLAG_FULLSCREEN,
        		WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_pong);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_pong, menu);
        return true;
    }
    
    TextView play = (TextView)findViewById(R.id.play_button);
    /*
    play.setOnClickListener(
    		new OnClickListener() {
    			public void onClick(View V){
    				Toast.makeText(getApplicationContext(),R.string.menu_play,Toast.LENGTH_SHORT).show();
    				}
    			});*/
}
