package com.example.fileread.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class read {
    private static HashMap<String,File[]>files=new HashMap<>();
    private static File rootFile;

    public static HashMap<String,File[]> readFile(File file) {

        rootFile=file;


        addFile(rootFile);

        return files;
    }

    private static void addFile(File file){

        addFile(file,file.listFiles());

    }

    private static void addFile(File file,File[]files1){


        if (files1!=null) {
            files.put(file.getName(),files1);
        }else {
            return;
        }

        for (File value : files1) {

            addFile(value, value.listFiles());

        }


    }
}
