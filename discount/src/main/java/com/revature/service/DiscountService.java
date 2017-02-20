package com.revature.service;

import com.revature.beans.Discount;
import com.revature.repository.DiscountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiscountService {
    private DiscountRepository repository;

    @Autowired
    public void setRepository(DiscountRepository repository) {this.repository = repository;}

    public Discount insert(Discount discount){ return repository .insert(discount); }
    public Discount save(Discount discount){ return repository.save(discount); }
    public Discount findByCodeAndUsedTrue(String code){ return repository.findByCodeAndUsedTrue(code); }
    public Discount findByProductId(String productId){ return repository.findByProductId(productId); }
    public Discount findByCustomerId(Integer customerId){ return repository.findByCustomerId(customerId); }
    public void delete(String id){ repository.delete(id); }

}

