/***
 Copyright (c) 2008-2012 CommonsWare, LLC
 Licensed under the Apache License, Version 2.0 (the "License"); you may not
 use this file except in compliance with the License. You may obtain	a copy
 of the License at http://www.apache.org/licenses/LICENSE-2.0. Unless required
 by applicable law or agreed to in writing, software distributed under the
 License is distributed on an "AS IS" BASIS,	WITHOUT	WARRANTIES OR CONDITIONS
 OF ANY KIND, either express or implied. See the License for the specific
 language governing permissions and limitations under the License.

 From _The Busy Coder's Guide to Android Development_
 http://commonsware.com/Android
 */

package com.example.admin.roofexpertsapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

public class TabbedView extends Activity {
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_tabbed_view);

        createTabs();

        InfoPageSetterUpper infoSetterUpper = new InfoPageSetterUpper();
        infoSetterUpper.sendInfo();
        JobPageSetterUpper setterUpper = new JobPageSetterUpper();
        setterUpper.setUp(this);
        EmailPageSetterUpper emailSetterUpper = new EmailPageSetterUpper();
        emailSetterUpper.sendInfo();
    }

    public void createTabs() {
        TabHost tabs=(TabHost)findViewById(R.id.tabhost);
        tabs.setup();

        TabHost.TabSpec spec1=tabs.newTabSpec("tag1");

        spec1.setIndicator("Personal");
        spec1.setContent(R.id.tab1);
        tabs.addTab(spec1);


        TabHost.TabSpec spec2=tabs.newTabSpec("tag2");

        spec2.setIndicator("Job");
        spec2.setContent(R.id.tab2);
        tabs.addTab(spec2);

        TabHost.TabSpec spec3=tabs.newTabSpec("tag3");
        spec3.setIndicator("Review");
        spec3.setContent(R.id.tab3);
        tabs.addTab(spec3);
    }

    /**
     * Created by Takeshi on 3/12/2015.
     */
    public class JobPageSetterUpper {

        private String jobType;

        public void setJobType(String jobType) {
            this.jobType = jobType;
        }

        public String getJobType() {

            return jobType;
        }

        public JobPageSetterUpper() {
            jobType = "Select a job...";

        }
        public void setUp(Context context) {
            // Initializes the text within the type spinner
            final Spinner typeSpinner = (Spinner) findViewById(R.id.yrsTypeSpinner);
            ArrayAdapter<CharSequence> typeAdapter = ArrayAdapter.createFromResource(context,
                    R.array.tile_type, android.R.layout.simple_spinner_item);
            typeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            typeSpinner.setAdapter(typeAdapter);

            // Initializes the text within the job spinner
            Spinner spinner = (Spinner) findViewById(R.id.job_spinner);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(context,
                    R.array.tile_jobs, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);

            final Button submitButton = (Button) findViewById(R.id.submitButton);

            submitButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getBaseContext(), "Submit Button was clicked with Job Type: " + jobType, Toast.LENGTH_SHORT).show();
                    ((TabHost)findViewById(R.id.tabhost)).setCurrentTab(2);
                }
            });

            // Specifying what the page does for each selection
            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    jobType = parent.getItemAtPosition(position).toString();
                    if (!jobType.equals("Select a job...")) {
                        clearView();

                        submitButton.setVisibility(View.VISIBLE);
                        if (jobType.equals("Leak Repair")) {
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
                        } else if (jobType.equals("2-Year Tune-Up")) {
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

                            typeSpinner.setVisibility(View.VISIBLE);
                            TextView text11 = (TextView) findViewById(R.id.yrsType);
                            text11.setVisibility(View.VISIBLE);
                        } else if (jobType.equals("5-Year Tune-Up")) {
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

                            typeSpinner.setVisibility(View.VISIBLE);
                            TextView text11 = (TextView) findViewById(R.id.yrsType);
                            text11.setVisibility(View.VISIBLE);

                            TextView text12 = (TextView) findViewById(R.id.yrsNumOldCement);
                            text12.setVisibility(View.VISIBLE);
                            EditText edit12 = (EditText) findViewById(R.id.yrsNumOldCementEdit);
                            edit12.setVisibility(View.VISIBLE);
                            TextView text13 = (TextView) findViewById(R.id.yrsNum3InDrain);
                            text13.setVisibility(View.VISIBLE);
                            EditText edit13 = (EditText) findViewById(R.id.yrsNum3InDrainEdit);
                            edit13.setVisibility(View.VISIBLE);
                        } else if (parent.getItemAtPosition(position)
                                .toString().equals("20-Year Lift and Re-lay")) {

                            TextView text = (TextView) findViewById(R.id.yrsNumSqPull);
                            text.setVisibility(View.VISIBLE);
                            EditText edit = (EditText) findViewById(R.id.yrsNumSqPullEdit);
                            edit.setVisibility(View.VISIBLE);
                        }
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }


        public void clearView() {
            RelativeLayout layout = (RelativeLayout) findViewById(R.id.form_layout);
            Button submit = (Button) findViewById(R.id.submitButton);
            for (int i = 0; i < layout.getChildCount(); i++) {
                layout.getChildAt(i).setVisibility(View.GONE);
                submit.setVisibility(View.GONE);
            }
        }
    }

    public class InfoPageSetterUpper {

        public void sendInfo() {
            final Button sendButton = (Button) findViewById(R.id.sendButton);
            sendButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getBaseContext(), "Send button was clicked", Toast.LENGTH_SHORT).show();
                    ((TabHost)findViewById(R.id.tabhost)).setCurrentTab(1);
                }
            });
        }
    }

    public class EmailPageSetterUpper {
        public void sendInfo() {
            final Button sendButton = (Button) findViewById(R.id.emailButton);
            sendButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String subject = ((EditText) findViewById(R.id.subject)).getText().toString();
                    String message = ((EditText) findViewById(R.id.messageBody)).getText().toString();
                    String to = ((EditText) findViewById(R.id.destinationAddress)).getText().toString();
                    Intent emailActivity = new Intent(Intent.ACTION_SEND);
                    //set up the recipient address
                    emailActivity.putExtra(Intent.EXTRA_EMAIL, new String[] { to });
                    //set up the email subject
                    emailActivity.putExtra(Intent.EXTRA_SUBJECT, subject);
                    //you can specify cc addresses as well
                    // email.putExtra(Intent.EXTRA_CC, new String[]{ ...});
                    // email.putExtra(Intent.EXTRA_BCC, new String[]{ ... });
                    //set up the message body
                    emailActivity.putExtra(Intent.EXTRA_TEXT, message);
                    emailActivity.setType("message/rfc822");
                    startActivity(Intent.createChooser(emailActivity, "Select your Email Provider :"));
                }
            });
        }
    }
}