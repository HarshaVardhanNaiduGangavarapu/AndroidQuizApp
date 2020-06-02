package com.example.AndroidQuiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

public class Quizz extends Activity {
	Button b;
	TextView tv;
	RadioGroup rg;
	RadioButton r1,r2,r3,r4;
	String r;
	String qus[] = { "Android introduced in which year?",
			"Android based on which language?",
			"Which company developed Android?",
			"Android dosen't support which format?",
			"Android based on which kernal", "What is Android?",
			"Which company bought Android?",
			"Which is the latest mobile version of Android?",
			"Android supports which features?",
			"Web browser available in Android is based on?" };

	String[][] options = {
			{ "1998", "2008", "2003", "2010" },
			{ "Java", "C++", "C", "VC++" },
			{ "Apple", "Google", "Nokia", "Android Inc" },
			{ "MPEG", "AVI", "MP4", "MIDI" },
			{ "Linux kernel", "MAC kernel", "Hybrid kernel", "Windows Kernel" },
			{ "Desktop Operating System", "Programming Language",
					"Mobile Operating System", "Database" },
			{ "Apple", "Google", "Nokia", "Microsoft" },
			{ "4.4", "2.3", "5.1.1","3.0"},
			{ "Multitasking", "Bluetooth", "Video calling", "All of the above" },
			{ "Open-source Webkit", "Firefox", "Opera", "Chrome" } };

	int ans[] = { 3, 1, 4, 2, 1, 3, 2, 3, 4, 1 };
	int result=0,as=0;
	int i = 0, j = 0, k = 0, l = 0, qn = 1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_quizz);
		tv=(TextView) findViewById(R.id.ques);
		rg=(RadioGroup) findViewById(R.id.radioGroup1);
		r1=(RadioButton) findViewById(R.id.radio0);
		r2=(RadioButton) findViewById(R.id.radio1);
		r3=(RadioButton) findViewById(R.id.radio2);
		r4=(RadioButton) findViewById(R.id.radio3);
		b=(Button) findViewById(R.id.NEXt);
		tv.setText(qn+"."+qus[i]);
		r1.setText(options[j][0]);
		r2.setText(options[j][1]);
		r3.setText(options[j][2]);
		r4.setText(options[j][3]);
		rg.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup arg0, int arg1) {
				// TODO Auto-generated method stub
				if(r1.isChecked())
					as=1;
				else if(r2.isChecked())
					as=2;
				else if(r3.isChecked())
					as=3;
				else if(r4.isChecked())
					as=4;
			}
		});
		b.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				int res=ans[l];
				if(as==res)
				{
					result++;
				}
				rg.clearCheck();
				i++;
				j++;
				l++;
				qn++;
				if(qn<=10)
				{
					tv.setText(qn + "." + qus[i]);
					r1.setText(options[j][0]);
					r2.setText(options[j][1]);
					r3.setText(options[j][2]);
					r4.setText(options[j][3]);
				}
				if(qn>10)
				{
					r=String.valueOf(result);
			     //Toast.makeText(getApplicationContext(),"Your Score Is:"+result, Toast.LENGTH_LONG).show();
				Intent i=new Intent(Quizz.this,Result.class);
				i.putExtra("value",r);
				startActivity(i);
				finish();
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.quizz, menu);
		return true;
	}

}
