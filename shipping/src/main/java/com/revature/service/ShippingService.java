package com.revature.service;

import com.revature.beans.Shipping;
import com.revature.repository.ShippingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShippingService {
    private ShippingRepository repository;
    @Autowired
    public void setRepository(ShippingRepository repository) {this.repository = repository;}

    public Shipping insert(Shipping shipping){return repository.insert(shipping);}
    public Shipping save(Shipping shipping){return repository.save(shipping);}
    public List<Shipping> findAll(){ return  repository.findAll(); }
    public Shipping findByCartId(String cartId){return repository.findByCartId(cartId);}
    public Shipping findByInvoiceId(String invoiceId){ return repository.findByInvoiceId(invoiceId);}
    public void delete(String id){ repository.delete(id);}
}
