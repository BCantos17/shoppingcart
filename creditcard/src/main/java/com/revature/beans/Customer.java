package com.revature.beans;

import org.springframework.data.annotation.Id;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class Customer {

    @Id
    private int id;

    @Valid
    @NotNull
    private String firstName;

    @Valid
    @NotNull
    private String lastName;

    @Valid
    private CreditCard card;

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public String getFirstName() {return firstName;}
    public void setFirstName(String firstName) {this.firstName = firstName;}
    public String getLastName() {return lastName;}
    public void setLastName(String lastName) {this.lastName = lastName;}
    public CreditCard getCard() {return card;}
    public void setCard(CreditCard card) {this.card = card;}
}
