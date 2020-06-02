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

public class MainActivity extends Activity {
Button b1,b2;
EditText e1,e2;
String s1,s2;
dbhelper db;
boolean a=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=(EditText) findViewById(R.id.name);
        e2=(EditText) findViewById(R.id.password);
        b1=(Button) findViewById(R.id.loginb);
        b2=(Button) findViewById(R.id.registerb);
        db=new dbhelper(this);
        b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				s1=e1.getText().toString().trim();
				s2=e2.getText().toString().trim();
			a=db.getdata(s1,s2);
			if(a==true)
			{
				Toast.makeText(getApplicationContext(), "Login Success!!!",Toast.LENGTH_LONG).show();
Intent i=new Intent(MainActivity.this,Instructions.class);
startActivity(i);
finish();
			}
			else
			{
				Toast.makeText(getApplicationContext(), "Invalid Login Credentials!!!",Toast.LENGTH_LONG).show();
			}
			}
		});
        b2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i=new Intent(MainActivity.this,Register.class);
				startActivity(i);
				finish();
			}
		});
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
