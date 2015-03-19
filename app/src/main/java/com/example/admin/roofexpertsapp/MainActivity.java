package com.example.admin.roofexpertsapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import org.docx4j.openpackaging.exceptions.Docx4JException;

import java.io.FileNotFoundException;
/**
 * The main page that the App goes to.
 */
public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    /**
     * An onClick method that goes to the client page
     *
     * @param v The view that was clicked to call this method
     */
    public void toClientPage(View v) {
        Intent intent = new Intent (getBaseContext(), ClientPage.class);
        startActivity(intent);
    }

    /**
     * An onClick method that goes to the tabbed estimate generator page
     *
     * @param v The view that was clicked to call this method
     */
    public void toTabbedPage(View v) {

        DocumentEdit doc = new DocumentEdit();
        try {
            doc.getTemplate("template");
            System.out.println("It opened!");
        } catch (Docx4JException e) {
            e.printStackTrace();
            System.out.println("Doc4JException");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("File not found");

        }

        Intent intent = new Intent (getBaseContext(), TabbedView.class);
        startActivity(intent);
    }
}
