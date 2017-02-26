package com.revature.service;


import com.revature.beans.Discount;
import com.revature.beans.Price;
import com.revature.repository.DiscountRepository;
import com.revature.repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceService {

    PriceRepository priceRepository;
    DiscountRepository discountRepository;

    @Autowired
    public void setPriceRepository(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }
    @Autowired
    public void setDiscountRepository(DiscountRepository discountRepository) {
        this.discountRepository = discountRepository;
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

    //validate discount code and return amount discount if exist otherwise return zero
    public Double validateDiscount(String discountCode){

        Double discountAmount = 0.0;
        Discount validation = null;

        //Create test discount code
        discountRepository.save(new Discount("test", 5.00));

        validation = discountRepository.findByDiscountCode(discountCode);
        if(validation != null){
            discountAmount = validation.getDiscountAmount();
        };

        return discountAmount;
    }
}
