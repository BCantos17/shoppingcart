package com.revature.service;

import com.revature.beans.Address;
import org.springframework.http.ResponseEntity;

public interface BillingService {
    ResponseEntity<Address> addAddress(Address address);
}
