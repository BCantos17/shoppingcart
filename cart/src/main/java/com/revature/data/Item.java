package com.revature.data;

import org.springframework.stereotype.Component;

@Component
public class Item {

    private Integer productId;
    private Integer quantity;

    public Item() {
    }

    public Item(int productId, Integer quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Item{" +
                "productId=" + productId +
                ", quantity=" + quantity +
                '}';
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
