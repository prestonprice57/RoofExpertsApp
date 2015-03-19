package com.example.admin.roofexpertsapp;

// (Palmer) From: http://examples.javacodegeeks.com/android/core/email/android-how-to-send-email/
// Made by Palmer

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class EmailActivity extends Activity {

    private static final String TAG_EMAIL_ACTIVITY = "Email Activity"; // For logging

    Button button;
    EditText destinationAddress;
    EditText sbj;
    EditText messageBody;
    @Override
    public void onCreate(Bundle savedInstanceState) {

        Log.i(TAG_EMAIL_ACTIVITY, "Creating Email activity");  // Logging

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);

        sbj = (EditText) findViewById(R.id.subject);
        messageBody = (EditText) findViewById(R.id.messageBody);
        button = (Button) findViewById(R.id.emailButton);
        destinationAddress = (EditText) findViewById(R.id.destinationAddress);
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                String subject = sbj.getText().toString();
                String message = messageBody.getText().toString();
                String to = destinationAddress.getText().toString();
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
