package com.revature.repository;

import com.revature.beans.Price;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface PriceRepository extends MongoRepository<Price, String> {


    Optional findById(String id);
    @Override
    List<Price> findAll();
    @Override
    <S extends Price> S save(S s);
    @Override
    <S extends Price> S insert(S s);
    @Override
    void deleteAll();

    Price findByCartId(String cartId);

}
