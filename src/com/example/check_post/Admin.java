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

public class Admin extends Activity implements OnClickListener{
	Spinner sp;
	ImageView out;
	SQLiteDatabase db;
	ListView l;
	EditText t1;
	 ArrayList<String> list1;
	 ArrayAdapter adapter;
	 Button sub;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_admin);
		sp=(Spinner)findViewById(R.id.spinner1);
		ArrayAdapter<CharSequence> ar=ArrayAdapter.createFromResource(this, R.array.re, android.R.layout.simple_list_item_1);
		ar.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
		sp.setAdapter(ar);
		sub=(Button)findViewById(R.id.button1);
		sub.setOnClickListener(this);
		out=(ImageView)findViewById(R.id.imageView1);
		
		
		db=openOrCreateDatabase("new", Context.MODE_PRIVATE, null);
		db.execSQL("create table if not exists vreg(uid varchar,rg varchar,vf varchar,vt varchar)");
		db.execSQL("create table if not exists noc(uid varchar,ac varchar,ac2 varchar)");
		db.execSQL("create table if not exists lic(uid varchar,ad varchar,lno varchar,lf varchar,lt varchar)");
		db.execSQL("create table if not exists per(uid varchar,ch1 varchar,s1 varchar,s2 varchar,ch2 varchar,c1 varchar,c2 varchar,ch3 varchar,g1 varchar,g2 varchar)");
		db.execSQL("create table if not exists sc(uid varchar,vf varchar,vt varchar)");
		db.execSQL("create table if not exists cc(uid varchar,vf varchar,vt varchar)");
		db.execSQL("create table if not exists gc(uid varchar,vf varchar,vt varchar)");

		
		l = (ListView) findViewById(R.id.listView1);
		
		
		/*
		final ArrayList<String> list = new ArrayList<String>();
		 list1 = new ArrayList<String>();
		 Cursor res=db.rawQuery("SELECT * FROM job", null);
		if(res.getCount()!=0)
		{
			while (res.moveToNext())
			{
	            list.add("Employee Type:   "+res.getString(0)+"\nEmployee ID:   "+res.getString(1)+"\n"+"Password:   "+res.getString(2)+"\n"+"Email:   "+res.getString(3)+"\n"+"Mobile No:   "+res.getString(4));
	            list1.add(res.getString(1));
			}
		}
		adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list);
		l.setAdapter(adapter);
		
		*/
out.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent a=new Intent(Admin.this,HomeActivity.class);
				startActivity(a);
				
			}
		});
		

		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		String u = sp.getSelectedItem().toString();
		String myUser = "VEHICLE DETAILS";
		if((v==sub) && u.equals(myUser))
    	{
    	
    		final ArrayList<String> list = new ArrayList<String>();
   		 list1 = new ArrayList<String>();
   		 Cursor res=db.rawQuery("SELECT * FROM vreg", null);
   		if(res.getCount()!=0)
   		{
   			while (res.moveToNext())
   			{
   	            list.add("User Id:   "+res.getString(0)+"\nRegistration No:   "+res.getString(1)+"\n"+"Valid From:   "+res.getString(2)+"\n"+"Valid To:   "+res.getString(3));
   	            list1.add(res.getString(1));
   			}
   		}
   		adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list);
   		l.setAdapter(adapter);
    	}
		
		else if ((v==sub) && u.equals("LICENSE DETAILS")) 
		{
			final ArrayList<String> list = new ArrayList<String>();
			 list1 = new ArrayList<String>();
			 Cursor res=db.rawQuery("SELECT * FROM lic", null);
			if(res.getCount()!=0)
			{
				while (res.moveToNext())
				{
		            list.add("User Id:   "+res.getString(0)+"\nAddress:   "+res.getString(1)+"\n"+" License No:   "+res.getString(2)+"\n"+"Valid From:   "+res.getString(3)+"\n"+"Valid To:   "+res.getString(4));
		            list1.add(res.getString(1));
				}
			}
			adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list);
			l.setAdapter(adapter);
		}
		else if ((v==sub) && u.equals("NOC DETAILS")) 
		{
			final ArrayList<String> list = new ArrayList<String>();
			 list1 = new ArrayList<String>();
			 Cursor res=db.rawQuery("SELECT * FROM noc", null);
			if(res.getCount()!=0)
			{
				while (res.moveToNext())
				{
		            list.add("User Id:   "+res.getString(0)+"\nNo Objection Certificate:   "+res.getString(1)+"\n"+"Fitness Certificate:   "+res.getString(2));
		            list1.add(res.getString(1));
				}
			}
			adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list);
			l.setAdapter(adapter);
		}
		
		else if ((v==sub) && u.equals("STAGE CARRIAGE DETAILS")) 
		{
			final ArrayList<String> list = new ArrayList<String>();
			 list1 = new ArrayList<String>();
			 Cursor res=db.rawQuery("SELECT * FROM SC", null);
			if(res.getCount()!=0)
			{
				while (res.moveToNext())
				{
		            list.add("User Id:   "+res.getString(0)+"\nValid From:   "+res.getString(1)+"\n"+"Valid To:   "+res.getString(2));
		            list1.add(res.getString(1));
				}
			}
			adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list);
			l.setAdapter(adapter);
		}
		else if ((v==sub) && u.equals("CONTRACT CARRIAGE DETAILS")) 
		{
			final ArrayList<String> list = new ArrayList<String>();
			 list1 = new ArrayList<String>();
			 Cursor res=db.rawQuery("SELECT * FROM CC", null);
			if(res.getCount()!=0)
			{
				while (res.moveToNext())
				{
		            list.add("User Id:   "+res.getString(0)+"\nValid From:   "+res.getString(1)+"\n"+"Valid To:   "+res.getString(2));
		            list1.add(res.getString(1));
				}
			}
			adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list);
			l.setAdapter(adapter);
		}
		else if ((v==sub) && u.equals("GOODS CARRIAGE DETAILS")) 
		{
			final ArrayList<String> list = new ArrayList<String>();
			 list1 = new ArrayList<String>();
			 Cursor res=db.rawQuery("SELECT * FROM GC", null);
			if(res.getCount()!=0)
			{
				while (res.moveToNext())
				{
		            list.add("User Id:   "+res.getString(0)+"\nValid From:   "+res.getString(1)+"\n"+"Valid To:   "+res.getString(2));
		            list1.add(res.getString(1));
				}
			}
			adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list);
			l.setAdapter(adapter);
		}
		
	}

	

}
