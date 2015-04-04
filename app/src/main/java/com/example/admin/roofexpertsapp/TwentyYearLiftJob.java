package com.example.admin.roofexpertsapp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Takeshi on 3/24/2015.
 */
public class TwentyYearLiftJob implements Job{
    private String type;
    private int numTilePullUp;    private float jobTotal;
    private List<float[]> prices;



    public float getJobTotal() {
        return jobTotal;
    }

    public void setJobTotal(float jobTotal) {
        this.jobTotal = jobTotal;
    }


    public String getType() {
        return type;
    }


    public void setType(String type) {
        this.type = type;
    }


    public int getNumTilePullUp() {
        return numTilePullUp;
    }

    public void setNumTilePullUp(int numTilePullUp) {
        this.numTilePullUp = numTilePullUp;
    }

    public TwentyYearLiftJob() {
        jobTotal = 0;

        prices = new ArrayList<>();

        prices.add(new float[] {600, 650, 650, 720});
        prices.add(new float[] {480, 540, 540, 600});
    }

    public float pricer(int amount) {
        float price = 0;
        float [] tempPrice;
        if (amount < 12) {
            tempPrice = prices.get(0);
        } else {
            tempPrice = prices.get(1);
        }
        switch (type) {
            case "STD WT":
                price = tempPrice[0];
                break;
            case "LT WT":
                price = tempPrice[1];
                break;
            case "S-CLAY":
                price = tempPrice[2];
                break;
            case "2-PC CLAY":
                price = tempPrice[3];
                break;
        }
        return price;
    }

    public float calculate() {
        System.err.println("amount: " + numTilePullUp);
        float price = pricer(numTilePullUp);
        float total = price * numTilePullUp;
        jobTotal = total;
        System.err.println("total: " + jobTotal);
        return total;
    }

    @Override
    public String outputXMLHeading() {
        return ("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<?xml-stylesheet type=\"text/xsl\" href=\"twentyYearTuneUpJob.xsl\"?>\n");
    }

    @Override
    public String outputXML() {
        return "  <job>\n" +
               "    <type>" + type + "</type>\n" +
               "    <numTilePullUp>" + numTilePullUp + "</numTilePullUp>\n" +
               "    <jobTotal>" + jobTotal + "</jobTotal>\n" +
               "  </job>\n" +
               "</estimate>";
    }

    @Override
    public String toString() {
        return "20yrTU";
    }
}
