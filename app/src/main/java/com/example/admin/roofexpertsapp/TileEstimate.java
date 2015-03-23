package com.example.admin.roofexpertsapp;

/**
 * Created by Takeshi on 3/17/2015.
 *
 * Description: Creates a class to store the information given by the user to an estimate
 */
public class TileEstimate {
    private String name;
    private String age;
    private String address;
    private String city;
    private String zip;
    private String mobilePhone;
    private String otherPhone;
    private String email;
    private String referral;
    private String dateReceived;
    private String dateScheduled;
    private String product;
    private String color;
    private String pitch;
    private Job job;

    /**
     * Description: initializes an estimate with all blank strings
     */
    public TileEstimate() {
        name = "";
        age = "";
        address = "";
        city = "";
        zip = "";
        mobilePhone = "";
        otherPhone = "";
        email = "";
        referral = "";
        dateReceived = "";
        dateScheduled = "";
        product = "";
        color = "";
        pitch = "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getOtherPhone() {
        return otherPhone;
    }

    public void setOtherPhone(String otherPhone) {
        this.otherPhone = otherPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getReferral() {
        return referral;
    }

    public void setReferral(String referral) {
        this.referral = referral;
    }

    public String getDateReceived() {
        return dateReceived;
    }

    public void setDateReceived(String dateReceived) {
        this.dateReceived = dateReceived;
    }

    public String getDateScheduled() {
        return dateScheduled;
    }

    public void setDateScheduled(String dateScheduled) {
        this.dateScheduled = dateScheduled;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPitch() {
        return pitch;
    }

    public void setPitch(String pitch) {
        this.pitch = pitch;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public void setJobType(String jobType) {
        /*
        The logic to specify which type of job will be instantiated

        if (jobType.equals("Leak Repair")) {
            job = new LeakRepairJob();
        } else if (jobType.equals("2-Year Tune-Up")) {
            job = new TwoYearTuneUpJob();
        } else if (jobType.equals("5-Year Tune-Up")) {
            job = new FiveYearTuneUpJob();
        } else if (jobType.equals("20-Year Lift and Re-lay")) {
            job = new TwentyYearLiftJob();
        }*/
    }
}
