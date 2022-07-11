package com.example.fileread;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.app.ActivityCompat;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.fileread.util.WriteFileDir;
import com.example.fileread.util.read;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.Stack;

public class ReadFile extends AppCompatActivity {


    File dataDirectory;
    String[]fileName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_file);
        String[]permissions={"android.permission.WRITE_EXTERNAL_STORAGE","android.permission.READ_EXTERNAL_STORAGE"};
        ActivityCompat.requestPermissions(this,permissions,0);
        dataDirectory = Environment.getRootDirectory();

        File[] files=dataDirectory.listFiles();

        fileName=new String[files.length+1];
        for (int i=0;i<files.length;i++){
            fileName[i]=files[i].getName();
        }
        fileName[files.length]="返回";
        ListView fileReadView = findViewById(R.id.fileRead);

        MyAdapter myAdapter = new MyAdapter();

        fileReadView.setAdapter(myAdapter);

    }

    public  class MyAdapter extends BaseAdapter  {


        @Override
        public int getCount() {
            return fileName.length;
        }

        @Override
        public Object getItem(int position) {
            return fileName[position];
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View view=View.inflate(ReadFile.this,R.layout.item_readfile,null);

            TextView textView = view.findViewById(R.id.file);
            String filename=fileName[position];

            textView.setText(filename);

            textView.setOnClickListener(v -> {
                File file;
                if (Objects.equals(filename, "返回")){
                    file =  new File(dataDirectory, filename).getParentFile().getParentFile();
                }

                else {
                     file = new File(dataDirectory, filename);
                }

                if (file.isDirectory()){

                    dataDirectory=file;

                    File[] files=dataDirectory.listFiles();



                    if (files != null) {
                        fileName=new String[files.length+1];
                    }
                    for (int i=0;i<files.length;i++){
                        fileName[i]=files[i].getName();
                    }
                    fileName[files.length]="返回";
                    ListView fileReadView = findViewById(R.id.fileRead);



                    MyAdapter myAdapter = new MyAdapter();

                    fileReadView.setAdapter(myAdapter);
                }


            });

            return view;
        }


    }
}