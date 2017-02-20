package com.revature.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@JsonIgnoreProperties(ignoreUnknown = true)
public class Price {

    @Id
    private String id;
    private String productId;
    private String state;
    private Double totalPrice;
    private String invoiceId;

    public Price() {super();}

    public Price(String productId, String state, Double totalPrice, String invoiceId) {
        this.productId = productId;
        this.state = state;
        this.totalPrice = totalPrice;
        this.invoiceId = invoiceId;
    }

    public String getProductId() {return productId;}
    public void setProductId(String productId) {this.productId = productId;}
    public String getState() {return state;}
    public void setState(String state) {this.state = state;}
    public Double getTotalPrice() {return totalPrice;}
    public void setTotalPrice(Double totalPrice) {this.totalPrice = totalPrice;}
    public String getInvoiceId() {return invoiceId;}
    public void setInvoiceId(String invoiceId) {this.invoiceId = invoiceId;}
}
