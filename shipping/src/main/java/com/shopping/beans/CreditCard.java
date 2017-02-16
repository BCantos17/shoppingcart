package com.shopping.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Document
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreditCard {

    @Id
    int id;

    @Valid
    @NotNull
    String fullName;

    @Valid
    @NotNull
    long number;

    @Valid
    @NotNull
    Date expDate;

    @Valid
    @NotNull
    int validate;

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public String getFullName() {return fullName;}
    public void setFullName(String fullName) {this.fullName = fullName;}
    public long getNumber() {return number;}
    public void setNumber(long number) {this.number = number;}
    public Date getExpDate() {return expDate;}
    public void setExpDate(Date expDate) {this.expDate = expDate;}
    public int getValidate() {return validate;}
    public void setValidate(int validate) {this.validate = validate;}
}
