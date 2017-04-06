package com.example.sqlitedemo;

import android.support.v7.app.ActionBarActivity;
import android.R.string;
import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;


@SuppressLint("NewApi")
public class MainActivity extends ActionBarActivity implements OnClickListener {
  private Button bt2,bt3;
  private TextView textView;
  private MySqlite mySqlite;
  private String content;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    init();
  }
  
  public void init(){
    mySqlite=new MySqlite(this);
    bt2=(Button) findViewById(R.id.charu);
    bt3=(Button) findViewById(R.id.get);
    textView=(TextView) findViewById(R.id.mytext);
    bt2.setOnClickListener(this);
    bt3.setOnClickListener(this);
  }

  @Override
  public void onClick(View v) {
    // TODO Auto-generated method stub
    switch (v.getId()) {
      case R.id.charu:
        ContentValues contentValues=new ContentValues();
        contentValues.put("name","1");
        contentValues.put("price", 10);
        mySqlite.insert(contentValues);
        break;
      case R.id.get:
       Cursor cursor=  mySqlite.query();
       while (cursor.moveToNext()) {
         int id=cursor.getInt(cursor.getColumnIndex("id"));
         String name=cursor.getString(cursor.getColumnIndex("name"));
         String price=cursor.getString(cursor.getColumnIndex("price"));
         content+="id="+id+"--name="+name+"--price="+price+"!!!!!!!!!!!!!!!!!!!!!!!!!!!";
       }
       textView.setText(content);
        break;
      default:
        break;
    }
  }
}
