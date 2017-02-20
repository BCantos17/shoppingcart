package com.revature.delegate;

import com.revature.beans.Address;
import com.revature.beans.CartFormData;
import com.revature.beans.CreditCard;
import com.revature.beans.ItemDTO;
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

    //Create a new cart
    //Add an item to the cart
    //Delete an item from the cart
    //Update the quantity of an item from the cart
    //Get all the Items in the cart
    ResponseEntity<List<ItemDTO>> getAllCartItems (CartFormData formData);
}
