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
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
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

/**
 * Creates a tabbed view to hold content in three different tabs while creating an estimate
 */
public class TabbedView extends Activity {
    private TileEstimate estimate;

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_tabbed_view);
        createTabs();
        estimate = new TileEstimate();

        InfoPageSetterUpper infoSetterUpper = new InfoPageSetterUpper();
        infoSetterUpper.sendInfo();
        JobPageSetterUpper setterUpper = new JobPageSetterUpper();
        setterUpper.setUp(this);
        EmailPageSetterUpper emailSetterUpper = new EmailPageSetterUpper();
        emailSetterUpper.sendInfo();
    }

    /**
     * Description: creates 3 different tabs to display content
     */
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

    public class InfoPageSetterUpper {

        public void sendInfo() {
            final Button sendButton = (Button) findViewById(R.id.sendButton);
            sendButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    estimate.setName(((EditText)findViewById(R.id.name)).getText().toString());
                    estimate.setAge(((EditText)findViewById(R.id.age)).getText().toString());
                    estimate.setAddress(((EditText)findViewById(R.id.address)).getText().toString());
                    estimate.setCity(((EditText)findViewById(R.id.city)).getText().toString());
                    estimate.setZip(((EditText)findViewById(R.id.zip)).getText().toString());
                    estimate.setMobilePhone(((EditText)findViewById(R.id.mobilePhone)).getText().toString());
                    estimate.setOtherPhone(((EditText)findViewById(R.id.otherPhone)).getText().toString());
                    estimate.setEmail(((EditText)findViewById(R.id.email)).getText().toString());
                    estimate.setReferral(((EditText)findViewById(R.id.referral)).getText().toString());
                    estimate.setDateReceived(((EditText)findViewById(R.id.dateReceived)).getText().toString());
                    estimate.setDateScheduled(((EditText)findViewById(R.id.dateScheduled)).getText().toString());
                    estimate.setProduct(((EditText)findViewById(R.id.product)).getText().toString());
                    estimate.setColor(((EditText)findViewById(R.id.color)).getText().toString());
                    estimate.setPitch(((EditText)findViewById(R.id.pitch)).getText().toString());

                    Toast.makeText(getBaseContext(), "Send button was clicked", Toast.LENGTH_SHORT).show();
                    ((TabHost)findViewById(R.id.tabhost)).setCurrentTab(1);
                }
            });
        }
    }

    /**
     * Created by Takeshi on 3/12/2015.
     */
    public class JobPageSetterUpper {

        private String jobType;
        private String matType;

        public void setJobType(String jobType) {
            this.jobType = jobType;
        }

        public String getJobType() {
            return jobType;
        }

        /**
         * Initializes the jobType
         */
        public JobPageSetterUpper() {
            jobType = "Select a job...";
        }

        /**
         * Description: sets up the view and sets contents to the spinners
         * @param context
         */
        public void setUp(Context context) {
            // Initializes the text within the type spinner
            final Spinner typeSpinner = (Spinner) findViewById(R.id.type_spinner);
            ArrayAdapter<CharSequence> typeAdapter = ArrayAdapter.createFromResource(context,
                    R.array.tile_type, android.R.layout.simple_spinner_item);
            typeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            typeSpinner.setAdapter(typeAdapter);

            typeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    matType = parent.getItemAtPosition(position).toString();
                }
                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                }
            });
            // Initializes the text within the job spinner
            final Spinner spinner = (Spinner) findViewById(R.id.job_spinner);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(context,
                    R.array.tile_jobs, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);

            final Button submitButton = (Button) findViewById(R.id.submitButton);

            submitButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switch (jobType) {
                        case "Leak Repair":
                            int amount = Integer.parseInt(((EditText)
                                    findViewById(R.id.leakNumTileEdit)).getText().toString());
                            int numLoc =Integer.parseInt(((EditText)
                                    findViewById(R.id.leakNumAreaEdit)).getText().toString());
                            System.out.println(matType + " " + amount + " " + numLoc);
                            estimate.setJob(new LeakRepairJob(matType, amount, numLoc));
                            System.out.println(((LeakRepairJob) estimate.getJob()).getNumLocations());
                            System.out.println("job: " + jobType
                                            + "\namount: " + Float.toString(((LeakRepairJob) estimate.getJob()).getNumTilePullUp())
                                            + "\ntype: " + ((LeakRepairJob) estimate.getJob()).getType()
                                            + "\nprice: $" + ((LeakRepairJob) estimate.getJob()).pricer(amount)
                                            + "\ntotal: $" + Float.toString(((LeakRepairJob) estimate.getJob()).getJobTotal()));
                            estimate.getJob().calculate();
                            estimate.saveEstimate(getBaseContext());
                            ((TextView)findViewById(R.id.display)).setText(
                                    "job: " + jobType
                                    + "\namount: " + Float.toString(((LeakRepairJob) estimate.getJob()).getNumTilePullUp())
                                    + "\ntype: " + ((LeakRepairJob) estimate.getJob()).getType()
                                    + "\nprice: $" + ((LeakRepairJob) estimate.getJob()).pricer(amount)
                                    + "\ntotal: $" + Float.toString(((LeakRepairJob) estimate.getJob()).getJobTotal()));
                            break;
                        case "2-Year Tune-Up":
                            int numTileBroken = Integer.parseInt(((EditText)
                                    findViewById(R.id.yrsNumBrokeEdit)).getText().toString());
                            int rake = Integer.parseInt(((EditText)
                                    findViewById(R.id.yrsRakeEdit)).getText().toString());
                            int ridge = Integer.parseInt(((EditText)
                                    findViewById(R.id.yrsRidgeEdit)).getText().toString());
                            int tileChipped = Integer.parseInt(((EditText)
                                    findViewById(R.id.yrsNumChipEdit)).getText().toString());
                            int tileMisplaced = Integer.parseInt(((EditText)
                                    findViewById(R.id.yrsNumMissEdit)).getText().toString());
                            int crown = Integer.parseInt(((EditText)
                                    findViewById(R.id.yrsNumCrownEdit)).getText().toString());
                            int pipe = Integer.parseInt(((EditText)
                                    findViewById(R.id.yrsNumPipeEdit)).getText().toString());
                            int chimney = Integer.parseInt(((EditText)
                                    findViewById(R.id.yrsNumChimEdit)).getText().toString());
                            int skylight = Integer.parseInt(((EditText)
                                    findViewById(R.id.yrsNumSkyEdit)).getText().toString());
                            ((TwoYearTuneUpJob)estimate.getJob()).setNumTileBroken(numTileBroken);
                            ((TwoYearTuneUpJob)estimate.getJob()).setRake(rake);
                            ((TwoYearTuneUpJob)estimate.getJob()).setRidge(ridge);
                            ((TwoYearTuneUpJob)estimate.getJob()).setNumTileChipped(tileChipped);
                            ((TwoYearTuneUpJob)estimate.getJob()).setNumTileMisplaced(tileMisplaced);
                            ((TwoYearTuneUpJob)estimate.getJob()).setNumCrown(crown);
                            ((TwoYearTuneUpJob)estimate.getJob()).setNumPipe(pipe);
                            ((TwoYearTuneUpJob)estimate.getJob()).setNumChim(chimney);
                            ((TwoYearTuneUpJob)estimate.getJob()).setNumSky(skylight);
                            ((TwoYearTuneUpJob)estimate.getJob()).setType(matType);
                            estimate.getJob().calculate();
                            estimate.saveEstimate(getBaseContext());
                            ((TextView)findViewById(R.id.display)).setText(
                                    "job: " + jobType
                                            + "\ntype: " + ((TwoYearTuneUpJob) estimate.getJob()).getType()
                                            + "\ntotal: $" + Float.toString(((TwoYearTuneUpJob) estimate.getJob()).calculate()));
                            break;
                        case "5-Year Tune-Up":
                            int numTileBroken5yr = Integer.parseInt(((EditText)
                                    findViewById(R.id.yrsNumBrokeEdit)).getText().toString());
                            int rake5yr = Integer.parseInt(((EditText)
                                    findViewById(R.id.yrsRakeEdit)).getText().toString());
                            int ridge5yr = Integer.parseInt(((EditText)
                                    findViewById(R.id.yrsRidgeEdit)).getText().toString());
                            int tileChipped5yr = Integer.parseInt(((EditText)
                                    findViewById(R.id.yrsNumChipEdit)).getText().toString());
                            int tileMisplaced5yr = Integer.parseInt(((EditText)
                                    findViewById(R.id.yrsNumMissEdit)).getText().toString());
                            int crown5yr = Integer.parseInt(((EditText)
                                    findViewById(R.id.yrsNumCrownEdit)).getText().toString());
                            int pipe5yr = Integer.parseInt(((EditText)
                                    findViewById(R.id.yrsNumPipeEdit)).getText().toString());
                            int chimney5yr = Integer.parseInt(((EditText)
                                    findViewById(R.id.yrsNumChimEdit)).getText().toString());
                            int skylight5yr = Integer.parseInt(((EditText)
                                    findViewById(R.id.yrsNumSkyEdit)).getText().toString());
                            int pipesReplaced5yr = Integer.parseInt(((EditText)
                                    findViewById(R.id.yrsNumOldCementEdit)).getText().toString());
                            int trench5yr = Integer.parseInt(((EditText)
                                    findViewById(R.id.yrsNum3InDrainEdit)).getText().toString());
                            ((FiveYearTuneUpJob)estimate.getJob()).setNumTileBroken(numTileBroken5yr);
                            ((FiveYearTuneUpJob)estimate.getJob()).setRake(rake5yr);
                            ((FiveYearTuneUpJob)estimate.getJob()).setRidge(ridge5yr);
                            ((FiveYearTuneUpJob)estimate.getJob()).setNumTileChipped(tileChipped5yr);
                            ((FiveYearTuneUpJob)estimate.getJob()).setNumTileMisplaced(tileMisplaced5yr);
                            ((FiveYearTuneUpJob)estimate.getJob()).setNumCrown(crown5yr);
                            ((FiveYearTuneUpJob)estimate.getJob()).setNumPipe(pipe5yr);
                            ((FiveYearTuneUpJob)estimate.getJob()).setNumChim(chimney5yr);
                            ((FiveYearTuneUpJob)estimate.getJob()).setNumSky(skylight5yr);
                            ((FiveYearTuneUpJob)estimate.getJob()).setNumPipesReplaced(pipesReplaced5yr);
                            ((FiveYearTuneUpJob)estimate.getJob()).setNumTrench(trench5yr);
                            ((FiveYearTuneUpJob)estimate.getJob()).setType(matType);
                            estimate.getJob().calculate();
                            estimate.saveEstimate(getBaseContext());
                            ((TextView)findViewById(R.id.display)).setText(
                                    "job: " + jobType
                                            + "\ntype: " + ((FiveYearTuneUpJob) estimate.getJob()).getType()
                                            + "\ntotal: $" + Float.toString(((FiveYearTuneUpJob) estimate.getJob()).calculate()));
                            break;
                        case "20-Year Lift and Re-lay":
                            int amount20 = Integer.parseInt(((EditText)
                                    findViewById(R.id.yrsNumSqPullEdit)).getText().toString());
                            ((TwentyYearLiftJob)estimate.getJob()).setNumTilePullUp(amount20);
                            ((TwentyYearLiftJob)estimate.getJob()).setType(matType);
                            estimate.getJob().calculate();
                            estimate.saveEstimate(getBaseContext());
                            ((TextView)findViewById(R.id.display)).setText(
                                      "job: " + jobType
                                    + "\namount: " + Float.toString(((TwentyYearLiftJob) estimate.getJob()).getNumTilePullUp())
                                    + "\ntype: " + ((TwentyYearLiftJob) estimate.getJob()).getType()
                                    + "\nprice: $" + ((TwentyYearLiftJob) estimate.getJob()).pricer(amount20)
                                    + "\ntotal: $" + Float.toString(((TwentyYearLiftJob) estimate.getJob()).getJobTotal()));
                            break;
                    }
                    Toast.makeText(getBaseContext(), "Submit Button was clicked with Job Type: " +
                        jobType, Toast.LENGTH_SHORT).show();
                    ((TabHost)findViewById(R.id.tabhost)).setCurrentTab(2);
                }
            });

            // Specifying what the page does for each selection
            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                /**
                 * Description: Displays a certain job based on what job type is selected and sets other
                 *         views to invisible.
                 *
                 * @param parent
                 * @param view
                 * @param position
                 * @param id
                 */
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
                            TwoYearTuneUpJob job = new TwoYearTuneUpJob();
                            estimate.setJob(job);

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

                        } else if (jobType.equals("5-Year Tune-Up")) {
                            FiveYearTuneUpJob job = new FiveYearTuneUpJob();
                            estimate.setJob(job);

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

                            TextView text12 = (TextView) findViewById(R.id.yrsNumOldCement);
                            text12.setVisibility(View.VISIBLE);
                            EditText edit12 = (EditText) findViewById(R.id.yrsNumOldCementEdit);
                            edit12.setVisibility(View.VISIBLE);
                            TextView text13 = (TextView) findViewById(R.id.yrsNum3InDrain);
                            text13.setVisibility(View.VISIBLE);
                            EditText edit13 = (EditText) findViewById(R.id.yrsNum3InDrainEdit);
                            edit13.setVisibility(View.VISIBLE);
                        } else if (jobType.equals("20-Year Lift and Re-lay")) {
                            TwentyYearLiftJob job = new TwentyYearLiftJob();
                            estimate.setJob(job);

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
                submit.setVisibility(View.GONE);}
        }
    }



    /*(Palmer) This might be useful:
    // http://www.myandroidsolutions.com/2012/07/19/add-image-to-email-intent-in-android/
    // build a email sending intent
    Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
    emailIntent.setType("image/png");
    // set the email subject
    emailIntent.putExtra(Intent.EXTRA_SUBJECT, "email subject");
    // set the email image path for the attachment
    emailIntent.putExtra(Intent.EXTRA_STREAM, Uri.parse("file://" + mEmailImagePath));
    // set the body of the email
    emailIntent.putExtra(Intent.EXTRA_TEXT, "some text message");
      */
    public class EmailPageSetterUpper {

        private static final int PICK_FROM_FILE = 101;

        public void sendInfo() {
            final Button sendButton = (Button) findViewById(R.id.emailButton);
            sendButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String subject = ((EditText) findViewById(R.id.subject)).getText().toString();
                    String message = ((EditText) findViewById(R.id.messageBody)).getText().toString();
                    String to = ((EditText) findViewById(R.id.destinationAddress)).getText().toString();
                    Intent emailActivity = new Intent(android.content.Intent.ACTION_SEND);
                    emailActivity.setType("image/png");
                    // set the email image path for the attachment
                    //openFile(); // For attaching
                    //emailActivity.putExtra(Intent.EXTRA_STREAM, Uri.parse("file://" + getBaseContext().getFilesDir()));
                    String filename = String.valueOf(((EditText)findViewById(R.id.attachment_name)).getText());
                    emailActivity.putExtra(Intent.EXTRA_STREAM,Uri.parse("file://" + Environment.getExternalStorageDirectory().getPath()+ "/Documents/" + filename));
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