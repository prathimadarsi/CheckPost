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
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Lic extends Activity {
    TextView id,uid;
    EditText ad,lno,lf,lt;
    SQLiteDatabase db;
	Button sub;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lic);
		uid=(TextView)findViewById(R.id.textView8);
		ad=(EditText)findViewById(R.id.editText3);
		lno=(EditText)findViewById(R.id.editText2);
		lf=(EditText)findViewById(R.id.editText4);
		lt=(EditText)findViewById(R.id.editText5);
		final GlobalClass globalvariabel = (GlobalClass)getApplicationContext();
		id=(TextView)findViewById(R.id.textView8);
		id.setText(globalvariabel.GetUsername().toString());
		
		sub=(Button)findViewById(R.id.button1);
		db=openOrCreateDatabase("new",Context.MODE_PRIVATE,null);
		db.execSQL("create table if not exists lic(uid varchar,ad varchar,lno varchar,lf varchar,lt varchar)");
		sub.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(ad.getText()	.toString().trim().length()==0||lno.getText().toString().
						trim().length()==0||lf.getText().toString().trim().length()==0||lt.getText().toString().trim().length()==0)
				{
					Toast.makeText(getApplicationContext(), "enter all fields",Toast.LENGTH_SHORT).show();
				return;
				}
				db.execSQL("insert into lic values('"+id.getText()+"','"+ad.getText()+"','"+lno.getText()+"','"+lf.getText()+"','"+lt.getText()+"')");
				Intent s=new Intent(Lic.this,Userhome.class);
				startActivity(s);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.lic, menu);
		return true;
	}

}
