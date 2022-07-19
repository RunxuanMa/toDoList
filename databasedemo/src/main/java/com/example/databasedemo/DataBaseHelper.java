package com.example.databasedemo;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DataBaseHelper extends SQLiteOpenHelper {

    private static final String TAG="DataBaseHelper";

    /**
     *
     *  context 上下文
     *  name  数据库名称
     *  factory  游标工厂
     *  version  版本号
     */
    public DataBaseHelper(@Nullable Context context) {
        super(context, Constants.dataBase_Name, null, Constants.VERSION_CODE);
    }


    /**
     * 第一次创建被调用
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {

        //创建时的回调, 初始化
        Log.e(TAG,"创建数据库");
       //创建字段
       //sql create table table_name(.......)

       String sql="create table "+Constants.TABLE_NAME+"( _id integer,name varchar,age integer,salary integer )";

       db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //升级数据库时的回调
        Log.e(TAG,"升级数据库");

        String sql;


        //添加字段 oldVersion 是版本号
        //版本号只能升级，不能降级

        switch (oldVersion){
            case 1:

                break;

            case 2:

                break;

            case 3:
                break;
        }

    }
}
