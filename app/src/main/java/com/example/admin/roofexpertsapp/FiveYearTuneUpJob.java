package com.example.admin.roofexpertsapp;

/**
 * Created by Takeshi on 3/25/2015.
 */
public class FiveYearTuneUpJob implements Job {
    private int numTileBroken;
    private String rake;
    private String ridge;
    private int numTileChipped;
    private int numTileMisplaced;
    private int numCrown;
    private int numPipe;
    private int numChim;
    private int numSky;

    public int getNumTileChipped() {
        return numTileChipped;
    }

    public void setNumTileChipped(int numTileChipped) {
        this.numTileChipped = numTileChipped;
    }

    public int getNumTileBroken() {
        return numTileBroken;
    }

    public void setNumTileBroken(int numTileBroken) {
        this.numTileBroken = numTileBroken;
    }

    public String getRake() {
        return rake;
    }

    public void setRake(String rake) {
        this.rake = rake;
    }

    public String getRidge() {
        return ridge;
    }

    public void setRidge(String ridge) {
        this.ridge = ridge;
    }

    public int getNumTileMisplaced() {
        return numTileMisplaced;
    }

    public void setNumTileMisplaced(int numTileMisplaced) {
        this.numTileMisplaced = numTileMisplaced;
    }

    public int getNumCrown() {
        return numCrown;
    }

    public void setNumCrown(int numCrown) {
        this.numCrown = numCrown;
    }

    public int getNumPipe() {
        return numPipe;
    }

    public void setNumPipe(int numPipe) {
        this.numPipe = numPipe;
    }

    public int getNumChim() {
        return numChim;
    }

    public void setNumChim(int numChim) {
        this.numChim = numChim;
    }

    public int getNumSky() {
        return numSky;
    }

    public void setNumSky(int numSky) {
        this.numSky = numSky;
    }

    public float calculate() {
        return 0;
    }
}