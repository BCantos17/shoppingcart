package com.revature.beans;

import org.springframework.data.annotation.Id;

public class Discount {

    @Id
    private String id;
    private String discountCode;
    private double discountAmount;

    public Discount() {
    }

    public Discount(String discountCode, double discountAmount) {
        this.discountCode = discountCode;
        this.discountAmount = discountAmount;
    }

    @Override
    public String toString() {
        return "Discount{" +
                "id='" + id + '\'' +
                ", discountCode='" + discountCode + '\'' +
                ", discountAmount=" + discountAmount +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDiscountCode() {
        return discountCode;
    }

    public void setDiscountCode(String discountCode) {
        this.discountCode = discountCode;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(double discountAmount) {
        this.discountAmount = discountAmount;
    }
}
