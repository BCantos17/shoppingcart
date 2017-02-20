package com.revature.web;

import com.revature.data.Cart;
import com.revature.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class CartController {

    private CartService service;

    @Autowired
    public void setService(CartService service) {
        this.service = service;
    }

    @RequestMapping(value = "/create",
            method = RequestMethod.POST,
            produces = APPLICATION_JSON_VALUE,
            consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<Cart> save(@RequestBody Cart cart) {
        return new ResponseEntity<>(service.save(cart), HttpStatus.OK);
    }

    @RequestMapping(value = "/update",
            method = RequestMethod.POST,
            produces = APPLICATION_JSON_VALUE,
            consumes = APPLICATION_JSON_VALUE)
    public Cart update(@RequestBody Cart cart) {
        return service.save(cart);
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.GET,
            produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Cart> findCartById(@PathVariable String id) {
        return new ResponseEntity<>(service.findOne(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Cart>> getAllCarts() {
        return service.getAllCarts();
    }

    @RequestMapping(value = "/cart/user/{userId}",
            method = RequestMethod.GET,
            produces = APPLICATION_JSON_VALUE)
    public Cart findCartByUserId(@PathVariable Integer userId) {
        return service.findCartByUserId(userId);
    }

    @RequestMapping(value = "/cart/deleteItem/{itemId}",
            method = RequestMethod.PUT,
            produces = APPLICATION_JSON_VALUE,
            consumes = APPLICATION_JSON_VALUE)
    public Cart deleteItemFromCart(@RequestBody Cart cart, @PathVariable String itemId) {
        return service.deleteItemFromCart(cart, itemId);
    }

    @RequestMapping(value = "/cart/updateItemQuantity/{itemId}/{newQuantity}",
            method = RequestMethod.PUT,
            produces = APPLICATION_JSON_VALUE,
            consumes = APPLICATION_JSON_VALUE)
    public Cart updateCartItem(@RequestBody Cart cart, @PathVariable String itemId, @PathVariable Integer newQuantity) {
        return service.updateItemQuantity(cart, itemId, newQuantity);
    }

    @RequestMapping(value = "/cart/insertItem/{productId}/{itemQuantity}",
            method = RequestMethod.PUT,
            produces = APPLICATION_JSON_VALUE,
            consumes = APPLICATION_JSON_VALUE)
    public Cart insertItemToCart(@RequestBody Cart cart, @PathVariable String productId, @PathVariable Integer itemQuantity) {
        return service.insertItemToCart(cart, productId, itemQuantity);
    }
}
