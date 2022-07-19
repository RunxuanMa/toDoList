package com.example.todolist.dataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;

import com.example.todolist.Bean.ItemBean;
import com.example.todolist.MainActivity;

import java.util.ArrayList;

public class Dao {
    private final String DataBase="toDoList";
    private int Id=0;
    private int Id1=0;  private int deleteTime=0;



    private   final DataBaseHelper dataBaseHelper;

    public Dao(Context context){
        dataBaseHelper=new DataBaseHelper(context);
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    public void insert(String content, ArrayList<ItemBean> data){

        SQLiteDatabase db = dataBaseHelper.getWritableDatabase();

        ContentValues values = new ContentValues();


        values.put("status","false");
        values.put("content",content);
        values.put("created","created");
        values.put("updated","updated");
        values.put("status","未完成");

        Id1++;
        db.insert(DataBase,null,values);
//        db.execSQL(" insert into toDoList  "+
//                " values ( "+
//                Id1+
//                ","+
//                content+
//                ","+
//                "update"+
//                ","+
//                "created,"+
//                "FALSE" +
//                " );");

        data=initData();


        db.close();


    }
    public void delete(String content, ArrayList<ItemBean> data){
        SQLiteDatabase db = dataBaseHelper.getWritableDatabase();
        int id=Integer.parseInt(content);



        db.execSQL( " delete from toDoList where _ID ="+id);


        db.close();


    }
    public void update(String content, String  id){
        SQLiteDatabase db = dataBaseHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        String[] split = id.split(":");

        contentValues.put("content",content);
        db.update(DataBase,contentValues,"_ID=?",new String[]{split[1]});

        String sql="select * from "+DataBase;

        Cursor cursor = db.rawQuery(sql, null);

        while (cursor.moveToNext()){

            int Content=cursor.getColumnIndex("content");
            System.out.println(cursor.getString(Content));
        }


        db.close();
    }
    public void complete(String id){


        SQLiteDatabase db = dataBaseHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("status","已完成");
        db.update(DataBase,contentValues,"_ID=?",new String[]{id});

        db.close();

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public  ArrayList<ItemBean> initData(){


        ArrayList<ItemBean> data = new ArrayList<>();
        SQLiteDatabase db = dataBaseHelper.getWritableDatabase();

        String sql="select * from "+" toDoList ";

        Cursor cursor = db.rawQuery(sql, null);

        while (cursor.moveToNext()){

            int ID = cursor.getColumnIndex("_ID");
            int status = cursor.getColumnIndex("status");

            int content = cursor.getColumnIndex("content");
            int id = Integer.parseInt(cursor.getString(ID));
            String Status=cursor.getString(status);
            String Content = cursor.getString(content);


            data.add(new ItemBean(id,Content, MainActivity.refFormatNowDate(),MainActivity.refFormatNowDate(),Status));


        }
        db.close();
        cursor.close();

        return data;


    }
}
