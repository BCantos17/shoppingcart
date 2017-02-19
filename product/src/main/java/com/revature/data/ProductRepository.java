package com.revature.data;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, Integer> {
    @Override
    <S extends Product> S save(S Product);

    @Override
    Product findOne(Integer integer);
}
