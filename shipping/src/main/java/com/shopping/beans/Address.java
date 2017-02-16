package com.shopping.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Document
@JsonIgnoreProperties(ignoreUnknown = true)
public class Address{

    @Id
    int id;

    @Valid
    @NotNull
    String fullName;

    @Valid
    @NotNull
    String line1;

    String line2;

    @Valid
    @NotNull
    String city;

    @Valid
    @NotNull
    String state;

    @Valid
    @NotNull
    int zipCode;

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
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
}
