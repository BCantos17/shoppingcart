package com.revature.delegate;

import com.revature.beans.Address;
import org.springframework.http.ResponseEntity;

public interface BusinessDelegate {
    ResponseEntity<Address> addAddress(Address address);
}
