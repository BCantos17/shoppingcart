package com.revature.beans;


import org.springframework.data.annotation.Id;
import java.util.List;

public class Cart {

    @Id
    private String cartId;
    private Integer userId;
    private List<Item> item;

    public Cart() {
    }

    public Cart(String cartId, Integer userId, List<Item> item) {
        this.cartId = cartId;
        this.userId = userId;
        this.item = item;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartId='" + cartId + '\'' +
                ", userId=" + userId +
                ", item=" + item +
                '}';
    }

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public List<Item> getItem() {
        return item;
    }

    public void setItem(List<Item> item) {
        this.item = item;
    }
}
