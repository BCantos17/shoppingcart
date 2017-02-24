package com.revature.delegate;

import com.revature.beans.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BusinessDelegate {
    ResponseEntity<Address> insertAddress(Address address);
    ResponseEntity<Address> saveAddress(Address address);
    ResponseEntity<List<Address>> findAddressByCustomerId(Integer customerId);
    ResponseEntity deleteAddress(String id);

    ResponseEntity<CreditCard> insertCreditCard(CreditCard creditCard);
    ResponseEntity<CreditCard> saveCreditCard(CreditCard creditCard);
    ResponseEntity<List<CreditCard>> findCreditCardByCustomerId(Integer customerId);
    ResponseEntity deleteCreditCard(String id);

    ResponseEntity<Shipping> saveShipping(Shipping shipping);
    ResponseEntity<Shipping> findShippingByCartId(String cartId);
    ResponseEntity<Shipping> deleteShipping(String id);

    //Create a new cart
    //Add an item to the cart
    ResponseEntity<Cart> addCartItem(CartFormData formData);
    //Delete an item from the cart
    ResponseEntity<Cart> removeCartItem(CartFormData formData);
    //Update the quantity of an item from the cart
    ResponseEntity<Cart> updateCartItemQuantity(CartFormData formData);
    //Get all the Items in the cart
    ResponseEntity<List<ItemDTO>> getAllCartItems(String cartId);
    //Empty cart
    public ResponseEntity<Cart> emptyCart (CartFormData formData);

    //updates the subtotal and tax of the cart
    ResponseEntity<Price> updatePrice(String cartId);
    //get Price object by cartId
    ResponseEntity<Price> findPriceByCartId(String cartId);
    //create new price object with cartId
    ResponseEntity<Price> createPrice(String cartId);
}
