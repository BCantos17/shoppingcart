package com.revature.service;

import com.revature.beans.Customer;
import org.springframework.http.ResponseEntity;

public interface BillingService {
    ResponseEntity<Customer> insertCustomerAddress(Customer customer);
}
