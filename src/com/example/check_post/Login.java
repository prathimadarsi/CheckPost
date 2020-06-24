package com.example.check_post;


import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends Activity {

	EditText user, pass;
	Button sub;
	String u;
    String p;
	SQLiteDatabase db;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		final GlobalClass globalvariabel = (GlobalClass)getApplicationContext();
		setContentView(R.layout.activity_login);
		setTitle("CheckPost");
		user = (EditText) findViewById(R.id.editText1);
		pass = (EditText) findViewById(R.id.editText2);
		sub=(Button) findViewById(R.id.button1);
		sub.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub			
				if(user.getText().toString().equals("")||pass.getText().toString().equals("")){
					
					Toast.makeText(Login.this, "Please enter all the fields..!", Toast.LENGTH_LONG).show();
				}else{	 
					 u = user.getText().toString();
					 p = pass.getText().toString();
					 try{
					          db=openOrCreateDatabase("new",SQLiteDatabase.CREATE_IF_NECESSARY,null);					    
					        }catch(Exception exception){
					            exception.printStackTrace();
					        }try{
					        	 
					        	
					        	 if(user.getText().toString().equals("admin")&& pass.getText().toString().equals("admin")){
					        		 Toast.makeText(Login.this, "Welcome To Admin Home Page "  + u , Toast.LENGTH_LONG).show();
					        			globalvariabel.Setusername(user.getText().toString().trim());
					    				globalvariabel.Setpassword(pass.getText().toString().trim());		
					        		 Intent a = new Intent(Login.this,Admin.class);
					            		startActivity(a);
					            		clear();
					            		return;
									}
					        	 Cursor cc = db.rawQuery("select * from reg where uid= '"+u+"' and pa= '"+p+"' ", null); 
					        	 if(cc.moveToFirst())
					        		 {String temp="";					       
						            if (cc != null) {
						            	if(cc.getCount() > 0)
						            	{
						            	//return true;
						            scan g=new scan();
						            g.execute();
						            
						            		Toast.makeText(Login.this, "Welcome "  + u , Toast.LENGTH_LONG).show();
						            		globalvariabel.Setusername(user.getText().toString().trim());
						    				globalvariabel.Setpassword(pass.getText().toString().trim());		
						            		Intent b = new Intent(Login.this,Lognext.class);
						            		startActivity(b);
						            		clear();
						            		return;
						            	}else{
						            		 Toast.makeText(Login.this, "Login Failed...!", Toast.LENGTH_LONG).show();
						            		 clear();
						            	}
						            	}
					        		 }
					              
					        	  
					        	 
					             
					            else{
				            		 Toast.makeText(Login.this, "Login Failed...!", Toast.LENGTH_LONG).show();
				            		 clear();
					        	 }
					        }//	return false;*/
				        		 catch(Exception exception){
					            exception.printStackTrace();
					        }
						}	 	
					        }
		});
		
	
		}		
		
			
	public class scan extends AsyncTask<String, String, String>{

		private ProgressDialog pd;

		protected void onPreExecute() {
			super.onPreExecute();
		 pd = new ProgressDialog(Login.this);
		 pd.setTitle("Please Wait!!");
		 pd.setMessage("Logging you In....");
		 pd.setMax(10);
		 pd.show();
		}
	
		@Override
		protected String doInBackground(String... params) {
			// TODO Auto-generated method stub
			return null;
		}
	}	
	
	public void clear()
	{
		user.setText("");
		pass.setText("");
	}
	
	
	
	}
