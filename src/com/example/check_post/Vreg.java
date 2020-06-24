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

public class Vreg extends Activity {

	Button next;
	TextView id,uid;
	EditText rg,vf,vt;
	SQLiteDatabase db;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_vreg);
		uid=(TextView)findViewById(R.id.textView7);
		rg=(EditText)findViewById(R.id.editText1);
		vf=(EditText)findViewById(R.id.editText2);
		vt=(EditText)findViewById(R.id.EditText01);
		final GlobalClass globalvariabel = (GlobalClass)getApplicationContext();
		id=(TextView)findViewById(R.id.textView7);
		id.setText(globalvariabel.GetUsername().toString());
		
		next=(Button)findViewById(R.id.button1);
		db=openOrCreateDatabase("new",Context.MODE_PRIVATE,null);
		db.execSQL("create table if not exists vreg(uid varchar,rg varchar,vf varchar,vt varchar)");
		next.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(rg.getText().toString().trim().length()==0||vf.getText().toString().
						trim().length()==0||vt.getText().toString().trim().length()==0)
				{
					Toast.makeText(getApplicationContext(), "enter all fields",Toast.LENGTH_SHORT).show();
				return;
				}
				db.execSQL("insert into vreg values('"+id.getText()+"','"+rg.getText()+"','"+vf.getText()+"','"+vt.getText()+"')");
				Intent x=new Intent(Vreg.this,Noc.class);
				startActivity(x);
			}
		});
	}

	

}
