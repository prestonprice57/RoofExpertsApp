package com.example.admin.roofexpertsapp;

import java.util.ArrayList;
import java.util.List;

/**
 * The class containing the data for each Leak Repair Job
 */
public class LeakRepairJob implements Job {
    private String type;
    private int numTilePullUp;
    private float jobTotal;
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

    public LeakRepairJob() {
        jobTotal = 0;

        prices = new ArrayList<>();

        prices.add(new float[] {10, 12, 12, 18});
        prices.add(new float[] {7, 10, 10, 14});
    }

    public float pricer(int amount) {
        float price = 0;
        float [] tempPrice = new float[4];
        if (amount < 400) {
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
        float price = pricer(numTilePullUp);
        float total = price * numTilePullUp;
        jobTotal = total;
        return total;
    }
}
