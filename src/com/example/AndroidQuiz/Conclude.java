package com.example.AndroidQuiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Conclude extends Activity {
Button email,sms,textmsg;
String em,sm,mess,textms;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_conclude);
		email=(Button) findViewById(R.id.email);
		sms=(Button) findViewById(R.id.sms);
		textmsg=(Button) findViewById(R.id.smsbutton);
		textmsg.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i=new Intent(Conclude.this,Sms1.class);
				i.putExtra("valuesms",em);
				startActivity(i);
				finish();
				
			}
		});
email.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		String sub="Android App Quiz Results";
		mess="I Got a Score of : "+em+" .Very Good App.Try It My Friend!!!";
		Intent email=new Intent(Intent.ACTION_SEND);
		email.putExtra(Intent.EXTRA_SUBJECT,sub);
		email.putExtra(Intent.EXTRA_TEXT, mess);
		email.setType("mess/rfc822");
		startActivity(Intent.createChooser(email, "Select An Option"));
		
	}
});
sms.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		Intent i=new Intent(Conclude.this,MainActivity.class);
		startActivity(i);
		finish();
	}
});
	Bundle b=getIntent().getExtras();
	em=b.getString("value1");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.conclude, menu);
		return true;
	}

}
