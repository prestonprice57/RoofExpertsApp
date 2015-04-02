package com.example.admin.roofexpertsapp;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.io.FileInputStream;


public class ClientPage extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_page);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_client_page, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void load(View view) {
        try {
            FileInputStream fin = openFileInput("hello.txt");
            int c;
            String temp="";
            while( (c = fin.read()) != -1) {
                temp = temp + Character.toString((char)c);
            }
            String[] tempArray = temp.split("\n");

            for (String tempS : tempArray) {
                System.out.println(tempS);
            }

        } catch (Exception e) {
            System.err.println("Error reading file");
            e.printStackTrace();
        }
    }
}
