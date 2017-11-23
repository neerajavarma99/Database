package neer.com.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
  Created by my on 11/18/2017.
 */

public class MyDataBase extends SQLiteOpenHelper
{
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "MyDatabase";
    Cursor cursor;
    public MyDataBase(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
      String s = "CREATE TABLE MyTable (KEY_ID INTEGER , username  TEXT PRIMARY KEY, password TEXT, fullname TEXT)";
        db.execSQL(s);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS MyTable" );
        onCreate(db);
    }
    public void addData(String username, String pass, String fullname)
    {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("username", username);
        values.put("password", pass);
        values.put("fullname", fullname);
        database.insert("MyTable", null,values) ;
        database.close();

    }
    public  String getData(String un)
    {
        String s = "SELECT  * FROM MyTable WHERE username= '"+un+"'" ;
        SQLiteDatabase db = this.getWritableDatabase();
          cursor = (db.rawQuery(s, null));
        if (cursor.moveToFirst())
        {
           return cursor.getString(2);
        }
        return null;
    }
    public String getName(String id)
    {
        String s = "SELECT  * FROM MyTable where username='"+id+"'";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(s, null);
        if (cursor.moveToFirst())
        {
            return cursor.getString(3);
        }
        return null;
    }
}
