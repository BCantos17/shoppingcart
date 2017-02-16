package com.revature.data;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import javax.jnlp.IntegrationService;

@Repository
public interface CartRepository extends MongoRepository <Cart, String> {


    //create
    <S extends Cart> S save (S cart);

    //find by cart id
    Cart findOne(String id);

    //retrieve by user id
    Cart findByUserId(Integer userId);


}
