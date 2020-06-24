package com.example.check_post;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Userhome extends Activity {

	Button lo,ad,li,pe;
	TextView id;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_userhome);
		final GlobalClass globalvariabel = (GlobalClass)getApplicationContext();
		id=(TextView)findViewById(R.id.textView3);
		id.setText(globalvariabel.GetUsername().toString());
		
		pe=(Button)findViewById(R.id.button3);
		pe.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent p=new Intent(Userhome.this,Permits.class);
				startActivity(p);
			}
		});
		li=(Button)findViewById(R.id.button2);
		li.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i=new Intent(Userhome.this,Lic.class);
				startActivity(i);
			}
		});
		ad=(Button)findViewById(R.id.button1);
		ad.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent h=new Intent(Userhome.this,Vreg.class);
				startActivity(h);
			}
		});
		lo=(Button)findViewById(R.id.button4);
		lo.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent l=new Intent(Userhome.this,HomeActivity.class);
				startActivity(l);
			}
		});
	}
 
	
}
