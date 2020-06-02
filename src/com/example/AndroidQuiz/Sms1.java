package com.example.AndroidQuiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.gsm.SmsManager;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Sms1 extends Activity {
Button b,b1;
EditText phone;
String msg,ph,em;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sms1);
		b=(Button) findViewById(R.id.send12345);
		b1=(Button) findViewById(R.id.logout);
		phone=(EditText) findViewById(R.id.phoneno);
		b.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				ph=phone.getText().toString();
				msg="I Got a Score of : "+em+".Very Good App.Try It My Friend!!!";
				try
				{
					SmsManager smsman=SmsManager.getDefault();
					smsman.sendTextMessage(ph, null, msg, null, null);
					Toast.makeText(getApplicationContext(), "SMS Sent!",
							Toast.LENGTH_LONG).show();
					
				}catch (Exception e) {
					Toast.makeText(getApplicationContext(),
							"SMS faild, please try again later!",
							Toast.LENGTH_LONG).show();
						e.printStackTrace();
						
					  }
			}
		});
		b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i=new Intent(Sms1.this,MainActivity.class);
				startActivity(i);
				finish();
			}
		});
		Bundle b=getIntent().getExtras();
		em=b.getString("valuesms");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.sms1, menu);
		return true;
	}

}
