package com.revature.repository;

import com.revature.beans.Shipping;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ShippingRepository extends MongoRepository<Shipping, String> {
    @Override
    List<Shipping> findAll();
}
