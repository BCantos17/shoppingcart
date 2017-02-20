package com.revature.service;

import com.revature.beans.Price;
import com.revature.repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceService {
    private PriceRepository repository;

    @Autowired
    public void setRepository(PriceRepository repository) {this.repository = repository;}

    public Price insert(Price price){ return repository.insert(price); }
    public Price save(Price price){ return repository.save(price); }
    public List<Price> findAll(){ return repository.findAll(); }
    public List<Price> findByProductId(String productId){ return repository.findByProductId(productId); }
    public List<Price> findByInvoiceId(String invoiceId){ return repository.findByInvoiceId(invoiceId); }
    public void delete(String id){ repository.delete(id); }
}
