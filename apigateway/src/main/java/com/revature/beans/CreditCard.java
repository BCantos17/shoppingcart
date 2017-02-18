package com.revature.beans;

import java.util.Date;

public class CreditCard {
    private String id;
    private Integer customerId;
    private String fullName;
    private Long number;
    private Date expDate;
    private Integer validate;

    public CreditCard() {super();}

    public CreditCard(int customerId, String fullName, Long number, Date expDate, Integer validate) {
        this.customerId = customerId;
        this.fullName = fullName;
        this.number = number;
        this.expDate = expDate;
        this.validate = validate;
    }

    public int getCustomerId() {return customerId;}
    public void setCustomerId(int customerId) {this.customerId = customerId;}
    public String getId() {return id;}
    public void setId(String id) {this.id = id;}
    public String getFullName() {return fullName;}
    public void setFullName(String fullName) {this.fullName = fullName;}
    public Long getNumber() {return number;}
    public void setNumber(Long number) {this.number = number;}
    public Date getExpDate() {return expDate;}
    public void setExpDate(Date expDate) {this.expDate = expDate;}
    public Integer getValidate() {return validate;}
    public void setValidate(int validate) {this.validate = validate;}
}
