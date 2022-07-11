package com.example.fileread;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.example.fileread.util.read;

import java.io.File;
import java.util.HashMap;

public class FileDirJumpActivity extends AppCompatActivity {
    HashMap<String, File[]> files=new HashMap<>();
    File dataDirectory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_dir_jump_activitty);

        String[]permissions={"android.permission.WRITE_EXTERNAL_STORAGE","android.permission.READ_EXTERNAL_STORAGE"};
        ActivityCompat.requestPermissions(this,permissions,0);
        dataDirectory = Environment.getRootDirectory();

        files= read.readFile(dataDirectory);

        ListView fileReadView = findViewById(R.id.fileRead);

        MyAdapter myAdapter = new MyAdapter();



        fileReadView.setAdapter(myAdapter);


    }
    public  class MyAdapter extends BaseAdapter implements View.OnClickListener {

        @Override
        public void onClick(View v) {

        }

        @Override
        public int getCount() {
            return 0;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            return null;
        }
    }
}