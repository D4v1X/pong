package com.davidsgame.pong;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class PongActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pong);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_pong, menu);
        return true;
    }
}
