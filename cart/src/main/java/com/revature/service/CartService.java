package com.revature.service;

import com.revature.data.Cart;
import com.revature.data.CartRepository;
import com.revature.data.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    private CartRepository repository;
    @Autowired
    public void setRepository(CartRepository repository) {
        this.repository = repository;
    }

    //insert a new cart
    public <S extends Cart> S save (S cart){
        return this.repository.save(cart);
    }

    //find by cart id
    public Cart findOne(String id){
        return (Cart)this.repository.findById(id).get();
    }

    //retrieve cart by user id
    public Cart findCartByUserId(Integer integer){
        return this.repository.findCartByUserId(integer);
    }

    //delete item from cart by item id
    public Cart deleteItemFromCart(Cart cart, String itemId) {
        cart.getItem().removeIf(item -> item.getItemId().equals(itemId));
        this.repository.save(cart);
        return (Cart)this.repository.findById(cart.getCartId()).get();
    }

    //update item quantity by item id
    public Cart updateItemQuantity(Cart cart, String itemId, Integer newQuantity){
        for( Item item:  cart.getItem()){
            if(item.getItemId().equals(itemId)){
                item.setQuantity(newQuantity);
            }
        }
        this.repository.save(cart);
        return (Cart)this.repository.findById(cart.getCartId()).get();
    }

    //insert a new item into cart
    public Cart insertItemToCart(Cart cart, String productId, Integer itemQuantity){
        String itemId = cart.getUserId() + productId;
        cart.getItem().add(new Item(itemId, productId, itemQuantity));
        this.repository.save(cart);
        return (Cart)this.repository.findById(cart.getCartId()).get();
    }

    public ResponseEntity<List<Cart>> getAllCarts() {
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }
}
