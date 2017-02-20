package com.revature.repository;

import com.revature.beans.Price;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PriceRepository extends MongoRepository<Price, String> {
    @Override
    Price insert(Price price);

    @Override
    Price save(Price price);

    @Override
    List<Price> findAll();

    List<Price> findByProductId(String productId);

    List<Price> findByInvoiceId(String invoiceId);

    @Override
    void delete(String id);
}
