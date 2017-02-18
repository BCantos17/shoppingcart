package com.revature.beans;

public class Customer {
    private int id;
    private String firstName;
    private String lastName;
    private Address billingAddress;
    private Address shippingAddress;
    private CreditCard card;

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public String getFirstName() {return firstName;}
    public void setFirstName(String firstName) {this.firstName = firstName;}
    public String getLastName() {return lastName;}
    public void setLastName(String lastName) {this.lastName = lastName;}
    public Address getBillingAddress() {return billingAddress;}
    public void setBillingAddress(Address billingAddress) {this.billingAddress = billingAddress;}
    public Address getShippingAddress() {return shippingAddress;}
    public void setShippingAddress(Address shippingAddress) {this.shippingAddress = shippingAddress;}
    public CreditCard getCard() {return card;}
    public void setCard(CreditCard card) {this.card = card;}
}
