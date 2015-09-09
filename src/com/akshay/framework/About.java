package com.akshay.framework;



import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class About extends  Activity implements OnClickListener 
{
   
	ImageButton ib[]=new ImageButton[5];
	TextView tvD;
	String url;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.about);
         intial();
	}
	private void intial() {
		// TODO Auto-generated method stub
	tvD=(TextView)findViewById(R.id.tvDevloper);
	     tvD.setText("Devlopers");
		ib[0]=(ImageButton)findViewById(R.id.ibAkshay786);
		ib[1]=(ImageButton)findViewById(R.id.ibKapil786);
		ib[2]=(ImageButton)findViewById(R.id.ibLike786);
		ib[3]=(ImageButton)findViewById(R.id.ibRate786);
		ib[4]=(ImageButton)findViewById(R.id.ibMsg786);
		for(int i=0;i<5;i++)
			ib[i].setOnClickListener(this);
	}
	@Override
	public void onClick(View id)
	{
		Intent i;
		// TODO Auto-generated method stub
		switch(id.getId())
		{
		
		case R.id.ibAkshay786:
			url = "https://www.facebook.com/AkiDiMasti";
			i= new Intent(Intent.ACTION_VIEW);
			i.setData(Uri.parse(url));
			startActivity(i);
			break;
		case R.id.ibKapil786:
			url = "https://www.facebook.com/Kachiever";
			i= new Intent(Intent.ACTION_VIEW);
			i.setData(Uri.parse(url));
			startActivity(i);
			break;
		case R.id.ibLike786:
			url = "http://www.example.com";
			i= new Intent(Intent.ACTION_VIEW);
			i.setData(Uri.parse(url));
			startActivity(i);
			break;
		case R.id.ibRate786:
			rateMyApp();
			break;
		case R.id.ibMsg786:
			try{
				email();
			}
			catch(Exception e)
			{
				Toast.makeText(this, "Error 301: Problem with email()", Toast.LENGTH_SHORT).show();
			}
			break;
		}
		
	}
	
	private void email() {
		// TODO Auto-generated method stub
		String emailaddress[] = { "akshay9911102163@gmail.com"};
		String message ="Enter your feedback or anything ......:p";
      Intent sm= new Intent(android.content.Intent.ACTION_SEND);
      sm.putExtra(android.content.Intent.EXTRA_EMAIL, emailaddress);
      sm.putExtra(android.content.Intent.EXTRA_SUBJECT,"Feeback of App: " + "App Name");
      sm.setType("plain/text");
      sm.putExtra(android.content.Intent.EXTRA_TEXT,message);
      startActivity(sm);
	}
	private boolean MyStartActivity(Intent aIntent) {
	    try
	    {
	        startActivity(aIntent);
	        return true;
	    }
	    catch (ActivityNotFoundException e)
	    {
	        return false;
	    }
	}
	 
	//On click event for rate this app button
	public void rateMyApp() {
	    Intent intent = new Intent(Intent.ACTION_VIEW);
	    //Try Google play
	    intent.setData(Uri.parse("market://details?id=package_name_or_id"));
	    if (!MyStartActivity(intent)) {
	        //Market (Google play) app seems not installed, let's try to open a webbrowser
	        intent.setData(Uri.parse("https://play.google.com/store/apps/details?id=package_name_or_id"));
	        if (!MyStartActivity(intent)) {
	            //Well if this also fails, we have run out of options, inform the user.
	            Toast.makeText(this, "Could not open Android market, please install the market app.", Toast.LENGTH_SHORT).show();
	        }
	    }
	    
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
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		TextView aRes=(TextView)findViewById(R.id.textView11);
	     aRes.setText(R.string.resume);
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

