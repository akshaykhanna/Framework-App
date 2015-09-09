package com.akshay.framework;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;



public class DBAdapterPreDB 
{
	
	 static final String KEY_STATE="state";
	 static final String KEY_CAPITAL="capital";
	 static final String DB_NAME="mydb";
	 static final String DB_TABLE ="Capital";
	 static final int DB_VERSION = 1;
	 static final String TAG = "DBAdapterPreDB";
	 
	 static final String DB_CREATE = "create table "+ DB_TABLE +"("+KEY_STATE + " text primary key , "
			 + KEY_CAPITAL +" text );";
	 final Context context;
	 SQLiteDatabase db;
	 final DBOpenHelper dbh;
	 
	 public  DBAdapterPreDB  (Context c)
	 
	 {
		 this.context=c;
		 dbh=new DBOpenHelper(c);
	 }
	 
	 private static class DBOpenHelper extends SQLiteOpenHelper
	 {
	  Context c;
		public DBOpenHelper(Context context) 
		{
			super(context, DB_NAME, null, DB_VERSION);
			// TODO Auto-generated constructor stub
			c=context;
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			// TODO Auto-generated method stub
			try
			{
				db.execSQL(DB_CREATE);
			}
			catch (Exception e)
			{
				Toast.makeText(c, "Failed to create DB", Toast.LENGTH_LONG).show();
			}
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
			// TODO Auto-generated method stub
			
					db.execSQL("DROP TABLE IF EXISTS contacts");
					onCreate(db);
		}
		
		
		 
	 }
	 
	//---opens the database---
	  public DBAdapterPreDB open() throws SQLException
	{
	db = dbh.getWritableDatabase();
	return this;
	}
	//---closes the database---
	public void close()
	{
	dbh.close();
	}
	//---
	public long insertContact(String state, String capital)
	{
	ContentValues initialValues = new ContentValues();
	initialValues.put(KEY_STATE, state);
	initialValues.put(KEY_CAPITAL, capital);
	return db.insert(DB_TABLE, null, initialValues);
	}
	//---deletes a particular contact---
	public boolean deleteContact(String state)
	{
	return db.delete(DB_TABLE, KEY_STATE + "=" + state, null) > 0;
	}
	//---retrieves all the contacts---
	public Cursor getAllContacts()
	{
	return db.query(DB_TABLE, new String[] {KEY_STATE,KEY_CAPITAL}, null, null, null, null, null);
	}
	//---retrieves a particular contact---
	public Cursor getContact(String state) throws SQLException
	{

	Cursor mCursor =db.query(true, DB_TABLE, new String[] {KEY_STATE,KEY_CAPITAL}, KEY_STATE + "=" +state, null,null, null, null, null);
	if (mCursor != null) {
	mCursor.moveToFirst();
	}
	return mCursor;
	}
	//---updates a contact---
	public boolean updateContact(String state, String capital)
	{
	ContentValues args = new ContentValues();
	args.put(KEY_STATE, state);
	args.put(KEY_CAPITAL, capital);
	return db.update(DB_TABLE, args, KEY_STATE + "=" + state, null) > 0;
	}

	}
