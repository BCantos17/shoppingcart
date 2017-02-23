package com.revature.data;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProductRepository extends MongoRepository<Product, Integer> {
    @Override
    <S extends Product> S save(S Product);

    @Override
    Product findOne(Integer integer);

    @Override
    List<Product> findAll();

    @Override
    void deleteAll();



}
