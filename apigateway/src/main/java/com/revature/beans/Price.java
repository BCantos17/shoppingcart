package com.revature.beans;


import org.springframework.data.annotation.Id;

public class Price {

    @Id
    private String priceId;
    private double tax;
    private double discount;
    private double shipping;
    private double subTotal;
    private double grandTotal;
    private String cartId;

    public Price() {
    }

    @Override
    public String toString() {
        return "Price{" +
                "priceId='" + priceId + '\'' +
                ", tax=" + tax +
                ", discount=" + discount +
                ", shipping=" + shipping +
                ", subTotal=" + subTotal +
                ", grandTotal=" + grandTotal +
                ", cartId='" + cartId + '\'' +
                '}';
    }

    public String getPriceId() {
        return priceId;
    }
    public void setPriceId(String priceId) {
        this.priceId = priceId;
    }
    public double getTax() {
        return tax;
    }
    public void setTax(double tax) {
        this.tax = tax;
    }
    public double getDiscount() {
        return discount;
    }
    public void setDiscount(double discount) {
        this.discount = discount;
    }
    public double getShipping() {
        return shipping;
    }
    public void setShipping(double shipping) {
        this.shipping = shipping;
    }
    public double getSubTotal() {
        return subTotal;
    }
    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }
    public double getGrandTotal() {
        return grandTotal;
    }
    public void setGrandTotal(double grandTotal) {
        this.grandTotal = grandTotal;
    }
    public String getCartId() {
        return cartId;
    }
    public void setCartId(String cartId) {
        this.cartId = cartId;
    }
}
