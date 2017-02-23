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
    private String cartId;
    private String invoiceId;
    private Double price;
    private String method;

    public Shipping() {}

    public Shipping(String id, String cartId, String invoiceId, Double price, String method) {
        this.id = id;
        this.cartId = cartId;
        this.invoiceId = invoiceId;
        this.price = price;
        this.method = method;
    }

    public Shipping(String cartId, String invoiceId, Double price, String method) {
        this.cartId = cartId;
        this.invoiceId = invoiceId;
        this.price = price;
        this.method = method;
    }

    public String getId() {return id;}
    public void setId(String id) {this.id = id;}
    public String getCartId() {return cartId;}
    public void setCartId(String cartId) {this.cartId = cartId;}
    public String getInvoiceId() {return invoiceId;}
    public void setInvoiceId(String invoiceId) {this.invoiceId = invoiceId;}
    public Double getPrice() {return price;}
    public void setPrice(Double price) {this.price = price;}
    public String getMethod() {return method;}
    public void setMethod(String method) {this.method = method;}
}
