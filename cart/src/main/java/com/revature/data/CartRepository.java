package com.revature.data;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartRepository extends MongoRepository <Cart, String> {

    //insert a new cart or update if id already exist
    <S extends Cart> S save (S cart);

    //find by cart id
    Optional findById(String id);

    //retrieve by user id
    Cart findCartByUserId(Integer userId);

    @Override
    List<Cart> findAll();
}
