package com.example.check_post;

import java.util.Timer;
import java.util.TimerTask;



import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		new Timer().schedule(new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				Intent a=new Intent(MainActivity.this,HomeActivity.class);
				startActivity(a);
			}
		},250);
	}

	@Override
    public void onBackPressed() {
    	// TODO Auto-generated method stub
    	 Toast.makeText(MainActivity.this, "You can close the App", Toast.LENGTH_LONG).show();
    }

}
