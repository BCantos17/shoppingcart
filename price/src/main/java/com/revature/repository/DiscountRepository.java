package com.revature.repository;

import com.revature.beans.Discount;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface DiscountRepository extends MongoRepository<Discount, String>{

    @Override
    Discount findOne(String s);

    @Override
    List<Discount> findAll();

    @Override
    void delete(String s);

    @Override
    <S extends Discount> S save(S s);

    Discount findByDiscountCode(String s);
}
