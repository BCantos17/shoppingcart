package com.revature.repository;


import com.revature.beans.CreditCard;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CreditCardRepository extends MongoRepository<CreditCard, String>{
    @Override
    CreditCard insert(CreditCard address);

    @Override
    CreditCard save(CreditCard address);

    @Override
    List<CreditCard> findAll();

    List<CreditCard> findByCustomerId(int customerId);

    @Override
    void delete(String id);
}
