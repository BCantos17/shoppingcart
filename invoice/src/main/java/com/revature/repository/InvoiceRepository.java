package com.revature.repository;

import com.revature.beans.Invoice;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface InvoiceRepository extends MongoRepository<Invoice, String>{
    @Override
    Invoice insert(Invoice invoice);

    @Override
    Invoice save(Invoice invoice);

    @Override
    List<Invoice> findAll();

    List<Invoice> findByCustomerId(Integer customerId);

    @Override
    void delete(String id);
}
