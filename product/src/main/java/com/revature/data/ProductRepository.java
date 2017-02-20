package com.revature.data;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RestResource
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
