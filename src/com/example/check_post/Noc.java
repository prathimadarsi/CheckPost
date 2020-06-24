package com.example.check_post;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Noc extends Activity {

	Button back;
	SQLiteDatabase db;
    RadioGroup acc,acc2;
    RadioButton ac,ac2;
	TextView id,uid;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_noc);
		
		acc=(RadioGroup)findViewById(R.id.radioGroup1);
		int ssid=acc.getCheckedRadioButtonId();
		ac=(RadioButton)findViewById(ssid);
		
		acc2=(RadioGroup)findViewById(R.id.radioGroup2);
		int ssid2=acc2.getCheckedRadioButtonId();
		ac2=(RadioButton)findViewById(ssid2);
		
		final GlobalClass globalvariabel = (GlobalClass)getApplicationContext();
		id=(TextView)findViewById(R.id.textView3);
		id.setText(globalvariabel.GetUsername().toString());
		
		back=(Button)findViewById(R.id.button1);
		db=openOrCreateDatabase("new",Context.MODE_PRIVATE,null);
		db.execSQL("create table if not exists noc(uid varchar,ac varchar,ac2 varchar)");
		back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(ac.getText()	.toString().trim().length()==0||ac2.getText().toString().
						trim().length()==0)
				{
					Toast.makeText(getApplicationContext(), "enter all fields",Toast.LENGTH_SHORT).show();
				return;
				}
				db.execSQL("insert into noc values('"+id.getText()+"','"+ac.getText()+"','"+ac2.getText()+"')");
				Intent p=new Intent(Noc.this,Userhome.class);
				startActivity(p);
			}
		});
	}	
}
