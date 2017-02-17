package com.revature.web;

import com.revature.beans.Cart;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class CartController {

    @RequestMapping(value = "/cart", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Cart> addItemToCart(@RequestBody Cart cart) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity("http://localhost:8723/cart/cart/", cart, Cart.class);
    }

    @RequestMapping(value = "/cart", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity updateItemInCart(@RequestBody Cart cart) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.put("http://localhost:8723/cart/cart/", cart);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/cart/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Cart> getCartById(@PathVariable int id){
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForEntity("http://localhost:8723/cart/cart/" + id, Cart.class);
    }
}
