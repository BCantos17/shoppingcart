package com.revature.delegate;

import com.revature.beans.Address;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BusinessDelegate {
    ResponseEntity<Address> insertAddress(Address address);
    ResponseEntity<Address> saveAddress(Address address);
    ResponseEntity<List<Address>> findByCustomerId(Integer customerId);
    ResponseEntity deleteAddress(String id);
}
