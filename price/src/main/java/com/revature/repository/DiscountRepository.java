package com.revature.repository;

import com.revature.beans.Discount;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface DiscountRepository extends MongoRepository<Discount, String>{

    @Override
    Optional findById(String id);

    @Override
    List<Discount> findAll();

    @Override
    void deleteById(String s);

    @Override
    <S extends Discount> S save(S s);

    Discount findByDiscountCode(String s);
}
