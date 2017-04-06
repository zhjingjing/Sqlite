package com.example.sqlitedemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class MySqlite extends SQLiteOpenHelper {
  

  //数据库版本
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
  //插入方法  
  public void insert(ContentValues values){  
      //获取SQLiteDatabase实例  
      SQLiteDatabase db = getWritableDatabase();  
      //插入数据库中  
      db.insert(TABLE_NAME, null, values);  
      db.close();  
  }  
  
  //查询方法  
  public Cursor query(){  
      SQLiteDatabase db = getReadableDatabase();  
      //获取Cursor  
      Cursor c = db.query(TABLE_NAME, null, null, null, null, null, null, null);  
      return c;  
        
  }  
  
  //根据唯一标识_id  来删除数据  
  public void delete(int id){  
      SQLiteDatabase db = getWritableDatabase();  
      db.delete(TABLE_NAME, "_id=?", new String[]{String.valueOf(id)});  
  } 
  //更新数据库的内容  
  public void update(ContentValues values, String whereClause, String[]whereArgs){  
      SQLiteDatabase db = getWritableDatabase();  
      db.update(TABLE_NAME, values, whereClause, whereArgs);  
  }  
    
  //关闭数据库  
  public void close(){  
      if(db != null){  
          db.close();  
      }  
  }  
}
