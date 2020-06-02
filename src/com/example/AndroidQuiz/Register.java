package com.example.AndroidQuiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends Activity {
	Button sub;
	EditText e1,e2,e3,e4;
	dbhelper db;
	String s1,s2,s3,s4;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
sub=(Button) findViewById(R.id.but);
e1=(EditText) findViewById(R.id.name);
e2=(EditText) findViewById(R.id.password);
e3=(EditText) findViewById(R.id.email);
e4=(EditText) findViewById(R.id.phonenum);
db=new dbhelper(this);
sub.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		s1=e1.getText().toString().trim();
		s2=e3.getText().toString().trim();
		s3=e3.getText().toString().trim();
		s4=e4.getText().toString().trim();
		if(s1.equals("") || s2.equals("") || s3.equals("")||s4.equals(""))
		{
			Toast.makeText(getApplicationContext(),"Please Enter Details!!!", Toast.LENGTH_LONG).show();
		}
	
		else
		{
		db.insert(s1,s3,s2,s4);
		Toast.makeText(getApplicationContext(), "Login Credentials Successfully Created!!!",Toast.LENGTH_SHORT).show();
		Intent i=new Intent(Register.this,MainActivity.class);
		startActivity(i);
	finish();
	}
	}
});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.register, menu);
		return true;
	}

}
