package com.akshay.framework;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

public class ListMenu extends ListActivity {

	String[] title = {
		      "DB",
		      "Twitter",
		      "Windows",
		      "Bing",
		      "Itunes",
		      "Wordpress",
		      "Drupal"
		  } ;
	String[] subTitle = {
		    "Precreated",
		    "Sub 2",
		    "Sub 3",
		    "Sub 4",
		    "Sub 5",
		    "Sub 6",
		    "Sub 7"
		   
		  } ;
		  Integer[] imageId = {
		      R.drawable.ic_launcher,
		      R.drawable.ic_launcher,
		      R.drawable.ic_launcher,
		      R.drawable.ic_launcher,
		      R.drawable.ic_launcher,
		      R.drawable.ic_launcher,
		      R.drawable.ic_launcher
		  };
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		CustomListAdapter apadterObj=new CustomListAdapter(ListMenu.this,title,imageId,subTitle);
		setListAdapter(apadterObj);
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		Intent i=new Intent(ListMenu.this,ThirdActivity.class);
		Bundle suitcase=new Bundle();
		suitcase.putString("title",title[position]);
		suitcase.putString("sub",subTitle[position]);
		suitcase.putInt("imgid", imageId[position]);
		i.putExtras(suitcase);
		startActivity(i);
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
