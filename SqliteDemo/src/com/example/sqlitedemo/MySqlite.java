package com.example.sqlitedemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class MySqlite extends SQLiteOpenHelper {
  

  //���ݿ�汾
  private static final int VERSION = 1;
  private String sql="";
  private final static String DB_NAME = "books.db";  
  private final static String TABLE_NAME = "book";  
  private SQLiteDatabase db;  
  public MySqlite(Context context, String name, CursorFactory factory, int version) {
    super(context, name, factory, version);
    // TODO Auto-generated constructor stub
  }
  
  public MySqlite(Context context){
    this(context, TABLE_NAME, null, VERSION);
  }
  @Override
  public void onCreate(SQLiteDatabase db) {
    // TODO Auto-generated method stub
    this.db=db;
    sql="create table book(id integer primary key autoincrement,name text,price real)";
    db.execSQL(sql);
  }

  @Override
  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    // TODO Auto-generated method stub
  }
  //���뷽��  
  public void insert(ContentValues values){  
      //��ȡSQLiteDatabaseʵ��  
      SQLiteDatabase db = getWritableDatabase();  
      //�������ݿ���  
      db.insert(TABLE_NAME, null, values);  
      db.close();  
  }  
  
  //��ѯ����  
  public Cursor query(){  
      SQLiteDatabase db = getReadableDatabase();  
      //��ȡCursor  
      Cursor c = db.query(TABLE_NAME, null, null, null, null, null, null, null);  
      return c;  
        
  }  
  
  //����Ψһ��ʶ_id  ��ɾ������  
  public void delete(int id){  
      SQLiteDatabase db = getWritableDatabase();  
      db.delete(TABLE_NAME, "_id=?", new String[]{String.valueOf(id)});  
  } 
  //�������ݿ������  
  public void update(ContentValues values, String whereClause, String[]whereArgs){  
      SQLiteDatabase db = getWritableDatabase();  
      db.update(TABLE_NAME, values, whereClause, whereArgs);  
  }  
    
  //�ر����ݿ�  
  public void close(){  
      if(db != null){  
          db.close();  
      }  
  }  
}
