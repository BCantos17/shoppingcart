package com.revature.web;

import com.revature.beans.Shipping;
import com.revature.delegate.BusinessDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shipping")
public class ShippingController {
    private BusinessDelegate delegate;
    @Autowired
    public void setDelegate(BusinessDelegate delegate) {this.delegate = delegate;}

    @RequestMapping(value = "/save",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Shipping> save(@RequestBody Shipping shipping) {
        return delegate.saveShipping(shipping);
    }

    @RequestMapping(value = "/cart/{cartId}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Shipping> findbyCartId(@PathVariable String cartId) {
        return delegate.findShippingByCartId(cartId);
    }
}
