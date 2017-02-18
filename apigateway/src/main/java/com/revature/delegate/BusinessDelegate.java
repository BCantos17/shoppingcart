package com.revature.delegate;

import com.revature.beans.Address;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BusinessDelegate {
    ResponseEntity<Address> addAddress(Address address);
    ResponseEntity<Address> updateAddress(Address address);
    ResponseEntity<List<Address>> findByCustomerId(Integer customerId);
    ResponseEntity deleteAddress(String id);
}
