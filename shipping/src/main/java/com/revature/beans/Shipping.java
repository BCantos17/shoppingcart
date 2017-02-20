package com.revature.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Document
@JsonIgnoreProperties(ignoreUnknown = true)
public class Shipping {

    @Id
    private String id;
    private String shippingType;

    public Shipping() {super();}

    public Shipping(String shippingType) {this.shippingType = shippingType;}

    public String getShippingType() {return shippingType;}
    public void setShippingType(String shippingType) {this.shippingType = shippingType;}
}
