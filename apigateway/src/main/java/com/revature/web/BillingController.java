package com.revature.web;

import com.revature.beans.Address;
import com.revature.delegate.BusinessDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/billing")
public class BillingController {

    private BusinessDelegate delegate;

    @Autowired
    public void setDelegate(BusinessDelegate delegate) {this.delegate = delegate;}

    @RequestMapping(value = "/address/add",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Address> createAssessment(@RequestBody Address address) {return delegate.addAddress(address);}
}
