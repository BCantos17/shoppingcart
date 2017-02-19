package com.revature.service;

import com.revature.beans.Address;
import com.revature.beans.CreditCard;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BillingService {
    ResponseEntity<Address> insertAddress(Address address);
    ResponseEntity<Address> saveAddress(Address address);
    ResponseEntity<List<Address>> findAddressByCustomerId(Integer customerId);
    ResponseEntity deleteAddress(String id);

    ResponseEntity<CreditCard> insertCreditCard(CreditCard creditCard);
    ResponseEntity<CreditCard> saveCreditCard(CreditCard creditCard);
    ResponseEntity<List<CreditCard>> findCreditCardByCustomerId(Integer customerId);
    ResponseEntity deleteCreditCard(String id);
}
