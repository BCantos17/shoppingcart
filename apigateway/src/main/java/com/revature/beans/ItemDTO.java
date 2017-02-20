package com.revature.beans;

public class ItemDTO {

    private String itemId;
    private Integer quantity;
    private int productId;
    private String productName;
    private double price;
    private String description;
    private String manufacturer;
    private String productImage;
    private int availableQuantity;
    private double itemTotal;

    public ItemDTO() {

    }

    public ItemDTO(Item item){
        this.itemId = item.getItemId();
        this.quantity = item.getQuantity();
    }

    public ItemDTO(Item item, Product product){
        this.itemId = item.getItemId();
        this.quantity = item.getQuantity();
        this.productId = product.getProductId();
        this.productName = product.getProductName();
        this.price = product.getPrice();
        this.description = product.getDescription();
        this.manufacturer = product.getManufacturer();
        this.productImage = product.getProductImage();
        this.availableQuantity = product.getAvailableQuantity();
        this.itemTotal= quantity * price;
    }

    @Override
    public String toString() {
        return "ItemDTO{" +
                "itemId='" + itemId + '\'' +
                ", quantity=" + quantity +
                ", productId=" + productId +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", productImage='" + productImage + '\'' +
                ", availableQuantity=" + availableQuantity +
                '}';
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(int availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public double getItemTotal() {
        return itemTotal;
    }

    public void setItemTotal(double itemTotal) {
        this.itemTotal = itemTotal;
    }
}