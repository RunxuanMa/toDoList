package com.example.todolist;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.todolist.Bean.ItemBean;
import com.example.todolist.adapter.ListViewAdapterForTheFirstLayer;
import com.example.todolist.adapter.ListViewAdapterForTheSecondLayer;
import com.example.todolist.dataBase.Dao;

import java.util.ArrayList;
import java.util.Date;

import pl.com.salsoft.sqlitestudioremote.SQLiteStudioService;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private static ArrayList<ItemBean>Data=new ArrayList<>();
    public static Dao dao;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView =(RecyclerView) findViewById(R.id.RecyclerView);

        dao=new Dao(this);
    //    dao.dataBaseHelper.getWritableDatabase().execSQL("create table toDoList"+"  ( _ID integer , status varchar,content varchar,created varchar,updated varchar  )");
    //    SQLiteStudioService.instance().start(this);


        Data=dao.initData();
        ListViewAdapterForTheFirstLayer FirstListViewAdapter = new ListViewAdapterForTheFirstLayer(Data);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(MainActivity.this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        linearLayoutManager.setReverseLayout(false);

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(FirstListViewAdapter);


//        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
//        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
//
//        linearLayoutManager.setReverseLayout(false);
//
//        recyclerView.setLayoutManager(linearLayoutManager);
//        recyclerView.setAdapter(FirstListViewAdapter);
//


    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static String refFormatNowDate(){

        Date nowTime = new Date(System.currentTimeMillis());

        SimpleDateFormat sdFormatter = new SimpleDateFormat("yyy-MM-dd");

        String retStrFormatNowDate = sdFormatter.format(nowTime);

        return retStrFormatNowDate;

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menulist,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        final EditText editText=new EditText(MainActivity.this);
        int itemId = item.getItemId();
        switch (itemId){
            case R.id.add:
                new AlertDialog.Builder(this).setTitle("输入添加的内容").setView(editText).
                        setPositiveButton("完成", new DialogInterface.OnClickListener() {
                            @RequiresApi(api = Build.VERSION_CODES.N)
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                dao.insert(editText.getText().toString(),Data);
                                Data=dao.initData();
                                ListViewAdapterForTheFirstLayer FirstListViewAdapter = new ListViewAdapterForTheFirstLayer(Data);




                                LinearLayoutManager linearLayoutManager=new LinearLayoutManager(MainActivity.this);
                                linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

                                linearLayoutManager.setReverseLayout(false);

                                 recyclerView.setLayoutManager(linearLayoutManager);
                                recyclerView.setAdapter(FirstListViewAdapter);


                            }
                        }).show();


                break;
            case R.id.delete:
                new AlertDialog.Builder(this).setTitle("输入想删除的内容ID").setView(editText).
                        setPositiveButton("完成", new DialogInterface.OnClickListener() {
                            @RequiresApi(api = Build.VERSION_CODES.N)
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                dao.delete(editText.getText().toString(),Data);
                                Data= dao.initData();
                                ListViewAdapterForTheFirstLayer FirstListViewAdapter = new ListViewAdapterForTheFirstLayer(Data);

                                LinearLayoutManager linearLayoutManager=new LinearLayoutManager(MainActivity.this);
                                linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

                                linearLayoutManager.setReverseLayout(false);

                                recyclerView.setLayoutManager(linearLayoutManager);
                                recyclerView.setAdapter(FirstListViewAdapter);


                            }
                        }).show();
                break;
            case R.id.edit:

                break;
            case R.id.complete:
                new AlertDialog.Builder(this).setTitle("输入完成的的内容ID").setView(editText).
                        setPositiveButton("完成", new DialogInterface.OnClickListener() {
                            @RequiresApi(api = Build.VERSION_CODES.N)
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                dao.complete(editText.getText().toString());
                                Data= dao.initData();
                                ListViewAdapterForTheFirstLayer FirstListViewAdapter = new ListViewAdapterForTheFirstLayer(Data);

                                LinearLayoutManager linearLayoutManager=new LinearLayoutManager(MainActivity.this);
                                linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

                                linearLayoutManager.setReverseLayout(false);

                                recyclerView.setLayoutManager(linearLayoutManager);
                                recyclerView.setAdapter(FirstListViewAdapter);

                            }
                        }).show();


                break;
        }

        return super.onOptionsItemSelected(item);
    }

//    @RequiresApi(api = Build.VERSION_CODES.N)
//    public static void changeTextView(String s, String id){
//
//        dao.update(s,id);
//        Data= dao.initData();
//        ListViewAdapterForTheFirstLayer FirstListViewAdapter = new ListViewAdapterForTheFirstLayer(Data);
//
//
//
//    }


}