package com.revature.beans;

public class Shipping {
    private final String ONE_DAY = "One-Day";
    private final String TWO_DAY = "Two-Day";
    private final String EXPEDITED = "Expedited";
    private final String STANDARD = "Standard";

    private final Double ONE_DAY_PRICE = 19.99;
    private final Double TWO_DAY_PRICE = 14.99;
    private final Double EXPEDITED_PRICE = 6.99;
    private final Double STANDARD_PRICE = 3.99;

    public Shipping() {super();}

    public String getONE_DAY() {return ONE_DAY;}
    public String getTWO_DAY() {return TWO_DAY;}
    public String getEXPEDITED() {return EXPEDITED;}
    public String getSTANDARD() {return STANDARD;}
    public Double getONE_DAY_PRICE() {return ONE_DAY_PRICE;}
    public Double getTWO_DAY_PRICE() {return TWO_DAY_PRICE;}
    public Double getEXPEDITED_PRICE() {return EXPEDITED_PRICE;}
    public Double getSTANDARD_PRICE() {return STANDARD_PRICE;}
}
