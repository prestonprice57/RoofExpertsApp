package com.example.admin.roofexpertsapp;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;


public class SelectorPage extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selector_page);

        clearView();

        Spinner spinner = (Spinner) findViewById(R.id.job_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.tile_jobs, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (!parent.getItemAtPosition(position).toString().equals("Select a job...")) {
                    clearView();
                }
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

                    Button button = (Button) findViewById(R.id.submitButton);
                    button.setVisibility(View.VISIBLE);
                } else if (parent.getItemAtPosition(position).toString().equals("2-Year Tune-Up")) {
                    TextView text = (TextView) findViewById(R.id.yrsNumBroke);
                    text.setVisibility(View.VISIBLE);
                    EditText edit = (EditText) findViewById(R.id.yrsNumBrokeEdit);
                    edit.setVisibility(View.VISIBLE);

                    TextView text2 = (TextView) findViewById(R.id.yrsRake);
                    text2.setVisibility(View.VISIBLE);
                    EditText edit2 = (EditText) findViewById(R.id.yrsRakeEdit);
                    edit2.setVisibility(View.VISIBLE);

                    TextView text3 = (TextView) findViewById(R.id.yrsRidge);
                    text3.setVisibility(View.VISIBLE);
                    EditText edit3 = (EditText) findViewById(R.id.yrsRidgeEdit);
                    edit3.setVisibility(View.VISIBLE);

                    TextView text4 = (TextView) findViewById(R.id.yrsNumChip);
                    text4.setVisibility(View.VISIBLE);
                    EditText edit4 = (EditText) findViewById(R.id.yrsNumChipEdit);
                    edit4.setVisibility(View.VISIBLE);
                    TextView text5 = (TextView) findViewById(R.id.yrsNumMiss);
                    text5.setVisibility(View.VISIBLE);
                    EditText edit5 = (EditText) findViewById(R.id.yrsNumMissEdit);
                    edit5.setVisibility(View.VISIBLE);
                    TextView text6 = (TextView) findViewById(R.id.yrsNumCrown);
                    text6.setVisibility(View.VISIBLE);
                    EditText edit6 = (EditText) findViewById(R.id.yrsNumCrownEdit);
                    edit6.setVisibility(View.VISIBLE);
                    TextView text7 = (TextView) findViewById(R.id.yrsNumPipe);
                    text7.setVisibility(View.VISIBLE);
                    EditText edit7 = (EditText) findViewById(R.id.yrsNumPipeEdit);
                    edit7.setVisibility(View.VISIBLE);

                    TextView text8 = (TextView) findViewById(R.id.yrsPullTile);
                    text8.setVisibility(View.VISIBLE);
                    TextView text9 = (TextView) findViewById(R.id.yrsNumChim);
                    text9.setVisibility(View.VISIBLE);
                    EditText edit9 = (EditText) findViewById(R.id.yrsNumChimEdit);
                    edit9.setVisibility(View.VISIBLE);
                    TextView text10 = (TextView) findViewById(R.id.yrsNumSky);
                    text10.setVisibility(View.VISIBLE);
                    EditText edit10 = (EditText) findViewById(R.id.yrsNumSkyEdit);
                    edit10.setVisibility(View.VISIBLE);

                    Button button = (Button) findViewById(R.id.submitButton);
                    button.setVisibility(View.VISIBLE);
                }

                // Insert 2-year tune up

                // Insert 5-year tune up

                // Insert 20-year tune up
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

    public void clearView() {
        RelativeLayout layout = (RelativeLayout) findViewById(R.id.form_layout);
        Button submit = (Button) findViewById(R.id.submitButton);
        for (int i = 0; i < layout.getChildCount(); i++) {
            layout.getChildAt(i).setVisibility(View.GONE);
            submit.setVisibility(View.GONE);
        }
    }

    public void sendLeak(View view) {
        ;
    }
}
