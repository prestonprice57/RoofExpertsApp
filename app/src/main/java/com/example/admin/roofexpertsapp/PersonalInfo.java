package com.example.admin.roofexpertsapp;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;


public class PersonalInfo extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_info);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_personal_info, menu);
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

    public void sendInfo() {

        final EditText nameField = (EditText) findViewById(R.id.name);
        String name = nameField.getText().toString();

        final EditText ageField = (EditText) findViewById(R.id.age);
        String age = ageField.getText().toString();

        final EditText addressField = (EditText) findViewById(R.id.address);
        String address = addressField.getText().toString();

        final EditText cityField = (EditText) findViewById(R.id.city);
        String city = cityField.getText().toString();

        final EditText zipField = (EditText) findViewById(R.id.zip);
        String zip = zipField.getText().toString();

        final EditText mobilePhoneField = (EditText) findViewById(R.id.mobilePhone);
        String mobilePhone = mobilePhoneField.getText().toString();

        final EditText otherPhoneField = (EditText) findViewById(R.id.otherPhone);
        String otherPhone = otherPhoneField.getText().toString();

        final EditText emailField = (EditText) findViewById(R.id.email);
        String email = emailField.getText().toString();

        final EditText referralField = (EditText) findViewById(R.id.referral);
        String referral = referralField.getText().toString();

        final EditText dateReceivedField = (EditText) findViewById(R.id.dateReceived);
        String dateReceived = dateReceivedField.getText().toString();

        final EditText dateScheduledField = (EditText) findViewById(R.id.dateScheduled);
        String dateScheduled = dateScheduledField.getText().toString();

        final EditText productField = (EditText) findViewById(R.id.product);
        String product = productField.getText().toString();

        final EditText colorField = (EditText) findViewById(R.id.color);
        String color = colorField.getText().toString();

        final EditText pitchField = (EditText) findViewById(R.id.pitch);
        String pitch = pitchField.getText().toString();

        // Declare DocumentCreator object
        DocumentCreator documentCreator = new DocumentCreator(this);
        documentCreator.setData(name, age, address, city, zip, mobilePhone, otherPhone, email,
                referral, dateReceived, dateScheduled, product, color, pitch);
        documentCreator.getData();
    }
}
