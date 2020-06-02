package com.example.AndroidQuiz;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class dbhelper extends SQLiteOpenHelper {
	
	SQLiteDatabase db;
	String ss1,ss2;

	public dbhelper(Context context) {
		super(context,"exampledb", null,1);
		// TODO Auto-generated constructor stub
		db=getReadableDatabase();
		db=getWritableDatabase();
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
try {
	db.execSQL("create table if not exists exampledb(name text,pass text,email text,phone text)");
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub

	}

	public boolean getdata(String s1, String s2) {
		// TODO Auto-generated method stub
		Cursor c = db.rawQuery("select name,pass from exampledb", null);
		boolean b;
		b=false;
		while (c.moveToNext()) {
			ss1 = c.getString(c.getColumnIndex("name"));
			ss2 = c.getString(c.getColumnIndex("pass"));
			if(s1.equals(ss1)&&s2.equals(ss2))
			{
			b=true;
		}
		}
		return b;
	}

	public void insert(String s1, String s2, String s3, String s4) {
		// TODO Auto-generated method stub
		db.execSQL("insert into exampledb values('"+s1+"','"+s2+"','"+s3+"','"+s4+"')");
	}

	
}
