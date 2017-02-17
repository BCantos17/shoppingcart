package com.revature.web;

import com.revature.beans.Cart;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartController {

    @RequestMapping(value = "/cart", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity addItemToCart(@RequestBody Cart cart) {
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value="/cart", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity editItemInCart(@RequestBody Cart cart) {
        return new ResponseEntity(HttpStatus.OK);
    }
}
