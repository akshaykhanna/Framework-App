package com.akshay.framework;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomListAdapter extends ArrayAdapter<String> {
	 
		private final Activity context;
		private final String[] title;
		private final String[] subTitle;
		private final Integer[] imageId;
		public CustomListAdapter(Activity context,String[] title, Integer[] imageId, String[] subTitle)
		{
		super(context, R.layout.list_single_item, title);
		this.context = context;
		this.title = title;
		this.subTitle=subTitle;
		this.imageId = imageId;
		
		}
		
		@Override
		public View getView(int position, View view, ViewGroup parent) 
		{
		LayoutInflater inflater = context.getLayoutInflater();
		View rowView= inflater.inflate(R.layout.list_single_item, null, true);
		TextView tvTitle = (TextView) rowView.findViewById(R.id.tvTitle);
		tvTitle.setText(title[position]);
		
		//if if Subtitle not required then comment 2 statements below ;
		TextView tvSubTitle = (TextView) rowView.findViewById(R.id.tvSubTitle);
		tvSubTitle.setText(subTitle[position]);
		
		//if image not required then comment 2 statements below ;
		ImageView imageView = (ImageView) rowView.findViewById(R.id.ivList);
        imageView.setImageResource(imageId[position]);
        
        
		return rowView;
		}
		

}
