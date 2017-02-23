package com.revature.beans;

public class Shipping {
    private final Double ONE_DAY = 19.99;
    private final Double TWO_DAY = 14.99;
    private final Double EXPEDITED = 6.99;
    private final Double STANDARD = 3.99;

    public Shipping() {super();}

    public Double getOneDay() {return ONE_DAY;}
    public Double getTwoDay() {return TWO_DAY;}
    public Double getEXPEDITED() {return EXPEDITED;}
    public Double getSTANDARD() {return STANDARD;}
}
