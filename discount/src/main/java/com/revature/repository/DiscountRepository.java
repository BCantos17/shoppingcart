package com.revature.repository;

import com.revature.beans.Discount;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DiscountRepository extends MongoRepository<Discount, String>{

    @Override
    Discount insert(Discount discount);

    @Override
    Discount save(Discount discount);

    Discount findByCodeAndUsedTrue(String code);

    Discount findByProductId(String productId);

    Discount findByCustomerId(Integer customerId);

    @Override
    void delete(String id);
}
