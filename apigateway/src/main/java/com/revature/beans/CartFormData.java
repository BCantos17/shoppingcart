package com.revature.beans;

public class CartFormData {

    private String cartId;
    private String itemId;
    private Integer quantity;
    private int productId;
    private int userId;

    public CartFormData() {
    }

    public CartFormData(String cartId, String itemId, Integer quantity, int productId, int userId) {
        this.cartId = cartId;
        this.itemId = itemId;
        this.quantity = quantity;
        this.productId = productId;
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "CartFormData{" +
                "cartId='" + cartId + '\'' +
                ", itemId='" + itemId + '\'' +
                ", quantity=" + quantity +
                ", productId=" + productId +
                ", userId=" + userId +
                '}';
    }

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
