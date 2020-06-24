package com.example.check_post;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Lognext extends Activity {

	Button nx;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lognext);
		nx=(Button)findViewById(R.id.button1);
		nx.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent n=new Intent(Lognext.this,Userhome.class);
				startActivity(n);
				
			}
		});
	}

	

}
