package com.revature.data;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends MongoRepository <Cart, Integer> {


    //create
    <S extends Cart> S save (S cart);

    //find by cart id
    Cart findOne(Integer integer);

    //retrieve by user id
    Cart findByUserId(Integer integer);


}
