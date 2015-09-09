package com.akshay.framework;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class ThirdActivity extends Activity 
{
    TextView tvTitle,tvSub;
    ImageView iv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.third_activity);
		intialise();
		getDataFromIntent();
		
	}

	private void getDataFromIntent() {
		// TODO Auto-generated method stub
		Bundle b=getIntent().getExtras();
		String title=b.getString("title");
		String sub=b.getString("sub");
		Integer id=b.getInt("imgid");
		tvTitle.setText(title);
		if(title.equalsIgnoreCase("DB"))
			{
			PreCreatedDb obj;
			
		obj=new PreCreatedDb(this,getPackageName());
	   String text=obj.dbPreCreatedDisplay();
	   tvSub.setText(text);
			}
		else
		{
		tvSub.setText(sub);
		
		 iv.setImageResource(id);
		}
	}

	

	private void intialise() {
		// TODO Auto-generated method stub
		tvTitle=(TextView)findViewById(R.id.tvThirdTitle);
		tvSub=(TextView)findViewById(R.id.tvThirdSub);
		iv=(ImageView)findViewById(R.id.ivThird);
		
	}
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.splash, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch(item.getItemId())
		{
		case R.id.menuHome:
			Intent about=new Intent("com.akshay.framework.MainActivity");
			startActivity(about);
			break;
		case R.id.menuAbout:
			Intent pre=new Intent("com.akshay.framework.About");
			startActivity(pre);
			break;
		case R.id.menuExit:
			finish();
			break;
		}
		return false;
		
	}
	
  
}
