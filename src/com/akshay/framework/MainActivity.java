package com.akshay.framework;





import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener
{
    Button b1,b2,b3,b4,b5;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		intialise();
	}
	private void intialise() {
		// TODO Auto-generated method stub
		b1=(Button)findViewById(R.id.button1);
		b2=(Button)findViewById(R.id.button2);
		b3=(Button)findViewById(R.id.button3);
		b4=(Button)findViewById(R.id.b_main_DB);
		b5=(Button)findViewById(R.id.button4);
	
		b1.setOnClickListener(this);
		b2.setOnClickListener(this);
		b3.setOnClickListener(this);
		b4.setOnClickListener(this);
		b5.setOnClickListener(this);
	}
	@Override
	public void onClick(View e) {
		// TODO Auto-generated method stub
		Intent i;
		switch(e.getId())
		{
		case R.id.button1:
			i=new Intent(MainActivity.this,ListMenu.class);
			startActivity(i);
			break;
		case R.id.button2:
			i=new Intent(MainActivity.this,Help.class);
			startActivity(i);
			break;

		case R.id.button3:
			i=new Intent(MainActivity.this,About.class);
			startActivity(i);
			break;
		case R.id.b_main_DB:
			//finish();
			i=new Intent(MainActivity.this,Db_ui.class);
			startActivity(i);
			break;	
		case R.id.button4:
			finish();
			break;

		}
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
