package com.revature.service;

import com.revature.beans.Cart;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@FeignClient("cart")
public interface CartService {
    @RequestMapping(value = "/create",
                    method = RequestMethod.POST,
                    produces = APPLICATION_JSON_VALUE,
                    consumes = APPLICATION_JSON_VALUE)
    ResponseEntity<Cart> createCart(@RequestBody Cart cart);

    @RequestMapping(value = "/update",
            method = RequestMethod.POST,
            produces = APPLICATION_JSON_VALUE,
            consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<Cart> updateCart(@RequestBody Cart cart);

    @RequestMapping(value = "/{id}",
            method = RequestMethod.GET,
            produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Cart> findCartById(@PathVariable("id") String id);

    @RequestMapping(value = "/cart/user/{userId}",
            method = RequestMethod.GET,
            produces = APPLICATION_JSON_VALUE)
    public Cart findCartByUserId(@PathVariable("userId") Integer userId);

}
