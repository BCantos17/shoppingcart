package com.revature.service;

import com.netflix.discovery.converters.Auto;
import com.revature.beans.Price;
import com.revature.repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceService {

    PriceRepository priceRepository;
    @Autowired
    public void setPriceRepository(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    public Price insertPrice(Price price){
        return priceRepository.insert(price);
    }
    public Price updatePrice(Price price){
        return priceRepository.save(price);
    }
    public Price findByCartId(String cartId){
        return priceRepository.findByCartId(cartId);
    }
    public List<Price> findAll () {
        return priceRepository.findAll();
    }
    public void deleteAll () { priceRepository.deleteAll(); }
    //discount
    public Price validateDiscount(String discountCode){
        return null;
    }
}
