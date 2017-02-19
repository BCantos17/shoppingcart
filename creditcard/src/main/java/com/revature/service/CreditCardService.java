package com.revature.service;

import com.revature.beans.CreditCard;
import com.revature.repository.CreditCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditCardService {
    private CreditCardRepository repository;

    @Autowired
    public void setRepository(CreditCardRepository repository) {this.repository = repository;}
    public CreditCard insert(CreditCard address){return repository.insert(address);}
    public CreditCard save(CreditCard address){return repository.save(address);}
    public List<CreditCard> findAll(){ return  repository.findAll(); }
    public List<CreditCard> findByCustomerId(int customerId){return repository.findByCustomerId(customerId);}
    public void delete(String id){repository.delete(id);}
}
