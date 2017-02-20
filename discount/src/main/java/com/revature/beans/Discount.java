package com.revature.beans;

public class Discount {
    private String id;
    private String code;
    private int discountAmount;
    private boolean used;
    private String productId;
    private Integer customerId;

    public Discount() {
    }

    public Discount(String code, int discountAmount, boolean used, String productId, Integer customerId) {
        this.code = code;
        this.discountAmount = discountAmount;
        this.used = used;
        this.productId = productId;
        this.customerId = customerId;
    }

    public String getId() {return id;}
    public void setId(String id) {this.id = id;}
    public String getCode() {return code;}
    public void setCode(String code) {this.code = code;}
    public int getDiscountAmount() {
        return discountAmount;
    }
    public void setDiscountAmount(int discountAmount) {
        this.discountAmount = discountAmount;
    }
    public boolean isUsed() {return used;}
    public void setUsed(boolean used) {this.used = used;}
    public String getProductId() {return productId;}
    public void setProductId(String productId) {this.productId = productId;}
    public Integer getCustomerId() {return customerId;}
    public void setCustomerId(Integer customerId) {this.customerId = customerId;}
}
