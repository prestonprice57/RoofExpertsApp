package com.example.admin.roofexpertsapp;

/**
 * The Job interface containing a method to fill in the elements for each Job
 */
public interface Job {
    float calculate();          // Calculate cost of job
    String outputXMLHeading();  // Heading for XML file
    String outputXML();         // Output for XML file
    String toString();          // Convert to string
}
