package com.shopping.data;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CartRepository extends MongoRepository <Cart, Integer> {
    @Override
    Cart findOne(Integer integer);
}
