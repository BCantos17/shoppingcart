package com.revature.web;

import com.revature.beans.Price;
import com.revature.delegate.BusinessDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/price")
public class PriceController {

    private BusinessDelegate delegate;
    @Autowired
    public void setDelegate(BusinessDelegate delegate) {this.delegate = delegate;}

    @RequestMapping(value = "/updateCartPrice/{cartId}",
                    method = RequestMethod.PUT,
                    produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Price> updateCartPrice(@PathVariable String cartId) {
        return delegate.updatePrice(cartId);
    }

    @RequestMapping(value="/getCartPrice/{cartId}",
                    method=RequestMethod.GET,
                    produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Price> getAllCartItems (@PathVariable String cartId){
        return delegate.findPriceByCartId(cartId);
    }
}
