package com.example.admin.roofexpertsapp;

/**
 * The Job interface containing a method to fill in the elements for each Job
 */
public interface Job {
    float calculate();
    String outputXMLHeading();
    String outputXML();
    String toString();
}
