package com.example.admin.roofexpertsapp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 3/30/15.
 */
public class FiveYearTuneUpJob implements Job{
    private int numTileBroken;
    private int rake;
    private int ridge;
    private String type;

    private float jobTotal;

    public String getType() {
        return type;
    }

    private int numTileChipped;
    private int numTileMisplaced;
    private int numCrown;
    private int numPipe;
    private int numChim;
    private int numSky;
    private int numPipesReplaced;
    private int numTrench;
    private List<float[]> prices;

    public FiveYearTuneUpJob() {
        numTileBroken = 0;
        rake = 0;
        ridge = 0;
        type = null;
        numTileChipped = 0;
        numTileMisplaced = 0;
        numCrown = 0;
        numPipe = 0;
        numChim = 0;
        numSky = 0;
        numPipesReplaced = 0;
        numTrench = 0;
        jobTotal = 0;

        prices = new ArrayList<>();

        //Broken tile cost
        prices.add(new float[] {25, 30, 30, 35});
        //Broken rake tile cost
        prices.add(new float[] {50, 60, 60, 70});
        //Loose, chipped, or misplaced tile cost
        prices.add(new float[] {6, 12, 12, 25});
        //Loose or misplaced rake tile cost
        prices.add(new float[] {12, 25, 25, 50});
        //Seal & paint crowns
        prices.add(new float[] {35, 50, 50, 70});
        //Seal and paint pipes
        prices.add(new float[] {6, 12, 12, 25});
        //Chimney cost
        prices.add(new float[] {120, 180, 180, 360});
        //Skylight cost
        prices.add(new float[] {360, 480, 480, 1000});
        //Number of pipes to replace
        prices.add(new float[] {120, 170, 170, 300});
        //3in drainage trench
        prices.add(new float[] {25, 35, 0, 0});

    }

    public float calculate() {
        float total = 0;
        float [] brokenTileArray = prices.get(0);
        float [] brokenRakeOrRidgeArray = prices.get(1);
        float [] tileChippedOrMisplacedArray = prices.get(2);
        float [] rakeChippedOrMisplacedArray = prices.get(3);
        float [] crownArray = prices.get(4);
        float [] pipeArray = prices.get(5);
        float [] chimneyArray = prices.get(6);
        float [] skylightArray = prices.get(7);
        float [] pipesReplacedArray = prices.get(8);
        float [] trenchArray = prices.get(9);

        float brokenTileCost = 0;
        float brokenRakeCost = 0;
        float brokenRidgeCost = 0;
        float tileChippedCost = 0;
        float tileMisplacedCost = 0;
        float crownCost = 0;
        float pipeCost = 0;
        float chimneyCost = 0;
        float skyCost = 0;
        float pipesReplacedCost = 0;
        float trenchCost = 0;

        switch (type) {
            case "STD WT":
                brokenTileCost = brokenTileArray[0];
                brokenRakeCost = brokenRakeOrRidgeArray[0];
                brokenRidgeCost = brokenRakeOrRidgeArray[0];
                tileChippedCost = tileChippedOrMisplacedArray[0];
                crownCost = crownArray[0];
                pipeCost = pipeArray[0];
                chimneyCost = chimneyArray[0];
                skyCost = skylightArray[0];
                pipesReplacedCost = pipesReplacedArray[0];
                trenchCost = trenchArray[0];
                break;
            case "LT WT":
                brokenTileCost = brokenTileArray[1];
                brokenRakeCost = brokenRakeOrRidgeArray[1];
                brokenRidgeCost = brokenRakeOrRidgeArray[1];
                tileChippedCost = tileChippedOrMisplacedArray[1];
                crownCost = crownArray[1];
                pipeCost = crownArray[1];
                chimneyCost = chimneyArray[1];
                skyCost = skylightArray[1];
                pipesReplacedCost = pipesReplacedArray[1];
                trenchCost = trenchArray[1];
                break;
            case "S-CLAY":
                brokenTileCost = brokenTileArray[2];
                brokenRakeCost = brokenRakeOrRidgeArray[2];
                brokenRidgeCost = brokenRakeOrRidgeArray[2];
                tileChippedCost = tileChippedOrMisplacedArray[2];
                crownCost = crownArray[2];
                pipeCost = crownArray[2];
                chimneyCost = chimneyArray[2];
                skyCost = skylightArray[2];
                pipesReplacedCost = pipesReplacedArray[2];
                trenchCost = trenchArray[2];
                break;
            case "2-PC CLAY":
                brokenTileCost = brokenTileArray[3];
                brokenRakeCost = brokenRakeOrRidgeArray[3];
                brokenRidgeCost = brokenRakeOrRidgeArray[3];
                tileChippedCost = tileChippedOrMisplacedArray[3];
                crownCost = crownArray[3];
                pipeCost = crownArray[3];
                chimneyCost = chimneyArray[3];
                skyCost = skylightArray[3];
                pipesReplacedCost = pipesReplacedArray[3];
                trenchCost = trenchArray[3];
                break;
        }

        int totalBrokenTile = numTileBroken * (int)brokenTileCost;
        int totalBrokenRake = rake * (int)brokenRakeCost;
        int totalBrokenRidge = ridge * (int)brokenRidgeCost;
        int totalChipped = (numTileChipped + numTileMisplaced) * (int)tileChippedCost;
        int totalCrown = numCrown * (int)crownCost;
        int totalPipe = numPipe * (int)pipeCost;
        int totalChimney = numChim * (int)chimneyCost;
        int totalSkylight = numSky * (int)skyCost;
        int totalPipesReplaced = numPipesReplaced * (int)pipesReplacedCost;
        int totalTrench = numTrench * (int)trenchCost;

        total = totalBrokenTile + totalBrokenRake + totalBrokenRidge + totalChipped + totalCrown
                + totalPipe + totalChimney + totalSkylight + totalPipesReplaced + totalTrench;

        if (total < 795) {
            total = 795;
        }

        jobTotal = total;

        return total;
    }

    @Override
    public String outputXML() {
        return (        "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                        "<?xml-stylesheet type=\"text/xsl\" href=\"fiveYearTuneUpJob.xsl\"?>\n" +
                        "<estimate>" +
                        "  <name>" + name + "</name>\n" +
                        "  <age>" + age + "</age>\n" +
                        "  <address>" + address + "</address>\n" +
                        "  <city>" + city + "</city>\n" +
                        "  <zip>" + zip + "</zip>\n" +
                        "  <mobilePhone>" + mobilePhone + "</mobilePhone>\n" +
                        "  <otherPhone>" + otherPhone + "</otherPhone>\n" +
                        "  <email>" + email + "</email>\n" +
                        "  <referral>" + referral + "</referral>\n" +
                        "  <dateReceived>" + dateReceived + "</dateReceived>\n" +
                        "  <dateScheduled>" + dateScheduled + "</dateScheduled>\n" +
                        "  <product>" + product + "</product>\n" +
                        "  <color>" + color + "</color>\n" +
                        "  <pitch>" + pitch + "</pitch>\n" +
                        "  <job>\n" +
                        "    <type>" + type + "</type>\n" +
                        "    <rake>" + rake + "</rake>\n" +
                        "    <ridge>" + ridge + "</ridge>\n" +
                        "    <numTileBroken>" + numTileBroken + "</numTileBroken>\n" +
                        "    <numTileChiped>" + numTileChipped + "</numTileChiped>\n" +
                        "    <numTileMisplaced>" + numTileMisplaced + "</numTileMisplaced>\n" +
                        "    <numCrown>" + numCrown + "</numCrown>\n" +
                        "    <numPipe>" + numPipe + "</numPipe>\n" +
                        "    <numChim>" + numChim + "</numChim>\n" +
                        "    <numSky>" + numSky + "</numSky>\n" +
                        "    <numPipesReplaced>" + numPipesReplaced + "</numPipesReplaced>\n" +
                        "    <numTrench>" + numTrench + "</numTrench>\n" +
                        "    <jobTotal>" + jobTotal + "</jobTotal>\n" +
                        "  </job>\n" +
                        "</estimate>"
        )
    }

    public void setNumTileBroken(int numTileBroken) {
        this.numTileBroken = numTileBroken;
    }

    public void setRake(int rake) {
        this.rake = rake;
    }

    public void setRidge(int ridge) {
        this.ridge = ridge;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setNumTileChipped(int numTileChipped) {
        this.numTileChipped = numTileChipped;
    }

    public void setNumTileMisplaced(int numTileMisplaced) {
        this.numTileMisplaced = numTileMisplaced;
    }

    public void setNumCrown(int numCrown) {
        this.numCrown = numCrown;
    }

    public void setNumPipe(int numPipe) {
        this.numPipe = numPipe;
    }

    public void setNumChim(int numChim) {
        this.numChim = numChim;
    }

    public void setNumSky(int numSky) {
        this.numSky = numSky;
    }

    public void setNumPipesReplaced(int numPipesReplaced) {
        this.numPipesReplaced = numPipesReplaced;
    }

    public void setNumTrench(int numTrench) {
        this.numTrench = numTrench;
    }

    public float getJobTotal() {
        return jobTotal;
    }
}
