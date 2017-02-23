package com.revature.beans;

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
    String id;

    @Valid
    @NotNull
    Integer customerId;

    @Valid
    @NotNull
    String fullName;

    @Valid
    @NotNull
    Long number;

    @Valid
    @NotNull
    Date expDate;

    @Valid
    @NotNull
    Integer validate;

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

