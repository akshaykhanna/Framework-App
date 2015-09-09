package com.akshay.framework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;


public class Help extends Activity 
{
   TextView tv;
   int count_lines=0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.help);
		tv=(TextView)findViewById(R.id.tvHelp);
	    InputStream obj=this.getResources().openRawResource(R.raw.helptext);
		BufferedReader br=new BufferedReader(new InputStreamReader(obj));
		String text="",t="";
		
		try {
			while((text=br.readLine())!=null)
			{
				t+=text+"\n";
				count_lines++;
			}
			tv.setText(t+count_lines);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			Toast.makeText(getBaseContext(), "Error 201: Unable to read from helptxt.txt", Toast.LENGTH_LONG);
		}
	}
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}
	

}
