package com.revature.data;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends MongoRepository<Product, Integer> {
    @Override
    <S extends Product> S save(S Product);

    @Override
    Optional<Product> findById(Integer integer);

    @Override
    List<Product> findAll();

    @Override
    void deleteAll();

}
