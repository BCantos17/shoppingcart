package com.shopping.service;

import com.shopping.data.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {
    private CartRepository repository;

    @Autowired
    public void setRepository(CartRepository repository) {
        this.repository = repository;
    }

    public CartRepository getRepository() {
        return repository;
    }
}
