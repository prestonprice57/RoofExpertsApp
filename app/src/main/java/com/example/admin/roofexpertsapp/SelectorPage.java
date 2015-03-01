package com.example.admin.roofexpertsapp;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


public class SelectorPage extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selector_page);

        Spinner spinner = (Spinner) findViewById(R.id.job_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.tile_jobs, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (parent.getItemAtPosition(position).toString().equals("Leak Repair")) {
                    TextView text = (TextView) findViewById(R.id.leakNumTile);
                    text.setVisibility(View.VISIBLE);
                    EditText edit = (EditText) findViewById(R.id.leakNumTileEdit);
                    edit.setVisibility(View.VISIBLE);

                    TextView text2 = (TextView) findViewById(R.id.leakNumArea);
                    text2.setVisibility(View.VISIBLE);
                    EditText edit2 = (EditText) findViewById(R.id.leakNumAreaEdit);
                    edit2.setVisibility(View.VISIBLE);

                    TextView text3 = (TextView) findViewById(R.id.leakLoc);
                    text3.setVisibility(View.VISIBLE);
                    EditText edit3 = (EditText) findViewById(R.id.leakLocEdit);
                    edit3.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_selector_page, menu);
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
}
