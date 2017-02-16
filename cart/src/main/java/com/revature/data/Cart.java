package com.revature.data;

import org.springframework.data.annotation.Id;
import java.util.List;


public class Cart {

    @Id
    private Integer cartId;
    private Integer userId;
    private List<Item> item;

    public Cart() {
    }

    public Cart(int carId, int userId, List<Item> item) {
        this.cartId = carId;
        this.userId = userId;
        this.item = item;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "carId=" + cartId +
                ", userId=" + userId +
                ", item=" + item +
                '}';
    }

    public int getCarId() {
        return cartId;
    }

    public void setCarId(int carId) {
        this.cartId = carId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<Item> getItem() {
        return item;
    }

    public void setItem(List<Item> item) {
        this.item = item;
    }
}
