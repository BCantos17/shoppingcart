package com.revature.repository;

import com.revature.beans.Price;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PriceRepository extends MongoRepository<Price, String> {

    @Override
    Price findOne(String s);
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
