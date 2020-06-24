package com.example.check_post;

import com.example.check_post.R;

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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Reg extends Activity {
	EditText id,pa,em,mb;
	Button sub;
    SQLiteDatabase db;
    RadioGroup acc;
    RadioButton ac;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_reg);
	
		setTitle("Registration");
		id=(EditText)findViewById(R.id.editText1);
		pa=(EditText)findViewById(R.id.editText2);
		em=(EditText)findViewById(R.id.editText3);
		mb=(EditText)findViewById(R.id.editText4);
		sub=(Button)findViewById(R.id.button1);
		acc=(RadioGroup)findViewById(R.id.radioGroup1);
		int ssid=acc.getCheckedRadioButtonId();
		ac=(RadioButton)findViewById(ssid);
		
		
		db=openOrCreateDatabase("new",Context.MODE_PRIVATE,null);
		db.execSQL("create table if not exists reg(uid varchar,pa varchar,em varchar,mb varchar,ac varchar)");
		sub.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(id.getText().toString().trim().length()==0||pa.getText()
						.toString().trim().length()==0||em.getText().toString().
						trim().length()==0||mb.getText().toString().trim().length()==0)
				{
					Toast.makeText(getApplicationContext(), "enter all fields",Toast.LENGTH_SHORT).show();
				return;
				}
				else if(mb.getText().toString().trim().length()!=10) {
	Toast.makeText(getApplicationContext(), "enter all 10 digits",Toast.LENGTH_SHORT).show();
				return;
				}
				db.execSQL("insert into reg values('"+id.getText()+"','"+pa.getText()+"','"+em.getText()+"','"+mb.getText()+"','"+ac.getText()+"')");
				Toast.makeText(getApplicationContext(), "Successfull Registration!!",Toast.LENGTH_SHORT).show();
				clr();
				Intent c=new Intent(Reg.this,Login.class);
				startActivity(c);
			}	
		
			
		});
	}
	
	public void clr()
	{
		id.setText("");
		pa.setText("");
		em.setText("");
		mb.setText("");
		
		
	}


}
