package com.example.admin.roofexpertsapp;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Palmer on 3/10/2015.
 */
public class DocumentCreator {
    String name;
    String age;
    String address;
    String city;
    String zip;
    String mobilePhone;
    String otherPhone;
    String email;
    String referral;
    String dateReceived;
    String dateScheduled;
    String product;
    String color;
    String pitch;

    // For the toast
    Context c;
    public DocumentCreator(Context context) {
        c = context; // For the toast
    }

    public void setData(String name, String age, String address, String city, String zip,
                        String mobilePhone, String otherPhone, String email, String referral,
                        String dateReceived, String dateScheduled, String product, String color,
                        String pitch) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.city = city;
        this.zip = zip;
        this.mobilePhone = mobilePhone;
        this.otherPhone = otherPhone;
        this.email = email;
        this.referral = referral;
        this.dateReceived = dateReceived;
        this.dateScheduled = dateScheduled;
        this.product = product;
        this.color = color;
        this.pitch = pitch;
    }

    public void getData() {
        Toast.makeText(c, "Hello", Toast.LENGTH_SHORT); // Toast test
    }
}
