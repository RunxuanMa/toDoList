package com.example.databasedemo;

import androidx.test.platform.app.InstrumentationRegistry;

public class Test extends ExampleInstrumentedTest{
    @Override
    public void useAppContext() {
        super.useAppContext();
    }

    public void testCreate(){

    }

    public void testInsert(){
        Dao dao=new Dao(InstrumentationRegistry.getInstrumentation().getTargetContext());
        dao.insert();
    }

}
