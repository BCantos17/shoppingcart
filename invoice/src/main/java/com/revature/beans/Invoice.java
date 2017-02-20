package com.revature.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@JsonIgnoreProperties(ignoreUnknown = true)
public class Invoice {

    @Id
    private String id;
    private Integer customerId;
    private List<Price> prices;
    private List<Product> products;
    private CreditCard card;
    private Address address;
    private boolean active;

    public Invoice() {super();}

    public Invoice(Integer customerId, List<Price> prices, List<Product> products, CreditCard card, Address address, boolean active) {
        this.customerId = customerId;
        this.prices = prices;
        this.products = products;
        this.card = card;
        this.address = address;
        this.active = active;
    }

    public String getId() {return id;}
    public void setId(String id) {this.id = id;}
    public Integer getCustomerId() {return customerId;}
    public void setCustomerId(Integer customerId) {this.customerId = customerId;}
    public List<Price> getPrices() {return prices;}
    public void setPrices(List<Price> prices) {this.prices = prices;}
    public List<Product> getProducts() {return products;}
    public void setProducts(List<Product> products) {this.products = products;}
    public CreditCard getCard() {return card;}
    public void setCard(CreditCard card) {this.card = card;}
    public Address getAddress() {return address;}
    public void setAddress(Address address) {this.address = address;}
    public boolean isActive() {return active;}
    public void setActive(boolean active) {this.active = active;}
}
