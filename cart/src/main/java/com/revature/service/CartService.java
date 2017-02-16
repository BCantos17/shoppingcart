package com.revature.service;

import com.revature.data.Cart;
import com.revature.data.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {
    private CartRepository repository;

    @Autowired
    public void setRepository(CartRepository repository) {
        this.repository = repository;
    }

    //create
    public <S extends Cart> S save (S cart){
        return this.repository.save(cart);
    }

    //find by cart id
    public Cart findOne(String id){
        return this.repository.findOne(id);
    }

    //retrieve by user id
    public Cart findByUserId(Integer integer){
        return this.repository.findByUserId(integer);
    }
}
