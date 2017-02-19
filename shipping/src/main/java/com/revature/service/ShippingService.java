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

    public List<Shipping> findAll(){ return  repository.findAll(); }
}
