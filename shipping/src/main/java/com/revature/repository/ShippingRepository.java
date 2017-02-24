package com.revature.repository;

import com.revature.beans.Shipping;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ShippingRepository extends MongoRepository<Shipping, String> {
    @Override
    Shipping insert(Shipping shipping);

    @Override
    Shipping save(Shipping shipping);

    @Override
    List<Shipping> findAll();

    Shipping findByCartId(String cartId);

    Shipping findByInvoiceId(String invoiceId);

    @Override
    void delete(String id);
}
