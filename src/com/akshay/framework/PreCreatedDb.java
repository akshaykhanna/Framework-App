package com.akshay.framework;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.content.Context;
import android.database.Cursor;
import android.widget.Toast;

public class PreCreatedDb 
{
	Context context;
	String Package_name;
	
	public PreCreatedDb(ThirdActivity thirdActivity, String pkg_name) {
		// TODO Auto-generated constructor stub
		context= thirdActivity;
		Package_name=pkg_name;
	}

	public String dbPreCreatedDisplay() 
	{
		// TODO Auto-generated method stub
		String para="";
		DBAdapterPreDB db = new DBAdapterPreDB(context);
		try {
		String destPath = "/data/data/" + Package_name +
		"/databases";
		File f = new File(destPath);
		if (!f.exists()) 
		{
		f.mkdirs();
		f.createNewFile();
		//---copy the db from the assets folder into
		// the databases folder---
		CopyDB(context.getAssets().open("mydb"),
		new FileOutputStream(destPath + "/MyDB"));
		}
		} catch (FileNotFoundException e) {
		Toast.makeText(context, "Error 401: Db copy: "+e.toString(), Toast.LENGTH_LONG).show();
		} catch (IOException e) {
			Toast.makeText(context, "Error 402: Db copy: "+e.toString(), Toast.LENGTH_LONG).show();
		}
		//---get all contacts---
		db.open();
		Cursor c = db.getAllContacts();
		
		if (c.moveToFirst())
		{
		do {
		 para+=DisplayContact(c);
		} while (c.moveToNext());
		}
		db.close();
		return para;
	}
	
	public void CopyDB(InputStream inputStream,
			OutputStream outputStream) throws IOException {
			//---copy 1K bytes at a time---
			byte[] buffer = new byte[1024];
			int length;
			while ((length = inputStream.read(buffer)) > 0) {
			outputStream.write(buffer, 0, length);
			}
			inputStream.close();
			outputStream.close();
			}
	public String DisplayContact(Cursor c)
	{
	String text="State: " + c.getString(0) + " " +
	"Capital " + c.getString(1) + "\n";
	
	return text;
	}
}
