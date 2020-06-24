package com.example.check_post;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class Permits extends Activity implements OnClickListener{
	Spinner sp;
	SQLiteDatabase db;
	ListView l;
	EditText t1;
	 ArrayList<String> list1;
	 ArrayAdapter adapter;
	 Button sub,quit;
	 TextView id,uid;
	 EditText vf,vt;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_permits);
		sp=(Spinner)findViewById(R.id.spinner1);
		uid=(TextView)findViewById(R.id.textView3);
		ArrayAdapter<CharSequence> ar=ArrayAdapter.createFromResource(this, R.array.per, android.R.layout.simple_list_item_1);
		ar.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
		sp.setAdapter(ar);
		sub=(Button)findViewById(R.id.button1);
		vf=(EditText)findViewById(R.id.editText1);
		vt=(EditText)findViewById(R.id.editText2);
		
		final GlobalClass globalvariabel = (GlobalClass)getApplicationContext();
		id=(TextView)findViewById(R.id.textView4);
		id.setText(globalvariabel.GetUsername().toString());
		
		quit=(Button)findViewById(R.id.button2);
		quit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			Intent q=new Intent(Permits.this,HomeActivity.class);
			startActivity(q);
			}
		});
		sub.setOnClickListener(this);
		
		
		db=openOrCreateDatabase("new", Context.MODE_PRIVATE, null);
		db.execSQL("create table if not exists sc(uid varchar,vf varchar,vt varchar)");
		db.execSQL("create table if not exists cc(uid varchar,vf varchar,vt varchar)");
		db.execSQL("create table if not exists gc(uid varchar,vf varchar,vt varchar)");

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		String u = sp.getSelectedItem().toString();
		String myUser = "STAGE CARRIAGE";
		if((v==sub) && u.equals(myUser))
    	{
    	db.execSQL("insert into sc values('"+id.getText()+"','"+vf.getText()+"','"+vt.getText()+"')");
   		 	}
		
		else if ((v==sub) && u.equals("CONTRACT CARRIAGE")) 
		{
			db.execSQL("insert into cc values('"+id.getText()+"','"+vf.getText()+"','"+vt.getText()+"')");
		}
		else if ((v==sub) && u.equals("GOODS CARRIAGE")) 
		{
			db.execSQL("insert into gc values('"+id.getText()+"','"+vf.getText()+"','"+vt.getText()+"')");
		}
		
	}
	

}
