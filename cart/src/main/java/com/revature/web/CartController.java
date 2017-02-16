package com.revature.web;

import com.revature.data.Cart;
import com.revature.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class CartController {

    private CartService service;

    @Autowired
    public void setService(CartService service) {
        this.service = service;
    }

    @RequestMapping(value="/cart",
                    method=RequestMethod.POST,
                    produces= APPLICATION_JSON_VALUE)
    public Cart save(@RequestBody Cart cart){
        return service.save(cart);
    }

    @RequestMapping(value="/cart/{id}",
                    method=RequestMethod.GET,
                    produces=APPLICATION_JSON_VALUE)
    public Cart findById(@PathVariable String id){
        return service.findOne(id);
    }

    @RequestMapping(value="/cart/user/{userId}",
                    method=RequestMethod.GET,
                    produces=APPLICATION_JSON_VALUE)
    public Cart findByUserId(@PathVariable Integer userId){
        return service.findByUserId(userId);
    }
}
