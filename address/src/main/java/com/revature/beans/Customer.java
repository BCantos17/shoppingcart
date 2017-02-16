package com.revature.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Document
@JsonIgnoreProperties(ignoreUnknown = true)
public class Customer {

    @Id
    int id;

    @Valid
    @NotNull
    String firstName;

    @Valid
    @NotNull
    String lastName;

    @Valid
    Address billingAddress;

    @Valid
    Address shippingAddress;

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
}
