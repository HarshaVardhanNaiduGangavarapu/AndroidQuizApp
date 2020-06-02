package com.example.AndroidQuiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Result extends Activity {
TextView tv;
Button b;
String s;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);
		tv=(TextView) findViewById(R.id.textresult);
		b=(Button) findViewById(R.id.resbut);
		b.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i=new Intent(Result.this,Conclude.class);
				i.putExtra("value1",s);
				startActivity(i);
				finish();
			}
		});
		Bundle b=getIntent().getExtras();
		s=b.getString("value");
		tv.setText(s);
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.result, menu);
		return true;
	}
}
