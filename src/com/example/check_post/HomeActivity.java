package com.example.check_post;



import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class HomeActivity extends Activity {
	Button ur,lg;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		ur=(Button)findViewById(R.id.button1);
		ur.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent a=new Intent(HomeActivity.this,Reg.class);
				startActivity(a);
			}
		});
		lg=(Button)findViewById(R.id.button2);
		lg.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			Intent b=new Intent(HomeActivity.this,Login.class);
			startActivity(b);
			}
		});
	}
	

}
