package com.revature.beans;


public class Item {
    private String itemId;
    private int productId;
    private Integer quantity;

    public Item() {
    }

    public Item(String itemId, int productId, Integer quantity) {
        this.itemId = itemId;
        this.productId = productId;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemId='" + itemId + '\'' +
                ", productId=" + productId +
                ", quantity=" + quantity +
                '}';
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
