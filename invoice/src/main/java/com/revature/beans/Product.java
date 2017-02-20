package com.revature.beans;

public class Product {
    private int productId;
    private String productName;
    private double price;
    private String description;
    private String manufacturer;
    private String productImage;
    private int availableQuantity;

    public Product() {super();}

    public int getAvailableQuantity() {return availableQuantity;}
    public void setAvailableQuantity(int availableQuantity) {this.availableQuantity = availableQuantity;}
    public String getProductImage() {return productImage;}
    public void setProductImage(String productImage) {this.productImage = productImage;}

    public int getProductId() {return productId;}
    public void setProductId(int productId) {this.productId = productId;}
    public String getProductName() {return productName;}
    public void setProductName(String productName) {this.productName = productName;}
    public double getPrice() {return price;}
    public void setPrice(double price) {this.price = price;}
    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}
    public String getManufacturer() {return manufacturer;}
    public void setManufacturer(String manufacturer) {this.manufacturer = manufacturer;}
}
