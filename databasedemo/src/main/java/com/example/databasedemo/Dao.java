package com.example.databasedemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class Dao {

    private final String TAG="Dao";

    private final DataBaseHelper mHelper;

    public Dao(Context context){
        //创建数据库
        mHelper=new DataBaseHelper(context);
    }

    public void insert(){
        SQLiteDatabase db = mHelper.getWritableDatabase();

        String sql="insert into "+Constants.TABLE_NAME+"(_id,name,age,salary,phone,address) values(?,?,?,?,?,?) ";

        db.execSQL(sql,new Object[]{1,"YOUR FATHER",20,500000,110,"这是地址"});

        db.close();
    }
    public void delete(){

        SQLiteDatabase db = mHelper.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put("_id",2);
        values.put("name","YOUR FATHER");
        values.put("phone",120);
        values.put("address","地址");
        values.put("salary",100);
        values.put("age",20);

        db.insert(Constants.TABLE_NAME,null,values);

        db.close();

    }
    public void update(){

        SQLiteDatabase db = mHelper.getWritableDatabase();

        String sql="update "+Constants.TABLE_NAME+" set salary =114514 where age = 20 ";

        db.execSQL(sql);

        db.close();

    }
    public void query(){
        SQLiteDatabase db = mHelper.getWritableDatabase();

        String sql="select * from "+Constants.TABLE_NAME;

        Cursor cursor = db.rawQuery(sql, null);

        while (cursor.moveToNext()){

            int name = cursor.getColumnIndex("name");

            String string = cursor.getString(name);

            Log.d(TAG,"name="+string);

        }

        cursor.close();

        db.close();
    }

}
