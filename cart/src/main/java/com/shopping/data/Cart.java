package com.shopping.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

@Component
public class Cart {
    @Id
    private int id;
    private Item item;


    @Autowired
    public void setItem(Item item) {
        this.item = item;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public Item getItem() {
        return item;
    }
}
