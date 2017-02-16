package com.revature.repository;


import com.revature.beans.CreditCard;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CreditCardRepository extends MongoRepository<CreditCard, Integer>{
    @Override
    CreditCard insert(CreditCard address);

    @Override
    CreditCard save(CreditCard address);

    List<CreditCard> findByCustomerId(int customerId);

    @Override
    void delete(Integer id);
}
