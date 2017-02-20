package com.revature.beans;

public class Address {
    private String id;
    private Integer customerId;
    private String fullName;
    private String line1;
    private String line2;
    private String city;
    private String state;
    private int zipCode;
    private boolean billing;

    public Address() {super();}

    public Address(Integer customerId, String fullName, String line1, String line2, String city, String state, int zipCode, boolean billing) {
        this.customerId = customerId;
        this.fullName = fullName;
        this.line1 = line1;
        this.line2 = line2;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.billing = billing;
    }

    public Address(Integer customerId, String fullName, String line1, String city, String state, int zipCode, boolean billing) {
        this.customerId = customerId;
        this.fullName = fullName;
        this.line1 = line1;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.billing = billing;
    }

    public String getId() {return id;}
    public void setId(String id) {this.id = id;}
    public String getFullName() {return fullName;}
    public void setFullName(String fullName) {this.fullName = fullName;}
    public String getLine1() {return line1;}
    public void setLine1(String line1) {this.line1 = line1;}
    public String getLine2() {return line2;}
    public void setLine2(String line2) {this.line2 = line2;}
    public String getCity() {return city;}
    public void setCity(String city) {this.city = city;}
    public String getState() {return state;}
    public void setState(String state) {this.state = state;}
    public int getZipCode() {return zipCode;}
    public void setZipCode(int zipCode) {this.zipCode = zipCode;}
    public int getCustomerId() {return customerId;}
    public void setCustomerId(int customerId) {this.customerId = customerId;}
    public boolean isBilling() {return billing;}
    public void setBilling(boolean billing) {this.billing = billing;}
}
