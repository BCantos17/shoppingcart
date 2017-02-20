package com.revature.data;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends MongoRepository <Cart, String> {


    //insert a new cart or update if id already exist
    <S extends Cart> S save (S cart);

    //find by cart id
    Cart findOne(String id);

    //retrieve by user id
    Cart findCartByUserId(Integer userId);

    @Override
    List<Cart> findAll();
}
